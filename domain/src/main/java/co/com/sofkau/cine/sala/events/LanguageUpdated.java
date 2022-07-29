package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieLanguage;
import co.com.sofkau.cine.sala.values.MovieName;

import java.util.UUID;

public class LanguageUpdated extends DomainEvent {
    private final MovieId movieId;
    private final MovieLanguage language;

    public LanguageUpdated(MovieId movieId, MovieLanguage language){
        super("co.com.sofkau.cine.sala.movienameupdated");
        this.movieId = movieId;
        this.language = language;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieLanguage getLanguage() {
        return language;
    }
}
