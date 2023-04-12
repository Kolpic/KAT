package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByPersonalIdentifier(int personalIdentifier);
}
