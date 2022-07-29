package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class ReceptionistId extends Identity {
    private ReceptionistId(String id){ super(id); }
    public ReceptionistId(){ }
    public static ReceptionistId of(String id) {
        return new ReceptionistId(id);
    }
}
