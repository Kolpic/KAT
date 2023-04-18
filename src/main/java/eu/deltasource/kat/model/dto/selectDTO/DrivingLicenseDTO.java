package eu.deltasource.kat.model.dto.selectDTO;

import eu.deltasource.kat.enums.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DrivingLicenseDTO {

    private String firstName;

    private String secondName;

    private String familyName;

    private Date dateOfCreation;

    private Date dateOfExpiry;

    private String city;

    private Sex sex;
}
