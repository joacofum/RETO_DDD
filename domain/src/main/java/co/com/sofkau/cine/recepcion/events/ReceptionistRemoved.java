package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;

public class ReceptionistRemoved extends DomainEvent {
    private final ReceptionistId receptionistId;
    private final Boolean wasDeleted;

    public ReceptionistRemoved(ReceptionistId receptionistId) {
        super("co.com.sofkau.cine.recepcion.receptionistremoved");
        this.receptionistId = receptionistId;
        this.wasDeleted = true;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
