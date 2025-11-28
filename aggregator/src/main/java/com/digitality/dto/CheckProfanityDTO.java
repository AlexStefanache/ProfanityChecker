package com.digitality.dto;

public class CheckProfanityDTO {
    public Boolean profane;

    public CheckProfanityDTO(){}

    public CheckProfanityDTO(Boolean profane) {
        this.profane = profane;
    }
    public Boolean getProfane() {
        return profane;
    }
    public void setProfane(Boolean profane) {
        this.profane = profane;
    }
}
