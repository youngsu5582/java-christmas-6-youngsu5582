package christmas.util;

import christmas.exception.ParserException;
import christmas.exception.message.ParserExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @Test
    @DisplayName("숫자 문자열을 입력하면 숫자로 변환한다.")
    void parseStringToNumber() {
        int expectedResult = 5;
        String numberInput = "5";
        Assertions.assertEquals(expectedResult, Parser.parseInfoToNumber(numberInput));
    }

    @DisplayName("숫자가 아닌 문자열을 입력하면 예외를 발생한다.")
    @ValueSource(strings = {"31일", "12-26", "31."})
    @ParameterizedTest
    void throwExceptionWhenInputNonNumber(String invalidInput) {
        assertThatThrownBy(() -> Parser.parseInfoToNumber(invalidInput))
                .isInstanceOf(ParserException.class)
                .hasMessageContaining(ParserExceptionMessage.NOT_NUMBER.getMessage());
    }
}
