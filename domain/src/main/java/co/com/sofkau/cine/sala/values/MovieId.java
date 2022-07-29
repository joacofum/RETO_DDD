package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.Identity;

public class MovieId extends Identity {
    private MovieId(String id){ super(id); }
    public MovieId(){ }
    public static MovieId of(String id) {
        return new MovieId(id);
    }

}
