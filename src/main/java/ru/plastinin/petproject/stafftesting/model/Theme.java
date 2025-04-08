package ru.plastinin.petproject.stafftesting.model;

import lombok.Data;

/**
 * Тема тестирования
 */

@Data
public class Theme {
    private Long themeId;
    private Direction direction;
    private String name;
    private boolean signBlock;
}
