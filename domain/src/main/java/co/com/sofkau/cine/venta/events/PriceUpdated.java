package co.com.sofkau.cine.venta.events;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.values.Price;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.SaleId;

public class PriceUpdated extends DomainEvent {
    private final ProductId productId;
    private final Price price;

    public PriceUpdated(ProductId productId, Price price) {
        super("co.com.sofkau.cine.venta.priceupdated");
        this.productId = productId;
        this.price = price;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }
}
