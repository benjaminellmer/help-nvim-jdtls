package com.example.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.server.generated.api.PersonsApiClient;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.server.generated.api")
public class ClientApplication implements CommandLineRunner {
    private PersonsApiClient apiClient;
    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    public ClientApplication(PersonsApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    public void run(String... args) {
        var personsResponse = apiClient.getPersons();

        if (personsResponse.getStatusCode().is2xxSuccessful()) {
            var body = personsResponse.getBody();
            logger.info(body.toString());
        }
    }
}
