package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.Mail;
import co.com.sofkau.cine.venta.values.SaleId;

public class UpdateMail extends Command {
    private final SaleId saleId;
    private final ClientId clientId;
    private final Mail mail;

    public UpdateMail(SaleId saleId, ClientId clientId, Mail mail) {
        this.saleId = saleId;
        this.clientId = clientId;
        this.mail = mail;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Mail getMail() {
        return mail;
    }
}
