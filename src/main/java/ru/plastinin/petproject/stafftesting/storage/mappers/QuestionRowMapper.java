package ru.plastinin.petproject.stafftesting.storage.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.plastinin.petproject.stafftesting.model.Direction;
import ru.plastinin.petproject.stafftesting.model.Question;
import ru.plastinin.petproject.stafftesting.model.Theme;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();

        Timestamp beginDate = rs.getTimestamp("date_begin");
        Timestamp endDate = rs.getTimestamp("date_end");
        Direction direction;

        if (endDate != null) {
            direction = Direction
                    .builder()
                    .directionId(rs.getLong("direction_id"))
                    .name(rs.getString("direction_name"))
                    .description(rs.getString("description"))
                    .dateBegin(beginDate.toLocalDateTime().toLocalDate())
                    .dateEnd(endDate.toLocalDateTime().toLocalDate())
                    .build();
        } else {
            direction = Direction
                    .builder()
                    .directionId(rs.getLong("direction_id"))
                    .name(rs.getString("direction_name"))
                    .description(rs.getString("description"))
                    .dateBegin(beginDate.toLocalDateTime().toLocalDate())
                    .build();
        }


        question.setQuestionId(rs.getLong("question_id"));
        question.setTheme(Theme.builder()
                .themeId(rs.getLong("theme_id"))
                .direction(direction)
                .name(rs.getString("theme_name"))
                .signBlock(rs.getBoolean("sign_blocked"))
                .build());
        question.setCurNumber(rs.getInt("cur_number"));
        question.setContent(rs.getString("content"));
        question.setHelpText(rs.getString("help_text"));
        return question;
    }
}
