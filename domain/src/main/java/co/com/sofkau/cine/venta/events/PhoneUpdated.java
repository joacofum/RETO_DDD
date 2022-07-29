package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.ClientId;

public class PhoneUpdated extends DomainEvent {
    private final ClientId clientId;
    private final PhoneNumber phoneNumber;

    public PhoneUpdated(ClientId clientId, PhoneNumber phoneNumber) {
        super("co.com.sofkau.cine.venta.phoneupdated");
        this.clientId = clientId;
        this.phoneNumber = phoneNumber;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
