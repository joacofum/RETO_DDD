package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.Mail;

public class MailUpdated extends DomainEvent {
    private final ClientId clientId;
    private final Mail mail;

    public MailUpdated(ClientId clientId, Mail mail) {
        super("co.com.sofkau.cine.venta.mailupdated");
        this.clientId = clientId;
        this.mail = mail;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Mail getMail() {
        return mail;
    }
}
