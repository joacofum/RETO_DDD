package co.com.sofkau.cine.venta.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.venta.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.ClientName;
import co.com.sofkau.cine.venta.values.Mail;

import java.util.Objects;

public class Client extends Entity<ClientId> {
    protected ClientName clientName;
    protected Mail mail;
    protected PhoneNumber phoneNumber;

    public Client(ClientId entityId) {
        super(entityId);
    }

    public Client(ClientId entityId, ClientName clientName, Mail mail, PhoneNumber number){
        super(entityId);
        this.clientName = clientName;
        this.mail = mail;
        this.phoneNumber = number;
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

    public void updateName(ClientName clientName){
        this.clientName = Objects.requireNonNull(clientName);
    }

    public void updateMail(Mail mail){
        this.mail = Objects.requireNonNull(mail);
    }

    public void updatePhone(PhoneNumber phone){
        this.phoneNumber = Objects.requireNonNull(phone);
    }

}
