package com.digitality.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "profanity")
public class Profanity {
    @MongoId
    private String id;
    private List<String> profanities;

    public Profanity() {}
    public Profanity(String id, List<String> profanities) {
        this.id = id;
        this.profanities = profanities;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<String> getProfanities() {
        return profanities;
    }
    public void setProfanities(List<String> profanities) {
        this.profanities = profanities;
    }
}
