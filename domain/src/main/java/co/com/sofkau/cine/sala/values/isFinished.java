package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class isFinished implements ValueObject<Boolean> {
    private final Boolean value;

    public isFinished(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        isFinished that = (isFinished) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
