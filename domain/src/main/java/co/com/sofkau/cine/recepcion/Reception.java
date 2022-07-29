package co.com.sofkau.cine.recepcion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.entities.Complain;
import co.com.sofkau.cine.recepcion.entities.Receptionist;
import co.com.sofkau.cine.recepcion.entities.Reservation;
import co.com.sofkau.cine.recepcion.events.*;
import co.com.sofkau.cine.recepcion.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Reception extends AggregateEvent<ReceptionId> {
    protected Receptionist receptionist;
    protected Set<Complain> complainSet;
    protected Set<Reservation> reservationSet;

    public Reception(ReceptionId entityId) {
        super(entityId);
    }

    public static Reception from(ReceptionId receptionId, List<DomainEvent> domainEvents) {
        Reception reception = new Reception(receptionId);
        domainEvents.forEach(reception::applyEvent);
        return reception;
    }

    //Events
    //Reservation
    public void addReservation(Price price, ReservationDescription description, ReservationDate reservationDate){
        ReservationId reservationId = new ReservationId();
        appendChange(new ReservationAdded(reservationId, price, description, reservationDate)).apply();
    }

    public void removeReservation(ReservationId reservationId){
        appendChange(new ReservationRemoved(reservationId)).apply();
    }

    public void updateReservationPrice(ReservationId reservationId, Price price){
        appendChange(new PriceUpdated(reservationId, price)).apply();
    }

    public void updateReservationDescription(ReservationId reservationId, ReservationDescription description){
        appendChange(new ReservationDescriptionUpdated(reservationId, description)).apply();
    }

    public void updateReservationDate(ReservationId reservationId, ReservationDate date){
        appendChange(new ReservationDateUpdated(reservationId, date)).apply();
    }

    //Complain
    public void addComplain(ComplainDescription description, ComplainDate date){
        ComplainId complainId = new ComplainId();
        appendChange(new ComplainAdded(complainId, description, date)).apply();
    }

    public void removeComplain(ComplainId complainId){
        appendChange(new ComplainRemoved(complainId)).apply();
    }

    public void udpateComplainDate(ComplainId complainId, ComplainDate date){
        appendChange(new ComplainDateUpdated(complainId, date)).apply();
    }

    public void updateComplainDescription(ComplainId complainId, ComplainDescription complainDescription){
        appendChange(new ComplainDescriptionUpdated(complainId, complainDescription)).apply();
    }

    //Receptionist
    public void addReceptionist(Name name, PhoneNumber phoneNumber){
        ReceptionistId receptionistId = new ReceptionistId();
        appendChange(new ReceptionistAdded(receptionistId, name, phoneNumber)).apply();
    }

    public void removeReceptionist(ReceptionistId receptionistId){
        appendChange(new ReceptionistRemoved(receptionistId)).apply();
    }

    public void updateReceptionistName(ReceptionistId receptionistId, Name name){
        appendChange(new NameUpdated(receptionistId, name)).apply();
    }

    public void updateReceptionistPhoneNumber(ReceptionistId receptionistId, PhoneNumber number){
        appendChange(new PhoneUpdated(receptionistId, number)).apply();
    }

    //findById methods
    protected Optional<Complain> findComplainById(ComplainId complainId) {
        return this.complainSet.stream().filter(client -> client.identity().equals(complainId)).findFirst();
    }

    protected Optional<Reservation> findReservationById(ReservationId reservationId) {
        return this.reservationSet.stream().filter(client -> client.identity().equals(reservationId)).findFirst();
    }

}
