package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.CinemaRoom;
import co.com.sofkau.cine.sala.entities.Movie;
import co.com.sofkau.cine.sala.values.*;

import java.util.List;

public class AddMovie extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieName movieName;
    private final Actor actorPrincipal;
    private final MovieDuration movieDuration;
    private final MovieLanguage movieLanguage;
    private final MovieDate movieDate;

    public AddMovie(CinemaRoomId cinemaRoomId, MovieName movieName, Actor actorPrincipal, MovieDuration movieDuration, MovieLanguage movieLanguage, MovieDate movieDate) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieName = movieName;
        this.actorPrincipal = actorPrincipal;
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

    public Actor getActorPrincipal() {
        return actorPrincipal;
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
