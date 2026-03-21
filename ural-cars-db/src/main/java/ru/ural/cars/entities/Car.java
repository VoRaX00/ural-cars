package ru.ural.cars.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.ural.cars.enums.CarType;
import ru.ural.entities.BaseEntity;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private Integer yearProduction;

    @Column(nullable = false)
    private String userUuid;

    @Column(nullable = false)
    private ZonedDateTime createdAt;

    @Column
    private ZonedDateTime updatedAt;

    @Column(nullable = false, unique = true)
    private String vinNumber;

}
