package ru.ural.cars.api;

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

    @PostMapping
    ResponseEntity<CarDto> create(@RequestBody CarRequest carRequest);

    @GetMapping("/by-vin/{vin}")
    ResponseEntity<CarDto> getByVin(@PathVariable String vin);

    @GetMapping("/{id}")
    ResponseEntity<CarDto> getById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<PageDto<CarDto>> getByFilters(@RequestParam PaginatedParamsDto paramsDto);

    @PutMapping("/{id}")
    ResponseEntity<CarDto> update(
            @PathVariable Long id,
            @RequestBody CarRequest carRequest
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}
