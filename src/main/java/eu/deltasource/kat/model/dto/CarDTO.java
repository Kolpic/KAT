package eu.deltasource.kat.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarDTO {

    private String brand;

    private String model;

    private boolean localInsurance;

    private boolean abroadInsurance;

    private String plateNumber;

    private Date yearMade;

    private String color;

    private String vinNumber;

    private PersonPersonIdentifierDTO personPersonIdentifier;
}
