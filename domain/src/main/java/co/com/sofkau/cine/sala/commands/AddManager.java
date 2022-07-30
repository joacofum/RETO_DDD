package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.MovieManagerId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

public class AddManager extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final ManagerName managerName;
    private final PhoneNumber phoneNumber;
    public AddManager(CinemaRoomId cinemaRoomId, ManagerName managerName, PhoneNumber phoneNumber) {
        this.cinemaRoomId = cinemaRoomId;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
    }
    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }
    public ManagerName getManagerName() {
        return managerName;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

}
