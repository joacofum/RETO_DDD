package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ReceptionDescription implements ValueObject<String> {
    private final String value;
    public ReceptionDescription(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
