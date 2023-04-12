package eu.deltasource.kat.web;

import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.repository.DrivingLicenseRepository;
import eu.deltasource.kat.service.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driving-licenses")
public class DrivingLicenseController {

    private final DrivingLicenseService drivingLicenseService;

    @Autowired
    public DrivingLicenseController(DrivingLicenseService drivingLicenseService) {
        this.drivingLicenseService = drivingLicenseService;
    }

    @GetMapping
    public ResponseEntity<List<DrivingLicense>> getAllDrivingLicenses() {
        return ResponseEntity.ok(drivingLicenseService.getAllDrivingLicenses());
    }
}
