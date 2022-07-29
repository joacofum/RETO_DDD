package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.*;

import java.util.List;

public class MovieAdded extends DomainEvent {
    private final MovieId movieId;
    private final MovieName movieName;
    private final List<Actor> actors;
    private final MovieDuration movieDuration;
    private final MovieLanguage movieLanguage;
    private final MovieDate movieDate;
    public MovieAdded(MovieId movieId, MovieName movieName, List<Actor> actors, MovieDuration movieDuration, MovieLanguage movieLanguage, MovieDate movieDate) {
        super("co.com.sofkau.cine.sala.movieAdded");
        this.movieId = movieId;
        this.movieName = movieName;
        this.actors = actors;
        this.movieDuration = movieDuration;
        this.movieLanguage = movieLanguage;
        this.movieDate = movieDate;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieName getMovieName() {
        return movieName;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public MovieDuration getMovieDuration() {
        return movieDuration;
    }

    public MovieLanguage getMovieLanguage() {
        return movieLanguage;
    }

    public MovieDate getMovieDate() {
        return movieDate;
    }
}
