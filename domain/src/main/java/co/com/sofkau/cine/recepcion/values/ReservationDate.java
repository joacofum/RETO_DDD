package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationDate implements ValueObject<LocalDate> {
    private final LocalDate date;
    public ReservationDate(LocalDate date) {
        this.date = Objects.requireNonNull(date);
    }
    public static ReservationDate of(LocalDate date) {
        return new ReservationDate(date);
    }

    @Override
    public LocalDate value() {
        return this.date;
    }

}