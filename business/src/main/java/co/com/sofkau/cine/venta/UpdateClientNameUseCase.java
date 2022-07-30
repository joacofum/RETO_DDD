package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdateClientName;

public class UpdateClientNameUseCase  extends UseCase<RequestCommand<UpdateClientName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientName> updateClientNameRequestCommand) {
        var command = updateClientNameRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateClientName(command.getClientId(), command.getName());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
