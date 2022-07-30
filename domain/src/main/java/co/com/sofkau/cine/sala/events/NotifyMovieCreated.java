package co.com.sofkau.cine.sala.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.MovieId;

public class NotifyMovieCreated extends DomainEvent {
    private final String notify;

    public NotifyMovieCreated( String notify) {
        super("co.com.sofkau.cine.sala.notifymoviecreated");
        this.notify = notify;
    }

    public String getNotify() {
        return notify;
    }
}
