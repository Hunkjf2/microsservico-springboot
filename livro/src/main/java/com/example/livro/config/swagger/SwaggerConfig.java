package com.example.livro.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microsserviço de Livros")
                        .description("Módulo de Livros")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Eduardo Ezequiel Marcolino")
                                .url("https://sistema.com")));
    }

}
