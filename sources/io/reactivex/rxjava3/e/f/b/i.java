package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public final class i<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final T[] f46807b;

    public i(T[] tArr) {
        this.f46807b = tArr;
    }

    public final void b(org.a.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.rxjava3.e.c.c) {
            bVar.onSubscribe(new a((io.reactivex.rxjava3.e.c.c) bVar, this.f46807b));
        } else {
            bVar.onSubscribe(new b(bVar, this.f46807b));
        }
    }

    static abstract class c<T> extends io.reactivex.rxjava3.e.j.b<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        /* access modifiers changed from: package-private */
        public abstract void fastPath();

        public final int requestFusion(int i2) {
            return i2 & 1;
        }

        /* access modifiers changed from: package-private */
        public abstract void slowPath(long j);

        c(T[] tArr) {
            this.array = tArr;
        }

        public final T poll() {
            int i2 = this.index;
            T[] tArr = this.array;
            if (i2 == tArr.length) {
                return null;
            }
            this.index = i2 + 1;
            return Objects.requireNonNull(tArr[i2], "array element is null");
        }

        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        public final void clear() {
            this.index = this.array.length;
        }

        public final void request(long j) {
            if (g.validate(j) && d.a((AtomicLong) this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class b<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.b<? super T> downstream;

        b(org.a.b<? super T> bVar, T[] tArr) {
            super(tArr);
            this.downstream = bVar;
        }

        /* access modifiers changed from: package-private */
        public final void fastPath() {
            Object[] objArr = this.array;
            int length = objArr.length;
            org.a.b<? super T> bVar = this.downstream;
            int i2 = this.index;
            while (i2 != length) {
                if (!this.cancelled) {
                    Object obj = objArr[i2];
                    if (obj == null) {
                        bVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                        return;
                    }
                    bVar.onNext(obj);
                    i2++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                bVar.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public final void slowPath(long j) {
            Object[] objArr = this.array;
            int length = objArr.length;
            int i2 = this.index;
            org.a.b<? super T> bVar = this.downstream;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 != length) {
                            j2 = get();
                            if (j3 == j2) {
                                this.index = i2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (!this.cancelled) {
                            bVar.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        Object obj = objArr[i2];
                        if (obj == null) {
                            bVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                            return;
                        }
                        bVar.onNext(obj);
                        j3++;
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }

    static final class a<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.rxjava3.e.c.c<? super T> downstream;

        a(io.reactivex.rxjava3.e.c.c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.downstream = cVar;
        }

        /* access modifiers changed from: package-private */
        public final void fastPath() {
            Object[] objArr = this.array;
            int length = objArr.length;
            io.reactivex.rxjava3.e.c.c<? super T> cVar = this.downstream;
            int i2 = this.index;
            while (i2 != length) {
                if (!this.cancelled) {
                    Object obj = objArr[i2];
                    if (obj == null) {
                        cVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                        return;
                    }
                    cVar.a(obj);
                    i2++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public final void slowPath(long j) {
            Object[] objArr = this.array;
            int length = objArr.length;
            int i2 = this.index;
            io.reactivex.rxjava3.e.c.c<? super T> cVar = this.downstream;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i2 == length) {
                        if (i2 != length) {
                            j2 = get();
                            if (j3 == j2) {
                                this.index = i2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (!this.cancelled) {
                            cVar.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        Object obj = objArr[i2];
                        if (obj == null) {
                            cVar.onError(new NullPointerException("The element at index " + i2 + " is null"));
                            return;
                        }
                        if (cVar.a(obj)) {
                            j3++;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j2 != 0);
        }
    }
}
