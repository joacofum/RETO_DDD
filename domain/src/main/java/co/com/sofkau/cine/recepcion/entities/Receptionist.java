package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.Name;
import co.com.sofkau.cine.recepcion.values.ReceptionId;
import co.com.sofkau.cine.recepcion.values.PhoneNumber;

import java.util.Objects;

public class Receptionist extends Entity<ReceptionId> {
    protected Name receptionistName;
    protected PhoneNumber number;
    public Receptionist(ReceptionId entityId) {
        super(entityId);
    }

    public Receptionist(ReceptionId entityId, Name receptionistName, PhoneNumber number) {
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
