package co.com.sofkau.cine.sala.values;

import co.com.sofka.domain.generic.Identity;

public class CinemaRoomId extends Identity {
    public CinemaRoomId() {}
    private CinemaRoomId(String id){ super(id); };
    public static CinemaRoomId of(String id) {
        return new CinemaRoomId(id);
    }
}
