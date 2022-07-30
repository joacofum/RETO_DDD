package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdateSellerName;

public class UpdateSellerNameUseCase extends UseCase<RequestCommand<UpdateSellerName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateSellerName> updateSellerNameRequestCommand) {
        var command = updateSellerNameRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateSellerName(command.getSellerId(), command.getName());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
