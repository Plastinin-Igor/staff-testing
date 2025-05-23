package ru.plastinin.petproject.stafftesting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plastinin.petproject.stafftesting.dto.*;
import ru.plastinin.petproject.stafftesting.exception.NotFoundException;
import ru.plastinin.petproject.stafftesting.model.Direction;
import ru.plastinin.petproject.stafftesting.storage.DirectionDbStorage;
import ru.plastinin.petproject.stafftesting.mapper.DirectionMapper;
import ru.plastinin.petproject.stafftesting.storage.ThemeDbStorage;


import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DirectionService {

    private final DirectionDbStorage directionDbStorage;
    private final ThemeDbStorage themeDbStorage;

    public DirectionResponseDto addDirection(DirectionResponseDto directionResponseDto) {
        Direction direction = DirectionMapper.dtoToModel(directionResponseDto);
        return DirectionMapper.modelToDto(directionDbStorage.addDirection(direction));
    }

    public DirectionResponseDto updateDirection(DirectionUpdateDto updateDto) {
        directionExists(updateDto.getDirectionId());
        Direction direction = directionDbStorage.directionById(updateDto.getDirectionId());
        direction = DirectionMapper.updateDirection(direction, updateDto);
        direction = directionDbStorage.updateDirection(direction);
        return DirectionMapper.modelToDto(direction);
    }

    public void deleteDirection(Long directionId) {
        directionExists(directionId);
        directionDbStorage.deleteDirection(directionId);
    }

    public Collection<DirectionResponseDto> allDirection() {
        return directionDbStorage.allDirection()
                .stream()
                .map(DirectionMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public DirectionResponseDto directionById(Long directionId) {
        return DirectionMapper.modelToDto(directionDbStorage.directionById(directionId));
    }

    private void directionExists(Long directionId) {
        if (directionDbStorage.directionById(directionId) == null) {
            log.error("Направление с id {} не найдено в системе.", directionId);
            throw new NotFoundException("Направление с id " + directionId + " не найдено в системе.");
        }
    }

}
