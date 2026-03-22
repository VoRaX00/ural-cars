package ru.ural.cars.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.ural.cars.dto.CarDto;
import ru.ural.cars.dto.CarRequest;
import ru.ural.cars.entities.Car;
import ru.ural.cars.mappers.CarMapper;
import ru.ural.cars.mappers.PaginatedMapper;
import ru.ural.cars.repositories.CarRepository;
import ru.ural.cars.repositories.CustomCarRepository;
import ru.ural.dto.PageDto;
import ru.ural.dto.PaginatedParamsDto;
import ru.ural.exceptions.NotFoundException;
import ru.ural.models.UserPrincipals;
import ru.ural.utils.JwtUtils;

import java.time.ZonedDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarMapper carMapper;

    private final PaginatedMapper paginatedMapper;

    private final CarRepository carRepository;

    private final CustomCarRepository customCarRepository;

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

    public CarDto findById(@NonNull Long id) {
        var foundCar = carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found car by id: %s".formatted(id)));

        return carMapper.toDto(foundCar);
    }

    public PageDto<CarDto> getPage(PaginatedParamsDto paramsDto) {
        var paramsModel = paginatedMapper.toModel(paramsDto);
        var items = customCarRepository.getItems(paramsModel);
        int totalResultCount = customCarRepository.getTotalResultCount(paramsModel.getFilters());
        int totalPageCount = totalResultCount % paramsModel.getItemsOnPage() == 0
                ? totalResultCount / paramsModel.getItemsOnPage()
                : totalResultCount / paramsModel.getItemsOnPage() + 1;

        return new PageDto<>(
                paramsModel.getCurrentPageNumber(),
                totalPageCount,
                totalResultCount,
                carMapper.toDto(items),
                paramsModel.getItemsOnPage()
        );
    }

}
