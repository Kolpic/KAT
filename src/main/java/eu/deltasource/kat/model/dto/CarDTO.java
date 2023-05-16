package eu.deltasource.kat.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private String brand;

    private String model;

    private boolean localInsurance;

    private boolean abroadInsurance;

    private String plateNumber;

    private Date yearMade;

    private String color;

    private String vinNumber;

    private int personalIdentifier;
}
