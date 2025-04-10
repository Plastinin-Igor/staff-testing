package ru.plastinin.petproject.stafftesting.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.plastinin.petproject.stafftesting.dto.QuestionCreateDto;
import ru.plastinin.petproject.stafftesting.dto.QuestionResponseDto;
import ru.plastinin.petproject.stafftesting.dto.QuestionUpdateDto;
import ru.plastinin.petproject.stafftesting.service.QuestionService;

import java.util.Collection;

@RestController
@Slf4j
@Valid
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("question")
    public QuestionResponseDto addQuestion(@Valid @RequestBody QuestionCreateDto createDto) {
        log.info("Добавление вопроса c id: {}.", createDto.getQuestionId());
        return questionService.addQuestion(createDto);
    }

    @PutMapping("question")
    public QuestionResponseDto updateQuestion(@Valid @RequestBody QuestionUpdateDto updateDto) {
        log.info("Обновление вопроса с id: {}.", updateDto.getQuestionId());
        return questionService.updateQuestion(updateDto);
    }

    @DeleteMapping("question/{questionId}")
    public void deleteQuestion(@PathVariable Long questionId) {
        log.info("Удаление вопроса с id: {}.", questionId);
        questionService.deleteQuestion(questionId);
    }

    @GetMapping("question")
    public Collection<QuestionResponseDto> allQuestion() {
        log.info("Выполнен запрос к списку вопросов.");
        return questionService.allQuestion();
    }

    @GetMapping("question/{questionId}")
    public QuestionResponseDto questionById(@PathVariable Long questionId) {
        log.info("Выполнен запрос к вопросу с id: {}.", questionId);
        return questionService.questionById(questionId);
    }

}
