package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.CarRepository;
import eu.deltasource.kat.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarService(CarRepository carRepository, PersonRepository personRepository,
                      ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .toList();

    }

    public Optional<CarDTO> getCarById(Long id) {
        return carRepository
                .findById(id)
                .map(car ->  modelMapper.map(car, CarDTO.class));
    }

    public long createNewCar(CarDTO newCar) {

        int currentPersonalIdentifier = newCar
                .getPerson()
                .getPersonalIdentifier();

        Optional<Person> optionalPerson = personRepository
                .findPersonByPersonalIdentifier(currentPersonalIdentifier);

        Car newCarEntity = new Car()
                .setBrand(newCar.getBrand())
                .setModel(newCar.getModel())
                .setLocalInsurance(newCar.isLocalInsurance())
                .setAbroadInsurance(newCar.isAbroadInsurance())
                .setPlateNumber(newCar.getPlateNumber())
                .setYearMade(newCar.getYearMade())
                .setColor(newCar.getColor())
                .setVinNumber(newCar.getVinNumber())
                .setPerson(optionalPerson.orElse(null));

        return carRepository.save(newCarEntity).getId();
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

}
