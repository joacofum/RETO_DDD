package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.UpdatePrice;
import co.com.sofkau.cine.venta.events.PriceUpdated;
import co.com.sofkau.cine.venta.events.ProductAdded;
import co.com.sofkau.cine.venta.events.SaleCreated;
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
class UpdateProductPriceUseCaseTest {
    @InjectMocks
    private UpdateProductPriceUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void UpdateProductPriceSuccessfully() {
        SaleId saleId = SaleId.of("AAAA");
        ProductId productId = ProductId.of("1");
        Price price = new Price(400);
        var command = new UpdatePrice(saleId, productId, price);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (PriceUpdated)events.get(1);
        Assertions.assertEquals(400, event.getPrice().value());
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