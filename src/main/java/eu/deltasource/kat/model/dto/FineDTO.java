package eu.deltasource.kat.model.dto;

import eu.deltasource.kat.model.dto.PersonPersonIdentifierDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FineDTO {

    private String type;

    private String location;

    private double price;

    private boolean isPaid;

    private String description;

    private PersonPersonIdentifierDTO personPersonIdentifier;
}
