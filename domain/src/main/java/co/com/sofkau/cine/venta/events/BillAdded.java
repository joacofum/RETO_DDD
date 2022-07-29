package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.Description;

public class BillAdded extends DomainEvent {
    private final BillId billId;
    private final Description description;

    public BillAdded(BillId billId, Description description){
        super("co.com.sofkau.cine.venta.billadded");
        this.billId = billId;
        this.description = description;
    }

    public BillId getBillId() {
        return billId;
    }

    public Description getDescription() {
        return description;
    }
}
