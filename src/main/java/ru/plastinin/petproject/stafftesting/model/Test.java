package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Тест
 */

@Data
public class Test {
    private Long testId;
    private Long studentId;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;
    private Long themeId;
}
