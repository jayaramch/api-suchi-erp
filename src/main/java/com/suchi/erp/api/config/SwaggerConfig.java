package com.suchi.erp.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.suchi.erp.api")).paths(PathSelectors.any()).build()
				.apiInfo(metaInfo());

	}

	private ApiInfo metaInfo() {

		return new ApiInfo("Spring Boot Swagger Suchi ERP API Documentation",
				"Spring Boot Swagger API Documentation for  Suchi ERP", "1.0", "Terms of Service",
				new Contact("Suchi ERP", "http://suchi-erp.com", "info@suchi-erp.com"),
				"Copyright 2019 © Suchi ERP All rights reserved", "http://suchi-erp.com/");
	}
}
