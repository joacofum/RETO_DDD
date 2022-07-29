package co.com.sofkau.cine.recepcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class ComplainDate implements ValueObject<LocalDate> {
    private final LocalDate date;
    public ComplainDate(LocalDate date) {
        this.date = Objects.requireNonNull(date);
    }
    public static ComplainDate of(LocalDate date) {
        return new ComplainDate(date);
    }

    @Override
    public LocalDate value() {
        return this.date;
    }

}