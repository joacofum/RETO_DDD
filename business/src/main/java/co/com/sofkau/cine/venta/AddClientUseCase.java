package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.addClient(command.getClientName(), command.getMail(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
