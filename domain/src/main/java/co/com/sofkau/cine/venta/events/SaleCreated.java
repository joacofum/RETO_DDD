package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;

public class SaleCreated extends DomainEvent {
    public SaleCreated() {
        super("co.com.sofkau.cine.venta.salecreated");
    }

}
