package christmas.domain.event;

import christmas.domain.event.InProgressEventList;
import christmas.factory.EventFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InProgressEventListTest {

    @Test
    @DisplayName("이벤트 목록 들을 , 할인 이벤트 와 증정 이벤트 로 분리 해서 InProgressEventList 를 만든다.")
    void createInprogressListWithEventList() {
        var eventList = EventFactory.getEventList();
        InProgressEventList inProgressEventList = InProgressEventList.of(eventList);
        var discountEventCount = inProgressEventList.discountEventList().size();
        var presentEventCount = inProgressEventList.presentEventList().size();
        Assertions.assertEquals(eventList.size(), discountEventCount + presentEventCount);
    }
}

