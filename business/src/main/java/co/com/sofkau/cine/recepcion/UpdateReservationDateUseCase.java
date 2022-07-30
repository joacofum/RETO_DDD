package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdateReservationDate;

public class UpdateReservationDateUseCase extends UseCase<RequestCommand<UpdateReservationDate>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateReservationDate> updateReservationDateRequestCommand) {
        var command = updateReservationDateRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.updateReservationDate(command.getReservationId(), command.getReservationDate());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
