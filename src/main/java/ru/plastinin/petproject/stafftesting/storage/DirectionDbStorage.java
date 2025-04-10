package ru.plastinin.petproject.stafftesting.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.plastinin.petproject.stafftesting.exception.NotFoundException;
import ru.plastinin.petproject.stafftesting.model.Direction;

import java.util.Collection;

@Repository
@Slf4j
public class DirectionDbStorage extends BaseDbStorage<Direction> implements DirectionStorage {

    private final static String FIND_ALL_DIRECTION = "select * from direction";
    private final static String FIND_DIRECTION_BY_ID = "select * from direction where direction_id = ?";
    private final static String INSERT_DIRECTION = """
            insert into direction 
            (name, description, date_begin, date_end) 
            values(?, ?, ?, ?)
            """;
    private final static String UPDATE_DIRECTION = """
            update direction
               set name = ?, description = ?, date_begin = ?, date_end = ?
             where direction_id = ?;
            """;
    private final static String DELETE_DIRECTION = "delete from direction where direction_id = ?";

    public DirectionDbStorage(JdbcTemplate jdbc, RowMapper<Direction> mapper) {
        super(jdbc, mapper);
    }

    @Override
    public Direction addDirection(Direction direction) {
        Long id = insert(INSERT_DIRECTION,
                direction.getName(),
                direction.getDescription(),
                direction.getDateBegin(),
                direction.getDateEnd());

        direction.setDirectionId(id);
        return direction;
    }

    @Override
    public Direction updateDirection(Direction direction) {
        update(UPDATE_DIRECTION,
                direction.getName(),
                direction.getDescription(),
                direction.getDateBegin(),
                direction.getDateEnd(),
                direction.getDirectionId());
        return direction;
    }

    @Override
    public void deleteDirection(Long directionId) {
        update(DELETE_DIRECTION, directionId);
    }

    @Override
    public Collection<Direction> allDirection() {
        return findMany(FIND_ALL_DIRECTION);
    }

    @Override
    public Direction directionById(Long directionId) {
        try {
            Direction direction = findOne(FIND_DIRECTION_BY_ID, directionId)
                    .orElseThrow(() ->
                            new NotFoundException("Направление с id: " + directionId + " не найдено в системе."));
            return direction;
        } catch (NotFoundException e) {
            log.error("Направление с id: {} не найдено в системе.", directionId);
            throw e;
        }
    }

}
