package christmas.view.message;

public enum OutputViewMessage {
    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PREVIEW_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    MENU_MESSAGE("<주문 메뉴>"),
    MENU_FORMAT("%s %d개"),
    TOTAL_SALE_MESSAGE("<할인 전 총주문 금액>"),
    PRICE_FORMAT("%s원");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
