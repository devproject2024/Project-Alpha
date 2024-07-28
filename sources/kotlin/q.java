package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.b.k;

final class q<T> implements Serializable, g<T> {
    public static final a Companion = new a((byte) 0);
    private static final AtomicReferenceFieldUpdater<q<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_value");
    private volatile Object _value = v.f47996a;

    /* renamed from: final  reason: not valid java name */
    private final Object f380final = v.f47996a;
    private volatile kotlin.g.a.a<? extends T> initializer;

    public q(kotlin.g.a.a<? extends T> aVar) {
        k.d(aVar, "initializer");
        this.initializer = aVar;
    }

    public final T getValue() {
        T t = this._value;
        if (t != v.f47996a) {
            return t;
        }
        kotlin.g.a.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T invoke = aVar.invoke();
            if (valueUpdater.compareAndSet(this, v.f47996a, invoke)) {
                this.initializer = null;
                return invoke;
            }
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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
