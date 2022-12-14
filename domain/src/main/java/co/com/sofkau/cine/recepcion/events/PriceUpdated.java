package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class PriceUpdated extends DomainEvent {
    private final ReservationId reservationId;
    private final Price price;

    public PriceUpdated(ReservationId reservationId, Price price) {
        super("co.com.sofkau.cine.recepcion.priceupdated");
        this.reservationId = reservationId;
        this.price = price;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public Price getPrice() {
        return price;
    }
}
