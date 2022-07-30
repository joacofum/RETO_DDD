package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieDate;
import co.com.sofkau.cine.sala.values.MovieId;

public class MovieDateUpdated extends DomainEvent {
    private final MovieId movieId;
    private final MovieDate date;


    public MovieDateUpdated( MovieId movieId, MovieDate date) {
        super("co.com.sofkau.cine.sala.moviedurationupdated");
        this.movieId = movieId;
        this.date = date;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieDate getDate() {
        return date;
    }
}
