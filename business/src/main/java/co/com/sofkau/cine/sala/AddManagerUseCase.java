package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.AddManager;

public class AddManagerUseCase extends UseCase<RequestCommand<AddManager>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddManager> addManagerRequestCommand) {
        var command = addManagerRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.addManager(command.getManagerName(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
