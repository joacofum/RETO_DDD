package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class MovieDate implements ValueObject<LocalDate> {
    private final LocalDate date;
    public MovieDate(LocalDate date) {
        this.date = Objects.requireNonNull(date);
    }
    public static MovieDate of(LocalDate date) {
        return new MovieDate(date);
    }

    @Override
    public LocalDate value() {
        return this.date;
    }

}