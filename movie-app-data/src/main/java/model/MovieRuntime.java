package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieRuntime {

    private Integer hours = 0;
    private Integer minutes = 0;


    public MovieRuntime(Integer hours, Integer minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Integer toMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public String toHoursAndMinutesFormat() {
        return this.hours.toString() + "hours " + this.minutes.toString() + "minutes";
    }

    @Override
    public String toString() {
        return "MovieRuntime{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
