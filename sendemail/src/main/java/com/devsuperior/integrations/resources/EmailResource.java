package com.devsuperior.integrations.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.integrations.dto.EmailDTO;
import com.devsuperior.integrations.services.EmailService;

@RestController
@RequestMapping(value = "/emails")
public class EmailResource {

	@Autowired
	private EmailService service;
	
	@PostMapping
	public ResponseEntity<EmailDTO> insert(@RequestBody EmailDTO dto) {
		service.sendEmail(dto);
		return ResponseEntity.noContent().build();
	}
}
