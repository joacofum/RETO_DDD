package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.venta.commands.AddProduct;
import co.com.sofkau.cine.venta.entities.Product;
import co.com.sofkau.cine.venta.events.BillAdded;
import co.com.sofkau.cine.venta.events.ProductAdded;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.values.Description;
import co.com.sofkau.cine.venta.values.Price;
import co.com.sofkau.cine.venta.values.SaleId;
import co.com.sofkau.cine.venta.values.Type;
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
class AddProductUseCaseTest {
    @InjectMocks
    private AddProductUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddProductSuccessfully() {
        SaleId saleId = SaleId.of("AAAA");
        Description productDescription = new Description("Coca 3L");
        Type type = new Type("Bebida");
        Price price = new Price(100);
        var command = new AddProduct(saleId, productDescription, type, price);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ProductAdded) events.get(1);
        Assertions.assertEquals("Coca 3L", event.getDescription().value());
        Assertions.assertEquals("Bebida", event.getType().value());
        Assertions.assertEquals(100, event.getPrice().value());
    }

    private List<DomainEvent> history() {
        var event = new SaleCreated();
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}