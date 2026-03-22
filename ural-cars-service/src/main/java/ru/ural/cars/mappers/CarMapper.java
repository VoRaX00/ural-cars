package ru.ural.cars.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.ural.cars.dto.CarDto;
import ru.ural.cars.dto.CarRequest;
import ru.ural.cars.entities.Car;
import ru.ural.cars.enums.CarType;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarMapper {

    @Mapping(target = "carType", expression = "java(car.getCarType().getValue())")
    CarDto toDto(Car car);

    List<CarDto> toDto(List<Car> cars);

    @Mapping(target = "userUuid", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "carType", source = "carType", qualifiedByName = "mapCarType")
    Car toEntity(CarRequest car);

    List<Car> toEntity(List<Car> cars);

    @Named("mapCarType")
    default CarType mapCarType(String value) {
        return CarType.parse(value);
    }

}
