package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdateProductDescription;

public class UpdateProductDescriptionUseCase extends UseCase<RequestCommand<UpdateProductDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateProductDescription> updateProductDescriptionRequestCommand) {
        var command = updateProductDescriptionRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateProductDescription(command.getProductId(), command.getDescription());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
