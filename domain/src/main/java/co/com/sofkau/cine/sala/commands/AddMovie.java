package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.CinemaRoom;
import co.com.sofkau.cine.sala.values.*;

import java.util.List;

public class AddMovie extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieName movieName;
    private final List<Actor> actors;
    private final MovieDuration movieDuration;
    private final MovieLanguage movieLanguage;
    private final MovieDate movieDate;

    public AddMovie(CinemaRoomId cinemaRoomId, MovieName movieName, List<Actor> actors, MovieDuration movieDuration, MovieLanguage movieLanguage, MovieDate movieDate) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieName = movieName;
        this.actors = actors;
        this.movieDuration = movieDuration;
        this.movieLanguage = movieLanguage;
        this.movieDate = movieDate;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
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
