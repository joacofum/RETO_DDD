package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.*;

public class AddReservation extends Command {
    private final ReceptionId receptionId;
    private final Price price;
    private final ReservationDescription description;
    private final ReservationDate reservationDate;

    public AddReservation(ReceptionId receptionId, Price price, ReservationDescription description, ReservationDate reservationDate) {
        this.receptionId = receptionId;
        this.price = price;
        this.description = description;
        this.reservationDate = reservationDate;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
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
