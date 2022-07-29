package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.ClientName;
import co.com.sofkau.cine.venta.values.Mail;

public class AddClient extends Command {
    private final ClientId clientId;
    private final ClientName clientName;
    private final Mail mail;
    private final PhoneNumber phoneNumber;

    public AddClient(ClientId clientId, ClientName clientName, Mail mail, PhoneNumber phoneNumber) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
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
