package ru.plastinin.petproject.stafftesting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plastinin.petproject.stafftesting.dto.QuestionCreateDto;
import ru.plastinin.petproject.stafftesting.dto.QuestionResponseDto;
import ru.plastinin.petproject.stafftesting.dto.QuestionUpdateDto;
import ru.plastinin.petproject.stafftesting.mapper.QuestionMapper;
import ru.plastinin.petproject.stafftesting.model.Question;
import ru.plastinin.petproject.stafftesting.model.Theme;
import ru.plastinin.petproject.stafftesting.storage.QuestionDbStorage;
import ru.plastinin.petproject.stafftesting.storage.ThemeDbStorage;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionDbStorage questionDbStorage;
    private final ThemeDbStorage themeDbStorage;

    public QuestionResponseDto addQuestion(QuestionCreateDto questionCreateDto) {
        Theme theme = themeDbStorage.themeById(questionCreateDto.getTheme());
        Question question = QuestionMapper.createDto(questionCreateDto);
        question.setTheme(theme);
        question = questionDbStorage.addQuestion(question);
        return QuestionMapper.modelToDto(question);
    }

    public QuestionResponseDto updateQuestion(QuestionUpdateDto questionUpdateDto) {
        Question question = questionDbStorage.questionById(questionUpdateDto.getQuestionId());
        question = QuestionMapper.updateDto(question, questionUpdateDto);
        question = questionDbStorage.updateQuestion(question);
        return QuestionMapper.modelToDto(question);
    }

    public void deleteQuestion(Long questionId) {
        questionDbStorage.questionById(questionId);
        questionDbStorage.deleteQuestion(questionId);
    }

    public Collection<QuestionResponseDto> allQuestion() {
        return questionDbStorage.allQuestion()
                .stream()
                .map(QuestionMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public QuestionResponseDto questionById(Long questionId) {
        Question question = questionDbStorage.questionById(questionId);
        return QuestionMapper.modelToDto(question);
    }
}
