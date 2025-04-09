package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class ThemeInsertDto {
    private Long themeId;
    private Long direction;
    private String name;
    private boolean signBlock;
}
