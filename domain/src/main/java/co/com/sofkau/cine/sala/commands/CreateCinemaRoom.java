package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.Capacity;
import co.com.sofkau.cine.sala.values.CinemaRoomId;

public class CreateCinemaRoom extends Command {
    private final CinemaRoomId entityId;
    private final Capacity capacity;

    public CreateCinemaRoom(CinemaRoomId entityId, Capacity capacity) {
        this.entityId = entityId;
        this.capacity = capacity;
    }

    public CinemaRoomId getEntityId() {
        return entityId;
    }

    public Capacity getCapacity() {
        return capacity;
    }
}
