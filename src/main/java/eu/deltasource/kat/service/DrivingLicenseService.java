package eu.deltasource.kat.service;

import eu.deltasource.kat.mapstruct.DrivingLicenseMapper;
import eu.deltasource.kat.model.dto.DrivingLicenseDTO;
import eu.deltasource.kat.model.entity.DrivingLicense;
import eu.deltasource.kat.repository.DrivingLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DrivingLicenseService {

    private final DrivingLicenseRepository drivingLicenseRepository;
    private final DrivingLicenseMapper drivingLicenseMapper;

    /**
     * Getting all available driving licenses from the drivingLicenseRepository, after
     * findAll method we are mapping every driving license to dto with the
     * help of drivingLicenseMapper.
     * @return list of all driving licenses from the database
     */
    public List<DrivingLicenseDTO> getAllDrivingLicenses() {
        return drivingLicenseRepository
                .findAll()
                .stream()
                .map(drivingLicenseMapper::drivingLicenseToDrivingLicenseDTO)
                .toList();
    }

    /**
     * Getting one driving license by id from the drivingLicenseRepository and
     * then we are mapping it to dto.
     * @param id the specific driving license that we want to get
     * @return optional of drivingLicenseDTO
     */
    public Optional<DrivingLicenseDTO> getDrivingLicenseById(long id) {
        return drivingLicenseRepository
                .findById(id)
                .map(drivingLicenseMapper::drivingLicenseToDrivingLicenseDTO);
    }

    /**
     * Creating new driving license in the database, firstly we are mapping
     * the object, that is given by the user(dto) to driving license entity.
     * @param newDrivingLicense the given for creation object by the user
     */
    public DrivingLicense createNewDrivingLicense(DrivingLicenseDTO newDrivingLicense) {
        return drivingLicenseRepository.save(drivingLicenseMapper.drivingLicenseDTOToDrivingLicense(newDrivingLicense));
    }

    /**
     * Deleting driving license by specific id, given by the user, if the
     * driving license is not present in the database we skip the delete method
     * @param id the driving license's that we want to delete from database
     */
    public void deleteDrivingLicenseById(long id) {
        if (drivingLicenseRepository.existsById(id)) {
           drivingLicenseRepository.deleteById(id);
        }
    }
}
