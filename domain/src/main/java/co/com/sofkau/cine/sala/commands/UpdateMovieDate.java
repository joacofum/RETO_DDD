package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieDate;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieManagerId;

public class UpdateMovieDate extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieId movieId;
    private final MovieDate date;

    public UpdateMovieDate(CinemaRoomId cinemaRoomId, MovieId movieId, MovieDate date) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
        this.date = date;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public MovieDate getDate() {
        return date;
    }

    public MovieId getMovieId() {
        return movieId;
    }
}
