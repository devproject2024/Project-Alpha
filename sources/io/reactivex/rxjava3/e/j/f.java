package io.reactivex.rxjava3.e.j;

import io.reactivex.rxjava3.e.k.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;

public final class f extends AtomicInteger implements c {
    private static final long serialVersionUID = -2189523197179400958L;
    c actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<c> missedSubscription = new AtomicReference<>();
    long requested;
    protected boolean unbounded;

    public f(boolean z) {
        this.cancelOnReplace = z;
    }

    public final void setSubscription(c cVar) {
        if (this.cancelled) {
            cVar.cancel();
            return;
        }
        Objects.requireNonNull(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            c andSet = this.missedSubscription.getAndSet(cVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        c cVar2 = this.actual;
        if (cVar2 != null && this.cancelOnReplace) {
            cVar2.cancel();
        }
        this.actual = cVar;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j != 0) {
            cVar.request(j);
        }
    }

    public final void request(long j) {
        if (g.validate(j) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                d.a(this.missedRequested, j);
                drain();
                return;
            }
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long a2 = d.a(j2, j);
                this.requested = a2;
                if (a2 == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            c cVar = this.actual;
            if (decrementAndGet() != 0) {
                drainLoop();
            }
            if (cVar != null) {
                cVar.request(j);
            }
        }
    }

    public final void produced(long j) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                d.a(this.missedProduced, j);
                drain();
                return;
            }
            long j2 = this.requested;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                long j4 = 0;
                if (j3 < 0) {
                    g.reportMoreProduced(j3);
                } else {
                    j4 = j3;
                }
                this.requested = j4;
            }
            if (decrementAndGet() != 0) {
                drainLoop();
            }
        }
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            drain();
        }
    }

    /* access modifiers changed from: package-private */
    public final void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* access modifiers changed from: package-private */
    public final void drainLoop() {
        c cVar = null;
        long j = 0;
        int i2 = 1;
        do {
            c cVar2 = this.missedSubscription.get();
            if (cVar2 != null) {
                cVar2 = this.missedSubscription.getAndSet((Object) null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0);
            }
            c cVar3 = this.actual;
            if (this.cancelled) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.actual = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = d.a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            g.reportMoreProduced(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    }
                    this.requested = j4;
                }
                if (cVar2 != null) {
                    if (cVar3 != null && this.cancelOnReplace) {
                        cVar3.cancel();
                    }
                    this.actual = cVar2;
                    if (j4 != 0) {
                        j = d.a(j, j4);
                        cVar = cVar2;
                    }
                } else if (!(cVar3 == null || j2 == 0)) {
                    j = d.a(j, j2);
                    cVar = cVar3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j != 0) {
            cVar.request(j);
        }
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }
}
