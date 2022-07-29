package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.Identity;

public class SaleId extends Identity {
    private SaleId(String id){ super(id); }
    public SaleId(){ }
    public static SaleId of(String id) {
        return new SaleId(id);
    }
}
