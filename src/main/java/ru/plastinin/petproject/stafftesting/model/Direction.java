package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * Направление тестирования (подготовки)
 *
 */

@Data
public class Direction {
    private Long directionId;
    private String name;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
}
