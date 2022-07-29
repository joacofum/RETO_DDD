package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReservationDate;
import co.com.sofkau.cine.recepcion.values.ReservationId;
import co.com.sofkau.cine.venta.values.Description;

public class ReservationAdded extends DomainEvent {
    private final ReservationId reservationId;
    private final Price price;
    private final Description description;
    private final ReservationDate reservationDate;

    public ReservationAdded(ReservationId reservationId, Price price, Description description, ReservationDate reservationDate) {
        super("co.com.sofkau.cine.recepcion.reservationadded");
        this.reservationId = reservationId;
        this.price = price;
        this.description = description;
        this.reservationDate = reservationDate;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public Price getPrice() {
        return price;
    }

    public Description getDescription() {
        return description;
    }

    public ReservationDate getReservationDate() {
        return reservationDate;
    }
}
