package eu.deltasource.kat.model.entity;

import eu.deltasource.kat.enums.Sex;
import lombok.*;
import javax.persistence.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "driving_license")
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

    @Column
    private String city;

    @Enumerated(EnumType.STRING)
    @Column
    private Sex sex;
}
