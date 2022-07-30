package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ComplainDate;
import co.com.sofkau.cine.recepcion.values.ComplainDescription;
import co.com.sofkau.cine.recepcion.values.ComplainId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class AddComplain extends Command {
    private final ReceptionId receptionId;
    private final ComplainDescription complainDescription;
    private final ComplainDate complainDate;

    public AddComplain(ReceptionId receptionId, ComplainDescription complainDescription, ComplainDate complainDate) {
        this.receptionId = receptionId;
        this.complainDescription = complainDescription;
        this.complainDate = complainDate;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ComplainDescription getComplainDescription() {
        return complainDescription;
    }

    public ComplainDate getComplainDate() {
        return complainDate;
    }
}
