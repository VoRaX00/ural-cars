package ru.ural.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ural.dto.CarDto;
import ru.ural.dto.CarRequest;
import ru.ural.dto.PageDto;
import ru.ural.dto.PaginatedParamsDto;

@RequestMapping("/api/cars")
@Tag(name = "Car api", description = "API грузов платформы BACAR")
public interface CarApi {

    @PostMapping
    ResponseEntity<CarDto> create(@RequestBody CarRequest carRequest);

    @GetMapping("/{vin}")
    ResponseEntity<CarDto> getByVin(@PathVariable String vin);

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
