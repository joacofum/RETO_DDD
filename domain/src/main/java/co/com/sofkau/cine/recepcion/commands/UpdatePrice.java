package co.com.sofkau.cine.recepcion.commands;


import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class UpdatePrice extends Command {
    private final ReceptionId receptionId;
    private final ReservationId reservationId;
    private final Price price;

    public UpdatePrice(ReceptionId receptionId, ReservationId reservationId, Price price) {
        this.receptionId = receptionId;
        this.reservationId = reservationId;
        this.price = price;
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
}
