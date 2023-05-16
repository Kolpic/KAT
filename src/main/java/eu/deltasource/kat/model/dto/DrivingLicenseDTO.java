package eu.deltasource.kat.model.dto;

import eu.deltasource.kat.enums.Sex;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrivingLicenseDTO {

    private String firstName;

    private String secondName;

    private String familyName;

    private Date dateOfCreation;

    private Date dateOfExpiry;

    private String city;

    private Sex sex;
}
