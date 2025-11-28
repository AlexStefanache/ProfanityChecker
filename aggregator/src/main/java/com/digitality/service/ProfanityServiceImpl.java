package com.digitality.service;

import com.digitality.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfanityServiceImpl implements ProfanityService{
    private String userUrl = "http://user-service/auth";
    private String profanityUrl = "http://profanity-service/profanity/check";

    private RestTemplate restTemplate;
    public ProfanityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProfanityResponseDTO checkProfanity(ProfanityRequestDTO profanityRequestDTO) {
        AuthRequestDTO authRequestDTO = new AuthRequestDTO(profanityRequestDTO.getEmail(), profanityRequestDTO.getPassword());
        AuthResponseDTO authResponseDTO = restTemplate.postForObject(userUrl, authRequestDTO, AuthResponseDTO.class);
        boolean userExists = authResponseDTO.isValid();
        if(userExists){
            MessageDTO messageDTO = new MessageDTO(profanityRequestDTO.getMessage());
            CheckProfanityDTO checkProfanityDTO = restTemplate.postForObject(profanityUrl, messageDTO, CheckProfanityDTO.class);
            return checkProfanityDTO.getProfane()
                    ? new ProfanityResponseDTO("Il messaggio contiene profanità", false)
                    : new ProfanityResponseDTO("Il messaggio non contiene profanità", true);
        }
        else{
            return new ProfanityResponseDTO("Utente non esiste", false);
        }
    }
}
