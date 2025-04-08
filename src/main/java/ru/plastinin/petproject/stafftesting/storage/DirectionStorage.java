package ru.plastinin.petproject.stafftesting.storage;

import ru.plastinin.petproject.stafftesting.model.Direction;

import java.util.Collection;

public interface DirectionStorage {

    Direction addDirection(Direction direction);

    Direction updateDirection(Direction direction);

    void deleteDirection(Long directionId);

    Collection<Direction> allDirection();

    Direction directionById(Long directionId);

}
