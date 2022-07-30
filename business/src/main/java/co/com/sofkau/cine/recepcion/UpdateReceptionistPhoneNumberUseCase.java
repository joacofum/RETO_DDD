package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdatePhone;

public class UpdateReceptionistPhoneNumberUseCase extends UseCase<RequestCommand<UpdatePhone>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePhone> updatePhoneRequestCommand) {
        var command = updatePhoneRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.updateReceptionistPhoneNumber(command.getRecepcionistId(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
