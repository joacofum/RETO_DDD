package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.Actor;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;

public class UpdateActor extends Command {
    private final CinemaRoomId cinemaRoomId;

    private final MovieId movieId;
    private final Actor actor;


    public UpdateActor(CinemaRoomId cinemaRoomId, MovieId movieId, Actor actor) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
        this.actor = actor;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public Actor getActor() {
        return actor;
    }

    public MovieId getMovieId() {
        return movieId;
    }
}
