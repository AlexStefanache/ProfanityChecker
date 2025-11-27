package com.digitality.dto;

public class ResponseDTO {
    public Boolean profane;

    public ResponseDTO(){}

    public ResponseDTO(Boolean profane) {
        this.profane = profane;
    }
    public Boolean getProfane() {
        return profane;
    }
    public void setProfane(Boolean profane) {
        this.profane = profane;
    }
}
