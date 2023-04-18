package eu.deltasource.kat.model.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "fine")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String location;

    private double price;

    @Column(name = "is_paid")
    private boolean isPaid;

    private String description;

    @ManyToOne
    private Person person;
}
