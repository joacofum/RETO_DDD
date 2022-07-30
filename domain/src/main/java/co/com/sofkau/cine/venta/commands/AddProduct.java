package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.*;

public class AddProduct extends Command {
    private final SaleId saleId;
    private final Description description;
    private final Type type;
    private final Price price;

    public AddProduct(SaleId saleId, Description description, Type type, Price price) {
        this.saleId = saleId;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public SaleId getSaleId() {
        return saleId;
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
