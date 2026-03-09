package ru.ural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ural.entities.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarByVinNumber(String vinNumber);

}
