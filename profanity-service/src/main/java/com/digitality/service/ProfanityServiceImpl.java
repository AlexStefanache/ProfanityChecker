package com.digitality.service;

import com.digitality.repository.ProfanityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class ProfanityServiceImpl implements ProfanityService{
    private ProfanityRepository profanityRepository;

    private String regex = "[,\\.\\s]";
    public ProfanityServiceImpl(ProfanityRepository profanityRepository) {
        this.profanityRepository = profanityRepository;
    }

    @Override
    public List<String> getAllProfanities() {
        return profanityRepository.findAllProfanities().stream()
                .flatMap(l -> l.getProfanities().stream())
                .toList();
    }

    @Override
    public Boolean checkProfanity(String message){
        HashSet<String> words = new HashSet<String>(Arrays.stream(message.split(regex)).map(String::toLowerCase).toList());
        HashSet<String> profanities = new  HashSet<String>(getAllProfanities().stream().map(String::toLowerCase).toList());
        words.retainAll(profanities);
        return !words.isEmpty();
    }
}
