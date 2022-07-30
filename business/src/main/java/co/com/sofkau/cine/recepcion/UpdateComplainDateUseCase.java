package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdateComplainDate;

public class UpdateComplainDateUseCase extends UseCase<RequestCommand<UpdateComplainDate>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateComplainDate> updateComplainDateRequestCommand) {
        var command = updateComplainDateRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.udpateComplainDate(command.getComplainId(), command.getComplainDate());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
