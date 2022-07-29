package co.com.sofkau.cine.venta.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.ProductId;

import java.util.Objects;
import java.util.Set;

public class Bill extends Entity<BillId> {
    protected Set<ProductId> productIdSet;
    protected BillDescription description;

    public Bill(BillId entityId, BillDescription description) {
        super(entityId);
        this.description = description;
    }

    public Set<ProductId> getProductIdSet() {
        return productIdSet;
    }

    public BillDescription getBillDescription() {
        return description;
    }

    public void updateBillDescription(BillDescription description){
        this.description = Objects.requireNonNull(description);
    }
}
