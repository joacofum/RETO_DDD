package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.Description;

public class BillAdded extends DomainEvent {
    private final BillId billId;
    private final BillDescription description;

    public BillAdded(BillId billId, BillDescription description){
        super("co.com.sofkau.cine.venta.billadded");
        this.billId = billId;
        this.description = description;
    }

    public BillId getBillId() {
        return billId;
    }

    public BillDescription getBillDescription() {
        return description;
    }
}
