package co.com.sofkau.cine.sala;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.cine.sala.entities.Manager;
import co.com.sofkau.cine.sala.entities.Movie;
import co.com.sofkau.cine.sala.events.*;

import java.util.HashSet;

public class CinemaRoomChange extends EventChange {
    CinemaRoomChange(CinemaRoom cinemaRoom){
        apply((CinemaRoomCreated event) -> {
            cinemaRoom.capacity = event.getCapacity();
            cinemaRoom.moviesSet = new HashSet<>();

        });

        //Movie
        apply((MovieAdded event) -> {
            Movie movie = new Movie(event.getMovieId(), event.getMovieName(), event.getActor(), event.getMovieDuration(), event.getMovieLanguage(), event.getMovieDate());
            cinemaRoom.moviesSet.add(movie);
        });

        apply((MovieRemoved event) -> {
            cinemaRoom.moviesSet.removeIf(client -> client.identity().equals(event.getMovieId()));
        });

        apply((LanguageUpdated event) -> {
            Movie movie = cinemaRoom.findMovieById(event.getMovieId()).orElseThrow();
            movie.updateLanguage(event.getLanguage());
        });

        apply((MovieNameUpdated event) -> {
            Movie movie = cinemaRoom.findMovieById(event.getMovieId()).orElseThrow();
            movie.updateName(event.getName());
        });

        apply((MovieIsPausedToggled event) -> {
            Movie movie = cinemaRoom.findMovieById(event.getMovieId()).orElseThrow();
            movie.toggleIsPaused(event.getIsPaused());
        });

        //Manager
        apply((ManagerAdded event) -> {
            cinemaRoom.manager = new Manager(event.getMovieManagerId(), event.getManagerName(), event.getPhoneNumber());
        });

        //¿Cómo se hace?
        apply((ManagerRemoved event) -> {
            cinemaRoom.manager = null;
        });

        apply((ManagerNameUpdated event) -> {
            cinemaRoom.manager.updateName(event.getName());
        });

        apply((ManagerPhoneNumberUpdated event) -> {
            cinemaRoom.manager.updatePhoneNumber(event.getNumber());
        });

    }
}
