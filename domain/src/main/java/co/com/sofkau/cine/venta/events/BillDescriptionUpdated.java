package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.BillId;

public class BillDescriptionUpdated extends DomainEvent {
    private final BillId billId;
    private final BillDescription billDescription;

    public BillDescriptionUpdated(BillId billId, BillDescription billDescription) {
        super("co.com.sofkau.cine.venta.billdescriptionupdated");
        this.billId = billId;
        this.billDescription = billDescription;
    }
}
