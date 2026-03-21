package ru.ural.cars.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.ural.cars.api.CarApi;
import ru.ural.cars.dto.CarDto;
import ru.ural.cars.dto.CarRequest;
import ru.ural.cars.services.CarService;
import ru.ural.dto.PageDto;
import ru.ural.dto.PaginatedParamsDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {

    private final CarService carService;

    @Override
    public ResponseEntity<CarDto> create(CarRequest carRequest) {
        return new ResponseEntity<>(carService.create(carRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CarDto> getByVin(String vin) {
        return ResponseEntity.ok(carService.findByVin(vin));
    }

    @Override
    public ResponseEntity<PageDto<CarDto>> getByFilters(PaginatedParamsDto paramsDto) {
        log.warn("Not implemented");
        return null;
    }

    @Override
    public ResponseEntity<CarDto> update(Long id, CarRequest carRequest) {
        log.warn("Not implemented");
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        log.warn("Not implemented");
        return null;
    }

}
