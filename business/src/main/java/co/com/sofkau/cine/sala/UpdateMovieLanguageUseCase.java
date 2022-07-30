package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.UpdateLanguage;

public class UpdateMovieLanguageUseCase extends UseCase<RequestCommand<UpdateLanguage>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateLanguage> updateLanguageRequestCommand) {
        var command = updateLanguageRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.updateMovieLanguage(command.getMovieId(), command.getLanguage());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
