package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.SaleId;

public class RemoveClient extends Command {
    private final ClientId clientId;
    private final SaleId saleId;

    public RemoveClient(ClientId clientId, SaleId saleId) {
        this.clientId = clientId;
        this.saleId = saleId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public SaleId getSaleId() {
        return saleId;
    }
}
