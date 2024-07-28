package io.reactivex.rxjava3.e.g;

import io.reactivex.rxjava3.e.c.j;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> implements j<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<C0823a<T>> f47621a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<C0823a<T>> f47622b = new AtomicReference<>();

    public a() {
        C0823a aVar = new C0823a();
        b(aVar);
        a(aVar);
    }

    public final boolean offer(T t) {
        if (t != null) {
            C0823a aVar = new C0823a(t);
            a(aVar).soNext(aVar);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.g.a.clear():void");
    }

    private C0823a<T> a() {
        return this.f47621a.get();
    }

    private C0823a<T> a(C0823a<T> aVar) {
        return this.f47621a.getAndSet(aVar);
    }

    private void b(C0823a<T> aVar) {
        this.f47622b.lazySet(aVar);
    }

    /* renamed from: io.reactivex.rxjava3.e.g.a$a  reason: collision with other inner class name */
    static final class C0823a<E> extends AtomicReference<C0823a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        C0823a() {
        }

        C0823a(E e2) {
            spValue(e2);
        }

        public final E getAndNullValue() {
            E lpValue = lpValue();
            spValue((Object) null);
            return lpValue;
        }

        public final E lpValue() {
            return this.value;
        }

        public final void spValue(E e2) {
            this.value = e2;
        }

        public final void soNext(C0823a<E> aVar) {
            lazySet(aVar);
        }

        public final C0823a<E> lvNext() {
            return (C0823a) get();
        }
    }

    public final T poll() {
        C0823a lvNext;
        C0823a aVar = this.f47622b.get();
        C0823a lvNext2 = aVar.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            b(lvNext2);
            return andNullValue;
        } else if (aVar == a()) {
            return null;
        } else {
            do {
                lvNext = aVar.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            b(lvNext);
            return andNullValue2;
        }
    }

    public final boolean isEmpty() {
        return this.f47622b.get() == a();
    }
}
