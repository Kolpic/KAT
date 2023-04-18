package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.selectDTO.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.CarRepository;
import eu.deltasource.kat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_= @Autowired)
@Service
public class CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    /**
     * Getting from the repository all cars, then takes every car
     * and maps it to CarDTO class
     * @return list of all cars available in the database
     */
    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
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
                .map(car ->  modelMapper.map(car, CarDTO.class));
    }

    /**
     * Creating the car object, provided by the user
     * First we are checking if the person provided by the user
     * is available in our database, then we are creating new car with the
     * provided person
     * @param newCar the new object we want to create and save in the database
     * @return the new created new object
     */
    public Car createNewCar(CarDTO newCar) {

        int currentPersonalIdentifier = newCar
                .getPersonPersonIdentifier()
                .getPersonalIdentifier();

        Optional<Person> optionalPerson = personRepository
                .findPersonByPersonalIdentifier(currentPersonalIdentifier);

        Car newCarEntity = Car
                .builder()
                .brand(newCar.getBrand())
                .model(newCar.getModel())
                .localInsurance(newCar.isLocalInsurance())
                .abroadInsurance(newCar.isAbroadInsurance())
                .plateNumber(newCar.getPlateNumber())
                .yearMade(newCar.getYearMade())
                .color(newCar.getColor())
                .vinNumber(newCar.getVinNumber())
                .person(optionalPerson.orElseThrow(NoSuchElementException::new))
                .build();

        return carRepository.save(newCarEntity);
    }

    /**
     * Deleting car with deleteById method from the repository
     * @param id the specific car's id, that we want to delete from database
     */
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

}
