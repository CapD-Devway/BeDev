package dev.com.bedev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BeDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeDevApplication.class, args);
    }

}
