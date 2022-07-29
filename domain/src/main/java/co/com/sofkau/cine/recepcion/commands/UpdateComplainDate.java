package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ComplainDate;
import co.com.sofkau.cine.recepcion.values.ComplainId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class UpdateComplainDate extends Command {
    private final ReceptionId receptionId;
    private final ComplainId complainId;
    private final ComplainDate complainDate;

    public UpdateComplainDate(ReceptionId receptionId, ComplainId complainId, ComplainDate complainDate) {
        this.receptionId = receptionId;
        this.complainId = complainId;
        this.complainDate = complainDate;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ComplainId getComplainId() {
        return complainId;
    }

    public ComplainDate getComplainDate() {
        return complainDate;
    }
}
