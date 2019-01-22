package movieapp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MovieRuntime {

    private Integer hours = 0;
    private Integer minutes = 0;

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
