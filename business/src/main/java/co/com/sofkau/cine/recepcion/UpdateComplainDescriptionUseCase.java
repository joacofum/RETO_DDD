package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdateComplainDescription;

public class UpdateComplainDescriptionUseCase extends UseCase<RequestCommand<UpdateComplainDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateComplainDescription> updateComplainDescriptionRequestCommand) {
        var command = updateComplainDescriptionRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.updateComplainDescription(command.getComplainId(), command.getComplainDescription());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
