package com.digitality.service;

import java.util.List;

public interface ProfanityService {
    List<String> getAllProfanities();

    Boolean checkProfanity(String message);
}
