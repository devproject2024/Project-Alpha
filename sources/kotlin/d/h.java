package kotlin.d;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.b.a.e;
import kotlin.g.b.k;
import kotlin.p;

public final class h<T> implements e, d<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<h<?>, Object> f47906b = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");

    /* renamed from: c  reason: collision with root package name */
    private static final a f47907c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    private final d<T> f47908a;
    private volatile Object result;

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    private h(d<? super T> dVar, Object obj) {
        k.d(dVar, "delegate");
        this.f47908a = dVar;
        this.result = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(d<? super T> dVar) {
        this(dVar, kotlin.d.a.a.UNDECIDED);
        k.d(dVar, "delegate");
    }

    public final f getContext() {
        return this.f47908a.getContext();
    }

    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            if (obj2 == kotlin.d.a.a.UNDECIDED) {
                if (f47906b.compareAndSet(this, kotlin.d.a.a.UNDECIDED, obj)) {
                    return;
                }
            } else if (obj2 != kotlin.d.a.a.COROUTINE_SUSPENDED) {
                throw new IllegalStateException("Already resumed");
            } else if (f47906b.compareAndSet(this, kotlin.d.a.a.COROUTINE_SUSPENDED, kotlin.d.a.a.RESUMED)) {
                this.f47908a.resumeWith(obj);
                return;
            }
        }
    }

    public final Object a() {
        Object obj = this.result;
        if (obj == kotlin.d.a.a.UNDECIDED) {
            if (f47906b.compareAndSet(this, kotlin.d.a.a.UNDECIDED, kotlin.d.a.a.COROUTINE_SUSPENDED)) {
                return kotlin.d.a.a.COROUTINE_SUSPENDED;
            }
            obj = this.result;
        }
        if (obj == kotlin.d.a.a.RESUMED) {
            return kotlin.d.a.a.COROUTINE_SUSPENDED;
        }
        if (!(obj instanceof p.b)) {
            return obj;
        }
        throw ((p.b) obj).exception;
    }

    public final e getCallerFrame() {
        d<T> dVar = this.f47908a;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    public final String toString() {
        return "SafeContinuation for " + this.f47908a;
    }
}
