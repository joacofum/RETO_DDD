package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdateReservationDescription;

public class UpdateReservationDescriptionUseCase extends UseCase<RequestCommand<UpdateReservationDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateReservationDescription> updateReservationDescriptionRequestCommand) {
        var command = updateReservationDescriptionRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.updateReservationDescription(command.getReservationId(), command.getReservationDescription());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
