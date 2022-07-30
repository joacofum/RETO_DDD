package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionDescription;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class CreateReception extends Command {
    private final ReceptionId receptionId;
    private final ReceptionDescription description;

    public CreateReception(ReceptionId receptionId, ReceptionDescription description) {
        this.receptionId = receptionId;
        this.description = description;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReceptionDescription getDescription() {
        return description;
    }
}
