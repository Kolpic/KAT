package eu.deltasource.kat.service;

import eu.deltasource.kat.configuration.ModelMapperConfiguration;
import eu.deltasource.kat.model.dto.CarDTO;
import eu.deltasource.kat.model.entity.Car;
import eu.deltasource.kat.model.entity.Person;
import eu.deltasource.kat.repository.PersonRepository;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Setting up custom mappings in our ModelMapper, this class provides
 * information and how the custom mappings are made.
 */
@Component
@DependsOn("modelMapper")
public class ModelMapperCustomImpl {

    private final ModelMapperConfiguration modelMapperConfiguration;
    private final PersonRepository personRepository; // service

    TypeMap<Car, CarDTO> propertyMap;

    /**
     * Adding already made custom mappings in our ModelMapper we have to do it in the class
     * constructor. We add the logic with the help of addMappings and
     * andConverter methods, otherwise our ModelMapper won't know about
     * the additional mappings that we made.
     */
    public ModelMapperCustomImpl(ModelMapperConfiguration modelMapperConfiguration, PersonRepository personRepository) {
        this.modelMapperConfiguration = modelMapperConfiguration;
        this.personRepository = personRepository;
        this.modelMapperConfiguration.modelMapper().addMappings(carToCarDTOPropertyMap);
        this.modelMapperConfiguration.modelMapper().addConverter(carDTOToCarConverter);
    }

    /**
     * Creating custom mapping between Car and CarDTO using PropertyMap,
     * more precisely we are saying how to take Person from Car and
     * take only one field, that is needed in CarDTO class.
     * We are using the source and the destination type to map it successfully
     */
    PropertyMap<Car, CarDTO> carToCarDTOPropertyMap = new PropertyMap<Car, CarDTO>() {
        @Override
        protected void configure() {
            propertyMap = modelMapperConfiguration.modelMapper().createTypeMap(Car.class, CarDTO.class);
            propertyMap.addMapping(Car::getPerson, CarDTO::setPersonPersonIdentifier);
        }
    };

    /**
     * Creating custom converter to help the ModelMapper understand how to
     * map information from CarDTO to Car. We are using source and destination
     * type to set things up. We are using also personRepository, because we
     * need findPersonByPI method - we are taking personalIdentifier from CarDTO
     * and we are converting it to Person.
     */
    Converter<CarDTO, Car> carDTOToCarConverter = new Converter<CarDTO, Car>() {
        @Override
        public Car convert(MappingContext<CarDTO, Car> context) {
            CarDTO carDTO = context.getSource();
            Car car = new Car();
            int personalIdentifier = carDTO.getPersonPersonIdentifier().getPersonalIdentifier();
            Person person = personRepository.findPersonByPI(personalIdentifier);
            car.setBrand(carDTO.getBrand());
            car.setModel(carDTO.getModel());
            car.setLocalInsurance(carDTO.isLocalInsurance());
            car.setAbroadInsurance(carDTO.isAbroadInsurance());
            car.setPlateNumber(carDTO.getPlateNumber());
            car.setYearMade(carDTO.getYearMade());
            car.setColor(carDTO.getColor());
            car.setVinNumber(carDTO.getVinNumber());
            car.setPerson(person);
            return car;
        }
    };
}
