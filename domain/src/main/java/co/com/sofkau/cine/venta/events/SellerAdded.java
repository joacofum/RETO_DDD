package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.SellerId;
import co.com.sofkau.cine.venta.values.SellerName;

public class SellerAdded extends DomainEvent {
    private final SellerId sellerId;
    private final SellerName sellerName;

    public SellerAdded(SellerId sellerId, SellerName sellerName) {
        super("co.com.sofkau.cine.venta.selleradded");
        this.sellerId = sellerId;
        this.sellerName = sellerName;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public SellerName getSellerName() {
        return sellerName;
    }

}
