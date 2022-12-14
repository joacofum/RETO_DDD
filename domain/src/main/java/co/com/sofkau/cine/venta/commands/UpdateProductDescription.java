package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.SaleId;

public class UpdateProductDescription extends Command {
    private final SaleId saleId;
    private final ProductId productId;
    private final Description description;

    public UpdateProductDescription(SaleId saleId, ProductId productId, Description description) {
        this.saleId = saleId;
        this.productId = productId;
        this.description = description;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Description getDescription() {
        return description;
    }
}
