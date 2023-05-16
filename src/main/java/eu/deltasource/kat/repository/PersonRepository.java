package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByPersonalIdentifier(int personalIdentifier);

    /**
     * Making custom query to find specific person from the repository
     * by personalIdentifier, and we are returning Person
     */
    @Query("select p from Person as p where p.personalIdentifier=?1")
    Person findPersonByPI(int personalIdentifier);
}
