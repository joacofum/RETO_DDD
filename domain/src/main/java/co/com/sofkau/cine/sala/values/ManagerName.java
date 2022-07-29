package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ManagerName implements ValueObject<String> {
    private final String name;
    private final String surname;


    public ManagerName(String name, String surname) {
        this.name = Objects.requireNonNull(name);
        this.surname =  Objects.requireNonNull(surname);
    }

    @Override
    public String value() {
        return this.name + " " + this.surname;
    }
}
