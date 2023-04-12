package eu.deltasource.kat.service;

import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.repository.DrivingLicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingLicenseService {

    private final DrivingLicenseRepository drivingLicenseRepository;

    public DrivingLicenseService(DrivingLicenseRepository drivingLicenseRepository) {
        this.drivingLicenseRepository = drivingLicenseRepository;
    }

    public List<DrivingLicense> getAllDrivingLicenses() {
        return drivingLicenseRepository.findAll();
    }
}
