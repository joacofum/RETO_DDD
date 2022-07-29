package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class RemoveReservation extends Command {
    private final ReceptionId receptionId;
    private final ReservationId reservationId;

    public RemoveReservation(ReceptionId receptionId, ReservationId reservationId) {
        this.receptionId = receptionId;
        this.reservationId = reservationId;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }
}
