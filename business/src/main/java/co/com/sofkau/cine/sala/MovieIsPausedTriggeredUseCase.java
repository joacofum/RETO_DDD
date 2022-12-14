package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.cine.sala.events.MovieAdded;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.isPaused;

public class MovieIsPausedTriggeredUseCase extends UseCase<TriggeredEvent<MovieAdded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<MovieAdded> movieAddedTriggeredEvent) {
        var event = movieAddedTriggeredEvent.getDomainEvent();
        var cinemaRoom = CinemaRoom.from(CinemaRoomId.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        var paused = new isPaused(false);
        cinemaRoom.togglePauseMovie(event.getMovieId(), paused);
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
