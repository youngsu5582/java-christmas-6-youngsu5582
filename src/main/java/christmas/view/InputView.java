package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.InputViewMessage;

public class InputView {

    private static String readInput() {
        return Console.readLine();
    }

    public static String inputVisitDate() {

        System.out.println(InputViewMessage.DATE_MESSAGE.getMessage());
        return readInput();
    }

    public static String inputOrder() {
        System.out.println(InputViewMessage.ORDER_MESSAGE.getMessage());
        return readInput();
    }
}
