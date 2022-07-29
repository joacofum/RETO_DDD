package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.cine.sala.values.MovieId;

public class RecepcionistId extends Identity {
    private RecepcionistId(String id){ super(id); }
    public RecepcionistId(){ }
    public static RecepcionistId of(String id) {
        return new RecepcionistId(id);
    }
}
