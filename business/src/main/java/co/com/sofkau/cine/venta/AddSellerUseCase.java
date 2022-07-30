package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.AddSeller;

public class AddSellerUseCase extends UseCase<RequestCommand<AddSeller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSeller> addSellerRequestCommand) {
        var command = addSellerRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.addSeller(command.getSellerName());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
