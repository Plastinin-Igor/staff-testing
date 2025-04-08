package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

/**
 * Вопросы тестирования и признак правильно ли ответил на вопрос пользователь
 */

@Data
public class Testquestion {
    private Long testquestionid;
    private Question question;
    private boolean signRight;
}
