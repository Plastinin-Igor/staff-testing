package ru.plastinin.petproject.stafftesting.storage.mappers;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.plastinin.petproject.stafftesting.model.Answer;
import ru.plastinin.petproject.stafftesting.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AnswerRowMapper implements RowMapper<Answer> {

    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Answer answer = new Answer();
        answer.setAnswerId(rs.getLong("answer_id"));
        answer.setQuestion(Question.builder().questionId(rs.getLong("question_id")).build());
        answer.setContent(rs.getString("content"));
        answer.setSignRight(rs.getBoolean("sign_right"));
        return answer;
    }
}
