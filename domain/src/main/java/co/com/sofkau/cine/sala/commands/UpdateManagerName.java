package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.*;

public class UpdateManagerName extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieManagerId movieManagerId;
    private final ManagerName name;

    public UpdateManagerName(CinemaRoomId cinemaRoomId, MovieManagerId movieManagerId, ManagerName name) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieManagerId = movieManagerId;
        this.name = name;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public ManagerName getName() {
        return name;
    }
}
