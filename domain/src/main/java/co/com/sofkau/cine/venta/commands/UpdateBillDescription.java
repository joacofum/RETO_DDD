package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.SaleId;

public class UpdateBillDescription extends Command {
    private final SaleId saleId;
    private final BillId billId;
    private final BillDescription billDescription;

    public UpdateBillDescription(SaleId saleId, BillId billId, BillDescription billDescription) {
        this.saleId = saleId;
        this.billId = billId;
        this.billDescription = billDescription;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public BillId getBillId() {
        return billId;
    }

    public BillDescription getBillDescription() {
        return billDescription;
    }
}
