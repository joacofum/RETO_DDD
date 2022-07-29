package co.com.sofkau.cine.recepcion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.cine.recepcion.entities.Complain;
import co.com.sofkau.cine.recepcion.entities.Receptionist;
import co.com.sofkau.cine.recepcion.entities.Reservation;
import co.com.sofkau.cine.recepcion.events.*;

import java.util.HashSet;

public class ReceptionChange extends EventChange{
    ReceptionChange(Reception reception) {
        apply((ReceptionCreated event) -> {
            reception.complainSet = new HashSet<>();
            reception.reservationSet = new HashSet<>();
        });

        //Reservation
        apply((ReservationAdded event) -> {
            Reservation reservation = new Reservation(event.getReservationId(), event.getPrice(), event.getReservationDescription(), event.getReservationDate());
            reception.reservationSet.add(reservation);
        });

        apply((ReservationRemoved event) -> {
            reception.reservationSet.removeIf(client -> client.identity().equals(event.getReservationId()));
        });

        apply((ReservationDescriptionUpdated event) -> {
            Reservation reservation = reception.findReservationById(event.getReservationId()).orElseThrow();
            reservation.updateDescription(event.getReservationDescription());
        });

        apply((ReservationDateUpdated event) -> {
            Reservation reservation = reception.findReservationById(event.getReservationId()).orElseThrow();
            reservation.updateDate(event.getReservationDate());
        });

        //Complain
        apply((ComplainAdded event) -> {
            Complain complain = new Complain(event.getComplainId(), event.getComplainDescription(), event.getComplainDate());
            reception.complainSet.add(complain);
        });

        apply((ComplainRemoved event) -> {
            reception.complainSet.removeIf(client -> client.identity().equals(event.getComplainId()));
        });

        apply((ComplainDescriptionUpdated event) -> {
            Complain complain = reception.findComplainById(event.getComplainId()).orElseThrow();
            complain.updateDescription(event.getComplainDescription());
        });

        apply((ComplainDateUpdated event) -> {
            Complain complain = reception.findComplainById(event.getComplainId()).orElseThrow();
            complain.updateDate(event.getComplainDate());
        });

        //Receptionist
        apply((ReceptionistAdded event) -> {
            reception.receptionist = new Receptionist(event.getRecepcionistId(), event.getName(), event.getPhoneNumber());
        });

        apply((ReceptionistRemoved event) -> {
            reception.receptionist = null;
        });

        apply((NameUpdated event) -> {
            reception.receptionist.updateName(event.getName());
        });

        apply((PhoneUpdated event) -> {
            reception.receptionist.updatePhoneNumber(event.getPhoneNumber());
        });
    }
}
