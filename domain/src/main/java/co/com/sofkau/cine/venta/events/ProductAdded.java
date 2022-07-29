package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.Price;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.Type;

public class ProductAdded extends DomainEvent {
    private final ProductId productId;
    private final Description description;
    private final Type type;
    private final Price price;

    public ProductAdded(ProductId productId, Description description, Type type, Price price){
        super("co.com.sofkau.cine.venta.productadded");
        this.productId = productId;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Description getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Price getPrice() {
        return price;
    }
}
