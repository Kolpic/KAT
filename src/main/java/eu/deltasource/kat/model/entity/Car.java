package eu.deltasource.kat.model.entity;

import lombok.*;
import javax.persistence.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    @Column(name = "local_insurance")
    private boolean localInsurance;

    @Column(name = "abroad_insurance")
    private boolean abroadInsurance;

    @Column(name = "plate_number", unique = true)
    private String plateNumber;

    @Column(name = "year_made")
    private Date yearMade;

    private String color;

    @Column(name = "vin_number", unique = true)
    private String vinNumber;

    @ManyToOne
    private Person person;
}
