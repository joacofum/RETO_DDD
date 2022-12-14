package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.Type;

public class UpdateType extends Command {
    private final SaleId saleId;
    private final ProductId productId;
    private final Type type;

    public UpdateType(SaleId saleId, ProductId productId, Type type) {
        this.saleId = saleId;
        this.productId = productId;
        this.type = type;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Type getType() {
        return type;
    }
}
