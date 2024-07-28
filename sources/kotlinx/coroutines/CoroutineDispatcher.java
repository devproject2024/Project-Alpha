package kotlinx.coroutines;

import kotlin.d.a;
import kotlin.d.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public abstract class CoroutineDispatcher extends a implements e {
    public static final Key Key = new Key((g) null);

    public abstract void dispatch(f fVar, Runnable runnable);

    public boolean isDispatchNeeded(f fVar) {
        return true;
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        k.d(cVar, "key");
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (bVar.isSubKey$kotlin_stdlib(getKey())) {
                E tryCast$kotlin_stdlib = bVar.tryCast$kotlin_stdlib(this);
                if (tryCast$kotlin_stdlib instanceof f.b) {
                    return tryCast$kotlin_stdlib;
                }
            }
            return null;
        } else if (e.f47904a == cVar) {
            return this;
        } else {
            return null;
        }
    }

    public f minusKey(f.c<?> cVar) {
        k.d(cVar, "key");
        if (!(cVar instanceof b)) {
            return e.f47904a == cVar ? kotlin.d.g.INSTANCE : this;
        }
        b bVar = (b) cVar;
        return (!bVar.isSubKey$kotlin_stdlib(getKey()) || bVar.tryCast$kotlin_stdlib(this) == null) ? this : kotlin.d.g.INSTANCE;
    }

    public CoroutineDispatcher() {
        super(e.f47904a);
    }

    public static final class Key extends b<e, CoroutineDispatcher> {
        public /* synthetic */ Key(g gVar) {
            this();
        }

        private Key() {
            super(e.f47904a, AnonymousClass1.INSTANCE);
        }
    }

    public final <T> d<T> interceptContinuation(d<? super T> dVar) {
        return new DispatchedContinuation<>(this, dVar);
    }

    public void releaseInterceptedContinuation(d<?> dVar) {
        if (dVar != null) {
            CancellableContinuationImpl<?> reusableCancellableContinuation = ((DispatchedContinuation) dVar).getReusableCancellableContinuation();
            if (reusableCancellableContinuation != null) {
                reusableCancellableContinuation.detachChild$kotlinx_coroutines_core();
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}
