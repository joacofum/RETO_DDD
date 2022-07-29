package co.com.sofkau.cine.sala.values;


import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class MovieName implements ValueObject<String> {
    private final String value;

    public MovieName(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieName name = (MovieName) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
