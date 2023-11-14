package christmas.domain;

import christmas.domain.date.DayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class DayOfWeekTest {
    @Test
    @DisplayName("해당 값을 넣으면 값에 받는 요일을 받는다.")
    void determineDayOfWeekFromValue() {
        int mondayValue = 0;
        DayOfWeek dayOfWeek = DayOfWeek.fromValue(mondayValue);
        Assertions.assertEquals(DayOfWeek.MONDAY, dayOfWeek);
    }

    @ParameterizedTest
    @DisplayName("금요일과 토요일은 주말이다.")
    @EnumSource(value = DayOfWeek.class, names = {"FRIDAY", "SATURDAY"})
    void fridayAndSaturdayIsWeekend(DayOfWeek weekendDay) {
        Assertions.assertTrue(weekendDay.isWeekend());
    }

    @ParameterizedTest
    @DisplayName("월요일, 화요일, 수요일, 일요일은 평일이다.")
    @EnumSource(value = DayOfWeek.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "SUNDAY"})
    void mondayTuesdayWednesdayAndSundayIsWeekday(DayOfWeek weekday) {
        Assertions.assertTrue(weekday.isWeekday());
    }
}

