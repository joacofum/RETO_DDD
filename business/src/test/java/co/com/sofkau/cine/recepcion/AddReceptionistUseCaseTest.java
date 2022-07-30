package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.AddReceptionist;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.recepcion.events.ReceptionistAdded;
import co.com.sofkau.cine.recepcion.events.ReservationAdded;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;
import co.com.sofkau.cine.recepcion.values.ReceptionDescription;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.sala.AddManagerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddReceptionistUseCaseTest {
    @InjectMocks
    private AddReceptionistUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddReceptionistSuccessfully(){
        ReceptionId receptionId = ReceptionId.of("ddddd");
        Name name = new Name("Fernando", "Gerfauo");
        PhoneNumber number = new PhoneNumber("22222");
        var command = new AddReceptionist(receptionId, name, number);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var receptionistAdded = (ReceptionistAdded) events.get(0);
        Assertions.assertEquals("Fernando Gerfauo", receptionistAdded.getName().value());
        Assertions.assertEquals("22222", receptionistAdded.getPhoneNumber().value());

    }

    private List<DomainEvent> history() {
        ReceptionDescription description = new ReceptionDescription("Prueba");
        var event = new ReceptionCreated(description);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}