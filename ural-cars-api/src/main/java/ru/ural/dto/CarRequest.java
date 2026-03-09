package ru.ural.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    @Schema(description = "Тип автомобиля")
    private String carType;

    @Schema(description = "Наименование автомобиля")
    private String carName;

    @Schema(description = "Модель автомобиля")
    private String carModel;

    @Schema(description = "Год производства")
    private Integer yearProduction;

    @Schema(description = "ВИН-номер")
    private String vinNumber;

}
