package com.google.android.gms.internal.p001firebaseperf;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-perf.s  reason: invalid package */
public final class s {

    /* renamed from: d  reason: collision with root package name */
    private static final s f9720d = new s();

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentLinkedQueue<ao> f9721a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledFuture f9722b;

    /* renamed from: c  reason: collision with root package name */
    public long f9723c;

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f9724e;

    /* renamed from: f  reason: collision with root package name */
    private final Runtime f9725f;

    private s() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private s(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.f9722b = null;
        this.f9723c = -1;
        this.f9724e = scheduledExecutorService;
        this.f9721a = new ConcurrentLinkedQueue<>();
        this.f9725f = runtime;
    }

    public static s a() {
        return f9720d;
    }

    public final void b() {
        ScheduledFuture scheduledFuture = this.f9722b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f9722b = null;
            this.f9723c = -1;
        }
    }

    public final synchronized void a(long j) {
        this.f9723c = j;
        try {
            this.f9722b = this.f9724e.scheduleAtFixedRate(new r(this), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Unable to start collecting Memory Metrics: ".concat(valueOf);
            } else {
                new String("Unable to start collecting Memory Metrics: ");
            }
        }
    }

    public final synchronized void c() {
        try {
            this.f9724e.schedule(new u(this), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Unable to collect Memory Metric: ".concat(valueOf);
            } else {
                new String("Unable to collect Memory Metric: ");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final ao d() {
        return (ao) ao.a().a(TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis())).a(g.a(ac.BYTES.zzp(this.f9725f.totalMemory() - this.f9725f.freeMemory()))).k();
    }
}
