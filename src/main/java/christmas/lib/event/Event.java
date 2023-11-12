package christmas.lib.event;

public abstract class Event {
    public abstract boolean checkCondition(Object object);
    public abstract Object provideReward(Object object);
}
