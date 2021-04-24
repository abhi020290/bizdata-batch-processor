package com.springboot.springbatchprocessor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.springboot.springbatchprocessor.entity"})
@OpenAPIDefinition(info = @Info(title = "Business Data Management System", description = "This application is to manage business raw data",
		termsOfService = "nothing", license = @License(name = "DMS"), contact = @Contact(email = "nothing@test.com"), version = "1.0.0"))

public class SpringBatchProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProcessorApplication.class, args);
	}

}
