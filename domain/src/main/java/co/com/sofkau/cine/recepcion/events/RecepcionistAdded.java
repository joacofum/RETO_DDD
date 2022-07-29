package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

public class RecepcionistAdded extends DomainEvent {
    private final RecepcionistId recepcionistId;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public RecepcionistAdded(RecepcionistId recepcionistId, Name name, PhoneNumber phoneNumber) {
        super("co.com.sofkau.cine.recepcion.recepcionistadded");
        this.recepcionistId = recepcionistId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
