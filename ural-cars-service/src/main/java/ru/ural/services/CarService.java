package ru.ural.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.ural.dto.CarDto;
import ru.ural.dto.CarRequest;
import ru.ural.entities.Car;
import ru.ural.mappers.CarMapper;
import ru.ural.repositories.CarRepository;
import ru.ural.exceptions.NotFoundException;
import ru.ural.models.UserPrincipals;
import ru.ural.utils.JwtUtils;

import java.time.ZonedDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    private final CarRepository carRepository;

    @NonNull
    public CarDto create(@NonNull CarRequest request) {
        Car entity = carMapper.toEntity(request);
        Authentication authentication = JwtUtils.getAuthentication();
        UserPrincipals user = JwtUtils.getUser(authentication);

        entity.setUserUuid(user.getUuid());
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
