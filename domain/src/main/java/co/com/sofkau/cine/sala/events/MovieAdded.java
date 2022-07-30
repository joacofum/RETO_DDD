package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.*;

public class MovieAdded extends DomainEvent {
    private final MovieId movieId;
    private final MovieName movieName;
    private final Actor actor;
    private final MovieDuration movieDuration;
    private final MovieLanguage movieLanguage;
    private final MovieDate movieDate;

    private final isPaused paused;

    public MovieAdded(MovieId movieId, MovieName movieName, Actor actor, MovieDuration movieDuration, MovieLanguage movieLanguage, MovieDate movieDate, isPaused paused) {
        super("co.com.sofkau.cine.sala.movieadded");
        this.movieId = movieId;
        this.movieName = movieName;
        this.actor = actor;
        this.movieDuration = movieDuration;
        this.movieLanguage = movieLanguage;
        this.movieDate = movieDate;
        this.paused = paused;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieName getMovieName() {
        return movieName;
    }

    public Actor getActor() {
        return actor;
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

    public isPaused getPaused() {
        return paused;
    }
}
