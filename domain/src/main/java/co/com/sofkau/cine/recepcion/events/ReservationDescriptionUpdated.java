package co.com.sofkau.cine.recepcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.values.ReservationDescription;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class ReservationDescriptionUpdated extends DomainEvent {
    private final ReservationId reservationId;
    private final ReservationDescription reservationDescription;

    public ReservationDescriptionUpdated(ReservationId reservationId, ReservationDescription reservationDescription) {
        super("co.com.sofkau.cine.recepcion.reservationdescriptionupdated");
        this.reservationId = reservationId;
        this.reservationDescription = reservationDescription;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public ReservationDescription getReservationDescription() {
        return reservationDescription;
    }
}
