package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.concurrent.atomic.AtomicLong;
import org.a.b;
import org.a.c;

public final class o<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final int f46818c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46819d = true;

    /* renamed from: e  reason: collision with root package name */
    final boolean f46820e = false;

    /* renamed from: f  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46821f;

    public o(h<T> hVar, int i2, io.reactivex.rxjava3.d.a aVar) {
        super(hVar);
        this.f46818c = i2;
        this.f46821f = aVar;
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar, this.f46818c, this.f46819d, this.f46820e, this.f46821f));
    }

    static final class a<T> extends io.reactivex.rxjava3.e.j.a<T> implements k<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final io.reactivex.rxjava3.d.a onOverflow;
        boolean outputFused;
        final j<T> queue;
        final AtomicLong requested = new AtomicLong();
        c upstream;

        a(b<? super T> bVar, int i2, boolean z, boolean z2, io.reactivex.rxjava3.d.a aVar) {
            j<T> jVar;
            this.downstream = bVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            if (z) {
                jVar = new io.reactivex.rxjava3.e.g.c<>(i2);
            } else {
                jVar = new io.reactivex.rxjava3.e.g.b<>(i2);
            }
            this.queue = jVar;
        }

        public final void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                io.reactivex.rxjava3.c.c cVar = new io.reactivex.rxjava3.c.c("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    cVar.initCause(th);
                }
                onError(cVar);
            } else if (this.outputFused) {
                this.downstream.onNext(null);
            } else {
                drain();
            }
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th);
            } else {
                drain();
            }
        }

        public final void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                drain();
            }
        }

        public final void request(long j) {
            if (!this.outputFused && g.validate(j)) {
                d.a(this.requested, j);
                drain();
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            int i2;
            if (getAndIncrement() == 0) {
                j<T> jVar = this.queue;
                b<? super T> bVar = this.downstream;
                int i3 = 1;
                while (!checkTerminated(this.done, jVar.isEmpty(), bVar)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.done;
                        T poll = jVar.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, bVar)) {
                            if (z2) {
                                break;
                            }
                            bVar.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !checkTerminated(this.done, jVar.isEmpty(), bVar)) {
                        if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-j2);
                        }
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, b<? super T> bVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        bVar.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        bVar.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        bVar.onError(th2);
                    } else {
                        bVar.onComplete();
                    }
                    return true;
                }
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public final T poll() {
            return this.queue.poll();
        }

        public final void clear() {
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }
}
