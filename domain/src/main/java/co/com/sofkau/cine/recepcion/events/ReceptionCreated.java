package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ReceptionDescription;

public class ReceptionCreated extends DomainEvent {
    ReceptionDescription receptionDescription;
    public ReceptionCreated(ReceptionDescription receptionDescription) {
        super("co.com.sofkau.cine.recepcion.receptioncreated");
        this.receptionDescription = receptionDescription;
    }

    public ReceptionDescription getReceptionDescription() {
        return this.receptionDescription;
    }
}
