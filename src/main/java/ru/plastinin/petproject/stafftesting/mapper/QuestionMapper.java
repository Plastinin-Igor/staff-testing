package ru.plastinin.petproject.stafftesting.mapper;

import ru.plastinin.petproject.stafftesting.dto.QuestionCreateDto;
import ru.plastinin.petproject.stafftesting.dto.QuestionResponseDto;
import ru.plastinin.petproject.stafftesting.dto.QuestionUpdateDto;
import ru.plastinin.petproject.stafftesting.model.Question;
import ru.plastinin.petproject.stafftesting.model.Theme;

public final class QuestionMapper {

    public static QuestionResponseDto modelToDto(Question question) {
        QuestionResponseDto responseDto = new QuestionResponseDto();
        responseDto.setQuestionId(question.getQuestionId());
        responseDto.setTheme(question.getTheme() != null ? ThemeMapper.modelToDto(question.getTheme()) : null);
        responseDto.setCurNumber(question.getCurNumber());
        responseDto.setContent(question.getContent());
        responseDto.setHelpText(question.getHelpText());

        return responseDto;
    }

    public static Question dtoToModel(QuestionResponseDto responseDto) {
        Question question = new Question();
        question.setQuestionId(responseDto.getQuestionId());
        question.setTheme(responseDto.getTheme() != null ? ThemeMapper.dtoToModel(responseDto.getTheme()) : null);
        question.setCurNumber(responseDto.getCurNumber());
        question.setContent(responseDto.getContent());
        question.setHelpText(responseDto.getHelpText());

        return question;
    }

    public static Question updateDto(Question question, QuestionUpdateDto request) {
        if (request.hasTheme()) {
            question.setTheme(Theme.builder().themeId(request.getTheme()).build());
        }

        if (request.hasCurNumber()) {
            question.setCurNumber(request.getCurNumber());
        }

        if (request.hasContent()) {
            question.setContent(request.getContent());
        }

        if (request.hasHelpText()) {
            question.setHelpText(request.getHelpText());
        }

        return question;
    }

    public static Question createDto(QuestionCreateDto createDto) {
        Question question = new Question();
        question.setTheme(Theme.builder().themeId(createDto.getTheme()).build());
        question.setCurNumber(createDto.getCurNumber());
        question.setContent(createDto.getContent());
        question.setHelpText(createDto.getHelpText());

        return question;
    }

}
