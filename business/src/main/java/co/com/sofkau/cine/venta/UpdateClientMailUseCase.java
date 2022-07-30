package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.cine.venta.commands.UpdateMail;

public class UpdateClientMailUseCase extends UseCase<RequestCommand<UpdateMail>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateMail> updateMailRequestCommand) {
        var command = updateMailRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), repository().getEventsBy(command.getSaleId().value()));
        sale.updateClientMail(command.getClientId(), command.getMail());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
