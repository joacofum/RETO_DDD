package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;

public class UpdatePhone extends Command {
    private final ReceptionId receptionId;
    private final RecepcionistId recepcionistId;
    private final PhoneNumber phoneNumber;

    public UpdatePhone(ReceptionId receptionId, RecepcionistId recepcionistId, PhoneNumber phoneNumber) {
        this.receptionId = receptionId;
        this.recepcionistId = recepcionistId;
        this.phoneNumber = phoneNumber;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public RecepcionistId getRecepcionistId() {
        return recepcionistId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
