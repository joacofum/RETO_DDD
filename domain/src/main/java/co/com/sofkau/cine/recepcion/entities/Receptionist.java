package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class Receptionist extends Entity<ReceptionId> {
    public Receptionist(ReceptionId entityId) {
        super(entityId);
    }
}
