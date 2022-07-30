package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.commands.UpdateManagerPhoneNumber;
import co.com.sofkau.cine.sala.events.*;
import co.com.sofkau.cine.sala.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateManagerPhoneUseCaseTest {
    @InjectMocks
    private UpdateManagerPhoneUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateManagerPhoneSuccessfully(){
        CinemaRoomId cinemaRoomId = CinemaRoomId.of("AAAA");
        MovieManagerId movieManagerId = MovieManagerId.of("1");
        PhoneNumber phoneNumber = new PhoneNumber("4013321");
        var command = new UpdateManagerPhoneNumber(cinemaRoomId, movieManagerId, phoneNumber);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCinemaRoomId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (ManagerPhoneNumberUpdated)events.get(0);
        Assertions.assertEquals("4013321", event.getNumber().value());
    }

    private List<DomainEvent> history() {
        Capacity capacity = new Capacity(20);
        var event1 = new CinemaRoomCreated(capacity);
        event1.setAggregateRootId("AAAA");

        MovieManagerId movieManagerId = MovieManagerId.of("1");
        ManagerName managerName = new ManagerName("Carlitos", "Duarte");
        PhoneNumber phoneNumber = new PhoneNumber("3819234");
        var event2 = new ManagerAdded(movieManagerId, managerName, phoneNumber);
        return List.of(event1, event2);
    }

}