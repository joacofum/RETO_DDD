package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ReservationDescription implements ValueObject<String> {
    private final String value;
    public ReservationDescription(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
