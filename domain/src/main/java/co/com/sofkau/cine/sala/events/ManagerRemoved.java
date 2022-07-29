package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieManagerId;

public class ManagerRemoved extends DomainEvent {
    private final MovieManagerId movieManagerId;
    private final Boolean wasDeleted;

    public ManagerRemoved(MovieManagerId movieManagerId) {
        super("co.com.sofkau.cine.sala.managerremoved");
        this.movieManagerId = movieManagerId;
        this.wasDeleted = true;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
