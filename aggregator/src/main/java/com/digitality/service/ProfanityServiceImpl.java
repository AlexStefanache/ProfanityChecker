package com.digitality.service;

import com.digitality.client.AuthClient;
import com.digitality.client.ProfanityClient;
import com.digitality.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfanityServiceImpl implements ProfanityService{
    private AuthClient authClient;
    private ProfanityClient profanityClient;
    public ProfanityServiceImpl(AuthClient authClient, ProfanityClient profanityClient) {
        this.authClient = authClient;
        this.profanityClient = profanityClient;
    }

    @Override
    public ProfanityResponseDTO checkProfanity(ProfanityRequestDTO profanityRequestDTO) {
        AuthRequestDTO authRequestDTO = new AuthRequestDTO(profanityRequestDTO.getEmail(), profanityRequestDTO.getPassword());
        AuthResponseDTO authResponseDTO = authClient.authenticate(authRequestDTO);
        boolean userExists = authResponseDTO.isValid();
        if(userExists){
            MessageDTO messageDTO = new MessageDTO(profanityRequestDTO.getMessage());
            CheckProfanityDTO checkProfanityDTO = profanityClient.check(messageDTO);
            return checkProfanityDTO.getProfane()
                    ? new ProfanityResponseDTO("Il messaggio contiene profanità", false)
                    : new ProfanityResponseDTO("Il messaggio non contiene profanità", true);
        }
        else{
            return new ProfanityResponseDTO("Utente non esiste", false);
        }
    }
}
