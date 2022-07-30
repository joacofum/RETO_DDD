package co.com.sofkau.cine.sala.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.MovieManagerId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

import java.util.Objects;

public class Manager extends Entity<MovieManagerId> {
    protected ManagerName managerName;
    protected PhoneNumber phoneNumber;

    public Manager(MovieManagerId entityId) {
        super(entityId);
    }

    public Manager(MovieManagerId entityId, ManagerName name, PhoneNumber number){
        super(entityId);
        this.managerName = name;
        this.phoneNumber = number;
    }

    public void updatePhoneNumber(PhoneNumber number){
        this.phoneNumber = Objects.requireNonNull(number);
    }

    public void updateName(ManagerName name){
        this.managerName = Objects.requireNonNull(name);
    }

    public ManagerName getManagerName() {
        return managerName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }



}
