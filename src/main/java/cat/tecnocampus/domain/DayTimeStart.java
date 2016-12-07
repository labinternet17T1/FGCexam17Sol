package cat.tecnocampus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by roure on 18/11/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayTimeStart {

    private long id;

    @JsonFormat(pattern = "HH:mm")
    private String begin;

    private String dayOfWeek;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
