package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacity implements ValueObject<Integer> {
    private final Integer value;
    public Capacity(Integer capacity){
        this.value = Objects.requireNonNull(capacity);
    }

    public Integer value(){
        return this.value;
    }

}
