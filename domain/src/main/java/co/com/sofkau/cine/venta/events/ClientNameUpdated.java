package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.ClientId;
import co.com.sofkau.cine.venta.values.ClientName;

public class ClientNameUpdated extends DomainEvent {
    private final ClientId clientId;
    private final ClientName name;

    public ClientNameUpdated(ClientId clientId, ClientName name){
        super("co.com.sofkau.cine.venta.clientnameupdated");
        this.clientId = clientId;
        this.name = name;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public ClientName getName() {
        return name;
    }
}
