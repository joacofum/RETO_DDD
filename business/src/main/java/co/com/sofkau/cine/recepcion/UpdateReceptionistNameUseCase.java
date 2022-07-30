package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdateName;

public class UpdateReceptionistNameUseCase extends UseCase<RequestCommand<UpdateName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateName> updateNameRequestCommand) {
        var command = updateNameRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.updateReceptionistName(command.getRecepcionistId(), command.getName());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
