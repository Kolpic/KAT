package eu.deltasource.kat.model.dto;

import eu.deltasource.kat.model.dto.DrivingLicenseIdDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonDTO {

    private int personalIdentifier;

    private Set<Integer> numbers;

    private DrivingLicenseDTO drivingLicense;
}
