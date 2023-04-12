package eu.deltasource.kat.web;

import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCar() {
        return ResponseEntity
                .ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable long id) {
        Optional<CarDTO> currentCar = carService.getCarById(id);

        return currentCar
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Because of ResponseEntity.created we are returning the
     * status code with the current new object.
     * The path after the uriComponentsBuilder is the url where
     * we can get the created object.
     * @param newCar is the car object provided by the client
     * @param uriComponentsBuilder is uri instance of the uri
     * class (comes from spring and it is a utility class)
     * @return status code 201
     */
    @PostMapping()
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO newCar,
                                            UriComponentsBuilder uriComponentsBuilder) {
        long newCarId = carService.createNewCar(newCar);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/cars/{id}")
                .build(newCarId))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable long id) {
        carService.deleteById(id);

        return ResponseEntity
                .notFound()
                .build();
    }
}
