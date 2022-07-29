package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.ClientId;

public class ClientRemoved extends DomainEvent {
    private final ClientId clientId;

    public ClientRemoved(ClientId clientId) {
        super("co.com.sofkau.cine.venta.clientremoved");
        this.clientId = clientId;
    }

    public ClientId getClientId() {
        return clientId;
    }

}
