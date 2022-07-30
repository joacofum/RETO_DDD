package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.UpdateComplainDate;
import co.com.sofkau.cine.recepcion.events.ComplainAdded;
import co.com.sofkau.cine.recepcion.events.ComplainDateUpdated;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
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
class UpdateComplainDateUseCaseTest {
    @InjectMocks
    private UpdateComplainDateUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateComplainDateSuccessfully() {
        ReceptionId receptionId = ReceptionId.of("AAAAA");
        ComplainId complainId = ComplainId.of("1");
        ComplainDate complainDate = new ComplainDate(LocalDate.of(2022,7,30));
        var command = new UpdateComplainDate(receptionId, complainId, complainDate);

        when(repository.getEventsBy("AAAAA")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var complainAdded = (ComplainDateUpdated) events.get(0);
        Assertions.assertEquals(LocalDate.of(2022,7,30), complainAdded.getComplainDate().value());

    }

    private List<DomainEvent> history() {
        ReceptionDescription description = new ReceptionDescription("Prueba");
        var event1 = new ReceptionCreated(description);
        event1.setAggregateRootId("xxxx");

        ComplainId complainId = ComplainId.of("1");
        ComplainDescription complainDescription = new ComplainDescription("Una porquería este cine");
        ComplainDate complainDate = new ComplainDate(LocalDate.of(2022,7,29));
        var event2 = new ComplainAdded(complainId, complainDescription, complainDate);

        return List.of(event1, event2);
    }
}