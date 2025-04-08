package ru.plastinin.petproject.stafftesting.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.plastinin.petproject.stafftesting.dto.DirectionDto;
import ru.plastinin.petproject.stafftesting.dto.DirectionUpdateDto;
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
}
