package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ComplainId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class RemoveComplain extends Command {
    private final ReceptionId receptionId;
    private final ComplainId complainId;

    public RemoveComplain(ReceptionId receptionId, ComplainId complainId) {
        this.receptionId = receptionId;
        this.complainId = complainId;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ComplainId getComplainId() {
        return complainId;
    }
}
