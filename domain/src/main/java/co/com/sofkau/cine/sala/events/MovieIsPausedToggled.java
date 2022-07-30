package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.isPaused;

public class MovieIsPausedToggled extends DomainEvent {
    private final MovieId movieId;
    private final isPaused isPaused;

    public MovieIsPausedToggled(MovieId movieId, isPaused isPaused) {
        super("co.com.sofkau.cine.sala.movieispausedtoggle");
        this.movieId = movieId;
        this.isPaused = isPaused;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public isPaused getIsPaused() {
        return isPaused;
    }
}
