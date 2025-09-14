package com.entrena.entrenaplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EntrenaPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrenaPlatformApplication.class, args);
    }

}
