package ru.plastinin.petproject.stafftesting.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.plastinin.petproject.stafftesting.exception.NotFoundException;
import ru.plastinin.petproject.stafftesting.model.Theme;

import java.util.Collection;

@Repository
@Slf4j
public class ThemeDbStorage extends BaseDbStorage<Theme> implements ThemeStorage {

    private final static String FIND_ALL_THEMES = """
            select t.theme_id,
            	   t.name,
            	   t.sign_blocked,
            	   d.direction_id,
            	   d.name direction_name,
            	   d.description,
            	   d.date_begin,
            	   d.date_end
              from themes t
             inner join direction d on (d.direction_id = t.direction_id)
            """;

    private final static String FIND_THEMES_BY_ID = """
            select t.theme_id,
            	   t.name,
            	   t.sign_blocked,
            	   d.direction_id,
            	   d.name direction_name,
            	   d.description,
            	   d.date_begin,
            	   d.date_end
              from themes t
             inner join direction d on (d.direction_id = t.direction_id)
             where t.THEME_ID = ?
            """;

    private final static String INSERT_THEME = """
            insert into themes
            (direction_id, name, sign_blocked) 
            values(?, ?, ?)
            """;

    private final static String UPDATE_THEME = """
            update themes
               set direction_id = ?,
                   name = ?,
                   sign_blocked = ?
             where theme_id = ?
            """;

    private final static String DELETE_THEME = """
            delete from themes where theme_id = ? 
            """;

    public ThemeDbStorage(JdbcTemplate jdbc, RowMapper<Theme> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Theme addTheme(Theme theme) {
        Long id = insert(INSERT_THEME,
                theme.getDirection().getDirectionId(),
                theme.getName(),
                theme.isSignBlock());
        theme.setThemeId(id);
        return theme;
    }

    @Override
    public Theme updateTheme(Theme theme) {
        update(UPDATE_THEME,
                theme.getDirection().getDirectionId(),
                theme.getName(),
                theme.isSignBlock(),
                theme.getThemeId());
        return theme;
    }

    @Override
    public void deleteTheme(Long themeId) {
        update(DELETE_THEME, themeId);
    }

    @Override
    public Collection<Theme> allTheme() {
        return findMany(FIND_ALL_THEMES);
    }

    @Override
    public Theme themeById(Long themeId) {
        try {
            Theme theme = findOne(FIND_THEMES_BY_ID, themeId)
                    .orElseThrow(() ->
                            new NotFoundException("Тема с id: " + themeId + " не найдена в системе."));
            return theme;
        } catch (NotFoundException e) {
            log.error("Тема с id: {} не найдена в системе.", themeId);
            throw e;
        }
    }
}
