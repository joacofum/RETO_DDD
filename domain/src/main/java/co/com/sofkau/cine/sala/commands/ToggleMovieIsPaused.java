package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.isPaused;

public class ToggleMovieIsPaused extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieId movieId;
    private final isPaused isPaused;


    public ToggleMovieIsPaused(CinemaRoomId cinemaRoomId, MovieId movieId, isPaused isPaused) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
        this.isPaused = isPaused;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public isPaused getIsPaused() {
        return isPaused;
    }
}
