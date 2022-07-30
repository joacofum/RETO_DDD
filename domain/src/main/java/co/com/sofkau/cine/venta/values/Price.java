package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Price implements ValueObject<Integer> {
    private final Integer value;

    public Price(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
