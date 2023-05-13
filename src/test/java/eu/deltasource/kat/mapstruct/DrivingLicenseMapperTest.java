package eu.deltasource.kat.mapstruct;

import eu.deltasource.kat.enums.Sex;
import eu.deltasource.kat.model.dto.DrivingLicenseDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.DrivingLicense;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class DrivingLicenseMapperTest {

    private DrivingLicenseMapper drivingLicenseMapper = Mappers.getMapper(DrivingLicenseMapper.class);
    private DrivingLicense drivingLicense;
    private DrivingLicenseDTO drivingLicenseDTO;

    @Test
    public void testDrivingLicenseToDrivingLicenseDTOShouldMapSuccessful() {
        // GIVEN

        drivingLicense = new DrivingLicense(3L, "Galin", "Petrov", "Petrov",
                Date.valueOf("2030-02-01"), Date.valueOf("2040-02-01"),
                "Plovdiv", Sex.MALE);

        // WHEN

        DrivingLicenseDTO mappedDrivingLicense = drivingLicenseMapper.
                drivingLicenseToDrivingLicenseDTO(drivingLicense);

        // THEN

        assertEquals(mappedDrivingLicense.getFirstName(), drivingLicense.getFirstName());
        assertEquals(mappedDrivingLicense.getSecondName(), drivingLicense.getSecondName());
        assertEquals(mappedDrivingLicense.getFamilyName(), drivingLicense.getFamilyName());
        assertEquals(mappedDrivingLicense.getDateOfCreation(), drivingLicense.getDateOfCreation());
        assertEquals(mappedDrivingLicense.getDateOfExpiry(), drivingLicense.getDateOfExpiry());
    }

    @Test
    public void testDrivingLicenseDTOToDrivingLicenseShouldMapSuccessful() {
        // GIVEN

        drivingLicenseDTO = new DrivingLicenseDTO("Galin", "Petrov", "Petrov",
                Date.valueOf("2030-02-01"), Date.valueOf("2040-02-01"),
                "Plovdiv", Sex.MALE);

        // WHEN

        DrivingLicense mappedDrivingLicense = drivingLicenseMapper.
                drivingLicenseDTOToDrivingLicense(drivingLicenseDTO);

        // THEN

        assertNull(mappedDrivingLicense.getId());
        assertEquals(mappedDrivingLicense.getFirstName(), drivingLicenseDTO.getFirstName());
        assertEquals(mappedDrivingLicense.getSecondName(), drivingLicenseDTO.getSecondName());
        assertEquals(mappedDrivingLicense.getFamilyName(), drivingLicenseDTO.getFamilyName());
        assertEquals(mappedDrivingLicense.getDateOfCreation(), drivingLicenseDTO.getDateOfCreation());
        assertEquals(mappedDrivingLicense.getDateOfExpiry(), drivingLicenseDTO.getDateOfExpiry());
    }

}