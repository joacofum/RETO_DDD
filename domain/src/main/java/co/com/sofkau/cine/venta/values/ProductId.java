package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.Identity;

public class ProductId extends Identity {
    private ProductId(String id){ super(id); }
    public ProductId(){ }
    public static ProductId of(String id) {
        return new ProductId(id);
    }
}
