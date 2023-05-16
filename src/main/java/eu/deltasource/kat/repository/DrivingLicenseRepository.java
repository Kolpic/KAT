package eu.deltasource.kat.repository;

import eu.deltasource.kat.model.entity.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Long> {

}
