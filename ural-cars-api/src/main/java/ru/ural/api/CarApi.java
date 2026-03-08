package ru.ural.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.ural.dto.CarDto;
import ru.ural.dto.CarRequest;
import ural.ru.dto.PageDto;
import ural.ru.dto.PaginatedParamsDto;

@RequestMapping("/api/cars")
@Tag(name = "Car api", description = "API грузов платформы BACAR")
public interface CarApi {

    @PostMapping
    ResponseEntity<CarDto> create(@RequestBody CarRequest carRequest, Authentication authentication);

    @GetMapping("/{id}")
    ResponseEntity<CarDto> getById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<PageDto<CarDto>> getByFilters(@RequestParam PaginatedParamsDto paramsDto);

    @PutMapping("/{id}")
    ResponseEntity<CarDto> update(
            @PathVariable Long id,
            @RequestBody CarRequest carRequest,
            Authentication authentication
    );

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id, Authentication authentication);

}
