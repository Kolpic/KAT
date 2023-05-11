package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @AfterEach
    void tearDown() {
        personRepository.deleteAll();
    }

    @Test
    public void testFindByPIShouldFindPerson() {
        // GIVEN
        Person person = new Person();
        person.setPersonalIdentifier(3242342);

        // WHEN
        personRepository.save(person);

        // THEN
        Person expectedPerson = personRepository.findPersonByPI(3242342);
        assertEquals(expectedPerson, personRepository.findPersonByPI(3242342));
    }
}