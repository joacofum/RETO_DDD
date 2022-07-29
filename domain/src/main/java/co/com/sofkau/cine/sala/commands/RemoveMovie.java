package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieManagerId;

public class RemoveMovie extends Command {
    private final MovieId movieId;
    private final CinemaRoomId cinemaRoomId;

    public RemoveMovie(MovieId movieId, CinemaRoomId cinemaRoomId) {
        this.movieId = movieId;
        this.cinemaRoomId = cinemaRoomId;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }
}
