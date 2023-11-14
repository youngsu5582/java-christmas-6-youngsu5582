package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class CaseTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    @DisplayName("""
            25일날 아이스크림 두개 먹는 케이스
            금액 : 10000 - 8446( 평일 할인*2 + 특별 할인 + 크리스마스 디데이 할인 ) = 1554
            이벤트 뱃지 : 별
            """)
    void case1() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-2");
            assertThat(output()).contains(
                    "아이스크림 2개",
                    "10,000원",
                    "없음",
                    "크리스마스 디데이 할인: -3,400원",
                    "특별 할인: -1,000원",
                    "평일 할인: -4,046원",
                    "증정 이벤트: 0원",
                    "-8,446원",
                    "1,554원",
                    "별"
            );
        });
    }

    @Test
    @DisplayName("""
            26일날 양송이 두개 먹는 케이스
            금액 : 12000 - 0 (할인받을게 없음) = 12000
            이벤트 뱃지 : 없음
            """)
    void case2() {
        assertSimpleTest(() -> {
            run("26", "양송이수프-2");
            assertThat(output()).contains(
                    "양송이수프 2개",
                    "12,000원",
                    "없음",
                    "0원"
            );
        });
    }
    @Test
    @DisplayName("""
            31일날 초코케이크 스무개 먹는 케이스
            총 혜택 금액 : 66460( 특별 할인 + 평일 할인*20 + 증정 이벤트 )
            금액 : 300,000 - 41,460 = 258,540
            이벤트 뱃지 : 별
            """)
    void case3() {
        assertSimpleTest(() -> {
            run("31", "초코케이크-20");

            assertThat(output()).contains(
                    "초코케이크 20개",
                    "300,000원",
                    "증정 이벤트: -25,000원",
                    "특별 할인: -1,000원",
                    "평일 할인: -40,460원",
                    "-66,460원",
                    "258,540원",
                    "산타"
            );
        });
    }
    @Test
    @DisplayName("""
            29일날 바비큐립 2개 , 양송이수프 2개 먹는 케이스
            총 혜택 금액 : 29,046원 ( 증정 이벤트 + 주말 할인*2 )
            금액 : 120,000 - 4,046 = 115,954
            이벤트 뱃지 : 산타
            """)
    void case4() {
        assertSimpleTest(() -> {
            run("29", "바비큐립-2,양송이수프-2");
            assertThat(output()).contains(
                    "바비큐립 2개",
                    "양송이수프 2개",
                    "120,000원",
                    "샴페인 1개",
                    "주말 할인: -4,046원",
                    "증정 이벤트: -25,000원",
                    "-29,046원",
                    "115,954원",
                    "산타"
            );
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}