package christmas.util;


import christmas.domain.date.DayOfWeek;

public class Calendar {
    private final static DayOfWeek startDate = DayOfWeek.FRIDAY;

    public static DayOfWeek calculateDayOfWeek(int day) {
        int weekValue = (startDate.getValue() + day - 1) % 7;
        return DayOfWeek.fromValue(weekValue);
    }
}