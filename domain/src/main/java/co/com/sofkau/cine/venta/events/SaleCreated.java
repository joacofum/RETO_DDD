package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.SaleId;

public class SaleCreated extends DomainEvent {
    public SaleCreated() {
        super("co.com.sofkau.cine.venta.salecreated");
    }

}
