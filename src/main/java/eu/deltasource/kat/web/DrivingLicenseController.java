package eu.deltasource.kat.web;

import eu.deltasource.kat.model.dto.selectDTO.DrivingLicenseDTO;
import eu.deltasource.kat.service.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driving-licenses")
public class DrivingLicenseController {

    private final DrivingLicenseService drivingLicenseService;

    @Autowired
    public DrivingLicenseController(DrivingLicenseService drivingLicenseService) {
        this.drivingLicenseService = drivingLicenseService;
    }

    @GetMapping
    public ResponseEntity<List<DrivingLicenseDTO>> getAllDrivingLicenses() {
        return ResponseEntity.ok(drivingLicenseService.getAllDrivingLicenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrivingLicenseDTO> getDrivingLicenseById(@PathVariable long id) {
        Optional<DrivingLicenseDTO> optionalDrivingLicense =
                drivingLicenseService.getDrivingLicenseById(id);

        return optionalDrivingLicense
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}