package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.Identity;

public class MovieManagerId extends Identity {
    private MovieManagerId(String id) {
        super(id);
    }

    public MovieManagerId() {

    }

    public static MovieManagerId of(String id) {
        return new MovieManagerId(id);
    }
}
