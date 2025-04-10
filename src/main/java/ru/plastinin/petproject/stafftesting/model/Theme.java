package ru.plastinin.petproject.stafftesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тема тестирования
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    private Long themeId;
    private Direction direction;
    private String name;
    private boolean signBlock;
}
