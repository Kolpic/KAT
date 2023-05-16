package eu.deltasource.kat.repository;

import eu.deltasource.kat.enums.Sex;
import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.model.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    private Person person;

    @AfterEach
    void tearDown() {
        personRepository.deleteAll();
    }

    @Test
    public void testFindPersonByPIShouldFindPersonSuccessful() {
        // GIVEN

        person = new Person(5L, 424242, null, null);
        personRepository.save(person);

        // WHEN

        Person wantedPerson = personRepository.findPersonByPI(424242);

        // THEN

        assertEquals(wantedPerson.getPersonalIdentifier(), person.getPersonalIdentifier());
        assertEquals(wantedPerson.getPhoneNumbers(), person.getPhoneNumbers());
    }

    @Test
    public void testFindPersonByPIShouldNotFindPersonSuccessful() {
        // GIVEN

        person = new Person(5L, 424242, null, null);

        // WHEN

        Person wantedPerson = personRepository.findPersonByPI(424242);

        // THEN

        assertNull(wantedPerson);
    }
}