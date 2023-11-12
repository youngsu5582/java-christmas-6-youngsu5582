package christmas.lib.event;

public abstract class Event<T, E> {
    public abstract boolean checkCondition(T object);

    public abstract Object provideReward(E object);
}
