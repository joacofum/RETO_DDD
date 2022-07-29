package co.com.sofkau.cine.recepcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.RecepcionistId;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

public class AddReceptionist extends Command {
    private final ReceptionId receptionId;
    private final RecepcionistId recepcionistId;
    private final Name name;
    private final PhoneNumber phoneNumber;

    public AddReceptionist(ReceptionId receptionId, RecepcionistId recepcionistId, Name name, PhoneNumber phoneNumber) {
        this.receptionId = receptionId;
        this.recepcionistId = recepcionistId;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
