package com.sophia.stravaendpoint.controller;

import com.sophia.stravaendpoint.service.StravaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;         
import java.util.Map; 

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StravaController {

    private final StravaService stravaServ;

    @GetMapping("/athlete")    
    public Mono<Map<String, Object>> getAthlete() {
        return stravaServ.getAthlete();
    }
}
