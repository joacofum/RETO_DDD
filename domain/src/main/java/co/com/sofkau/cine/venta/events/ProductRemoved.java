package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.ProductId;
public class ProductRemoved extends DomainEvent {
    private final ProductId productId;
    private final Boolean wasDeleted;

    public ProductRemoved(ProductId productId) {
        super("co.com.sofkau.cine.venta.productremoved");
        this.productId = productId;
        this.wasDeleted = true;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
