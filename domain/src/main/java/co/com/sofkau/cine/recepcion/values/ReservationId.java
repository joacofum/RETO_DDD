package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class ReservationId extends Identity {
    private ReservationId(String id){ super(id); }
    public ReservationId(){ }
    public static ReservationId of(String id) {
        return new ReservationId(id);
    }
}
