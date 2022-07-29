package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.SellerName;

public class AddSeller extends Command {
    private final SaleId saleId;
    private final SellerName sellerName;

    public AddSeller(SaleId saleId, SellerName sellerName) {
        this.saleId = saleId;
        this.sellerName = sellerName;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public SellerName getSellerName() {
        return sellerName;
    }
}
