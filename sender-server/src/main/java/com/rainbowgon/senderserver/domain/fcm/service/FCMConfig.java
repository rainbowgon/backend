package com.rainbowgon.senderserver.domain.fcm.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.rainbowgon.senderserver.global.error.exception.FCMFileNotFoundException;
import com.rainbowgon.senderserver.global.error.exception.FCMInitializerFailException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class FCMConfig {

    @Bean
    FirebaseMessaging firebaseMessaging() {
        try {
            ClassPathResource resource = new ClassPathResource("fcm/openthedoor-930e4-firebase-adminsdk" +
                                                                       "-t332b" +
                                                                       "-aa9888ba26.json");

            InputStream refreshToken = null;
            refreshToken = resource.getInputStream();

            FirebaseApp firebaseApp = null;
            List<FirebaseApp> firebaseAppList = FirebaseApp.getApps();

            if (firebaseAppList != null && !firebaseAppList.isEmpty()) {
                for (FirebaseApp app : firebaseAppList) {
                    if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                        firebaseApp = app;
                    }
                }
            } else {
                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(refreshToken))
                        .build();

                firebaseApp = FirebaseApp.initializeApp(options);
            }

            return FirebaseMessaging.getInstance(firebaseApp);
        } catch (FileNotFoundException e) {
            System.out.println("==============================111==");
            e.printStackTrace();
            System.out.println("==============================111==");
            throw FCMFileNotFoundException.EXCEPTION;
        } catch (IOException e) {
            System.out.println("==============================222==");
            e.printStackTrace();
            System.out.println("==============================222==");
            throw FCMInitializerFailException.EXCEPTION;
        }
    }
}
