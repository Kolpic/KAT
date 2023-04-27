package eu.deltasource.kat.service;

import eu.deltasource.kat.mapstruct.PersonMapper;
import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> getAllPersons() {
        return personRepository
                .findAll()
                .stream()
                .map(personMapper::personToPersonDTO)
                .toList();
    }

    public Person findPersonByPersonalIdentifier(int personalIdentifier) {
        return personRepository
                .findPersonByPersonalIdentifier(personalIdentifier);
    }
}
