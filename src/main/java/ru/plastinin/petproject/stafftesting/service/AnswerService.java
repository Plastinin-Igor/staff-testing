package ru.plastinin.petproject.stafftesting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.plastinin.petproject.stafftesting.dto.AnswerResponseDto;
import ru.plastinin.petproject.stafftesting.mapper.AnswerMapper;
import ru.plastinin.petproject.stafftesting.storage.AnswerDbStorage;
import ru.plastinin.petproject.stafftesting.storage.DirectionDbStorage;
import ru.plastinin.petproject.stafftesting.storage.QuestionDbStorage;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerDbStorage answerDbStorage;
    private final QuestionDbStorage questionDbStorage;
    private final DirectionDbStorage directionDbStorage;

    public Collection<AnswerResponseDto> allAnswer() {
        return answerDbStorage.allAnswer()
                .stream()
                .map(AnswerMapper::modelToDto)
                .collect(Collectors.toList());

    }


}
