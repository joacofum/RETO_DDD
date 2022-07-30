package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.commands.AddManager;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
import co.com.sofkau.cine.sala.events.ManagerAdded;
import co.com.sofkau.cine.sala.values.Capacity;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddManagerUseCaseTest {

    @InjectMocks
    private AddManagerUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addManagerSuccessfully(){
        CinemaRoomId cinemaRoomId = CinemaRoomId.of("ddddd");
        ManagerName managerName = new ManagerName("Adryan", "Ynfante");
        PhoneNumber phoneNumber = new PhoneNumber("Prueba123");
        var command = new AddManager(cinemaRoomId, managerName, phoneNumber);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCinemaRoomId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ManagerAdded)events.get(0);
        Assertions.assertEquals("Adryan Ynfante", event.getManagerName().value());
        Assertions.assertEquals("Prueba123", event.getPhoneNumber().value());

    }

    private List<DomainEvent> history() {
        Capacity capacity = new Capacity(20);
        var event = new CinemaRoomCreated(capacity);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}