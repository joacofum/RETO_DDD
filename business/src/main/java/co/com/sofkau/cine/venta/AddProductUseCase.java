package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.AddProduct;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {
        var command = addProductRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.addProduct(command.getDescription(), command.getType(), command.getPrice());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
