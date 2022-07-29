package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ReceptionCreated extends DomainEvent {
    public ReceptionCreated() {
        super("co.com.sofkau.cine.recepcion.receptioncreated");
    }
}
