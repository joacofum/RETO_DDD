package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.AddBill;
import co.com.sofkau.cine.venta.commands.UpdateBillDescription;
import co.com.sofkau.cine.venta.events.BillAdded;
import co.com.sofkau.cine.venta.events.BillDescriptionUpdated;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.values.BillDescription;
import co.com.sofkau.cine.venta.values.BillId;
import co.com.sofkau.cine.venta.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateBillDescriptionUseCaseTest {

    @InjectMocks
    private UpdateBillDescriptionUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateBillDescriptionSuccessfully(){
        SaleId saleId = SaleId.of("AAAA");
        BillId billId = BillId.of("1");
        BillDescription billDescription = new BillDescription("Venta de camiseta de Stranger Things");
        var command = new UpdateBillDescription(saleId, billId, billDescription);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (BillDescriptionUpdated) events.get(1);
        Assertions.assertEquals("Venta de camiseta de Stranger Things", event.getBillDescription().value());

    }

    private List<DomainEvent> history() {
        var event1 = new SaleCreated();
        event1.setAggregateRootId("xxxxx");
        BillId billId = BillId.of("1");
        BillDescription billDescription = new BillDescription("Venta de pop");
        var event2 = new BillAdded(billId, billDescription);

        return List.of(event1, event2);
    }
}