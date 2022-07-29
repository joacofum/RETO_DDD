package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class UpdateName extends Command {
    private final ReceptionId receptionId;
    private final ReceptionistId receptionistId;
    private final Name name;

    public UpdateName(ReceptionId receptionId, ReceptionistId receptionistId, Name name) {
        this.receptionId = receptionId;
        this.receptionistId = receptionistId;
        this.name = name;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public Name getName() {
        return name;
    }
}
