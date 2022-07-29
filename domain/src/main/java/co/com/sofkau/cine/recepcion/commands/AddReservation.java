package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.ReservationDate;
import co.com.sofkau.cine.recepcion.values.ReservationId;
import co.com.sofkau.cine.venta.values.Description;

public class AddReservation extends Command {
    private final ReceptionId receptionId;
    private final ReservationId reservationId;
    private final Price price;
    private final Description description;
    private final ReservationDate reservationDate;

    public AddReservation(ReceptionId receptionId, ReservationId reservationId, Price price, Description description, ReservationDate reservationDate) {
        this.receptionId = receptionId;
        this.reservationId = reservationId;
        this.price = price;
        this.description = description;
        this.reservationDate = reservationDate;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
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
