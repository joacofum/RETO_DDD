package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.Identity;

public class ComplainId extends Identity {
    private ComplainId(String id){ super(id); }
    public ComplainId(){ }
    public static ComplainId of(String id) {
        return new ComplainId(id);
    }
}
