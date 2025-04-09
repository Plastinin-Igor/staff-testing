package ru.plastinin.petproject.stafftesting.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

/**
 * Направление тестирования (подготовки)
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direction {
    private Long directionId;
    @NotBlank(message = "Наименование не может быть пустым или содержать пробелы")
    private String name;

    private String description;

    @NotNull(message = "Дата начала действия направления должна быть задана")
    private LocalDate dateBegin;

    private LocalDate dateEnd;
}
