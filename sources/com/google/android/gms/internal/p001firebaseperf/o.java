package com.google.android.gms.internal.p001firebaseperf;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-perf.o  reason: invalid package */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    private static final long f9709e = TimeUnit.SECONDS.toMicros(1);

    /* renamed from: f  reason: collision with root package name */
    private static o f9710f = null;

    /* renamed from: a  reason: collision with root package name */
    public ScheduledFuture f9711a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f9712b;

    /* renamed from: c  reason: collision with root package name */
    public final long f9713c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentLinkedQueue<av> f9714d;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f9715g;

    /* renamed from: h  reason: collision with root package name */
    private final String f9716h;

    private o() {
        long j = -1;
        this.f9712b = -1;
        this.f9714d = new ConcurrentLinkedQueue<>();
        this.f9715g = Executors.newSingleThreadScheduledExecutor();
        String num = Integer.toString(Process.myPid());
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 11);
        sb.append("/proc/");
        sb.append(num);
        sb.append("/stat");
        this.f9716h = sb.toString();
        this.f9713c = Build.VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : j;
    }

    public static o a() {
        if (f9710f == null) {
            f9710f = new o();
        }
        return f9710f;
    }

    public final void b() {
        ScheduledFuture scheduledFuture = this.f9711a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f9711a = null;
            this.f9712b = -1;
        }
    }

    public final synchronized void a(long j) {
        this.f9712b = j;
        try {
            this.f9711a = this.f9715g.scheduleAtFixedRate(new q(this), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Unable to start collecting Cpu Metrics: ".concat(valueOf);
            } else {
                new String("Unable to start collecting Cpu Metrics: ");
            }
        }
    }

    public final synchronized void c() {
        try {
            this.f9715g.schedule(new p(this), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Unable to collect Cpu Metric: ".concat(valueOf);
            } else {
                new String("Unable to collect Cpu Metric: ");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0068, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.p001firebaseperf.av d() {
        /*
            r12 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            java.lang.String r2 = r12.f9716h     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0066 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0066 }
            long r1 = r1.toMicros(r2)     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = " "
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x0066 }
            r4 = 13
            r4 = r3[r4]     // Catch:{ all -> 0x0066 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x0066 }
            r6 = 15
            r6 = r3[r6]     // Catch:{ all -> 0x0066 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0066 }
            r8 = 14
            r8 = r3[r8]     // Catch:{ all -> 0x0066 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ all -> 0x0066 }
            r10 = 16
            r3 = r3[r10]     // Catch:{ all -> 0x0066 }
            long r10 = java.lang.Long.parseLong(r3)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.av$a r3 = com.google.android.gms.internal.p001firebaseperf.av.a()     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.av$a r1 = r3.a(r1)     // Catch:{ all -> 0x0066 }
            long r8 = r8 + r10
            long r2 = r12.b(r8)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.av$a r1 = r1.c(r2)     // Catch:{ all -> 0x0066 }
            long r4 = r4 + r6
            long r2 = r12.b(r4)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.av$a r1 = r1.b(r2)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.dq r1 = r1.k()     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.dq r1 = (com.google.android.gms.internal.p001firebaseperf.dq) r1     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.av r1 = (com.google.android.gms.internal.p001firebaseperf.av) r1     // Catch:{ all -> 0x0066 }
            r0.close()     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            return r1
        L_0x0066:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            com.google.android.gms.internal.p001firebaseperf.j.a(r1, r0)     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
        L_0x0071:
            throw r2     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
        L_0x0072:
            r0 = move-exception
            goto L_0x0077
        L_0x0074:
            r0 = move-exception
            goto L_0x0077
        L_0x0076:
            r0 = move-exception
        L_0x0077:
            java.lang.String r1 = "Unexpected '/proc/[pid]/stat' file format encountered: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x008b
            r1.concat(r0)
            goto L_0x00ab
        L_0x008b:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            goto L_0x00ab
        L_0x0091:
            r0 = move-exception
            java.lang.String r1 = "Unable to read 'proc/[pid]/stat' file: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x00a6
            r1.concat(r0)
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseperf.o.d():com.google.android.gms.internal.firebase-perf.av");
    }

    private final long b(long j) {
        return Math.round((((double) j) / ((double) this.f9713c)) * ((double) f9709e));
    }
}
