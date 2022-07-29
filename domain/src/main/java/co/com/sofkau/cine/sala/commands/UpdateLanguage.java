package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieLanguage;

public class UpdateLanguage extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieId movieId;
    private final MovieLanguage language;

    public UpdateLanguage(CinemaRoomId cinemaRoomId, MovieId movieId, MovieLanguage language) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieId = movieId;
        this.language = language;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieLanguage getLanguage() {
        return language;
    }
}
