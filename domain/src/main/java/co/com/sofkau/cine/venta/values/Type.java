package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<String> {
    private final String value;
    public Type(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
