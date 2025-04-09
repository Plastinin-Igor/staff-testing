package ru.plastinin.petproject.stafftesting.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.plastinin.petproject.stafftesting.dto.*;
import ru.plastinin.petproject.stafftesting.model.Theme;
import ru.plastinin.petproject.stafftesting.service.QuestionService;

import java.util.Collection;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("direction")
    public DirectionDto addDirection(@Valid @RequestBody DirectionDto directionDto) {
        log.info("Добавление направления {}.", directionDto.getName());
        return questionService.addDirection(directionDto);
    }

    @PutMapping("direction")
    public DirectionDto updateDirection(@Valid @RequestBody DirectionUpdateDto directionUpdateDto) {
        log.info("Обновление направления {} с id: {}.", directionUpdateDto.getName(),
                directionUpdateDto.getDirectionId());
        return questionService.updateDirection(directionUpdateDto);
    }

    @DeleteMapping("direction/{directionId}")
    public void deleteDirection(@PathVariable Long directionId) {
        log.info("Удаление направления с id: {}.", directionId);
        questionService.deleteDirection(directionId);
    }

    @GetMapping("directions")
    public Collection<DirectionDto> allDirection() {
        log.info("Выполнен запрос к списку направлений.");
        return questionService.allDirection();
    }

    @GetMapping("direction/{directionId}")
    public DirectionDto directionById(@PathVariable Long directionId) {
        log.info("Выполнен запрос к направлению с id: {}", directionId);
        return questionService.directionById(directionId);
    }

    @PostMapping("theme")
    public ThemeDto addTheme(@Valid @RequestBody ThemeInsertDto themeDto) {
        log.info("Добавление темы {}.", themeDto.getName());
        return questionService.addTheme(themeDto);
    }

    @PutMapping("theme")
    public ThemeDto updateTheme(@Valid @RequestBody ThemeUpdateDto themeUpdateDto) {
        log.info("Обновление темы {} с id: {}.", themeUpdateDto.getName(), themeUpdateDto.getThemeId());
        return questionService.updateTheme(themeUpdateDto);
    }

    @DeleteMapping("theme/{themeId}")
    public void deleteTheme(@PathVariable Long themeId) {
        log.info("Удаление темы с id: {}.", themeId);
        questionService.deleteTheme(themeId);
    }

    @GetMapping("themes")
    public Collection<ThemeDto> allTheme() {
        log.info("Выполнен запрос к списку тем.");
        return questionService.allTheme();
    }

    @GetMapping("theme/{themeId}")
    public ThemeDto themeById(@PathVariable Long themeId) {
        log.info("Выполнен запрос к теме с id: {}.", themeId);
        return questionService.themeById(themeId);
    }


}
