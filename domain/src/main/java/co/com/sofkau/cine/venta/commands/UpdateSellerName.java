package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.SellerId;
import co.com.sofkau.cine.venta.values.SellerName;

public class UpdateSellerName extends Command {
    private final SaleId saleId;
    private final SellerId sellerid;
    private final SellerName name;

    public UpdateSellerName(SaleId saleId, SellerId sellerid, SellerName name) {
        this.saleId = saleId;
        this.sellerid = sellerid;
        this.name = name;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public SellerId getSellerId() {
        return sellerid;
    }

    public SellerName getName() {
        return name;
    }
}
