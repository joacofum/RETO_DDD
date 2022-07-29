package co.com.sofkau.cine.sala;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.entities.Manager;
import co.com.sofkau.cine.sala.entities.Movie;
import co.com.sofkau.cine.sala.events.*;
import co.com.sofkau.cine.sala.values.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CinemaRoom extends AggregateEvent<CinemaRoomId> {
    protected Set<Movie> moviesSet;
    protected Manager manager;
    protected Capacity capacity;

    private CinemaRoom(CinemaRoomId entityId) {
        super(entityId);
    }

    public static CinemaRoom from(CinemaRoomId cinemaRoomId, List<DomainEvent> domainEvents) {
        CinemaRoom cinemaRoom = new CinemaRoom(cinemaRoomId);
        domainEvents.forEach(cinemaRoom::applyEvent);
        return cinemaRoom;
    }

    //Events
    //CinemaRoom events
    public void addManager(ManagerName name, PhoneNumber number){
        MovieManagerId managerId = new MovieManagerId();
        appendChange(new ManagerAdded(managerId, name, number)).apply();
    }

    public void addMovie(MovieName movieName, List<Actor> actors, MovieDuration movieDuration, MovieLanguage movieLanguage, MovieDate movieDate){
        MovieId movieId = new MovieId();
        appendChange(new MovieAdded(movieId, movieName, actors, movieDuration, movieLanguage, movieDate)).apply();
    }

    public void removeManager(MovieManagerId managerId) {
        appendChange(new ManagerRemoved(managerId)).apply();
    }

    public void removeMovie(MovieId movieId){
        appendChange(new MovieRemoved(movieId)).apply();
    }

    //Movie events.
    public void updateMovieLanguage(MovieId movieId, MovieLanguage language){
        appendChange(new LanguageUpdated(movieId, language)).apply();
    }

    public void updateMovieName(MovieId movieId, MovieName name){
        appendChange(new MovieNameUpdated(movieId, name)).apply();
    }

    //Manager events.
    public void updateManagerName(MovieManagerId movieManagerId, ManagerName name){
        appendChange(new ManagerNameUpdated(movieManagerId, name)).apply();
    }

    public void updateManagerPhoneNumber(MovieManagerId movieManagerId, PhoneNumber number){
        appendChange(new ManagerPhoneNumberUpdated(movieManagerId, number)).apply();
    }

    //findById methods
    protected Optional<Movie> findMovieById(MovieId movieId) {
        return this.moviesSet.stream().filter(client -> client.identity().equals(movieId)).findFirst();
    }

}
