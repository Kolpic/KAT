package eu.deltasource.kat.model.dto;

import eu.deltasource.kat.model.dto.DrivingLicenseIdDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import springfox.documentation.spring.web.json.Json;

import java.util.Set;

@Getter
@Setter
public class PersonDTO {

    private int personalIdentifier;

    @Type(type = "JSON")
    private String phoneNumbers;

    private long drivingLicenseId;
}
