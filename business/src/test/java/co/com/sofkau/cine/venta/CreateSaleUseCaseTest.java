package co.com.sofkau.cine.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.cine.venta.commands.CreateSale;
import co.com.sofkau.cine.venta.events.SaleCreated;
import co.com.sofkau.cine.venta.values.SaleId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
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
        //Assertions.assertEquals("ddddd", saleCreated.getSaleId().value());
    }
}