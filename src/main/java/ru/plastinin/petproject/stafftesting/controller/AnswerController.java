package ru.plastinin.petproject.stafftesting.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.plastinin.petproject.stafftesting.dto.AnswerResponseDto;
import ru.plastinin.petproject.stafftesting.service.AnswerService;

import java.util.Collection;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("answer")
    public Collection<AnswerResponseDto> allAnswers() {
        return answerService.allAnswer();
    }

}
