package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;

public class UpdatePhone extends Command {
    private final ReceptionId receptionId;
    private final ReceptionistId receptionistId;
    private final PhoneNumber phoneNumber;

    public UpdatePhone(ReceptionId receptionId, ReceptionistId receptionistId, PhoneNumber phoneNumber) {
        this.receptionId = receptionId;
        this.receptionistId = receptionistId;
        this.phoneNumber = phoneNumber;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public ReceptionistId getRecepcionistId() {
        return receptionistId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
