package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdatePrice;

public class UpdateProductPriceUseCase  extends UseCase<RequestCommand<UpdatePrice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePrice> updatePriceRequestCommand) {
        var command = updatePriceRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateProductPrice(command.getProductId(), command.getPrice());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
