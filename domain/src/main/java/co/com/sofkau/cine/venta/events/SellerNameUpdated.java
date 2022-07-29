package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.SellerId;
import co.com.sofkau.cine.venta.values.SellerName;

public class SellerNameUpdated extends DomainEvent {
    private final SellerId sellerId;
    private final SellerName name;

    public SellerNameUpdated(SellerId sellerId, SellerName name) {
        super("co.com.sofkau.cine.venta.sellernameupdated");
        this.sellerId = sellerId;
        this.name = name;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public SellerName getName() {
        return name;
    }
}
