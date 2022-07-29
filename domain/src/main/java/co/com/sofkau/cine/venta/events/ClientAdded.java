package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.ClientName;
import co.com.sofkau.cine.venta.values.Mail;

public class ClientAdded extends DomainEvent {
    private final ClientId clientId;
    private final ClientName clientName;
    private final Mail mail;
    private final PhoneNumber phoneNumber;

    public ClientAdded(ClientId clientId, ClientName clientName, Mail mail, PhoneNumber phone) {
        super("co.com.sofkau.cine.venta.clientadded");
        this.clientId = clientId;
        this.clientName = clientName;
        this.mail = mail;
        this.phoneNumber = phone;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public ClientName getClientName() {
        return clientName;
    }

    public Mail getMail() {
        return mail;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
