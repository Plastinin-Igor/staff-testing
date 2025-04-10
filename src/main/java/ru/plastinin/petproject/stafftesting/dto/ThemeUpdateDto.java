package ru.plastinin.petproject.stafftesting.dto;

import lombok.Data;

@Data
public class ThemeUpdateDto {
    private Long themeId;
    private DirectionResponseDto direction;
    private String name;
    private boolean signBlock;

    public boolean hasDirection() {
        return !(direction == null);
    }

    public boolean hasName() {
        return !(name == null || name.isBlank());
    }

}
