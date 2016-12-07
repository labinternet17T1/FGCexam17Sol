package cat.tecnocampus.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by roure on 14/11/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteJourney {

    private long id;

    private List<DayTimeStart> startList;

    private Journey journey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DayTimeStart> getStartList() {
        return startList;
    }

    public void setStartList(List<DayTimeStart> startList) {
        this.startList = startList;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public String toString() {
        return "FavoriteJourney{" +
                "id=" + id +
                //", startList=" + startList +
                ", journey=" + journey +
                '}';
    }
}
