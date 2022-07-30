package co.com.sofkau.cine.sala;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.cine.sala.commands.CreateCinemaRoom;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
import co.com.sofkau.cine.sala.values.Capacity;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateCinemaRoomUseCaseTest {
    @InjectMocks
    private CreateCinemaRoomUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateCinemaRoomUseCase();
    }

    @Test
    void createCinemaRoomSuccessfully(){
        //ARRANGE
        CinemaRoomId cinemaRoomId = CinemaRoomId.of("ddddd");
        Capacity capacity = new Capacity(20);
        var command = new CreateCinemaRoom(cinemaRoomId, capacity);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEntityId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var cinemaRoomCreated = (CinemaRoomCreated)events.get(0);
        Assertions.assertEquals(20, cinemaRoomCreated.getCapacity().value());
    }

}