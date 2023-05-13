package eu.deltasource.kat.model.entity;

import eu.deltasource.kat.configuration.JsonParserConfiguration;
import eu.deltasource.kat.model.entity.DrivingLicense;
import lombok.*;
import org.hibernate.annotations.Type;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personal_identifier", unique = true)
    private int personalIdentifier;

    @Column(name = "numbers")
    @Type(type = "JSON")
    private String phoneNumbers;

    @OneToOne
    private DrivingLicense drivingLicense;
}
