package co.com.sofkau.cine.venta.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.*;

import java.util.Objects;

public class Product extends Entity<ProductId> {
    protected Description description;
    protected Type type;
    protected Price price;

    public Product(ProductId entityId, Description description, Type type, Price price) {
        super(entityId);
        this.description = description;
        this.type = type;
        this.price = price;
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

    public void updateDescription(Description description){
        this.description = Objects.requireNonNull(description);
    }

    public void updateType(Type type){
        this.type = Objects.requireNonNull(type);
    }

    public void updatePrice(Price price){
        this.price = Objects.requireNonNull(price);
    }
}
