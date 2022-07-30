package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateMovieDuration;

public class UpdateMovieDurationUseCase extends UseCase<RequestCommand<UpdateMovieDuration>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMovieDuration> updateMovieDurationRequestCommand) {
        var command = updateMovieDurationRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateMovieDuration(command.getMovieId(), command.getMovieDuration());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
