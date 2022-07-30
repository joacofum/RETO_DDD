package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieDuration;
import co.com.sofkau.cine.sala.values.MovieId;

public class UpdateMovieDuration extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieId movieId;
    private final MovieDuration movieDuration;

    public UpdateMovieDuration(CinemaRoomId cinemaRoomId, MovieId movieId, MovieDuration movieDuration) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
        this.movieDuration = movieDuration;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public MovieDuration getMovieDuration() {
        return movieDuration;
    }

    public MovieId getMovieId() {
        return movieId;
    }
}
