package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    /**
     * 임의 추가한 테스트 케이스
     */
    //-----------------------------------------------------------------------------
    
    @ParameterizedTest
    @DisplayName("부적절한 메뉴 포맷")
    @ValueSource(strings = {"타파스리-15","타파스-4,타파스-2","타파스-3.아이스크림-1","아이스크림-0"})
    void 메뉴_오류_테스트(String invalidMenuInfo){
        assertSimpleTest(() -> {
            runException("3", invalidMenuInfo);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 음료_단독_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-3");
            assertThat(output()).contains("[ERROR] 음료만 주문할 수 없습니다!");
        });
    }
    @Test
    void 메뉴_초과_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "아이스크림-21");
            assertThat(output()).contains("[ERROR] 총 주문한 개수가 20를 초과했습니다!");
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
