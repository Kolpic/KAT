package eu.deltasource.kat.controller;

import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Getting all cars from carService with getAllCars method
     * @return status ok with list of all cars in the database
     */
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCar() {
        return ResponseEntity
                .ok(carService.getAllCars());
    }

    /**
     * Getting specific car by id from the database using
     * getCarById method from carService
     * @param id car's id that we want to see
     * @return status ok if we have the car in the database,
     * if not we are returning not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable long id) {
        Optional<CarDTO> currentCar = carService.getCarById(id);
        return currentCar
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creating new car in the database using createNewCar method
     * from carService
     * @param newCar is the object we want to create
     * @return status created if we successfully added the
     * car in the database, if the new car object is null
     * returns status not found
     */
    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody CarDTO newCar) {
        Car savedCar = carService.createNewCar(newCar);
        if (savedCar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }

    /**
     * Deleting the specific car by id from the database using deleteById
     * method from carService.
     * First we are checking if the object exists in the database
     * then if we have it, we are deleting it
     * @param id car's id what we want to delete from database
     * @return status ok if the delete is successful, but if
     * we didn't delete the object returns not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CarDTO> deleteCarById(@PathVariable long id) {
        Optional<CarDTO> optionalCar = carService.getCarById(id);
        if (optionalCar.isPresent()) {
            carService.deleteById(id);
        }

        return optionalCar
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
