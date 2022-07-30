package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.AddReservation;

public class AddReservationUseCase extends UseCase<RequestCommand<AddReservation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddReservation> addReservationRequestCommand) {
        var command = addReservationRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.addReservation(command.getPrice(), command.getReservationDescription(), command.getReservationDate());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
