package christmas.domain.date;

import java.util.List;

public enum DayOfWeek {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);
    public static List<DayOfWeek> weekendList = List.of(FRIDAY, SATURDAY);
    public static List<DayOfWeek> weekdayList = List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);

    public static DayOfWeek fromValue(int value) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getValue() == value) {
                return day;
            }
        }
        return null;
    }

    public boolean isWeekend() {
        if (weekendList.contains(this)) {
            return true;
        }
        return false;
    }

    public boolean isWeekday() {
        if (weekdayList.contains(this)) {
            return true;
        }
        return false;
    }

    int value;

    DayOfWeek(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
