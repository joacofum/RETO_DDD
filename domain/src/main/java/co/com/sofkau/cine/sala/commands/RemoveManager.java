package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieManagerId;

public class RemoveManager extends Command {
    private final MovieManagerId movieManagerId;
    private final CinemaRoomId cinemaRoomId;

    public RemoveManager(MovieManagerId movieManagerId, CinemaRoomId cinemaRoomId) {
        this.movieManagerId = movieManagerId;
        this.cinemaRoomId = cinemaRoomId;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }
}
