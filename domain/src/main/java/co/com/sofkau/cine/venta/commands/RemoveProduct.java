package co.com.sofkau.cine.venta.commands;


import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.ProductId;
import co.com.sofkau.cine.venta.values.SaleId;

public class RemoveProduct extends Command {
    private final ProductId productId;
    private final SaleId saleId;

    public RemoveProduct(ProductId productId, SaleId saleId) {
        this.productId = productId;
        this.saleId = saleId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public SaleId getSaleId() {
        return saleId;
    }
}
