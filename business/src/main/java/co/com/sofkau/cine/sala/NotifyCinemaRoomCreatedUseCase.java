package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
import co.com.sofkau.cine.sala.values.CinemaRoomId;

public class NotifyCinemaRoomCreatedUseCase extends UseCase<TriggeredEvent<CinemaRoomCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CinemaRoomCreated> cinemaRoomTriggeredEvent) {
        var event = cinemaRoomTriggeredEvent.getDomainEvent();
        var cinemaRoom = CinemaRoom.from(CinemaRoomId.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        cinemaRoom.notifyCinemaRoomCreated("Empezó la película");
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
