package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.ProductId;

public class ProductDescriptionUpdated extends DomainEvent {
    private final ProductId productId;
    private final Description description;

    public ProductDescriptionUpdated(ProductId productId, Description description) {
        super("co.com.sofkau.cine.venta.productdescriptionupdated");
        this.productId = productId;
        this.description = description;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Description getDescription() {
        return description;
    }
}
