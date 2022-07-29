package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class ReservationRemoved extends DomainEvent {
    private final ReservationId reservationId;
    private final Boolean wasDeleted;

    public ReservationRemoved(ReservationId reservationId) {
        super("co.com.sofkau.cine.recepcion.reservationremoved");
        this.reservationId = reservationId;
        this.wasDeleted = true;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
