package kotlin;

import java.io.Serializable;

public final class d<T> implements Serializable, g<T> {
    private final T value;

    public final boolean isInitialized() {
        return true;
    }

    public d(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }

    public final String toString() {
        return String.valueOf(getValue());
    }
}
