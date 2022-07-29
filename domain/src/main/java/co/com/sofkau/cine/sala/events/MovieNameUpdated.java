package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.sala.values.MovieManagerId;
import co.com.sofkau.cine.sala.values.MovieName;

public class MovieNameUpdated extends DomainEvent {
    private final MovieId movieId;
    private final MovieName name;

    public MovieNameUpdated(MovieId movieId, MovieName name){
        super("co.com.sofkau.cine.sala.movienameupdated");
        this.movieId = movieId;
        this.name = name;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public MovieName getName() {
        return name;
    }
}
