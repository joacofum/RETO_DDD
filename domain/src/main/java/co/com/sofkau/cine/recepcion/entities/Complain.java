package co.com.sofkau.cine.recepcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.recepcion.values.ComplainDate;
import co.com.sofkau.cine.recepcion.values.ComplainDescription;
import co.com.sofkau.cine.recepcion.values.ComplainId;

import java.util.Objects;

public class Complain extends Entity<ComplainId> {
    protected ComplainDescription description;
    protected ComplainDate date;

    public Complain(ComplainId entityId) {
        super(entityId);
    }

    public Complain(ComplainId entityId, ComplainDescription description, ComplainDate date) {
        super(entityId);
        this.description = description;
        this.date = date;
    }

    public void updateDescription(ComplainDescription description){
        this.description = Objects.requireNonNull(description);
    }

    public void updateDate(ComplainDate date){
        this.date = Objects.requireNonNull(date);
    }
}
