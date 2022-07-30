package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.commands.UpdateReservationDescription;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.recepcion.events.ReservationAdded;
import co.com.sofkau.cine.recepcion.events.ReservationDateUpdated;
import co.com.sofkau.cine.recepcion.events.ReservationDescriptionUpdated;
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
class UpdateReservationDescriptionUseCaseTest {
    @InjectMocks
    private UpdateReservationDescriptionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateReservationDescriptionSuccessfully() {
        ReceptionId receptionId = ReceptionId.of("AAAAA");
        ReservationId reservationId = ReservationId.of("1");
        ReservationDescription reservationDescription = new ReservationDescription("Compra de asiento");
        var command = new UpdateReservationDescription(receptionId, reservationId, reservationDescription);

        when(repository.getEventsBy("AAAAA")).thenReturn(history());
        useCase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var complainAdded = (ReservationDescriptionUpdated) events.get(0);
        Assertions.assertEquals("Compra de asiento", complainAdded.getReservationDescription().value());

    }

    private List<DomainEvent> history() {
        ReceptionDescription description = new ReceptionDescription("Prueba");
        var event1 = new ReceptionCreated(description);
        event1.setAggregateRootId("AAAAA");

        ReservationId reservationId = ReservationId.of("1");
        Price price = new Price(400);
        ReservationDescription reservationDescription = new ReservationDescription("Compra de asiento");
        ReservationDate date = new ReservationDate(LocalDate.of(2022,7,29));
        var event2 = new ReservationAdded(reservationId, price, reservationDescription, date);

        return List.of(event1, event2);
    }
}