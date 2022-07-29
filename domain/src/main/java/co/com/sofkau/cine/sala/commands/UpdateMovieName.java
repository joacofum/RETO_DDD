package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieName;

public class UpdateMovieName extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieId movieId;
    private final MovieName name;

    public UpdateMovieName(CinemaRoomId cinemaRoomId, MovieId movieId, MovieName name) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
        this.name = name;
    }

    public CinemaRoomId getTrainerID() {
        return cinemaRoomId;
    }

    public MovieId getClientID() {
        return movieId;
    }

    public MovieName getName() {
        return name;
    }
}
