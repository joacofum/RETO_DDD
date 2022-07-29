package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.ClientName;
import co.com.sofkau.cine.venta.values.SaleId;

public class UpdateClientName extends Command {
    private final SaleId saleId;
    private final ClientId clientId;
    private final ClientName name;

    public UpdateClientName(SaleId saleId, ClientId clientId, ClientName name) {
        this.saleId = saleId;
        this.clientId = clientId;
        this.name = name;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public ClientName getName() {
        return name;
    }
}
