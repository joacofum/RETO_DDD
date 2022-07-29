package co.com.sofkau.cine.venta.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.ProductId;

import java.util.Objects;
import java.util.Set;

public class Bill extends Entity<BillId> {
    protected Set<ProductId> productIdSet;
    protected Description description;

    public Bill(BillId entityId, Set<ProductId> productIdSet, Description description) {
        super(entityId);
        this.productIdSet = productIdSet;
        this.description = description;
    }

    public Set<ProductId> getProductIdSet() {
        return productIdSet;
    }

    public Description getDescription() {
        return description;
    }

    public void updateDescription(Description description){
        this.description = Objects.requireNonNull(description);
    }
}
