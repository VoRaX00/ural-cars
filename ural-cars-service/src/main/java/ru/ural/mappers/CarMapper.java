package ru.ural.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.ural.dto.CarDto;
import ru.ural.dto.CarRequest;
import ru.ural.entities.Car;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    CarDto toDto(Car car);

    List<CarDto> toDto(List<Car> cars);

    Car toEntity(CarRequest car);

    List<Car> toEntity(List<Car> cars);

}
