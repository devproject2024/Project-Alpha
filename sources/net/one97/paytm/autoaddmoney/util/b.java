package net.one97.paytm.autoaddmoney.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f49279a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f49280b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f49281c;

    private b(Executor executor, Executor executor2, Executor executor3) {
        k.c(executor, "diskIO");
        k.c(executor2, "networkIO");
        k.c(executor3, "mainThread");
        this.f49279a = executor;
        this.f49280b = executor2;
        this.f49281c = executor3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b() {
        /*
            r3 = this;
            net.one97.paytm.autoaddmoney.util.e r0 = new net.one97.paytm.autoaddmoney.util.e
            r0.<init>()
            java.util.concurrent.Executor r0 = (java.util.concurrent.Executor) r0
            r1 = 3
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newFixedThreadPool(r1)
            java.lang.String r2 = "Executors.newFixedThreadPool(THREAD_COUNT)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            net.one97.paytm.autoaddmoney.util.b$a r2 = new net.one97.paytm.autoaddmoney.util.b$a
            r2.<init>()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            r3.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.util.b.<init>():void");
    }

    static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f49282a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            k.c(runnable, "command");
            this.f49282a.post(runnable);
        }
    }
}
