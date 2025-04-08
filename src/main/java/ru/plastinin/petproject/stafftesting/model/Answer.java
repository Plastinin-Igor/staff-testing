package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

/**
 * Ответ на вопрос
 */

@Data
public class Answer {
    private Long answerId;
    private Question question;
    private String content;
    private boolean signRight;
}
