package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.ReservationId;

public class Reservation extends Entity<ReservationId> {
    public Reservation(ReservationId entityId) {
        super(entityId);
    }

}
