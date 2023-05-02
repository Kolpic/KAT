package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.service.PersonService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "person.id", source = "person.id")
    @Mapping(target = "person.personalIdentifier", source = "person.personalIdentifier")
    @Mapping(target = "person.phoneNumbers", source = "person.phoneNumbers")
    @Mapping(target = "person.drivingLicense", source = "person.drivingLicense")
    @Mapping(ignore = true, target = "id")
    Car carWithPersonDTOToCar(CarDTO car, Person person);



    @Mapping(target = "personalIdentifier", source = "person.personalIdentifier")
    CarDTO carToCarDTO(Car car);


    @Mapping(target = "person.personalIdentifier", source = "personalIdentifier")
    Car carDTOToCar(CarDTO carDTO);
}
