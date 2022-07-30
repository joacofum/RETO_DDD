package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdateBillDescription;

public class UpdateBillDescriptionUseCase extends UseCase<RequestCommand<UpdateBillDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateBillDescription> updateBillDescriptionRequestCommand) {
        var command = updateBillDescriptionRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateBillDescription(command.getBillId(), command.getBillDescription());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
