package com.digitality.dto;

import java.util.List;

public class ProfanityDTO {
    private List<String> profanities;

    public ProfanityDTO() {}
    public ProfanityDTO(List<String> profanities) {
        this.profanities = profanities;
    }
    public List<String> getProfanities() {
        return profanities;
    }
    public void setProfanities(List<String> profanities) {
        this.profanities = profanities;
    }
}
