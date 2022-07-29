package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;

public class PhoneUpdated extends DomainEvent {
    private final RecepcionistId recepcionistId;
    private final PhoneNumber phoneNumber;

    public PhoneUpdated(RecepcionistId recepcionistId, PhoneNumber phoneNumber) {
        super("co.com.sofkau.cine.recepcion.phoneupdated");
        this.recepcionistId = recepcionistId;
        this.phoneNumber = phoneNumber;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
