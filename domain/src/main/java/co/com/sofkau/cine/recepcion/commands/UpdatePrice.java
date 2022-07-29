package co.com.sofkau.cine.recepcion.commands;


import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class UpdatePrice extends Command {
    private final ReceptionId receptionId;
    private final RecepcionistId recepcionistId;
    private final Price price;

    public UpdatePrice(ReceptionId receptionId, RecepcionistId recepcionistId, Price price) {
        this.receptionId = receptionId;
        this.recepcionistId = recepcionistId;
        this.price = price;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public Price getPrice() {
        return price;
    }
}
