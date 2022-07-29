package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.SaleId;
public class AddBill extends Command {
    private final BillId billId;
    private final SaleId saleId;
    private final Description description;

    public AddBill(BillId billId, SaleId saleId, Description description) {
        this.billId = billId;
        this.saleId = saleId;
        this.description = description;
    }

    public BillId getBillId() {
        return billId;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public Description getDescription() {
        return description;
    }
}
