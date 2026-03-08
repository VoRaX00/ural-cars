package ru.ural.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarType {

    PASSENGER("Легковой автомобиль"),
    CARGO_TRUCK("Грузовой автомобиль");

    private final String value;

}
