package ru.plastinin.petproject.stafftesting.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DirectionDto {
    private Long directionId;
    @NotBlank(message = "Наименование не может быть пустым или содержать пробелы")
    private String name;

    private String description;

    @NotNull(message = "Дата начала действия направления должна быть задана")
    private LocalDate dateBegin;

    private LocalDate dateEnd;
}
