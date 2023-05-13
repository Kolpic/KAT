package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.enums.Sex;
import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.model.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);
    private Person person;
    private PersonDTO personDTO;
    private DrivingLicense drivingLicense;

    @BeforeEach
    void setUp() {
        drivingLicense = new DrivingLicense(3L, "Galin", "Petrov", "Petrov",
                Date.valueOf("2030-02-01"), Date.valueOf("2040-02-01"),
                "Plovdiv", Sex.MALE);
    }

    @Test
    public void testPersonDTOWithDrivingLicenseToPersonShouldMapSuccessful() {
        // GIVEN

        personDTO = new PersonDTO(424242, null, 3L);

        // WHEN

        Person mappedPerson = personMapper.personDTOWithDrivingLicenseToPerson(personDTO, drivingLicense);

        // THEN

        assertNull(mappedPerson.getId());
        assertEquals(mappedPerson.getPersonalIdentifier(), personDTO.getPersonalIdentifier());
        assertEquals(mappedPerson.getPhoneNumbers(), personDTO.getPhoneNumbers());
        assertEquals(mappedPerson.getDrivingLicense().getId(), personDTO.getDrivingLicenseId());
    }

    @Test
    public void testPersonToPersonDTOShouldMapSuccessful() {
        // GIVEN

        person = new Person(5L, 34242,
                "{\"phone\": \"089342524\", \"email\": \"cdcbsadcs@gmail.com\"}",drivingLicense);

        // WHEN

        PersonDTO mappedPerson = personMapper.personToPersonDTO(person);

        // THEN

        assertEquals(mappedPerson.getPersonalIdentifier(), person.getPersonalIdentifier());
        assertEquals(mappedPerson.getDrivingLicenseId(), person.getDrivingLicense().getId());
        assertEquals(mappedPerson.getPhoneNumbers(), person.getPhoneNumbers());
    }
}