package movieapp.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomDate extends BaseEntity {

    private Integer year = -1;
    private Integer month = -1;
    private String monthString = "not set";
    private Integer day = -1;

    public CustomDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
        setMonthNameAndNumber();
    }

    public CustomDate(Integer year, String monthString, Integer day) {
        this.year = year;
        this.monthString = monthString;
        this.day = day;
    }

    @Override
    public String toString() {
        return "CustomDate{"
                + year + "  "
                + monthString + "  "
                + day +
                '}';
    }

    private void setMonthNameAndNumber() {
        if (month != -1) {
            switch (month) {
                case 1:
                    monthString = "January";
                    break;
                case 2:
                    monthString = "February";
                    break;
                case 3:
                    monthString = "March";
                    break;
                case 4:
                    monthString = "April";
                    break;
                case 5:
                    monthString = "May";
                    break;
                case 6:
                    monthString = "June";
                    break;
                case 7:
                    monthString = "July";
                    break;
                case 8:
                    monthString = "August";
                    break;
                case 9:
                    monthString = "September";
                    break;
                case 10:
                    monthString = "October";
                    break;
                case 11:
                    monthString = "November";
                    break;
                case 12:
                    monthString = "December";
                    break;
                default:
                    monthString = "not set";
                    break;
            }
        }
        if (monthString != "not set") {
            switch (monthString) {
                case "January":
                    month = 1;
                    break;
                case "February":
                    month = 2;
                    break;
                case "March":
                    month = 3;
                    break;
                case "April":
                    month = 4;
                    break;
                case "May":
                    month = 5;
                    break;
                case "June":
                    month = 6;
                    break;
                case "July":
                    month = 7;
                    break;
                case "August":
                    month = 8;
                    break;
                case "September":
                    month = 9;
                    break;
                case "October":
                    month = 10;
                    break;
                case "November":
                    month = 11;
                    break;
                case "December":
                    month = 12;
                    break;
                default:
                    month = -1;
                    break;
            }
        }
    }
}
