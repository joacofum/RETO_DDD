package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateMovieDate;

public class UpdateMovieDateUseCase extends UseCase<RequestCommand<UpdateMovieDate>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMovieDate> updateMovieDateRequestCommand) {
        var command = updateMovieDateRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateMovieDate(command.getMovieId(), command.getDate());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
