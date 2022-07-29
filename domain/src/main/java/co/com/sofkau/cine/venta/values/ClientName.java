package co.com.sofkau.cine.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ClientName implements ValueObject<String> {
    private final String name;
    private final String surname;


    public ClientName(String name, String surname) {
        this.name = Objects.requireNonNull(name);
        this.surname =  Objects.requireNonNull(surname);

        if(this.name.isBlank() || this.surname.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }

        if(this.name.length() > 200 || this.surname.length() > 200){
            throw new IllegalArgumentException("El nombre no permite mas de 200 caracteres");
        }

    }

    @Override
    public String value() {
        return this.name + " " + this.surname;
    }
}
