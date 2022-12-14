package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ComplainDescription implements ValueObject<String> {
    private final String value;
    public ComplainDescription(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
