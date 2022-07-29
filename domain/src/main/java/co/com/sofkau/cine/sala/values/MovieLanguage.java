package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MovieLanguage implements ValueObject<String> {
    private final String name;

    public MovieLanguage(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String value() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieLanguage name = (MovieLanguage) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
