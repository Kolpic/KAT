package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.selectDTO.PersonDTO;
import eu.deltasource.kat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_= @Autowired)
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public List<PersonDTO> getAllPersons() {
        return personRepository
                .findAll()
                .stream()
                .map(person -> modelMapper.map(person, PersonDTO.class))
                .toList();
    }
}
