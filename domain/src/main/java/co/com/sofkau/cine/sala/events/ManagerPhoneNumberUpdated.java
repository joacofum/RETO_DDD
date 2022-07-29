package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieManagerId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

public class ManagerPhoneNumberUpdated extends DomainEvent {
    private final MovieManagerId movieManagerId;
    private final PhoneNumber number;

    public ManagerPhoneNumberUpdated(MovieManagerId movieManagerId, PhoneNumber number){
        super("co.com.sofkau.cine.sala.managerphonenumberupdated");
        this.movieManagerId = movieManagerId;
        this.number = number;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public PhoneNumber getNumber() {
        return number;
    }
}
