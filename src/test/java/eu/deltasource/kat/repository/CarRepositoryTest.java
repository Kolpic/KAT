package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;
    private Car newCar;

    @BeforeEach
    void setUp() {
        newCar = new Car(5L, "Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", null);
        carRepository.save(newCar);
    }

    @Test
    public void testFindByPlateNumberShouldFindSuccessful() {
        // WHEN

        Optional<Car> optionalCar = carRepository.findByPlateNumber("PB0000KP");

        // THEN

        assertEquals(optionalCar.get().getPlateNumber(), newCar.getPlateNumber());
    }

    @Test
    public void testFindByPlateNumberShouldNotFindSuccessful() {
        // WHEN

        Optional<Car> optionalCar = carRepository.findByPlateNumber("Not existing plate number");

        // THEN

        assertTrue(optionalCar.isEmpty());
    }

    @Test
    public void testFindByVinNumberShouldFindSuccessful() {
        // WHEN

        Optional<Car> optionalCar = carRepository.findByVinNumber("4y45g22");

        // THEN

        assertEquals(optionalCar.get().getVinNumber(), newCar.getVinNumber());
    }

    @Test
    public void testFindByVinNumberShouldNotFindSuccessful() {
        // WHEN

        Optional<Car> optionalCar = carRepository.findByVinNumber("Not existing vin number");

        // THEN

        assertTrue(optionalCar.isEmpty());
    }
}