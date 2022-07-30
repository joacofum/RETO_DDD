package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.CreateCinemaRoom;

public class CreateCinemaRoomUseCase extends UseCase<RequestCommand<CreateCinemaRoom>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateCinemaRoom> createCinemaRoomRequestCommand) {
        var command = createCinemaRoomRequestCommand.getCommand();
        var cinemaRoom = new CinemaRoom(command.getEntityId(), command.getCapacity());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
