package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {
}
