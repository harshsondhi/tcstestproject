package com.sondhi.harsh.tcsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class TcsprojectApplication {

	public static void main(String[] args) {

		SpringApplication.run(TcsprojectApplication.class, args);
		System.out.println("@@@@@@@@@@@@hello@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}
