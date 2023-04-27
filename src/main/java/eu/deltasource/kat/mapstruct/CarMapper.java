package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.service.PersonService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { PersonService.class })
public interface CarMapper {

    @Mapping(target = "personalIdentifier", source = "person.personalIdentifier")
    public abstract CarDTO carToCarDTO(Car car);


    @Mapping(target = "person", source = "personalIdentifier")
    Car carDTOToCar(CarDTO carDTO);
}
