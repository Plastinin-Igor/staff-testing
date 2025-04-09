package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class ThemeDto {
    private Long themeId;
    private DirectionDto direction;
    private String name;
    private boolean signBlock;
}
