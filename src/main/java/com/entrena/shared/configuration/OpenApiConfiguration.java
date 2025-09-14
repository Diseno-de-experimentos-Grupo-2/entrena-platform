package com.entrena.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI entrenaOpenApi() {
        var openApi = new OpenAPI();
        openApi.info(new Info()
                .title("Entrena Platform API")
                .description("Training platform for exercise and routine management")
                .version("v1.0.0")
                .license(new License().name("Apache 2.0").url("https://springdoc.org"))
                .contact(new Contact()
                        .name("Entrena Team")
                        .email("support@entrena.com")));
        return openApi;
    }
}
