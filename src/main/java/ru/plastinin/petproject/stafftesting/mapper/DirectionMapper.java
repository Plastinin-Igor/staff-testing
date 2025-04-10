package ru.plastinin.petproject.stafftesting.mapper;


import ru.plastinin.petproject.stafftesting.dto.DirectionResponseDto;
import ru.plastinin.petproject.stafftesting.dto.DirectionUpdateDto;
import ru.plastinin.petproject.stafftesting.model.Direction;

public final class DirectionMapper {
    public static DirectionResponseDto modelToDto(Direction direction) {
        DirectionResponseDto dto = new DirectionResponseDto();
        dto.setDirectionId(direction.getDirectionId());
        dto.setName(direction.getName());
        dto.setDescription(direction.getDescription());
        dto.setDateBegin(direction.getDateBegin());
        dto.setDateEnd(direction.getDateEnd());
        return dto;
    }

    public static Direction dtoToModel(DirectionResponseDto dto) {
        Direction direction = new Direction();
        direction.setDirectionId(dto.getDirectionId());
        direction.setName(dto.getName());
        direction.setDescription(dto.getDescription());
        direction.setDateBegin(dto.getDateBegin());
        direction.setDateEnd(dto.getDateEnd());
        return direction;
    }


    public static Direction updateDirection(Direction direction, DirectionUpdateDto request) {
        if (request.hasName()) {
            direction.setName(request.getName());
        }
        if (request.hasDescription()) {
            direction.setDescription(request.getDescription());
        }
        if (request.hasDateBegin()) {
            direction.setDateBegin(request.getDateBegin());
        }
        if (request.hasDateEnd()) {
            direction.setDateEnd(request.getDateEnd());
        }
        return direction;
    }


}
