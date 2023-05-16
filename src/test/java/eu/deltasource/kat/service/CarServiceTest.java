package eu.deltasource.kat.service;

import eu.deltasource.kat.enums.Sex;
import eu.deltasource.kat.mapstruct.CarMapper;
import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.CarRepository;
import eu.deltasource.kat.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private CarMapper carMapper;
    @InjectMocks
    private CarService carService;

    private DrivingLicense drivingLicense;
    private Person person;
    private Car car;
    private CarDTO carDTO;
    private Car savedCar;

    @BeforeEach
    void setUp() {
        drivingLicense = new DrivingLicense(3L, "Galin", "Petrov", "Petrov",
                Date.valueOf("2030-02-01"), Date.valueOf("2040-02-01"),
                "Plovdiv", Sex.MALE);
        person = new Person(2L, 4245252,
                "{\"phone\": \"089342524\", \"email\": \"cdcbsadcs@gmail.com\"}",drivingLicense);
        car = new Car(1L, "Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", person);
        carDTO = new CarDTO("Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", 4245252);
        savedCar = new Car(1L, "Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", person);
    }

    @Test
    public void testGetAllCarsShouldGetAllCarsSuccessful() {
        // GIVEN

        CarDTO carOne = new CarDTO("Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", 34242);
        Car mappedCarOne = new Car(1L, "Opel", "Zafira", false,
                true, "PB0000KP", Date.valueOf("1997-02-01"),
                "Red", "4y45g22", person);
//        CarDTO carTwo = new CarDTO("Opel", "Astra", false,
//                true, "PB0966KP", Date.valueOf("2002-02-01"),
//                "Red", "cs3g55", 34242);
        when(carRepository.saveAndFlush(Mockito.any(Car.class))).thenReturn(mappedCarOne);
        when(carMapper.carDTOWithPersonToCar(carOne, person)).thenReturn(mappedCarOne);
        List<CarDTO> carsDTOList = new ArrayList<>();
        carsDTOList.add(carOne);

        // WHEN

        when(carService.getAllCars()).thenReturn(carsDTOList);
        carService.getAllCars();

        // THEN

        verify(carRepository).findAll();
    }

    @Test
    public void testGetCarByIdShouldGetTheCarSuccessful() {
        // WHEN

        carService.getCarById(10L);

        // THEN

        verify(carRepository).findById(10L);
    }

    @Test
    public void testGetCarByIdShouldNotGetTheCarSuccessful() {
        // WHEN

        carService.getCarById(10L);

        // THEN

        verify(carRepository, never()).findById(1L);
    }

    @Test
    public void testCreateNewCarShouldCreateNewCarSuccessful() {
        // GIVEN

//        Car carToBeSaved = carMapper.carDTOWithPersonToCar(carDTO, person);
//        carRepository.saveAndFlush(carToBeSaved);
        when(personRepository.findPersonByPI(4245252)).thenReturn(person);
        when(carMapper.carDTOWithPersonToCar(carDTO, person)).thenReturn(car);
        when(carRepository.saveAndFlush(car)).thenReturn(savedCar);

        // WHEN

        CarDTO alreadySavedCar = carService.createNewCar(carDTO);

        // THEN

        assertNotNull(alreadySavedCar);
    }
}