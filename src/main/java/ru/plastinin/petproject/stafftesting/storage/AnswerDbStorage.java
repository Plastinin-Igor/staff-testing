package ru.plastinin.petproject.stafftesting.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.plastinin.petproject.stafftesting.model.Answer;

import java.util.Collection;
import java.util.List;

@Repository
@Slf4j
public class AnswerDbStorage extends BaseDbStorage<Answer> implements AnswerStorage {

    private final static String FIND_ALL_ANSWER = """
            select a.answer_id,
            	   a.question_id,
            	   a.content,
            	   a.sign_right
              from answers a
            """;

    public AnswerDbStorage(JdbcTemplate jdbc, RowMapper<Answer> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Answer addAnswer(Answer answer) {
        return null;
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return null;
    }

    @Override
    public void deleteAnswer(Long answerId) {

    }

    @Override
    public Collection<Answer> allAnswer() {
        return findMany(FIND_ALL_ANSWER);
    }

    @Override
    public Answer answerById(Long answerId) {
        return null;
    }
}
