package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieManagerId;

public class MovieRemoved extends DomainEvent {
    private final MovieId movieId;
    private final Boolean wasDeleted;

    public MovieRemoved(MovieId movieId) {
        super("co.com.sofkau.cine.sala.movieremoved");
        this.movieId = movieId;
        this.wasDeleted = true;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
