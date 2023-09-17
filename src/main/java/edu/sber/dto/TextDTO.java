package edu.sber.dto;

import jakarta.validation.constraints.NotEmpty;

public class TextDTO {
    @NotEmpty
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
