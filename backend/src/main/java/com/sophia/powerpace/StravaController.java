package com.sophia.powerpace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StravaController {

    private final StravaService stravaService;

    public StravaController(StravaService stravaService) {
        this.stravaService = stravaService;
    }

    @GetMapping("/api/test")
    public String testTokenUse() {
        return stravaService.getAthleteProfile();
    }
}
