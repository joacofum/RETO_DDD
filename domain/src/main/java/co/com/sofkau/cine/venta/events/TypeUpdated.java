package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.Type;

public class TypeUpdated extends DomainEvent {
    private final ProductId productId;
    private final Type type;

    public TypeUpdated(ProductId productId, Type type) {
        super("co.com.sofkau.cine.venta.typeupdated");
        this.productId = productId;
        this.type = type;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Type getType() {
        return type;
    }
}
