package ru.ural.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import ru.ural.api.CarApi;
import ru.ural.dto.CarDto;
import ru.ural.dto.CarRequest;
import ru.ural.services.CarService;
import ural.ru.dto.PageDto;
import ural.ru.dto.PaginatedParamsDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {

    private final CarService carService;

    @Override
    public ResponseEntity<CarDto> create(CarRequest carRequest, Authentication authentication) {
        log.warn("Not implemented");
        return null;
    }

    @Override
    public ResponseEntity<CarDto> getById(Long id) {
        log.warn("Not implemented");
        return null;
    }

    @Override
    public ResponseEntity<PageDto<CarDto>> getByFilters(PaginatedParamsDto paramsDto) {
        log.warn("Not implemented");
        return null;
    }

    @Override
    public ResponseEntity<CarDto> update(Long id, CarRequest carRequest, Authentication authentication) {
        log.warn("Not implemented");
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id, Authentication authentication) {
        log.warn("Not implemented");
        return null;
    }

}
