package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ModelMapperImpl {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;


}
