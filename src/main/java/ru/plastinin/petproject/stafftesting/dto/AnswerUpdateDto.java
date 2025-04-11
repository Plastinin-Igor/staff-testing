package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class AnswerUpdateDto {
    private Long answerId;
    private Long question;
    private String content;
    private boolean signRight;

    public boolean hasQuestion() {
        return (question != null);
    }

    public boolean hasContent() {
        return !(content == null || content.isBlank());
    }

}
