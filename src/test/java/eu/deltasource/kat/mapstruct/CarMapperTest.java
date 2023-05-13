package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.enums.Sex;
import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.model.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);
    private Person person;
    private DrivingLicense drivingLicense;
    private CarDTO carDTO;
    private Car car;

    @BeforeEach
    void setUp() {
        drivingLicense = new DrivingLicense(3L, "Galin", "Petrov", "Petrov",
                Date.valueOf("2030-02-01"), Date.valueOf("2040-02-01"),
                "Plovdiv", Sex.MALE);
        person = new Person(2L, 34242,
                "{\"phone\": \"089342524\", \"email\": \"cdcbsadcs@gmail.com\"}",drivingLicense);
    }

    @Test
    public void testCarDTOWithPersonToCarShouldMapSuccessful() {
        // GIVEN

        carDTO = new CarDTO("Opel", "Corsa", true,
                true, "PB0543KP", Date.valueOf("1997-02-01"),
                "Red", "wf4fe22", 34242);

        // WHEN

        Car mappedCar = carMapper.carDTOWithPersonToCar(carDTO, person);

        // THEN

        assertNull(mappedCar.getId());
        assertEquals(mappedCar.getPerson().getDrivingLicense().getId(), 3L);
        assertEquals(mappedCar.getPerson().getId(), 2L);
    }

    @Test
    public void testCarToCarDTOShouldMapSuccessful() {
        // GIVEN

        car = new Car(5L, "Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", person);

        // WHEN

        CarDTO mappedCar = carMapper.carToCarDTO(car);

        // THEN

        assertEquals(mappedCar.getPersonalIdentifier(), car.getPerson().getPersonalIdentifier());
        assertEquals(mappedCar.getVinNumber(), car.getVinNumber());
        assertEquals(mappedCar.getPlateNumber(), car.getPlateNumber());
    }
}