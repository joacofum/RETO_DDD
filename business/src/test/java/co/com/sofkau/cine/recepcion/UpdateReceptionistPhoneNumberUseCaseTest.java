package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.UpdatePhone;
import co.com.sofkau.cine.recepcion.events.PhoneUpdated;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.recepcion.events.ReceptionistAdded;
import co.com.sofkau.cine.recepcion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateReceptionistPhoneNumberUseCaseTest {
    @InjectMocks
    private UpdateReceptionistPhoneNumberUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateReceptionistPhoneNumberSuccessfully() {
        //ARRANGE
        ReceptionId receptionId = ReceptionId.of("AAAAA");
        ReceptionistId receptionistId = ReceptionistId.of("1");
        PhoneNumber number = new PhoneNumber("22222");
        var command = new UpdatePhone(receptionId, receptionistId, number);

        when(repository.getEventsBy("AAAAA")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var complainAdded = (PhoneUpdated) events.get(0);
        Assertions.assertEquals("22222", complainAdded.getPhoneNumber().value());
    }

    private List<DomainEvent> history() {
        ReceptionDescription description = new ReceptionDescription("Prueba");
        var event1 = new ReceptionCreated(description);
        event1.setAggregateRootId("xxxx");

        ReceptionistId receptionistId = ReceptionistId.of("1");
        Name name = new Name("Pablo", "Lopez");
        PhoneNumber number = new PhoneNumber("22222");
        var event2 = new ReceptionistAdded(receptionistId, name, number);

        return List.of(event1, event2);
    }
}