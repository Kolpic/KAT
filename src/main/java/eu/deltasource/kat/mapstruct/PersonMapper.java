package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.Person;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);
}
