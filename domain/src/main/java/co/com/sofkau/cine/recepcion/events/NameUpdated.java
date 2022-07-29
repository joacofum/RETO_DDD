package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;

public class NameUpdated extends DomainEvent {
    private final RecepcionistId recepcionistId;
    private final Name name;

    public NameUpdated(RecepcionistId recepcionistId, Name name) {
        super("co.com.sofkau.cine.recepcion.nameupdated");
        this.recepcionistId = recepcionistId;
        this.name = name;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public Name getName() {
        return name;
    }
}
