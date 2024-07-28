package io.reactivex.rxjava3.e.g;

import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.k.p;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c<T> implements j<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f47623a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f47624b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    int f47625c;

    /* renamed from: d  reason: collision with root package name */
    long f47626d;

    /* renamed from: e  reason: collision with root package name */
    final int f47627e;

    /* renamed from: f  reason: collision with root package name */
    AtomicReferenceArray<Object> f47628f;

    /* renamed from: g  reason: collision with root package name */
    final int f47629g;

    /* renamed from: h  reason: collision with root package name */
    AtomicReferenceArray<Object> f47630h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f47631i = new AtomicLong();

    public c(int i2) {
        int a2 = p.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f47628f = atomicReferenceArray;
        this.f47627e = i3;
        this.f47625c = Math.min(a2 / 4, f47623a);
        this.f47630h = atomicReferenceArray;
        this.f47629g = i3;
        this.f47626d = (long) (i3 - 1);
        a(0);
    }

    public final boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f47628f;
            long j2 = this.f47624b.get();
            int i2 = this.f47627e;
            int i3 = ((int) j2) & i2;
            if (j2 < this.f47626d) {
                return a(atomicReferenceArray, t, j2, i3);
            }
            long j3 = ((long) this.f47625c) + j2;
            if (atomicReferenceArray.get(((int) j3) & i2) == null) {
                this.f47626d = j3 - 1;
                return a(atomicReferenceArray, t, j2, i3);
            }
            long j4 = j2 + 1;
            if (atomicReferenceArray.get(((int) j4) & i2) == null) {
                return a(atomicReferenceArray, t, j2, i3);
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.f47628f = atomicReferenceArray2;
            this.f47626d = (j2 + ((long) i2)) - 1;
            atomicReferenceArray2.lazySet(i3, t);
            a(atomicReferenceArray, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i3, j);
            a(j4);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
    }

    public final T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f47630h;
        long j2 = this.f47631i.get();
        int i2 = this.f47629g;
        int i3 = ((int) j2) & i2;
        T t = atomicReferenceArray.get(i3);
        boolean z = t == j;
        if (t != null && !z) {
            atomicReferenceArray.lazySet(i3, (Object) null);
            b(j2 + 1);
            return t;
        } else if (!z) {
            return null;
        } else {
            AtomicReferenceArray<Object> a2 = a(atomicReferenceArray, i2 + 1);
            this.f47630h = a2;
            T t2 = a2.get(i3);
            if (t2 != null) {
                a2.lazySet(i3, (Object) null);
                b(j2 + 1);
            }
            return t2;
        }
    }

    public final T a() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f47630h;
        long j2 = this.f47631i.get();
        int i2 = this.f47629g;
        T t = atomicReferenceArray.get(((int) j2) & i2);
        return t == j ? a(a(atomicReferenceArray, i2 + 1), j2, i2) : t;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f47630h = atomicReferenceArray;
        return atomicReferenceArray.get(((int) j2) & i2);
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private void a(long j2) {
        this.f47624b.lazySet(j2);
    }

    private void b(long j2) {
        this.f47631i.lazySet(j2);
    }

    public final boolean a(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f47628f;
        long j2 = this.f47624b.get();
        int i2 = this.f47627e;
        long j3 = 2 + j2;
        if (atomicReferenceArray.get(((int) j3) & i2) == null) {
            int i3 = ((int) j2) & i2;
            atomicReferenceArray.lazySet(i3 + 1, t2);
            atomicReferenceArray.lazySet(i3, t);
            a(j3);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f47628f = atomicReferenceArray2;
        int i4 = ((int) j2) & i2;
        atomicReferenceArray2.lazySet(i4 + 1, t2);
        atomicReferenceArray2.lazySet(i4, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i4, j);
        a(j3);
        return true;
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        atomicReferenceArray.lazySet(i2, t);
        a(j2 + 1);
        return true;
    }

    private static AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i2);
        atomicReferenceArray.lazySet(i2, (Object) null);
        return atomicReferenceArray2;
    }

    public final boolean isEmpty() {
        return this.f47624b.get() == this.f47631i.get();
    }
}
