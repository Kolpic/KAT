package eu.deltasource.kat.service;

import eu.deltasource.kat.mapstruct.PersonMapper;
import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.DrivingLicenseRepository;
import eu.deltasource.kat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final DrivingLicenseRepository drivingLicenseRepository;
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

    public Optional<PersonDTO> getPersonById(long id) {
        return personRepository
                .findById(id)
                .map(personMapper::personToPersonDTO);
    }

    public Person createNewPerson(PersonDTO personToBeCreated) {
        long drivingLicenseId = personToBeCreated.getDrivingLicenseId();
        DrivingLicense drivingLicense = drivingLicenseRepository.findById(drivingLicenseId)
                .orElseThrow();
        Person createdPerson = personMapper.personDTOWithDrivingLicenseToPerson(personToBeCreated, drivingLicense);
        return personRepository.save(createdPerson);
    }

    public void deletePersonById(long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        optionalPerson.ifPresent(personRepository::delete);
    }
}
