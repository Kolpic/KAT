package eu.deltasource.kat.model.entity;

import eu.deltasource.kat.enums.CategoryVehicle;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private CategoryVehicle category;

    @ManyToOne
    private DrivingLicense drivingLicense;
}
