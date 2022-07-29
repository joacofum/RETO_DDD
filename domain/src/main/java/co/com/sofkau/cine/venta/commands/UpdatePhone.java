package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.SaleId;

public class UpdatePhone extends Command {
    private final SaleId saleId;
    private final ClientId clientId;
    private final PhoneNumber phoneNumber;

    public UpdatePhone(SaleId saleId, ClientId clientId, PhoneNumber phoneNumber) {
        this.saleId = saleId;
        this.clientId = clientId;
        this.phoneNumber = phoneNumber;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
