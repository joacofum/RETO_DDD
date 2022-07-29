package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ComplainId;

public class ComplainRemoved extends DomainEvent {
    private final ComplainId complainId;
    private final Boolean wasDeleted;

    public ComplainRemoved(ComplainId complainId) {
        super("co.com.sofkau.cine.recepcion.complainremoved");
        this.complainId = complainId;
        this.wasDeleted = true;
    }

    public ComplainId getComplainId() {
        return complainId;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
