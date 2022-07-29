package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.ReceptionistId;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;

import java.util.Objects;

public class Receptionist extends Entity<ReceptionistId> {
    protected Name receptionistName;
    protected PhoneNumber number;
    public Receptionist(ReceptionistId entityId) {
        super(entityId);
    }

    public Receptionist(ReceptionistId entityId, Name receptionistName, PhoneNumber number) {
        super(entityId);
        this.receptionistName = receptionistName;
        this.number = number;
    }

    public void updateName(Name name){
        this.receptionistName = Objects.requireNonNull(name);
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber){
        this.number = Objects.requireNonNull(phoneNumber);
    }
}
