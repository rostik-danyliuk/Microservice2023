package com.example.microservice2023.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("checkstyle:MissingJavadocType")
@OpenAPIDefinition(
        info = @Info(title = "Docs for Microservices",
                description = "SwaggerConfig file",
                version = "1.0",
                contact = @Contact(
                        name = "Rostik",
                        email = "danyliuk.rostyslav@chnu.edu.ua"
                )
        )
)
public class SwaggerConfig {

}
