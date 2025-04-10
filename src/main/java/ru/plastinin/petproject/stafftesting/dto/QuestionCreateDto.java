package ru.plastinin.petproject.stafftesting.dto;


import lombok.Data;

@Data
public class QuestionCreateDto {
    private Long questionId;
    private Long theme;
    private int curNumber;
    private String content;
    private String helpText;
}
