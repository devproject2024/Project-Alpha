package kotlin;

import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlin.g.b.k;

final class r<T> implements Serializable, g<T> {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public r(a<? extends T> aVar, Object obj) {
        k.d(aVar, "initializer");
        this.initializer = aVar;
        this._value = v.f47996a;
        this.lock = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(a aVar, Object obj, int i2, g gVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }

    public final T getValue() {
        T t;
        T t2 = this._value;
        if (t2 != v.f47996a) {
            return t2;
        }
        synchronized (this.lock) {
            t = this._value;
            if (t == v.f47996a) {
                a aVar = this.initializer;
                k.a((Object) aVar);
                t = aVar.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
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
