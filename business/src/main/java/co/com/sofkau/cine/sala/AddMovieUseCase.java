package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.sala.commands.AddMovie;

public class AddMovieUseCase extends UseCase<RequestCommand<AddMovie>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddMovie> addMovieRequestCommand) {
        var command = addMovieRequestCommand.getCommand();
        var cinemaRoom = CinemaRoom.from(command.getCinemaRoomId(), repository().getEventsBy(command.getCinemaRoomId().value()));
        cinemaRoom.addMovie(command.getMovieName(), command.getActorPrincipal(), command.getMovieDuration(), command.getMovieLanguage(), command.getMovieDate(), command.getPaused());
        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
    }
}
