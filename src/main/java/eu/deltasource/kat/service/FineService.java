package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.selectDTO.FineDTO;
import eu.deltasource.kat.repository.FineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_= @Autowired)
@Service
public class FineService {

    private final FineRepository fineRepository;
    private final ModelMapper modelMapper;

    public List<FineDTO> getAllFines() {
        return fineRepository
                .findAll()
                .stream()
                .map(fine -> modelMapper.map(fine, FineDTO.class))
                .toList();
    }

}
