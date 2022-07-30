package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.UpdateSellerName;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.events.SellerAdded;
import co.com.sofkau.cine.venta.events.SellerNameUpdated;
import co.com.sofkau.cine.venta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateSellerNameUseCaseTest {
    @InjectMocks
    private UpdateSellerNameUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void UpdateSellerNameSuccessfully() {
        SaleId saleId = SaleId.of("AAAA");
        SellerId sellerId = SellerId.of("1");
        SellerName sellerName = new SellerName("Nicolás", "Ovelar");
        var command = new UpdateSellerName(saleId, sellerId, sellerName);


        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SellerNameUpdated) events.get(1);
        Assertions.assertEquals("Nicolás Ovelar", event.getName().value());
    }

    private List<DomainEvent> history() {
        var event1 = new SaleCreated();
        event1.setAggregateRootId("xxxxx");
        SellerId sellerId = SellerId.of("1");
        SellerName sellerName = new SellerName("Matías", "Souza");
        var event2 = new SellerAdded(sellerId, sellerName);

        return List.of(event1, event2);
    }
}