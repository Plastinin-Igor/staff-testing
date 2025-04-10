package ru.plastinin.petproject.stafftesting.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.plastinin.petproject.stafftesting.dto.*;
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
    public DirectionResponseDto addDirection(@Valid @RequestBody DirectionResponseDto directionResponseDto) {
        log.info("Добавление направления {}.", directionResponseDto.getName());
        return questionService.addDirection(directionResponseDto);
    }

    @PutMapping("direction")
    public DirectionResponseDto updateDirection(@Valid @RequestBody DirectionUpdateDto directionUpdateDto) {
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
    public Collection<DirectionResponseDto> allDirection() {
        log.info("Выполнен запрос к списку направлений.");
        return questionService.allDirection();
    }

    @GetMapping("direction/{directionId}")
    public DirectionResponseDto directionById(@PathVariable Long directionId) {
        log.info("Выполнен запрос к направлению с id: {}", directionId);
        return questionService.directionById(directionId);
    }


}
