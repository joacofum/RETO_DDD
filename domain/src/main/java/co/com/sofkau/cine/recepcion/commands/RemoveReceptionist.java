package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class RemoveReceptionist extends Command {
    private final ReceptionId receptionId;
    private final ReceptionistId receptionistId;

    public RemoveReceptionist(ReceptionId receptionId, ReceptionistId receptionistId) {
        this.receptionId = receptionId;
        this.receptionistId = receptionistId;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }
}
