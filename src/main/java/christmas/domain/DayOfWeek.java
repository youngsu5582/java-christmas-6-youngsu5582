package christmas.domain;

import christmas.exception.DayOfWeekException;
import christmas.exception.message.DayOfWeekExceptionMessage;

public enum DayOfWeek {
    MONDAY(0),
    TUSEDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    public static DayOfWeek fromValue(int value) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getValue() == value) {
                return day;
            }
        }
        throw new DayOfWeekException(DayOfWeekExceptionMessage.INVALID_VALUE);
    }

    int value;

    DayOfWeek(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
