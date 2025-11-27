package com.digitality.repository;

import com.digitality.dto.ProfanityDTO;
import com.digitality.model.Profanity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfanityRepository extends MongoRepository<Profanity,String> {
    @Query(value = "{}", fields = "{ '_id': 0 }")
    List<ProfanityDTO> findAllProfanities();
}
