package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.CreateReception;

public class CreateReceptionUseCase extends UseCase<RequestCommand<CreateReception>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateReception> createReceptionRequestCommand) {
        var command = createReceptionRequestCommand.getCommand();
        var reception = new Reception(command.getReceptionId(), command.getDescription());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
