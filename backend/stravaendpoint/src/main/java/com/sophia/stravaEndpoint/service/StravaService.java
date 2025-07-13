package com.sophia.stravaendpoint.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;

import reactor.core.publisher.Mono; 
import java.util.Map;   

@Service
public class StravaService {

    private final WebClient webClient;

    public StravaService(
            @Value("${strava.access-token}") String accessToken,
            WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder
                .baseUrl("https://www.strava.com/api/v3")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .build();
    }

    public Mono<Map<String, Object>> getAthlete() {
        return webClient.get()
                .uri("/athlete")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {}); 
    }
}
