package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.AddReceptionist;


public class AddReceptionistUseCase extends UseCase<RequestCommand<AddReceptionist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddReceptionist> addReceptionistRequestCommand) {
        var command = addReceptionistRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.addReceptionist(command.getName(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
