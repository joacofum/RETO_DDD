package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateManagerPhoneNumber;

public class UpdateManagerPhoneUseCase extends UseCase<RequestCommand<UpdateManagerPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateManagerPhoneNumber> updateManagerPhoneNumberRequestCommand) {
        var command = updateManagerPhoneNumberRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateManagerPhoneNumber(command.getMovieManagerId(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
