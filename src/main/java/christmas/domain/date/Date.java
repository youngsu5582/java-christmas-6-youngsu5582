package christmas.domain.date;

import christmas.exception.DateException;
import christmas.exception.message.DateExceptionMessage;
import christmas.util.Calendar;

import static christmas.constant.DateConstant.START_DAY;
import static christmas.constant.DateConstant.END_DAY;

public record Date(int day, DayOfWeek dayOfWeek) {
    public static Date of(int day) {
        validate(day);

        DayOfWeek dayOfWeek = getDayOfWeek(day);
        return new Date(day, dayOfWeek);
    }

    private static void validate(int day) {
        validateDayRange(day);
    }

    private static void validateDayRange(int day) {
        if (day < START_DAY || day > END_DAY) {
            throw new DateException(DateExceptionMessage.INVALID_DAY);
        }
    }

    private static DayOfWeek getDayOfWeek(int day) {
        return Calendar.calculateDayOfWeek(day);
    }

}
