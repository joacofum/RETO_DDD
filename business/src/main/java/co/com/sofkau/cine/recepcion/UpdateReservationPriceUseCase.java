package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.recepcion.commands.UpdatePrice;

public class UpdateReservationPriceUseCase extends UseCase<RequestCommand<UpdatePrice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePrice> updatePriceRequestCommand) {
        var command = updatePriceRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), repository().getEventsBy(command.getReceptionId().value()));
        reception.updateReservationPrice(command.getReservationId(), command.getPrice());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
