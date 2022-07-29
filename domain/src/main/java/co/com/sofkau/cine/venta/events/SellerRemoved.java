package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.SellerId;

public class SellerRemoved extends DomainEvent {
    private final SellerId sellerId;

    public SellerRemoved(SellerId sellerId) {
        super("co.com.sofkau.cine.venta.sellerremoved");
        this.sellerId = sellerId;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

}
