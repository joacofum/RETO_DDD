package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class CreateReception extends Command {
    private final ReceptionId receptionId;

    public CreateReception(ReceptionId receptionId) {
        this.receptionId = receptionId;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }
}
