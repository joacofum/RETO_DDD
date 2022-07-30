package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.commands.UpdateActor;
import co.com.sofkau.cine.sala.commands.UpdateLanguage;
import co.com.sofkau.cine.sala.events.ActorUpdated;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
import co.com.sofkau.cine.sala.events.LanguageUpdated;
import co.com.sofkau.cine.sala.events.MovieAdded;
import co.com.sofkau.cine.sala.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateMovieLanguageUseCaseTest {
    @InjectMocks
    private UpdateMovieLanguageUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void updateMovieLanguageSuccessfully(){
        CinemaRoomId cinemaRoomId = CinemaRoomId.of("AAAA");
        MovieId movieId = MovieId.of("1");
        MovieLanguage movieLanguage = new MovieLanguage("Español");

        var command = new UpdateLanguage(cinemaRoomId, movieId, movieLanguage);

        when(repository.getEventsBy("AAAA")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCinemaRoomId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //Assert
        var event = (LanguageUpdated)events.get(0);
        Assertions.assertEquals("Español", event.getLanguage().value());

    }

    private List<DomainEvent> history() {
        Capacity capacity = new Capacity(20);
        var event1 = new CinemaRoomCreated(capacity);
        event1.setAggregateRootId("AAAA");

        MovieId movieId = MovieId.of("1");
        MovieName movieName = new MovieName("Pocahontas");
        Actor actor = new Actor("Robin", "Hood");
        MovieDuration movieDuration = new MovieDuration(LocalTime.of(2,30,12));
        MovieLanguage movieLanguage = new MovieLanguage("Inglés");
        MovieDate movieDate = new MovieDate(LocalDate.of(2022,7,29));
        var event2 = new MovieAdded(movieId, movieName, actor, movieDuration, movieLanguage, movieDate);

        return List.of(event1, event2);
    }
}