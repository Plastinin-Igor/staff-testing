package ru.plastinin.petproject.stafftesting.storage.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.plastinin.petproject.stafftesting.model.Theme;
import ru.plastinin.petproject.stafftesting.model.Direction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class ThemeRowMapper implements RowMapper<Theme> {
    @Override
    public Theme mapRow(ResultSet rs, int rowNum) throws SQLException {
        Theme theme = new Theme();
        theme.setThemeId(rs.getLong("theme_id"));
        theme.setName(rs.getString("name"));
        theme.setSignBlock(rs.getBoolean("sign_blocked"));

        Timestamp beginDate = rs.getTimestamp("date_begin");
        Timestamp endDate = rs.getTimestamp("date_end");

        if (endDate != null) {
            theme.setDirection(Direction
                    .builder()
                    .directionId(rs.getLong("direction_id"))
                    .name(rs.getString("direction_name"))
                    .description(rs.getString("description"))
                    .dateBegin(beginDate.toLocalDateTime().toLocalDate())
                    .dateEnd(endDate.toLocalDateTime().toLocalDate())
                    .build()
            );
        } else {
            theme.setDirection(Direction
                    .builder()
                    .directionId(rs.getLong("direction_id"))
                    .name(rs.getString("direction_name"))
                    .description(rs.getString("description"))
                    .dateBegin(beginDate.toLocalDateTime().toLocalDate())
                    .build()
            );
        }
        return theme;
    }
}
