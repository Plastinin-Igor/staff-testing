package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

/**
 * Вопрос
 */

@Data
public class Question {
    private Long questionId;
    private Theme theme;
    private int curNumber;
    private String content;
    private String helpText;
}
