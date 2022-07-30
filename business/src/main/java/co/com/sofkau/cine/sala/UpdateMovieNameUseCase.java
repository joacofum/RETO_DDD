package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateMovieName;

public class UpdateMovieNameUseCase extends UseCase<RequestCommand<UpdateMovieName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMovieName> updateMovieNameRequestCommand) {
        var command = updateMovieNameRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateMovieName(command.getMovieId(), command.getName());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
