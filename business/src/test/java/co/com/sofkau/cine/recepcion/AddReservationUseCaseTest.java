package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.AddReservation;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.recepcion.events.ReservationAdded;
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
class AddReservationUseCaseTest {

    @InjectMocks
    private AddReservationUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addReservationSuccessfully(){
        //ARRANGE
        ReceptionId receptionId = ReceptionId.of("ddddda");
        Price price = new Price(400);
        ReservationDescription description = new ReservationDescription("Compra de asiento");
        ReservationDate date = new ReservationDate(LocalDate.of(2022,7,29));
        var command = new AddReservation(receptionId, price, description, date);

        lenient().when(repository.getEventsBy("ddddda")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var reservationAdded = (ReservationAdded) events.get(0);
        Assertions.assertEquals(400, reservationAdded.getPrice().value());
        Assertions.assertEquals("Compra de asiento", reservationAdded.getReservationDescription().value());
        Assertions.assertEquals(LocalDate.of(2022,7,29), reservationAdded.getReservationDate().value());
    }

    private List<DomainEvent> history() {
        ReceptionDescription description = new ReceptionDescription("Prueba");
        var event = new ReceptionCreated(description);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}