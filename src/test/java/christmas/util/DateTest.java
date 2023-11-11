package christmas.util;

import christmas.domain.Date;
import christmas.exception.DateException;
import christmas.exception.message.DateExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static christmas.constant.DateConstant.START_DAY;
import static christmas.constant.DateConstant.END_DAY;

public class DateTest {
    @Test
    @DisplayName("날짜를 입력하여 Date 를 만든다.")
    void createDateWithDay(){
        int day = 13;
        Date date = Date.of(day);
        Assertions.assertEquals(date.getClass(),Date.class);
        Assertions.assertEquals(date.day(),day);
    }
    @ParameterizedTest
    @DisplayName("범위 밖에 있는 날짜를 입력하면 예외를 발생한다.")
    @ValueSource(ints = {START_DAY-1,END_DAY+1})
    void throwExceptionWhenDayIsOutRange(int invalidDay){
        assertThatThrownBy(()-> Date.of(invalidDay))
                .isInstanceOf(DateException.class)
                .hasMessageContaining(DateExceptionMessage.INVALID_DAY.getMessage());
    }
}
