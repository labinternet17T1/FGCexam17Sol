package cat.tecnocampus.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by roure on 14/11/2016.
 */
public class Journey {

    private long id;

    private Station origin;

    private Station destination;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Station getOrigin() {
        return origin;
    }

    public void setOrigin(Station origin) {
        this.origin = origin;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "id=" + id +
                ", origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
