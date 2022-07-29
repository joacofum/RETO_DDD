package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.MovieManagerId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

public class ManagerAdded extends DomainEvent {
    private final MovieManagerId movieManagerId;
    private final ManagerName managerName;
    private final PhoneNumber phoneNumber;

    public ManagerAdded(MovieManagerId movieManagerId, ManagerName managerName, PhoneNumber phoneNumber) {
        super("co.com.sofkau.cine.sala.manageradded");
        this.movieManagerId = movieManagerId;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public ManagerName getManagerName() {
        return managerName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
