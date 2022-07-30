package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieDuration;
import co.com.sofkau.cine.sala.values.MovieId;

public class MovieDurationUpdated extends DomainEvent {
    private final MovieId movieId;
    private final MovieDuration movieDuration;

    public MovieDurationUpdated(MovieId movieId, MovieDuration movieDuration) {
        super("co.com.sofkau.cine.sala.moviedurationupdated");
        this.movieId = movieId;
        this.movieDuration = movieDuration;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieDuration getMovieDuration() {
        return movieDuration;
    }
}
