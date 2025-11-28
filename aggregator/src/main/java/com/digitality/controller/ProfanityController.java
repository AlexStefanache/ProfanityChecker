package com.digitality.controller;

import com.digitality.dto.ProfanityRequestDTO;
import com.digitality.dto.ProfanityResponseDTO;
import com.digitality.service.ProfanityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profanity")
public class ProfanityController {
    private ProfanityService profanityService;
    public ProfanityController(ProfanityService profanityService) {
        this.profanityService = profanityService;
    }

    @PostMapping
    public ResponseEntity<ProfanityResponseDTO> checkProfanity(@RequestBody ProfanityRequestDTO profanityRequestDTO) {
        return ResponseEntity.ok(profanityService.checkProfanity(profanityRequestDTO));
    }
}
