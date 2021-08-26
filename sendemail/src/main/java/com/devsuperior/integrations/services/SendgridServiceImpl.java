package com.devsuperior.integrations.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.devsuperior.integrations.dto.EmailDTO;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class SendgridServiceImpl implements SendgridService {

	private Logger LOG = LoggerFactory.getLogger(SendgridServiceImpl.class);

	@Autowired
	private SendGrid sendGrid;

	@Override
	public void sendEmail(EmailDTO dto) {
		Mail mail = prepareEmail(dto);
		callEmailAPI(mail);
	}

	@Override
	public Mail prepareEmail(EmailDTO dto) {
		Email from = new Email(dto.getFromEmail(), dto.getFromName());
		Email to = new Email(dto.getTo());
		Content content = new Content(dto.getContentType(), dto.getBody());
		Mail mail = new Mail(from, dto.getSubject(), to, content);
		mail.setReplyTo(new Email(dto.getReplyTo()));
		return mail;
	}

	protected void callEmailAPI(Mail mail) {

		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			LOG.info("Sending email from: " + mail.getFrom().getEmail());
			Response response = sendGrid.api(request);
			if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
				LOG.error("Error sending email: " + response.getBody());
			} else {
				LOG.info("Email sent! Status = " + response.getStatusCode());
			}
		} 
		catch (IOException e) {
			LOG.error("Error sending email: " + e.getMessage());
		}
	}
}
