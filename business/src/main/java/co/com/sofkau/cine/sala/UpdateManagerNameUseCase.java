package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateManagerName;

public class UpdateManagerNameUseCase extends UseCase<RequestCommand<UpdateManagerName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateManagerName> updateManagerNameRequestCommand) {
        var command = updateManagerNameRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateManagerName(command.getMovieManagerId(), command.getName());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
