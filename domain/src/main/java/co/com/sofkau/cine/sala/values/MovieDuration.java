package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class MovieDuration implements ValueObject<LocalTime> {
    private final LocalTime time;
    public MovieDuration(LocalTime time) {
        this.time = Objects.requireNonNull(time);
    }

    public static MovieDuration of(LocalTime time) { return new MovieDuration(time); }

    @Override
    public LocalTime value() {
        return this.time;
    }

}
