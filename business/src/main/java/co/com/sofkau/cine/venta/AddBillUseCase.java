package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.AddBill;

public class AddBillUseCase extends UseCase<RequestCommand<AddBill>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddBill> addBillRequestCommand) {
        var command = addBillRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.addBill(command.getBillDescription());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
