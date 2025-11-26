package com.digitality.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitality.repository.ProfanityRepository;

@Service
public class ProfanityServiceImpl implements ProfanityService{
	private ProfanityRepository profanityRepository;
	public ProfanityServiceImpl(ProfanityRepository profanityRepository) {
		this.profanityRepository = profanityRepository;
	}
	
	@Override
	public List<String> getAllProfanities(){
		return profanityRepository.findAllProfanities()
				.stream()
				.flatMap(p -> p.getProfanities().stream())
				.toList();
	}
}
