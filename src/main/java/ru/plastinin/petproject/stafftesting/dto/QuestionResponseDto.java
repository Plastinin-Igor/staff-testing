package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class QuestionResponseDto {
    private Long questionId;
    private ThemeResponseDto theme;
    private int curNumber;
    private String content;
    private String helpText;
}
