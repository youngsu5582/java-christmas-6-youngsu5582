package christmas.constant;

import christmas.domain.category.Drink;
import christmas.domain.menu.Menu;

public interface EventConstant {
    public static final Integer EVENT_THRESHOLD_PRICE = 10000;

    public static final Integer WEEKEND_DISCOUNT_PRICE = 2023;
    public static final String WEEKEND_DISCOUNT_EVENT_MESSAGE = "주말 할인";

    public static final Integer WEEKDAY_DISCOUNT_PRICE = 2023;
    public static final String WEEKDAY_DISCOUNT_EVENT_MESSAGE = "평일 할인";


    public static final Integer D_DAY_DISCOUNT_UNIT = 100;
    public static final Integer D_DAY_START_PRICE = 1000;
    public static final Integer CHRISTMAS_DAY = 25;
    public static final String CHRISTMAS_EVENT_MESSAGE = "크리스마스 디데이 할인";

    public static final Integer SPECIAL_DAY_PRICE = 1000;
    public static final String SPECIAL_DAY_MESSAGE = "특별 할인";


    public static final Integer CHAMPAGNE_LIMIT_PRICE = 120000;
    public static final Menu CHAMPAGNE_PRESENT = Drink.CHAMPAGNE.get();
}
