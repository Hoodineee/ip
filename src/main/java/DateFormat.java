import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class DateFormat {
    protected String date;
    protected LocalDate dateFormatted;
    protected String afterBy;
    protected LocalTime timeFormatted;
    protected String stringDate;
    protected String stringTime;
    protected LocalDateTime dateAndTime;

    public DateFormat(String date) {
        this.afterBy = date;
        this.date = date;
        this.dateFormatted = null;
        this.timeFormatted = null;

        String day;
        String month;
        String year;
        String hour;
        String minutes;
        String time;

        if (this.afterBy.contains("/")) {
            if (this.afterBy.indexOf("/") < 3) {
                int afterDaySlashIndex = afterBy.indexOf("/");
                String afterDay;
                if (afterDaySlashIndex == 1) {
                    day = "0" + afterBy.substring(0, 1);
                    afterDay = afterBy.substring(afterDaySlashIndex + 1);
                } else {
                    day = afterBy.substring(0, 2);
                    afterDay = afterBy.substring(afterDaySlashIndex + 2);
                }
                int afterMonthSlashIndex = afterDay.indexOf("/");
                String afterMonth;
                if (afterMonthSlashIndex == 1) {
                    month = "0" + afterDay.substring(0, 1);
                    afterMonth = afterDay.substring(afterMonthSlashIndex + 1);
                } else {
                    month = afterDay.substring(0, 2);
                    afterMonth = afterDay.substring(afterMonthSlashIndex + 2);
                }
                year = afterMonth.substring(0, 4);
                time = afterMonth.substring(5);
            } else {
                year = afterBy.substring(0, 4);
                int afterYearSlashIndex = afterBy.indexOf("/");
                String afterYear = afterBy.substring(afterYearSlashIndex + 1);
                ;
                int afterMonthSlashIndex = afterYear.indexOf("/");
                String afterMonth;
                if (afterMonthSlashIndex == 1) {
                    month = "0" + afterYear.substring(0, 1);
                    afterMonth = afterYear.substring(afterMonthSlashIndex + 1);
                } else {
                    month = afterYear.substring(0, 2);
                    afterMonth = afterYear.substring(afterMonthSlashIndex + 2);
                }
                String afterDay;
                if (afterMonth.charAt(1) == ' ') {
                    day = "0" + afterMonth.substring(0, 1);
                    afterDay = afterMonth.substring(afterMonthSlashIndex + 1);
                } else {
                    day = afterMonth.substring(0, 2);
                    afterDay = afterMonth.substring(afterMonthSlashIndex + 2);
                }
                time = afterDay;
            }
        } else {
            if (this.afterBy.indexOf("-") < 3) {
                int afterDayDashIndex = afterBy.indexOf("-");
                String afterDay;
                if (afterDayDashIndex == 1) {
                    day = "0" + afterBy.substring(0, 1);
                    afterDay = afterBy.substring(afterDayDashIndex + 1);
                } else {
                    day = afterBy.substring(0, 2);
                    afterDay = afterBy.substring(afterDayDashIndex + 2);
                }
                int afterMonthDashIndex = afterDay.indexOf("-");
                String afterMonth;
                if (afterMonthDashIndex == 1) {
                    month = "0" + afterDay.substring(0, 1);
                    afterMonth = afterDay.substring(afterMonthDashIndex + 1);
                } else {
                    month = afterDay.substring(0, 2);
                    afterMonth = afterDay.substring(afterMonthDashIndex + 2);
                }
                year = afterMonth.substring(0, 4);
                time = afterMonth.substring(5);
            } else {
                year = afterBy.substring(0, 4);
                int afterYearDashIndex = afterBy.indexOf("-");
                String afterYear = afterBy.substring(afterYearDashIndex + 1);
                ;
                int afterMonthDashIndex = afterYear.indexOf("-");
                String afterMonth;
                if (afterMonthDashIndex == 1) {
                    month = "0" + afterYear.substring(0, 1);
                    afterMonth = afterYear.substring(afterMonthDashIndex + 1);
                } else {
                    month = afterYear.substring(0, 2);
                    afterMonth = afterYear.substring(afterMonthDashIndex + 2);
                }
                String afterDay;
                if (afterMonth.charAt(1) == ' ') {
                    day = "0" + afterMonth.substring(0, 1);
                    afterDay = afterMonth.substring(afterMonthDashIndex + 1);
                } else {
                    day = afterMonth.substring(0, 2);
                    afterDay = afterMonth.substring(afterMonthDashIndex + 2);
                }
                time = afterDay;
                System.out.println(time);
            }
        }
            this.stringDate = year + "-" + month + "-" + day;
            this.dateFormatted = LocalDate.parse(year + "-" + month + "-" + day);
            if (date.length() > 10) {
                if (time.length() <= 3) {
                    hour = "0" + time.substring(0, 1);
                    System.out.println(hour);
                    minutes = time.substring(1, 3);
                } else {
                    hour = time.substring(0, 2);
                    minutes = time.substring(2, 4);
                }
                this.stringTime = hour + ":" + minutes + ":00";
                this.timeFormatted = LocalTime.parse(hour + ":" + minutes + ":" + "00");
            }

        if (this.timeFormatted != null) {
            this.dateAndTime = LocalDateTime.parse(this.stringDate + "T" + this.stringTime);
        }
    }

    public String formatDate(String pattern) {
            return this.dateFormatted.format(DateTimeFormatter.ofPattern(pattern));
    }

    public String formatTime() {
        return this.timeFormatted.format(DateTimeFormatter.ISO_TIME);
    }

    public String toString() {
        if (this.timeFormatted == null) {
            return this.formatDate("MMM d yyyy");
        } else {
            return this.formatDate("MMM d yyyy") + " " + this.formatTime();
        }
    }

    public static void main(String args[]) {
        DateFormat d4 = new DateFormat("2/2/2021 1800");
        System.out.println(d4.formatDate("MMM d yyyy"));
        System.out.println(d4.formatTime());
    }
}

