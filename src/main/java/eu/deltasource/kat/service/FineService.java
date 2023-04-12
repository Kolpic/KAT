package eu.deltasource.kat.service;

import eu.deltasource.kat.model.entity.Fine;
import eu.deltasource.kat.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineService {

    private final FineRepository fineRepository;

    @Autowired
    public FineService(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

}
