package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.ReservationDate;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class UpdateReservationDate extends Command {
    private final ReceptionId receptionId;
    private final ReservationId reservationId;
    private final ReservationDate reservationDate;

    public UpdateReservationDate(ReceptionId receptionId, ReservationId reservationId, ReservationDate reservationDate) {
        this.receptionId = receptionId;
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReservationId getReservationId() {
        return reservationId;
    }

    public ReservationDate getReservationDate() {
        return reservationDate;
    }
}
