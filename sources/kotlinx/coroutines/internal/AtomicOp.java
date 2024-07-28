package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.DebugKt;

public abstract class AtomicOp<T> extends OpDescriptor {
    private static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(T t, Object obj);

    public AtomicOp<?> getAtomicOp() {
        return this;
    }

    public long getOpSequence() {
        return 0;
    }

    public abstract Object prepare(T t);

    public final boolean isDecided() {
        return this._consensus != AtomicKt.NO_DECISION;
    }

    public final Object decide(Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj != AtomicKt.NO_DECISION)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        if (obj2 != AtomicKt.NO_DECISION) {
            return obj2;
        }
        if (_consensus$FU.compareAndSet(this, AtomicKt.NO_DECISION, obj)) {
            return obj;
        }
        return this._consensus;
    }

    public final Object perform(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == AtomicKt.NO_DECISION) {
            obj2 = decide(prepare(obj));
        }
        complete(obj, obj2);
        return obj2;
    }
}
