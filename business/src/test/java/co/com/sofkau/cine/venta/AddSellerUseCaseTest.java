package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.AddSeller;
import co.com.sofkau.cine.venta.events.ProductAdded;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.events.SellerAdded;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.SellerName;
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
class AddSellerUseCaseTest {
    @InjectMocks
    private AddSellerUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddSellerSuccessfully() {
        SaleId saleId = SaleId.of("AAAA");
        SellerName sellerName = new SellerName("Matías", "Souza");
        var command = new AddSeller(saleId, sellerName);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SellerAdded) events.get(1);
        Assertions.assertEquals("Matías Souza", event.getSellerName().value());
    }

    private List<DomainEvent> history() {
        var event = new SaleCreated();
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}