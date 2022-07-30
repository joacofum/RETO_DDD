package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieId;

public class MovieIsPausedToggled extends DomainEvent {
    private final MovieId movieId;

    public MovieIsPausedToggled(MovieId movieId) {
        super("co.com.sofkau.cine.sala.movieispausedtoggle");
        this.movieId = movieId;
    }

    public MovieId getMovieId() {
        return movieId;
    }
}
