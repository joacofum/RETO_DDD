package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.SaleId;
public class AddBill extends Command {
    private final SaleId saleId;
    private final BillDescription description;

    public AddBill(SaleId saleId, BillDescription description) {
        this.saleId = saleId;
        this.description = description;
    }


    public SaleId getSaleId() {
        return saleId;
    }

    public BillDescription getBillDescription() {
        return description;
    }
}
