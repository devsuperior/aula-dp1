package com.devsuperior.integrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devsuperior.integrations.dto.EmailDTO;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class SendgridServiceMock implements SendgridService {

	private Logger LOG = LoggerFactory.getLogger(SendgridServiceMock.class);

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
		LOG.info("Sending mock email from: " + mail.getFrom().getEmail());
	}
}
