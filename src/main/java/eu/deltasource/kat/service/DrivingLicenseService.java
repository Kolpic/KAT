package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.DrivingLicenseDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.repository.DrivingLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DrivingLicenseService {

    private final DrivingLicenseRepository drivingLicenseRepository;
    private final ModelMapper modelMapper;

    public List<DrivingLicenseDTO> getAllDrivingLicenses() {
        return drivingLicenseRepository
                .findAll()
                .stream()
                .map(drivingLicense -> modelMapper.map(drivingLicense, DrivingLicenseDTO.class))
                .toList();
    }

    public Optional<DrivingLicenseDTO> getDrivingLicenseById(Long id) {
        return drivingLicenseRepository
                .findById(id)
                .map(drivingLicense -> modelMapper.map(drivingLicense, DrivingLicenseDTO.class));
    }

    public long createNewDrivingLicense(DrivingLicenseDTO newLicense) {
        DrivingLicense drivingLicenseToBeCreated = DrivingLicense
                .builder()
                .firstName(newLicense.getFirstName())
                .secondName(newLicense.getSecondName())
                .familyName(newLicense.getFamilyName())
                .dateOfCreation(newLicense.getDateOfCreation())
                .dateOfExpiry(newLicense.getDateOfExpiry())
                .city(newLicense.getCity())
                .sex(newLicense.getSex())
                .build();

        return drivingLicenseRepository.save(drivingLicenseToBeCreated).getId();
    }
}
