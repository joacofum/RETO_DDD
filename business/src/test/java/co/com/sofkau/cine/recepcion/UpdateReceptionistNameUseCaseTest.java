package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.UpdateName;
import co.com.sofkau.cine.recepcion.events.*;
import co.com.sofkau.cine.recepcion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateReceptionistNameUseCaseTest {
    @InjectMocks
    private UpdateReceptionistNameUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateReceptionistNameSuccessfully() {
        ReceptionId receptionId = ReceptionId.of("AAAAA");
        ReceptionistId receptionistId = ReceptionistId.of("1");
        Name name = new Name("Pablo", "Lopez");
        var command = new UpdateName(receptionId, receptionistId, name);

        when(repository.getEventsBy("AAAAA")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var complainAdded = (NameUpdated) events.get(0);
        Assertions.assertEquals("Pablo Lopez", complainAdded.getName().value());
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