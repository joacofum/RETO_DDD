package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.Actor;
import co.com.sofkau.cine.sala.values.MovieId;

public class ActorUpdated extends DomainEvent {
    private final MovieId movieId;
    private final Actor actor;


    public ActorUpdated( MovieId movieId, Actor actor) {
        super("co.com.sofkau.cine.sala.actorupdated");
        this.movieId = movieId;
        this.actor = actor;
    }


    public MovieId getMovieId() {
        return movieId;
    }

    public Actor getActor() {
        return actor;
    }
}
