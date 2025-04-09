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

        //TODO Попробовать найти более оптимальное решение
        //TODO так сделано, что бы обойти ошибку: java.lang.NullPointerException: Cannot invoke "java.sql.Timestamp.toLocalDateTime()" because "endDate" is null
        if (rs.getTimestamp("date_end") != null) {
            Timestamp endDate = rs.getTimestamp("date_end");
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
