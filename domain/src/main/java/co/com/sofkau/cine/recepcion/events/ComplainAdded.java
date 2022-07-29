package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ComplainDate;
import co.com.sofkau.cine.recepcion.values.ComplainDescription;
import co.com.sofkau.cine.recepcion.values.ComplainId;

public class ComplainAdded extends DomainEvent {
    private final ComplainId complainId;
    private final ComplainDescription complainDescription;
    private final ComplainDate complainDate;

    public ComplainAdded(ComplainId complainId, ComplainDescription complainDescription, ComplainDate complainDate) {
        super("co.com.sofkau.cine.recepcion.complainadded");
        this.complainId = complainId;
        this.complainDescription = complainDescription;
        this.complainDate = complainDate;
    }

    public ComplainId getComplainId() {
        return complainId;
    }

    public ComplainDescription getComplainDescription() {
        return complainDescription;
    }

    public ComplainDate getComplainDate() {
        return complainDate;
    }
}
