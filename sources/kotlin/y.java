package kotlin;

import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.k;

public final class y<T> implements Serializable, g<T> {
    private Object _value = v.f47996a;
    private a<? extends T> initializer;

    public y(a<? extends T> aVar) {
        k.d(aVar, "initializer");
        this.initializer = aVar;
    }

    public final T getValue() {
        if (this._value == v.f47996a) {
            a<? extends T> aVar = this.initializer;
            k.a((Object) aVar);
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    public final boolean isInitialized() {
        return this._value != v.f47996a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new d(getValue());
    }
}
