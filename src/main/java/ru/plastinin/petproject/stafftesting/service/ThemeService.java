package ru.plastinin.petproject.stafftesting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plastinin.petproject.stafftesting.dto.ThemeCreateDto;
import ru.plastinin.petproject.stafftesting.dto.ThemeResponseDto;
import ru.plastinin.petproject.stafftesting.dto.ThemeUpdateDto;
import ru.plastinin.petproject.stafftesting.mapper.ThemeMapper;
import ru.plastinin.petproject.stafftesting.model.Direction;
import ru.plastinin.petproject.stafftesting.model.Theme;
import ru.plastinin.petproject.stafftesting.storage.DirectionDbStorage;
import ru.plastinin.petproject.stafftesting.storage.ThemeDbStorage;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ThemeService {

    private final DirectionDbStorage directionDbStorage;
    private final ThemeDbStorage themeDbStorage;

    public ThemeResponseDto addTheme(ThemeCreateDto themeDto) {
        Direction direction = directionDbStorage.directionById(themeDto.getDirection());
        Theme theme = ThemeMapper.insertTheme(themeDto);
        theme.setDirection(direction);
        return ThemeMapper.modelToDto(themeDbStorage.addTheme(theme));
    }

    public ThemeResponseDto updateTheme(ThemeUpdateDto updateDto) {
        //TODO добавить exists
        Theme theme = themeDbStorage.themeById(updateDto.getThemeId());
        theme = ThemeMapper.updateTheme(theme, updateDto);
        theme = themeDbStorage.updateTheme(theme);
        return ThemeMapper.modelToDto(theme);
    }

    public void deleteTheme(Long themeId) {
        themeDbStorage.themeById(themeId);
        themeDbStorage.deleteTheme(themeId);
    }

    public Collection<ThemeResponseDto> allTheme() {
        return themeDbStorage.allTheme()
                .stream()
                .map(ThemeMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public ThemeResponseDto themeById(Long themeId) {
        return ThemeMapper.modelToDto(themeDbStorage.themeById(themeId));
    }

}
