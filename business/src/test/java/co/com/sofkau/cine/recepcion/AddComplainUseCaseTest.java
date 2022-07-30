package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.AddComplain;
import co.com.sofkau.cine.recepcion.commands.AddReceptionist;
import co.com.sofkau.cine.recepcion.events.ComplainAdded;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.recepcion.events.ReceptionistAdded;
import co.com.sofkau.cine.recepcion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddComplainUseCaseTest {
        @InjectMocks
        private AddComplainUseCase useCase;

        @Mock
        private DomainEventRepository repository;

        @Test
        void AddComplainSuccessfully(){
            ReceptionId receptionId = ReceptionId.of("ddddd");
            ComplainDescription complainDescription = new ComplainDescription("Una porquería este cine");
            ComplainDate complainDate = new ComplainDate(LocalDate.of(2022,7,29));
            var command = new AddComplain(receptionId, complainDescription, complainDate);

            when(repository.getEventsBy("ddddd")).thenReturn(history());
            useCase.addRepository(repository);

            //ACT
            var events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor(command.getReceptionId().value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();

            //ASSERT
            var complainAdded = (ComplainAdded) events.get(0);
            Assertions.assertEquals("Una porquería este cine", complainAdded.getComplainDescription().value());
            Assertions.assertEquals(LocalDate.of(2022,7,29), complainAdded.getComplainDate().value());

    }

        private List<DomainEvent> history() {
        ReceptionDescription description = new ReceptionDescription("Prueba");
        var event = new ReceptionCreated(description);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}