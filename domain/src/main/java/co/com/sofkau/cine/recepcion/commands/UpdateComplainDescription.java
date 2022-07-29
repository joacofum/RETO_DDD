package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ComplainDate;
import co.com.sofkau.cine.recepcion.values.ComplainDescription;
import co.com.sofkau.cine.recepcion.values.ComplainId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class UpdateComplainDescription extends Command {
    private final ReceptionId receptionId;
    private final ComplainId complainId;
    private final ComplainDescription complainDescription;

    public UpdateComplainDescription(ReceptionId receptionId, ComplainId complainId, ComplainDescription complainDescription) {
        this.receptionId = receptionId;
        this.complainId = complainId;
        this.complainDescription = complainDescription;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ComplainId getComplainId() {
        return complainId;
    }

    public ComplainDescription getComplainDescription() {
        return complainDescription;
    }
}
