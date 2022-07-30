package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.ClientName;
import co.com.sofkau.cine.venta.values.Mail;
import co.com.sofkau.cine.venta.values.SaleId;

public class AddClient extends Command {
    private final SaleId saleId;
    private final ClientName clientName;
    private final Mail mail;
    private final PhoneNumber phoneNumber;

    public AddClient(SaleId saleId, ClientName clientName, Mail mail, PhoneNumber phoneNumber) {
        this.saleId = saleId;
        this.clientName = clientName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public SaleId getSaleId() {
        return saleId;
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
