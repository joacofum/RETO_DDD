package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;

public class ToggleMovieIsPaused extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieId movieId;

    public ToggleMovieIsPaused(CinemaRoomId cinemaRoomId, MovieId movieId) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }
}
