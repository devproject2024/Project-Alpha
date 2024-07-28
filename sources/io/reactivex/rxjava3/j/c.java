package io.reactivex.rxjava3.j;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.e.k.m;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T> extends e<T> {

    /* renamed from: c  reason: collision with root package name */
    static final b[] f47805c = new b[0];

    /* renamed from: d  reason: collision with root package name */
    static final b[] f47806d = new b[0];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f47807f = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    final a<T> f47808a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b<T>[]> f47809b = new AtomicReference<>(f47805c);

    /* renamed from: e  reason: collision with root package name */
    boolean f47810e;

    interface a<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        T getValue();

        void replay(b<T> bVar);

        int size();

        void trimHead();
    }

    public static <T> c<T> a() {
        return new c<>(new C0829c(16));
    }

    private c(a<T> aVar) {
        this.f47808a = aVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        boolean z;
        b bVar = new b(wVar, this);
        wVar.onSubscribe(bVar);
        while (true) {
            b[] bVarArr = (b[]) this.f47809b.get();
            z = false;
            if (bVarArr != f47806d) {
                int length = bVarArr.length;
                b[] bVarArr2 = new b[(length + 1)];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
                if (this.f47809b.compareAndSet(bVarArr, bVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z || !bVar.cancelled) {
            this.f47808a.replay(bVar);
        } else {
            a(bVar);
        }
    }

    public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
        if (this.f47810e) {
            cVar.dispose();
        }
    }

    public final void onNext(T t) {
        j.a(t, "onNext called with a null value.");
        if (!this.f47810e) {
            a<T> aVar = this.f47808a;
            aVar.add(t);
            for (b replay : (b[]) this.f47809b.get()) {
                aVar.replay(replay);
            }
        }
    }

    public final void onError(Throwable th) {
        j.a(th, "onError called with a null Throwable.");
        if (this.f47810e) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        this.f47810e = true;
        Object error = m.error(th);
        a<T> aVar = this.f47808a;
        aVar.addFinal(error);
        for (b replay : a(error)) {
            aVar.replay(replay);
        }
    }

    public final void onComplete() {
        if (!this.f47810e) {
            this.f47810e = true;
            Object complete = m.complete();
            a<T> aVar = this.f47808a;
            aVar.addFinal(complete);
            for (b replay : a(complete)) {
                aVar.replay(replay);
            }
        }
    }

    public final T b() {
        return this.f47808a.getValue();
    }

    public final void c() {
        this.f47808a.trimHead();
    }

    public final boolean d() {
        return this.f47808a.size() != 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(b<T> bVar) {
        b<T>[] bVarArr;
        b[] bVarArr2;
        do {
            bVarArr = (b[]) this.f47809b.get();
            if (bVarArr != f47806d && bVarArr != f47805c) {
                int length = bVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (bVarArr[i3] == bVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        bVarArr2 = f47805c;
                    } else {
                        b[] bVarArr3 = new b[(length - 1)];
                        System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                        System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                        bVarArr2 = bVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f47809b.compareAndSet(bVarArr, bVarArr2));
    }

    private b<T>[] a(Object obj) {
        this.f47808a.compareAndSet((Object) null, obj);
        return (b[]) this.f47809b.getAndSet(f47806d);
    }

    static final class b<T> extends AtomicInteger implements io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final w<? super T> downstream;
        Object index;
        final c<T> state;

        b(w<? super T> wVar, c<T> cVar) {
            this.downstream = wVar;
            this.state = cVar;
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.a(this);
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* renamed from: io.reactivex.rxjava3.j.c$c  reason: collision with other inner class name */
    static final class C0829c<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        public final void trimHead() {
        }

        C0829c(int i2) {
            this.buffer = new ArrayList(i2);
        }

        public final void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        public final void addFinal(Object obj) {
            this.buffer.add(obj);
            trimHead();
            this.size++;
            this.done = true;
        }

        public final T getValue() {
            int i2 = this.size;
            if (i2 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t = list.get(i2 - 1);
            if (!m.isComplete(t) && !m.isError(t)) {
                return t;
            }
            if (i2 == 1) {
                return null;
            }
            return list.get(i2 - 2);
        }

        public final T[] getValues(T[] tArr) {
            int i2 = this.size;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List list = this.buffer;
            Object obj = list.get(i2 - 1);
            if ((m.isComplete(obj) || m.isError(obj)) && i2 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i2) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                tArr[i3] = list.get(i3);
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        public final void replay(b<T> bVar) {
            int i2;
            if (bVar.getAndIncrement() == 0) {
                List<Object> list = this.buffer;
                w<? super T> wVar = bVar.downstream;
                Integer num = (Integer) bVar.index;
                int i3 = 0;
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    bVar.index = 0;
                }
                int i4 = 1;
                while (!bVar.cancelled) {
                    int i5 = this.size;
                    while (i5 != i3) {
                        if (bVar.cancelled) {
                            bVar.index = null;
                            return;
                        }
                        Object obj = list.get(i3);
                        if (this.done && (i2 = i3 + 1) == i5 && i2 == (i5 = this.size)) {
                            if (m.isComplete(obj)) {
                                wVar.onComplete();
                            } else {
                                wVar.onError(m.getError(obj));
                            }
                            bVar.index = null;
                            bVar.cancelled = true;
                            return;
                        }
                        wVar.onNext(obj);
                        i3++;
                    }
                    if (i3 == this.size) {
                        bVar.index = Integer.valueOf(i3);
                        i4 = bVar.addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    }
                }
                bVar.index = null;
            }
        }

        public final int size() {
            int i2 = this.size;
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2 - 1;
            Object obj = this.buffer.get(i3);
            return (m.isComplete(obj) || m.isError(obj)) ? i3 : i2;
        }
    }
}
