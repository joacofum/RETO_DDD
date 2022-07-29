package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ComplainDescription;
import co.com.sofkau.cine.recepcion.values.ComplainId;

public class ComplainDescriptionUpdated extends DomainEvent {
    private final ComplainId complainId;
    private final ComplainDescription complainDescription;

    public ComplainDescriptionUpdated(ComplainId complainId, ComplainDescription complainDescription) {
        super("co.com.sofkau.cine.recepcion.complaindescriptionupdated");
        this.complainId = complainId;
        this.complainDescription = complainDescription;
    }

    public ComplainId getComplainId() {
        return complainId;
    }

    public ComplainDescription getComplainDescription() {
        return complainDescription;
    }
}
