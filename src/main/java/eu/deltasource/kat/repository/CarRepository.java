package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByPlateNumber(String plateNumber);

    Optional<Car> findByVinNumber(String vinNumber);
}
