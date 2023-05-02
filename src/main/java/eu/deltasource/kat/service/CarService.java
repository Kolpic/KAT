package eu.deltasource.kat.service;

import eu.deltasource.kat.mapstruct.CarMapper;
import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.CarRepository;
import eu.deltasource.kat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;
    private final CarMapper carMapper;

    /**
     * Getting from the repository all cars, then takes every car
     * and maps it to CarDTO class
     * @return list of all cars available in the database
     */
    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(carMapper::carToCarDTO)
                .toList();
    }

    /**
     * Getting specific car from repository with findById method
     * then we are mapping this car to CarDTO
     * @param id needed car, that we want to take
     * @return optional of CarDTO
     */
    public Optional<CarDTO> getCarById(Long id) {
        return carRepository
                .findById(id)
                .map(carMapper::carToCarDTO);
    }

    /**
     * Creating the car object, provided by the user. We are mapping
     * provided information from CarDTO to Car.
     * @param newCar the new object we want to create and save in the database
     * @return the new created new object
     */
    public Car createNewCar(CarDTO newCar) {
        int personalIdentifier = newCar.getPersonalIdentifier();
        Person foundPersonByPI = personRepository.findPersonByPersonalIdentifier(personalIdentifier);
        Car newCarEntity = carMapper.carWithPersonDTOToCar(newCar, foundPersonByPI);
        return carRepository.saveAndFlush(newCarEntity);
    }

    /**
     * Deleting car with deleteById method from the repository
     * @param id the specific car's id, that we want to delete from database
     */
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

}
