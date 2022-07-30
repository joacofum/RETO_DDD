package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateActor;

public class UpdateMovieActorUseCase extends UseCase<RequestCommand<UpdateActor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateActor> updateActorRequestCommand) {
        var command = updateActorRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateMovieActor(command.getMovieId(), command.getActor());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
