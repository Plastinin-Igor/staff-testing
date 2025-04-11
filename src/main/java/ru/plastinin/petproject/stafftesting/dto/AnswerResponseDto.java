package ru.plastinin.petproject.stafftesting.dto;


import lombok.Data;

@Data
public class AnswerResponseDto {
    private Long answerId;
    private QuestionResponseDto question;
    private String content;
    private boolean signRight;
}
