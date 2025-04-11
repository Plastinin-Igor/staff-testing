package ru.plastinin.petproject.stafftesting.model;

import lombok.*;

/**
 * Вопрос
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long questionId;
    private Theme theme;
    private int curNumber;
    private String content;
    private String helpText;
}
