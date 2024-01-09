package com.zoomies.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/health")
public class HealthController {

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        return ResponseEntity.ok("OK");
    }

}
