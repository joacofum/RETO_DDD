package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ReservationDate;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class ReservationDateUpdated extends DomainEvent {
    private final ReservationId reservationId;
    private final ReservationDate reservationDate;

    public ReservationDateUpdated(ReservationId reservationId, ReservationDate reservationDate) {
        super("co.com.sofkau.cine.recepcion.reservationdateupdated");
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public ReservationDate getReservationDate() {
        return reservationDate;
    }
}
