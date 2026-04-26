package ru.ural.cars.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.ural.cars.enums.CarType;
import ru.ural.entities.BaseEntity;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @JdbcTypeCode(SqlTypes.JSON)
    private List<Long> fileIds = new ArrayList<>();

}
