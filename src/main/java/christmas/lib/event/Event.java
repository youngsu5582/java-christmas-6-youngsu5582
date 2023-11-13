package christmas.lib.event;

public abstract class Event<T1, T2,R> {
    public abstract boolean checkCondition(T1 object);

    public abstract R provideReward(T2 object);
}
