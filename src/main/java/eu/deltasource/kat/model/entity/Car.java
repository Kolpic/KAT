package eu.deltasource.kat.model.entity;

import lombok.*;
import javax.persistence.*;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column(name = "local_insurance")
    private boolean localInsurance;

    @Column(name = "abroad_insurance")
    private boolean abroadInsurance;

    @Column(name = "plate_number", unique = true)
    private String plateNumber;

    @Column(name = "year_made")
    private Date yearMade;

    @Column
    private String color;

    @Column(name = "vin_number", unique = true)
    private String vinNumber;

    @ManyToOne
    private Person person;

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setLocalInsurance(boolean localInsurance) {
        this.localInsurance = localInsurance;
        return this;
    }

    public Car setAbroadInsurance(boolean abroadInsurance) {
        this.abroadInsurance = abroadInsurance;
        return this;
    }

    public Car setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public Car setYearMade(Date yearMade) {
        this.yearMade = yearMade;
        return this;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public Car setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
        return this;
    }

    public Car setPerson(Person person) {
        this.person = person;
        return this;
    }
}
