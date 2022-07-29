package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.ReservationDescription;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class UpdateReservationDescription extends Command {
    private final ReceptionId receptionId;
    private final ReservationId reservationId;
    private final ReservationDescription reservationDescription;

    public UpdateReservationDescription(ReceptionId receptionId, ReservationId reservationId, ReservationDescription reservationDescription) {
        this.receptionId = receptionId;
        this.reservationId = reservationId;
        this.reservationDescription = reservationDescription;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public ReservationDescription getReservationDescription() {
        return reservationDescription;
    }
}
