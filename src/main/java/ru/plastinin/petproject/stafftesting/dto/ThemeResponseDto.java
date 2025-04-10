package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class ThemeResponseDto {
    private Long themeId;
    private DirectionResponseDto direction;
    private String name;
    private boolean signBlock;
}
