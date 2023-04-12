package eu.deltasource.kat.model.dto;

import eu.deltasource.kat.enums.CategoryVehicle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    private CategoryVehicle category;

    private DrivingLicenseDTO drivingLicense;
}
