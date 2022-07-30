package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdatePhone;

public class UpdateClientPhoneUseCase extends UseCase<RequestCommand<UpdatePhone>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePhone> updatePhoneRequestCommand) {
        var command = updatePhoneRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateClientPhone(command.getClientId(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
