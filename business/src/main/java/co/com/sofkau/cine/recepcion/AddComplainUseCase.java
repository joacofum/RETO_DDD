package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.AddComplain;

public class AddComplainUseCase extends UseCase<RequestCommand<AddComplain>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddComplain> addComplainRequestCommand) {
        var command = addComplainRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.addComplain(command.getComplainDescription(), command.getComplainDate());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
