package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.Price;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.Type;

public class AddProduct extends Command {
    private final ProductId productId;
    private final Description description;
    private final Type type;
    private final Price price;

    public AddProduct(ProductId productId, Description description, Type type, Price price) {
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
