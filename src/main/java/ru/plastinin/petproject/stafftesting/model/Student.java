package ru.plastinin.petproject.stafftesting.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Участник тестирования
 *
 */

@Data
public class Student {
    private Long studentId;

    @NotBlank(message = "Логин не может быть пустым или содержать пробелы")
    private String Login;

    private String fullName;

    @NotNull(message = "Адрес электронной почты должен быть задан")
    @Email(message = "Не является электронной почтой")
    private String email;

    @Past(message = "Дата рождения не может быть в будущем")
    private LocalDate datebirth;

    @Size(min = 0, max = 2)
    private int gender;
}
