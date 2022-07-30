package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.UpdatePrice;
import co.com.sofkau.cine.venta.commands.UpdateType;
import co.com.sofkau.cine.venta.events.ProductAdded;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.events.TypeUpdated;
import co.com.sofkau.cine.venta.values.*;
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
class UpdateProductTypeUseCaseTest {
    @InjectMocks
    private UpdateProductTypeUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void UpdateProductTypeSuccessfully() {
        SaleId saleId = SaleId.of("AAAA");
        ProductId productId = ProductId.of("1");
        Type type = new Type("Comida");
        var command = new UpdateType(saleId, productId, type);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TypeUpdated) events.get(1);
        Assertions.assertEquals("Comida", event.getType().value());
    }

    private List<DomainEvent> history() {
        var event1 = new SaleCreated();
        event1.setAggregateRootId("xxxxx");

        ProductId productId = ProductId.of("1");
        Description productDescription = new Description("Coca 3L");
        Type type = new Type("Bebida");
        Price price = new Price(100);
        var event2 = new ProductAdded(productId, productDescription, type, price);

        return List.of(event1, event2);
    }
}