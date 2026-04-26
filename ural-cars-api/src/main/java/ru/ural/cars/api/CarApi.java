package ru.ural.cars.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ural.cars.dto.CarDto;
import ru.ural.cars.dto.CarRequest;
import ru.ural.dto.PageDto;
import ru.ural.dto.PaginatedParamsDto;

@RequestMapping("/api/cars")
@Tag(name = "Car api", description = "API для работы с машинами")
public interface CarApi {

    @Operation(summary = "Создать транспорт")
    @PostMapping
    ResponseEntity<CarDto> create(@RequestBody CarRequest carRequest);

    @Operation(summary = "Получить транспорт по vin номеру")
    @GetMapping("/by-vin/{vin}")
    ResponseEntity<CarDto> getByVin(@PathVariable String vin);

    @Operation(summary = "Получить транспорт по id")
    @GetMapping("/{id}")
    ResponseEntity<CarDto> getById(@PathVariable Long id);

    @Operation(summary = "Получить пагинированный список транспортов")
    @GetMapping
    ResponseEntity<PageDto<CarDto>> getByFilters(PaginatedParamsDto paramsDto);

    @Operation(summary = "Изменить транспорт")
    @PutMapping("/{id}")
    ResponseEntity<CarDto> update(
            @PathVariable Long id,
            @RequestBody CarRequest carRequest
    );

    @Operation(summary = "Удалить транспорт")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}
