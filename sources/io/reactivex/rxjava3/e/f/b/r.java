package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;

public final class r<T> extends a<T, T> {
    public r(h<T> hVar) {
        super(hVar);
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar));
    }

    static final class a<T> extends AtomicInteger implements k<T>, c {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current = new AtomicReference<>();
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final AtomicLong requested = new AtomicLong();
        c upstream;

        a(b<? super T> bVar) {
            this.downstream = bVar;
        }

        public final void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.current.lazySet(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                drain();
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet((Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                b<? super T> bVar = this.downstream;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i2 = 1;
                do {
                    long j = 0;
                    while (true) {
                        z = false;
                        if (j == atomicLong.get()) {
                            break;
                        }
                        boolean z2 = this.done;
                        T andSet = atomicReference.getAndSet((Object) null);
                        boolean z3 = andSet == null;
                        if (!checkTerminated(z2, z3, bVar, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            bVar.onNext(andSet);
                            j++;
                        } else {
                            return;
                        }
                    }
                    if (j == atomicLong.get()) {
                        boolean z4 = this.done;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (checkTerminated(z4, z, bVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j != 0) {
                        d.b(atomicLong, j);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (th != null) {
                    atomicReference.lazySet((Object) null);
                    bVar.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    bVar.onComplete();
                    return true;
                }
            }
        }
    }
}
