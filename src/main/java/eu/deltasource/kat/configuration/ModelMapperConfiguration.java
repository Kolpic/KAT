package eu.deltasource.kat.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    /**
     * Java library used for object mappings.
     * The goal of ModelMapper is to make object mapping easy, by automatically determining
     * how one object model maps to another, based on conventions
     * @return new instance of ModelMapper as a bean, that we can use
     * in our application
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }





















}
