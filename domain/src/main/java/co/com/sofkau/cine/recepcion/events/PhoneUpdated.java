package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;

public class PhoneUpdated extends DomainEvent {
    private final ReceptionistId receptionistId;
    private final PhoneNumber phoneNumber;

    public PhoneUpdated(ReceptionistId receptionistId, PhoneNumber phoneNumber) {
        super("co.com.sofkau.cine.recepcion.phoneupdated");
        this.receptionistId = receptionistId;
        this.phoneNumber = phoneNumber;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
