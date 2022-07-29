package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;

public class ReceptionistAdded extends DomainEvent {
    private final ReceptionistId receptionistId;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public ReceptionistAdded(ReceptionistId receptionistId, Name name, PhoneNumber phoneNumber) {
        super("co.com.sofkau.cine.recepcion.recepcionistadded");
        this.receptionistId = receptionistId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
