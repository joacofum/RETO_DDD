package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.SaleId;

public class SaleCreated extends DomainEvent {
    private final SaleId saleId;
    public SaleCreated(SaleId saleId) {
        super("co.com.sofkau.cine.venta.salecreated");
        this.saleId = saleId;
    }

    public SaleId getSaleId() {
        return saleId;
    }
}
