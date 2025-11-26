package com.digitality.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.digitality.model.ProfanityGroup;

public interface ProfanityRepository extends MongoRepository<ProfanityGroup, String>{
	@Query(value = "{}", fields = "{ 'profanities': 1 }")
	List<ProfanityOnly> findAllProfanities();
}
