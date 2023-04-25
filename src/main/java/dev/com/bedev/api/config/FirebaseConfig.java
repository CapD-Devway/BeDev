package dev.com.bedev.api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Value("${app.firebase-file}")
    private String FileName;

    @Bean
    public FirebaseApp firebaseApp() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream(FileName);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        return FirebaseApp.initializeApp(options);


    }

    @Bean
    public FirebaseAuth getFirebaseAuth() throws IOException {
        return FirebaseAuth.getInstance(firebaseApp());
    }
}
