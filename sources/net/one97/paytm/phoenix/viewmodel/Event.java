package net.one97.paytm.phoenix.viewmodel;

public class Event<T> {
    private final T content;
    private boolean hasBeenHandled;

    public static /* synthetic */ void hasBeenHandled$annotations() {
    }

    public Event(T t) {
        this.content = t;
    }

    public final boolean getHasBeenHandled() {
        return this.hasBeenHandled;
    }

    public final T getContentIfNotHandled() {
        if (this.hasBeenHandled) {
            return null;
        }
        this.hasBeenHandled = true;
        return this.content;
    }

    public final T peekContent() {
        return this.content;
    }
}
