package eu.deltasource.kat.service;

import eu.deltasource.kat.model.dto.selectDTO.CategoryDTO;
import eu.deltasource.kat.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_= @Autowired)
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }
}
