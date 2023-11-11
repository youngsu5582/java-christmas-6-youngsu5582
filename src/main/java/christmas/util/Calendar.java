package christmas.util;


import christmas.domain.DayOfWeek;

public class Calendar {
    private static DayOfWeek startDate = DayOfWeek.FRIDAY;

    public static DayOfWeek calculateDayOfWeek(int day) {
        int weekValue = (startDate.getValue() + day - 1) % 7;
        return DayOfWeek.fromValue(weekValue);
    }

    public static void setStartDate(DayOfWeek dayOfWeek) {
        Calendar.startDate = dayOfWeek;
    }
}