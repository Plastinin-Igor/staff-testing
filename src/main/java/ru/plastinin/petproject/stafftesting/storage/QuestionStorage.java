package ru.plastinin.petproject.stafftesting.storage;

import ru.plastinin.petproject.stafftesting.model.Question;

import java.util.Collection;

public interface QuestionStorage {

    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    void deleteQuestion(Long themeId);

    Collection<Question> allQuestion();

    Question questionById(Long themeId);

}
