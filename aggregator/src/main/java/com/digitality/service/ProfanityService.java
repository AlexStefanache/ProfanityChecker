package com.digitality.service;

import com.digitality.dto.ProfanityRequestDTO;
import com.digitality.dto.ProfanityResponseDTO;

public interface ProfanityService {
    ProfanityResponseDTO checkProfanity(ProfanityRequestDTO profanityRequestDTO);
}
