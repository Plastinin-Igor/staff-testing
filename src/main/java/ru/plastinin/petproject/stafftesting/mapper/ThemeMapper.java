package ru.plastinin.petproject.stafftesting.mapper;

import ru.plastinin.petproject.stafftesting.dto.ThemeResponseDto;
import ru.plastinin.petproject.stafftesting.dto.ThemeCreateDto;
import ru.plastinin.petproject.stafftesting.dto.ThemeUpdateDto;
import ru.plastinin.petproject.stafftesting.model.Theme;

public final class ThemeMapper {

    public static ThemeResponseDto modelToDto(Theme theme) {
        ThemeResponseDto dto = new ThemeResponseDto();
        dto.setThemeId(theme.getThemeId());
        dto.setDirection(theme.getDirection() != null ? DirectionMapper.modelToDto(theme.getDirection()) : null);
        dto.setName(theme.getName());
        dto.setSignBlock(theme.isSignBlock());

        return dto;
    }

    public static Theme dtoToModel(ThemeResponseDto dto) {
        Theme theme = new Theme();
        theme.setDirection(dto.getDirection() != null ? DirectionMapper.dtoToModel(dto.getDirection()) : null);
        theme.setName(dto.getName());
        theme.setSignBlock(dto.isSignBlock());

        return theme;
    }

    public static Theme updateTheme(Theme theme, ThemeUpdateDto request) {
        if (request.hasDirection()) {
            theme.setDirection(request.getDirection() != null ? DirectionMapper.dtoToModel(request.getDirection()) : null);
        }
        if (request.hasName()) {
            theme.setName(request.getName());
        }
        theme.setSignBlock(request.isSignBlock());
        return theme;
    }

    public static Theme insertTheme(ThemeCreateDto insertDto) {
        Theme theme = new Theme();
        theme.setName(insertDto.getName());
        theme.setSignBlock(insertDto.isSignBlock());
        return theme;
    }


}
