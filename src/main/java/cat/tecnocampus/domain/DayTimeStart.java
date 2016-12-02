package cat.tecnocampus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by roure on 18/11/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayTimeStart {

    private long id;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime begin;

    private DayOfWeek dayOfWeek;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
