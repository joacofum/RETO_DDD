package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;

public class NameUpdated extends DomainEvent {
    private final ReceptionistId receptionistId;
    private final Name name;

    public NameUpdated(ReceptionistId receptionistId, Name name) {
        super("co.com.sofkau.cine.recepcion.nameupdated");
        this.receptionistId = receptionistId;
        this.name = name;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public Name getName() {
        return name;
    }
}
