package christmas;

import christmas.controller.GameController;
import christmas.factory.ControllerFactory;

public class Application {
    public static void main(String[] args) {
        GameController gameController = ControllerFactory.getGameController();
        gameController.run();
    }
}
