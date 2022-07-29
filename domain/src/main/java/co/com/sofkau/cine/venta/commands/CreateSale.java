package co.com.sofkau.cine.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.venta.values.SaleId;

public class CreateSale extends Command {
    private final SaleId entityId;

    public CreateSale(SaleId entityId) {
        this.entityId = entityId;
    }

    public SaleId getEntityId() {
        return entityId;
    }
}
