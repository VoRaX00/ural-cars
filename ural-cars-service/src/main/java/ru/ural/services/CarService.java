package ru.ural.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.ural.dto.CarDto;
import ru.ural.dto.CarRequest;
import ru.ural.entities.Car;
import ru.ural.mappers.CarMapper;
import ru.ural.repositories.CarRepository;
import ural.ru.exceptions.NotFoundException;
import ural.ru.models.UserPrincipals;
import ural.ru.utils.JwtUtils;

import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    private final CarRepository carRepository;

    @NonNull
    public CarDto create(@NonNull CarRequest request, @Nullable Authentication authentication) {
        Car entity = carMapper.toEntity(request);

        UserPrincipals user = JwtUtils.getUser(authentication);

        entity.setUserUuid(UUID.fromString(user.getUuid()));
        entity.setCreatedAt(ZonedDateTime.now());

        Car savedCar = carRepository.save(entity);
        return carMapper.toDto(savedCar);
    }

    public CarDto findByVin(@NonNull String vin) {
        var foundCar = carRepository.findCarByVinNumber(vin)
                .orElseThrow(() -> new NotFoundException("Not found car by vin: %s".formatted(vin)));

        return carMapper.toDto(foundCar);
    }

}
