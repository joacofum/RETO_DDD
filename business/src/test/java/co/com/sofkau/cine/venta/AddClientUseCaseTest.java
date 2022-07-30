package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.CreateCinemaRoomUseCase;
import co.com.sofkau.cine.venta.commands.AddClient;
import co.com.sofkau.cine.venta.events.BillAdded;
import co.com.sofkau.cine.venta.events.ClientAdded;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.values.ClientName;
import co.com.sofkau.cine.venta.values.Mail;
import co.com.sofkau.cine.venta.values.PhoneNumber;
import co.com.sofkau.cine.venta.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {
    @InjectMocks
    private AddClientUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void AddClientSuccessfully() {
        SaleId saleId = SaleId.of("AAAA");
        ClientName clientName = new ClientName("Pedro", "González");
        Mail mail = new Mail("pedrog@gmail.com");
        PhoneNumber phoneNumber = new PhoneNumber("22222");
        var command = new AddClient(saleId, clientName, mail, phoneNumber);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientAdded) events.get(1);

        Assertions.assertEquals("Pedro González", event.getClientName().value());
        Assertions.assertEquals("pedrog@gmail.com", event.getMail().value());
        Assertions.assertEquals("22222", event.getPhoneNumber().value());
    }

    private List<DomainEvent> history() {
        var event = new SaleCreated();
        event.setAggregateRootId("xxxxx");
        return java.util.List.of(event);
    }
}