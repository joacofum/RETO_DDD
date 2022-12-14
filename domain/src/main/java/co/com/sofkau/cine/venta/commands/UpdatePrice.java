package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.Price;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.SaleId;

public class UpdatePrice extends Command {
    private final SaleId saleId;
    private final ProductId productId;
    private final Price price;

    public UpdatePrice(SaleId saleId, ProductId productId, Price price) {
        this.saleId = saleId;
        this.productId = productId;
        this.price = price;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }
}
