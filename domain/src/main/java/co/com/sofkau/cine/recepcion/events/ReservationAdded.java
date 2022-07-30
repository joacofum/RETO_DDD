package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReservationDate;
import co.com.sofkau.cine.recepcion.values.ReservationDescription;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class ReservationAdded extends DomainEvent {
    private final ReservationId reservationId;
    private final Price price;
    private final ReservationDescription description;
    private final ReservationDate reservationDate;

    public ReservationAdded(ReservationId reservationId, Price price, ReservationDescription description, ReservationDate reservationDate) {
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

    public ReservationDescription getReservationDescription() {
        return description;
    }

    public ReservationDate getReservationDate() {
        return reservationDate;
    }
}
