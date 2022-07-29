package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.MovieManagerId;

public class ManagerNameUpdated extends DomainEvent {
    private final MovieManagerId movieManagerId;
    private final ManagerName name;

    public ManagerNameUpdated(MovieManagerId movieManagerId, ManagerName name){
        super("co.com.sofkau.cine.sala.managernameupdated");
        this.movieManagerId = movieManagerId;
        this.name = name;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public ManagerName getName() {
        return name;
    }
}
