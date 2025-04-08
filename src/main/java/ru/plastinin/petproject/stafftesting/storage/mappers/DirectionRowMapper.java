package ru.plastinin.petproject.stafftesting.storage.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.plastinin.petproject.stafftesting.model.Direction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class DirectionRowMapper implements RowMapper<Direction> {
    @Override
    public Direction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Direction direction = new Direction();
        direction.setDirectionId(rs.getLong("direction_id"));
        direction.setName(rs.getString("name"));
        direction.setDescription(rs.getString("description"));

        Timestamp dateBegin = rs.getTimestamp("date_begin");
        direction.setDateBegin(dateBegin.toLocalDateTime().toLocalDate());

        if (rs.getTimestamp("date_end") != null) {
            Timestamp dateEnd = rs.getTimestamp("date_end");
            direction.setDateEnd(dateEnd.toLocalDateTime().toLocalDate());
        }

        return direction;
    }
}
