package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdateType;

public class UpdateProductTypeUseCase  extends UseCase<RequestCommand<UpdateType>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateType> updateTypeRequestCommand) {
        var command = updateTypeRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateProductType(command.getProductId(), command.getType());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
