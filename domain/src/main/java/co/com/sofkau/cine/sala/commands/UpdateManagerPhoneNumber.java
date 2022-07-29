package co.com.sofkau.cine.sala.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.cine.sala.values.CinemaRoomId;
import co.com.sofkau.cine.sala.values.ManagerName;
import co.com.sofkau.cine.sala.values.MovieManagerId;
import co.com.sofkau.cine.sala.values.PhoneNumber;

public class UpdateManagerPhoneNumber extends Command {
    private final CinemaRoomId cinemaRoomId;
    private final MovieManagerId movieManagerId;
    private final PhoneNumber phoneNumber;

    public UpdateManagerPhoneNumber(CinemaRoomId cinemaRoomId, MovieManagerId movieManagerId, PhoneNumber phoneNumber) {
        this.cinemaRoomId = cinemaRoomId;
        this.movieManagerId = movieManagerId;
        this.phoneNumber = phoneNumber;
    }

    public CinemaRoomId getCinemaRoomId() {
        return cinemaRoomId;
    }

    public MovieManagerId getMovieManagerId() {
        return movieManagerId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
