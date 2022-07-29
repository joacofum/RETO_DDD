package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ComplainDate;
import co.com.sofkau.cine.recepcion.values.ComplainId;

public class ComplainDateUpdated extends DomainEvent {
    private final ComplainId complainId;
    private final ComplainDate complainDate;

    public ComplainDateUpdated(ComplainId complainId, ComplainDate complainDate) {
        super("co.com.sofkau.cine.recepcion.complaindateupdated");
        this.complainId = complainId;
        this.complainDate = complainDate;
    }

    public ComplainId getComplainId() {
        return complainId;
    }

    public ComplainDate getComplainDate() {
        return complainDate;
    }
}
