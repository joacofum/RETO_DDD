package co.com.sofkau.cine.venta.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.venta.values.SellerId;
import co.com.sofkau.cine.venta.values.SellerName;

import java.util.Objects;

public class Seller extends Entity<SellerId> {
    protected SellerName sellerName;

    public Seller(SellerId entityId, SellerName sellerName) {
        super(entityId);
        this.sellerName = sellerName;
    }

    public SellerName getSellerName() {
        return sellerName;
    }

    public void setSellerName(SellerName sellerName) {
        this.sellerName = sellerName;
    }

    public void updateName(SellerName sellerName){
        this.sellerName = Objects.requireNonNull(sellerName);
    }
}
