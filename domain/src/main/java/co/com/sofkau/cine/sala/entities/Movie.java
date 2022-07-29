package co.com.sofkau.cine.sala.entities;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.sala.values.*;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Movie extends Entity<MovieId> {
    protected MovieName movieName;
    protected List<Actor> actors;
    protected MovieDuration movieDuration;
    protected MovieLanguage movieLanguage;
    protected MovieDate movieDate;
    protected isFinished finished;
    protected isPaused paused;

    public Movie(MovieId entityId) {
        super(entityId);
    }

    public Movie(MovieId entityId, MovieName name, List<Actor> actors, MovieDuration movieDuration, MovieLanguage movieLanguage, MovieDate movieDate) {
        super(entityId);
        this.movieName = name;
        this.actors = actors;
        this.movieDuration = movieDuration;
        this.movieLanguage = movieLanguage;
        this.movieDate = movieDate;
        this.finished = new isFinished(false);
        this.paused = new isPaused(true);
    }

    public void updateName(MovieName movieName){
        this.movieName = Objects.requireNonNull(movieName);
    }

    public void updateLanguage(MovieLanguage movieLanguage){
        this.movieLanguage = Objects.requireNonNull(movieLanguage);
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

    public isFinished getFinished() {
        return finished;
    }

    public isPaused getPaused() {
        return paused;
    }
}
