package ru.ural.cars.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @Schema(description = "Id автомобиля")
    private Long id;

    @Schema(description = "Тип автомобиля")
    private String carType;

    @Schema(description = "Наименование автомобиля")
    private String carName;

    @Schema(description = "Модель автомобиля")
    private String carModel;

    @Schema(description = "Год производства")
    private Integer yearProduction;

    @Schema(description = "Uuid пользователя")
    private String userUuid;

    @Schema(description = "Дата создания")
    private ZonedDateTime createdAt;

    @Schema(description = "Дата обновления")
    private ZonedDateTime updatedAt;

    @Schema(description = "ВИН-номер")
    private String vinNumber;

    @Schema(description = "Id файлов транспортного средства")
    private List<Long> fileIds;

}
