package com.zoomies.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoomies.api.util.ResponseUtil;

@RequestMapping("/health")
public class HealthController {

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        return ResponseUtil.success("I'm alive!");
    }

}
