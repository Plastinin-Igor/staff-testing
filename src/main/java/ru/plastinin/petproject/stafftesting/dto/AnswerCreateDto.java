package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class AnswerCreateDto {
    private Long answerId;
    private Long question;
    private String content;
    private boolean signRight;
}
