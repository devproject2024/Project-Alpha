package com.sendbird.android;

import com.sendbird.android.log.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class TimeoutScheduler {

    /* renamed from: a  reason: collision with root package name */
    final AtomicBoolean f44672a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f44673b;

    /* renamed from: c  reason: collision with root package name */
    TimeoutEventhandler f44674c;

    /* renamed from: d  reason: collision with root package name */
    Object f44675d;

    /* renamed from: e  reason: collision with root package name */
    private long f44676e;

    /* renamed from: f  reason: collision with root package name */
    private final long f44677f;

    /* renamed from: g  reason: collision with root package name */
    private final l f44678g;

    public interface TimeoutEventhandler {
        void onTimeout(Object obj);
    }

    TimeoutScheduler(long j) {
        this(j, j, false, (TimeoutEventhandler) null, (Object) null);
    }

    TimeoutScheduler(long j, TimeoutEventhandler timeoutEventhandler) {
        this(j, j, false, timeoutEventhandler, (Object) null);
    }

    TimeoutScheduler(TimeoutEventhandler timeoutEventhandler) {
        this(1000, 1000, true, timeoutEventhandler, (Object) null);
    }

    TimeoutScheduler(long j, long j2, boolean z, TimeoutEventhandler timeoutEventhandler, Object obj) {
        this.f44672a = new AtomicBoolean(false);
        this.f44673b = new AtomicBoolean(false);
        this.f44678g = new l();
        this.f44677f = j;
        this.f44676e = j2;
        this.f44673b.set(z);
        this.f44674c = timeoutEventhandler;
        this.f44675d = obj;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a(this.f44676e);
    }

    private void a(long j) {
        this.f44676e = j;
        if (this.f44672a.getAndSet(false)) {
            a(false);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.f44672a.set(false);
        b(z);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b() {
        this.f44673b.set(false);
        c();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c() {
        if (this.f44674c == null) {
            throw new NullPointerException("callback must Non null");
        } else if (!this.f44672a.get()) {
            this.f44678g.scheduleAtFixedRate(new Runnable() {
                public final void run() {
                    if (TimeoutScheduler.this.f44674c != null) {
                        TimeoutScheduler.this.f44674c.onTimeout(TimeoutScheduler.this.f44675d);
                    }
                    if (!TimeoutScheduler.this.f44673b.get()) {
                        TimeoutScheduler.this.a(false);
                    }
                    TimeoutScheduler.this.f44672a.set(false);
                }
            }, this.f44677f, this.f44676e, TimeUnit.MILLISECONDS);
            this.f44672a.compareAndSet(false, true);
        }
    }

    private void b(boolean z) {
        Logger.d("__ TimeoutScheduler::cancelAll(%s)", Boolean.valueOf(z));
        this.f44678g.a(z);
    }
}
