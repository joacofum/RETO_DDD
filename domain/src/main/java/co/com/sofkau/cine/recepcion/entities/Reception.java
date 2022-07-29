package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.ReceptionId;

public class Reception extends Entity<ReceptionId> {
    public Reception(ReceptionId entityId) {
        super(entityId);
    }
}
