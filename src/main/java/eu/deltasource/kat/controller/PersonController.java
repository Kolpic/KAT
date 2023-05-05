package eu.deltasource.kat.controller;

import eu.deltasource.kat.model.dto.PersonDTO;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable long id) {
        Optional<PersonDTO> person = personService.getPersonById(id);

        return person
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> createNewPerson(@RequestBody PersonDTO personToBeCreated) {
        Person createdPerson = personService.createNewPerson(personToBeCreated);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable long id) {
        personService.deletePersonById(id);
    }

}
