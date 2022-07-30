package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
import co.com.sofkau.cine.sala.events.NotifyMovieCreated;
import co.com.sofkau.cine.sala.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyCinemaRoomCreatedUseCaseTest {
    @InjectMocks
    private NotifyCinemaRoomCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase() {
        Capacity capacity = new Capacity(20);
        var event = new CinemaRoomCreated(capacity);
        event.setAggregateRootId("AAAA");

        when(repository.getEventsBy("AAAA")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var movie = (NotifyMovieCreated) events.get(0);

        assertEquals("Empezó la película", movie.getNotify());

    }

}