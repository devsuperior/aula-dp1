package com.devsuperior.integrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sendgrid.helpers.mail.Mail;

public class SendgridServiceMock extends SendgridServiceAbstract {

	private Logger LOG = LoggerFactory.getLogger(SendgridServiceMock.class);

	@Override
	protected void callEmailAPI(Mail mail) {
		LOG.info("Sending mock email from: " + mail.getFrom().getEmail());
	}
}
