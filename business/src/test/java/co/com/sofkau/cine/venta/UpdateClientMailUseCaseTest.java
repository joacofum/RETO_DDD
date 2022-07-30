package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.commands.UpdateActor;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.MovieId;
import co.com.sofkau.cine.venta.commands.AddClient;
import co.com.sofkau.cine.venta.commands.UpdateMail;
import co.com.sofkau.cine.venta.events.ClientAdded;
import co.com.sofkau.cine.venta.events.MailUpdated;
import co.com.sofkau.cine.venta.events.SaleCreated;
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
class UpdateClientMailUseCaseTest {

    @InjectMocks
    private UpdateClientMailUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClientMailSuccessfully(){
        //ARRANGE
        SaleId saleId = SaleId.of("AAAA");
        ClientId clientId = ClientId.of("1");
        Mail mail = new Mail("adryanynfante@gmail.com");

        var command = new UpdateMail(saleId, clientId, mail);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSaleId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT

        var event = (MailUpdated)events.get(1);
        Assertions.assertEquals("adryanynfante@gmail.com", event.getMail().value());


    }

    private List<DomainEvent> history() {
        var event = new SaleCreated();
        event.setAggregateRootId("xxxxx");

        ClientId clientId = ClientId.of("1");
        ClientName clientName = new ClientName("Pedro", "González");
        Mail mail = new Mail("pedrog@gmail.com");
        PhoneNumber phoneNumber = new PhoneNumber("22222");
        var event2 = new ClientAdded(clientId, clientName, mail, phoneNumber);

        return List.of(event, event2);
    }
}