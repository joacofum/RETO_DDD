package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class ReceptionId extends Identity {
    private ReceptionId(String id){ super(id); }
    public ReceptionId(){ }
    public static ReceptionId of(String id) {
        return new ReceptionId(id);
    }
}
