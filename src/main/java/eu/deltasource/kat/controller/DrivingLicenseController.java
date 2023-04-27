package eu.deltasource.kat.controller;

import eu.deltasource.kat.model.dto.DrivingLicenseDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.service.DrivingLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/driving-licenses")
public class DrivingLicenseController {

    private final DrivingLicenseService drivingLicenseService;

    /**
     * Getting list of all driving licenses in the database
     * @return response entity with status ok and the list of all objects
     * converted to dto's
     */
    @GetMapping
    public ResponseEntity<List<DrivingLicenseDTO>> getAllDrivingLicenses() {
        return ResponseEntity.ok(drivingLicenseService.getAllDrivingLicenses());
    }

    /**
     * Getting driving license by id, provided by the user
     * @param id the specific driving license id that we want to get
     * @return if the driving license is present in the database we are
     * returning response entity with the license mapped to dto with http status ok,
     * if the license is not present in the database we are returning not found status code
     */
    @GetMapping("/{id}")
    public ResponseEntity<DrivingLicenseDTO> getDrivingLicenseById(@PathVariable long id) {
        Optional<DrivingLicenseDTO> optionalDrivingLicense =
                drivingLicenseService.getDrivingLicenseById(id);

        return optionalDrivingLicense
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creating new driving license in the database, with the help of
     * createNewDrivingLicense method and we are returning http status created
     * @param newDrivingLicense the new driving license, given from the user
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewDrivingLicense(@RequestBody DrivingLicenseDTO newDrivingLicense) {
        drivingLicenseService.createNewDrivingLicense(newDrivingLicense);
    }

    /**
     * Deleting driving license by id and we are returning http status no content
     * @param id specific driving license that we want to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDrivingLicenseById(@PathVariable long id) {
        drivingLicenseService.deleteDrivingLicenseById(id);
    }
}