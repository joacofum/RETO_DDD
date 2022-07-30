package co.com.sofkau.cine.recepcion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.cine.recepcion.commands.CreateReception;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.recepcion.values.ReceptionDescription;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateReceptionUseCaseTest {
    @InjectMocks
    private CreateReceptionUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateReceptionUseCase();
    }

    @Test
    void createReceptionUseCase(){
        //ARRANGE
        ReceptionId receptionId = ReceptionId.of("ddddd");
        ReceptionDescription description = new ReceptionDescription("Descripcion de prueba");
        var command = new CreateReception(receptionId, description);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getReceptionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var receptionCreated = (ReceptionCreated)events.get(0);
        Assertions.assertEquals("Descripcion de prueba", receptionCreated.getReceptionDescription().value());
    }

}