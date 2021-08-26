package com.devsuperior.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.integrations.services.SendgridService;
import com.devsuperior.integrations.services.SendgridServiceMock;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public SendgridService sendgridServiceBean() {
		return new SendgridServiceMock();
	}
}
