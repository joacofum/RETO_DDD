package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReservationDate;
import co.com.sofkau.cine.recepcion.values.ReservationDescription;
import co.com.sofkau.cine.recepcion.values.ReservationId;
import co.com.sofkau.cine.recepcion.values.ReservationDescription;

import java.util.Objects;

public class Reservation extends Entity<ReservationId> {
    protected Price price;
    protected ReservationDescription description;
    protected ReservationDate date;

    public Reservation(ReservationId entityId) {
        super(entityId);
    }

    public Reservation(ReservationId entityId, Price price, ReservationDescription description, ReservationDate date) {
        super(entityId);
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public void updatePrice(Price price){
        this.price = Objects.requireNonNull(price);
    }

    public void updateDescription(ReservationDescription description){
        this.description = Objects.requireNonNull(description);
    }

    public void updateDate(ReservationDate date){
        this.date = Objects.requireNonNull(date);
    }
}
