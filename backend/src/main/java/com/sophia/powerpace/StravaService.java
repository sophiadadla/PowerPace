package com.sophia.powerpace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class StravaService {

    @Value("${strava.api.token}")
    private String stravaApiToken;

    private final RestTemplate restTemplate;

    public StravaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAthleteProfile() {
        String url = "https://www.strava.com/api/v3/athlete";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(stravaApiToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "Error: " + response.getStatusCode();
        }
    }
}
