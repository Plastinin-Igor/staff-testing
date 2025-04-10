package ru.plastinin.petproject.stafftesting.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.plastinin.petproject.stafftesting.dto.ThemeCreateDto;
import ru.plastinin.petproject.stafftesting.dto.ThemeResponseDto;
import ru.plastinin.petproject.stafftesting.dto.ThemeUpdateDto;
import ru.plastinin.petproject.stafftesting.service.ThemeService;

import java.util.Collection;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ThemeController {

    private final ThemeService themeService;

    @PostMapping("theme")
    public ThemeResponseDto addTheme(@Valid @RequestBody ThemeCreateDto themeDto) {
        log.info("Добавление темы {}.", themeDto.getName());
        return themeService.addTheme(themeDto);
    }

    @PutMapping("theme")
    public ThemeResponseDto updateTheme(@Valid @RequestBody ThemeUpdateDto themeUpdateDto) {
        log.info("Обновление темы {} с id: {}.", themeUpdateDto.getName(), themeUpdateDto.getThemeId());
        return themeService.updateTheme(themeUpdateDto);
    }

    @DeleteMapping("theme/{themeId}")
    public void deleteTheme(@PathVariable Long themeId) {
        log.info("Удаление темы с id: {}.", themeId);
        themeService.deleteTheme(themeId);
    }

    @GetMapping("theme")
    public Collection<ThemeResponseDto> allTheme() {
        log.info("Выполнен запрос к списку тем.");
        return themeService.allTheme();
    }

    @GetMapping("theme/{themeId}")
    public ThemeResponseDto themeById(@PathVariable Long themeId) {
        log.info("Выполнен запрос к теме с id: {}.", themeId);
        return themeService.themeById(themeId);
    }

}
