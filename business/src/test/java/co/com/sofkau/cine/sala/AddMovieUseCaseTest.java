package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.commands.AddMovie;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
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
class AddMovieUseCaseTest {

    @InjectMocks
    private AddMovieUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addMovieSuccessfully(){
        CinemaRoomId cinemaRoomId = CinemaRoomId.of("ddddd");
        MovieName movieName = new MovieName("Pocahontas");
        Actor actor = new Actor("Robin", "Hood");
        MovieDuration movieDuration = new MovieDuration(LocalTime.of(2,30,12));
        MovieLanguage movieLanguage = new MovieLanguage("Inglés");
        MovieDate movieDate = new MovieDate(LocalDate.of(2022,7,29));
        var command = new AddMovie(cinemaRoomId, movieName, actor, movieDuration, movieLanguage, movieDate);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCinemaRoomId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MovieAdded)events.get(0);
        Assertions.assertEquals("Pocahontas", event.getMovieName().value());
        Assertions.assertEquals("Robin Hood", event.getActor().value());
        Assertions.assertEquals(LocalTime.of(2,30,12).toString(), event.getMovieDuration().value().toString());
        Assertions.assertEquals("Inglés", event.getMovieLanguage().value());
        Assertions.assertEquals(LocalDate.of(2022,7,29).toString(), event.getMovieDate().value().toString());
    }

    private List<DomainEvent> history() {
        Capacity capacity = new Capacity(20);
        var event = new CinemaRoomCreated(capacity);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}