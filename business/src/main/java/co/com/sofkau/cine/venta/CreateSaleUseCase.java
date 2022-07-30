package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.CreateSale;

public class CreateSaleUseCase extends UseCase<RequestCommand<CreateSale>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateSale> createSaleRequestCommand) {
        var command = createSaleRequestCommand.getCommand();
        var sale = new Sale(command.getEntityId());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
