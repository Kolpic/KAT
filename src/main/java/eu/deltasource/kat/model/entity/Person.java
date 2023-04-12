package eu.deltasource.kat.model.entity;

import eu.deltasource.kat.model.entity.DrivingLicense;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personal_identifier", unique = true)
    private int personalIdentifier;

    @Column
    @ElementCollection
    private Set<Integer> numbers;

    @OneToOne
    private DrivingLicense drivingLicense;
}
