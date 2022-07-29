package co.com.sofkau.cine.recepcion.commands;


import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Price;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class UpdatePrice extends Command {
    private final ReceptionId receptionId;
    private final ReceptionistId receptionistId;
    private final Price price;

    public UpdatePrice(ReceptionId receptionId, ReceptionistId receptionistId, Price price) {
        this.receptionId = receptionId;
        this.receptionistId = receptionistId;
        this.price = price;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public Price getPrice() {
        return price;
    }
}
