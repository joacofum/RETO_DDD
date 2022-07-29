package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.Capacity;

public class CinemaRoomCreated extends DomainEvent {
    private final Capacity capacity;
    public CinemaRoomCreated(Capacity capacity) {
        super("co.com.sofkau.cine.sala.cinemaroomcreated");
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
