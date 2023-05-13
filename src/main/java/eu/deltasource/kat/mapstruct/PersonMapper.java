package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "drivingLicenseId", source = "drivingLicense.id")
    PersonDTO personToPersonDTO(Person person);

    @Mapping(ignore = true, target = "id")
    Person personDTOWithDrivingLicenseToPerson(PersonDTO personDTO, DrivingLicense drivingLicense);

    DrivingLicense drivingLicenseToDrivingLicense(DrivingLicense drivingLicense);

    Person personDTOToPerson(PersonDTO personDTO);
}
