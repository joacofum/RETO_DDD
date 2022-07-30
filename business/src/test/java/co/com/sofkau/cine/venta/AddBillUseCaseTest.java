package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.AddBill;
import co.com.sofkau.cine.venta.events.BillAdded;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AddBillUseCaseTest {
    @InjectMocks
    private AddBillUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddBill() {
        SaleId saleId = SaleId.of("AAAA");
        BillDescription billDescription = new BillDescription("Venta de pop");
        var command = new AddBill(saleId, billDescription);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (BillAdded) events.get(1);
        Assertions.assertEquals("Venta de pop", event.getBillDescription().value());

    }

    private List<DomainEvent> history() {
        //SaleId saleId = SaleId.of("AAAA");
        var event = new SaleCreated();
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}