package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.SellerId;

public class RemoveSeller extends Command {
    private final SellerId sellerId;
    private final SaleId saleId;

    public RemoveSeller(SellerId sellerId, SaleId saleId) {
        this.sellerId = sellerId;
        this.saleId = saleId;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public SaleId getSaleId() {
        return saleId;
    }
}
