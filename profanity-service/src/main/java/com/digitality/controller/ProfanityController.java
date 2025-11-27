package com.digitality.controller;

import com.digitality.dto.MessageDTO;
import com.digitality.dto.ResponseDTO;
import com.digitality.service.ProfanityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profanity")
public class ProfanityController {
    private ProfanityService profanityService;
    public ProfanityController(ProfanityService profanityService) {
        this.profanityService = profanityService;
    }

    @GetMapping("/get")
    public List<String> getProfanities() {
        return profanityService.getAllProfanities();
    }

    @PostMapping("/check")
    public ResponseEntity<ResponseDTO> checkProfanity(@RequestBody MessageDTO messageDTO) {
        ResponseDTO responseDTO = new ResponseDTO(profanityService.checkProfanity(messageDTO.getMessage()));
        return ResponseEntity.ok(responseDTO);
    }
}
