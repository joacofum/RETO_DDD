package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.BillId;

public class BillRemoved extends DomainEvent {
    private final BillId billId;

    public BillRemoved(BillId billId){
        super("co.com.sofkau.cine.venta.billremoved");
        this.billId = billId;
    }

    public BillId getBillId() {
        return billId;
    }
}

