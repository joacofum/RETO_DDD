package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class UpdateName extends Command {
    private final ReceptionId receptionId;
    private final RecepcionistId recepcionistId;
    private final Name name;

    public UpdateName(ReceptionId receptionId, RecepcionistId recepcionistId, Name name) {
        this.receptionId = receptionId;
        this.recepcionistId = recepcionistId;
        this.name = name;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public Name getName() {
        return name;
    }
}
