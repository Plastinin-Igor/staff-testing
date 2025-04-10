package ru.plastinin.petproject.stafftesting.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.plastinin.petproject.stafftesting.exception.NotFoundException;
import ru.plastinin.petproject.stafftesting.model.Question;

import java.util.Collection;

@Repository
@Slf4j
public class QuestionDbStorage extends BaseDbStorage<Question> implements QuestionStorage {

    private final static String FIND_ALL_QUESTION = """
            select q.question_id,
            	   t.theme_id,
            	   d.direction_id,
            	   d.name direction_name,
            	   d.description direction_description,
            	   d.date_begin,
            	   d.date_end,
            	   t.name theme_name,
            	   t.sign_blocked,
            	   q.cur_number,
            	   q.content,
            	   q.help_text
              from questions q
              inner join themes t on (t.theme_id = q.theme_id)
              inner join direction d on (d.direction_id = t.direction_id)
            """;

    private final static String FIND_QUESTION_BY_ID = """
            select q.question_id,
            	   t.theme_id,
            	   d.direction_id,
            	   d.name direction_name,
            	   d.description direction_description,
            	   d.date_begin,
                   d.date_end,
            	   t.name theme_name,
            	   t.sign_blocked,
            	   q.cur_number,
            	   q.content,
            	   q.help_text
              from questions q
             inner join themes t on (t.theme_id = q.theme_id)
             inner join direction d on (d.direction_id = t.direction_id)
             where q.question_id = ?
            """;

    private final static String INSERT_QUESTION = """
            insert into questions (theme_id, cur_number, content, help_text) values(?, ?, ?, ?);
            """;

    private final static String UPDATE_QUESTION = """
            update questions set theme_id = ?, cur_number = ?, content = ?, help_text = ? where question_id = ?
            """;

    private final static String DELETE_QUESTION = """
            delete from questions where question_id = ?
            """;

    public QuestionDbStorage(JdbcTemplate jdbc, RowMapper<Question> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Question addQuestion(Question question) {
        Long id = insert(INSERT_QUESTION,
                question.getTheme().getThemeId(),
                question.getCurNumber(),
                question.getContent(),
                question.getHelpText());
        question.setQuestionId(id);
        return question;
    }

    @Override
    public Question updateQuestion(Question question) {
        update(UPDATE_QUESTION,
                question.getTheme().getThemeId(),
                question.getCurNumber(),
                question.getContent(),
                question.getHelpText(),
                question.getQuestionId());
        return question;
    }

    @Override
    public void deleteQuestion(Long themeId) {
        update(DELETE_QUESTION, themeId);
    }

    @Override
    public Collection<Question> allQuestion() {
        return findMany(FIND_ALL_QUESTION);
    }

    @Override
    public Question questionById(Long themeId) {
        try {
            Question question = findOne(FIND_QUESTION_BY_ID, themeId)
                    .orElseThrow(() -> new NotFoundException("Вопрос с id: " + themeId + " не найден в системе."));
            return question;
        } catch (NotFoundException e) {
            log.error("Вопрос с id: {} не найден в системе.", themeId);
            throw e;
        }
    }
}
