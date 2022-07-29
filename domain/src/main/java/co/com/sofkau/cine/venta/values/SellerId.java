package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.cine.sala.values.MovieId;

public class SellerId extends Identity {
    private SellerId(String id){ super(id); }
    public SellerId(){ }
    public static SellerId of(String id) {
        return new SellerId(id);
    }
}
