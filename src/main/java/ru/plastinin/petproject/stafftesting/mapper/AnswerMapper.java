package ru.plastinin.petproject.stafftesting.mapper;

import ru.plastinin.petproject.stafftesting.dto.AnswerCreateDto;
import ru.plastinin.petproject.stafftesting.dto.AnswerResponseDto;
import ru.plastinin.petproject.stafftesting.dto.AnswerUpdateDto;
import ru.plastinin.petproject.stafftesting.model.Answer;
import ru.plastinin.petproject.stafftesting.model.Question;

public final class AnswerMapper {

    public static AnswerResponseDto modelToDto(Answer answer) {
        AnswerResponseDto dto = new AnswerResponseDto();
        dto.setAnswerId(answer.getAnswerId());
        dto.setQuestion(answer.getQuestion() != null ? QuestionMapper.modelToDto(answer.getQuestion()) : null);
        dto.setContent(answer.getContent());
        dto.setSignRight(dto.isSignRight());
        return dto;
    }

    public static Answer dtoToModel(AnswerResponseDto dto) {
        Answer answer = new Answer();
        answer.setAnswerId(dto.getAnswerId());
        answer.setQuestion(dto.getQuestion() != null ? QuestionMapper.dtoToModel(dto.getQuestion()) : null);
        answer.setContent(dto.getContent());
        answer.setSignRight(dto.isSignRight());
        return answer;
    }

    public static Answer updateDto(Answer answer, AnswerUpdateDto updateDto) {
        if (updateDto.hasQuestion()) {
            answer.setQuestion(Question.builder().questionId(updateDto.getQuestion()).build());
        }

        if (updateDto.hasContent()) {
            answer.setContent(updateDto.getContent());
        }

        answer.setSignRight(updateDto.isSignRight());

        return answer;
    }

    static Answer insertDto(AnswerCreateDto createDto) {
        Answer answer = new Answer();
        answer.setQuestion(Question.builder().questionId(createDto.getQuestion()).build());
        answer.setContent(createDto.getContent());
        answer.setSignRight(createDto.isSignRight());
        return answer;
    }
}
