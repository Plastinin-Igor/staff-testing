package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Тест
 */

@Data
public class Test {
    private Long testId;
    private Student student;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;
    private Theme theme;
}
