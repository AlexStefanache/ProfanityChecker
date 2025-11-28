package com.digitality.dto;

public class ProfanityResponseDTO {
    private String message;
    private Boolean valid;

    public ProfanityResponseDTO(String message, Boolean valid) {
        this.message = message;
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
