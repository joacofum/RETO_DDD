package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;

public class PriceUpdated extends DomainEvent {
    private final RecepcionistId recepcionistId;
    private final Price price;

    public PriceUpdated(RecepcionistId recepcionistId, Price price) {
        super("co.com.sofkau.cine.recepcion.priceupdated");
        this.recepcionistId = recepcionistId;
        this.price = price;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public Price getPrice() {
        return price;
    }
}
