package co.com.sofkau.cine.venta.values;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BillDescription implements ValueObject<String> {
    private final String value;
    public BillDescription(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
