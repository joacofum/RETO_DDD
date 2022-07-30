package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.cine.sala.CreateCinemaRoomUseCase;
import co.com.sofkau.cine.sala.commands.CreateCinemaRoom;
import co.com.sofkau.cine.sala.events.CinemaRoomCreated;
import co.com.sofkau.cine.sala.values.Capacity;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.venta.commands.CreateSale;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class CreateSaleUseCaseTest {
    @InjectMocks
    private CreateSaleUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CreateSaleUseCase();
    }

    @Test
    void CreateSale() {
        //ARRANGE
        SaleId saleId = SaleId.of("ddddd");
        var command = new CreateSale(saleId);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEntityId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var saleCreated = (SaleCreated) events.get(0);
        Assertions.assertEquals("ddddd", saleCreated.getSaleId().value());
    }
}