package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.model.dto.DrivingLicenseDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DrivingLicenseMapper {

    DrivingLicenseDTO drivingLicenseToDrivingLicenseDTO(DrivingLicense drivingLicense);

    DrivingLicense drivingLicenseDTOToDrivingLicense(DrivingLicenseDTO drivingLicenseDTO);
}
