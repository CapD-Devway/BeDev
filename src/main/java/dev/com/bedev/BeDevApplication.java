package dev.com.bedev;

import com.google.cloud.spring.autoconfigure.firestore.GcpFirestoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {GcpFirestoreAutoConfiguration.class})
public class BeDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeDevApplication.class, args);
    }

}
