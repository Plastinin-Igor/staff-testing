package ru.plastinin.petproject.stafftesting.storage;

import ru.plastinin.petproject.stafftesting.model.Answer;

import java.util.Collection;

public interface AnswerStorage {
    Answer addAnswer(Answer answer);

    Answer updateAnswer(Answer answer);

    void deleteAnswer(Long answerId);

    Collection<Answer> allAnswer();

    Answer answerById(Long answerId);
}
