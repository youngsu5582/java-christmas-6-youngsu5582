package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.date.DayOfWeek;

public class CalendarTest {
    @Test
    @DisplayName("첫날이 금요일이면 7일은 목요일이다.")
    void isDayOfWeekIsThursdayWhenFirstDateIsFriday() {
        DayOfWeek dayOfWeek = Calendar.calculateDayOfWeek(7);
        Assertions.assertEquals(DayOfWeek.THURSDAY, dayOfWeek);
    }

    @Test
    @DisplayName("첫날이 금요일이면 22일은 월요일이다.")
    void isDayOfWeekIsMondayWhenFirstDateIsMonday() {
        DayOfWeek dayOfWeek = Calendar.calculateDayOfWeek(22);
        Assertions.assertEquals(DayOfWeek.FRIDAY, dayOfWeek);
    }

}
