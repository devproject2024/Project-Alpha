package com.alipay.imobile.network.quake;

import android.os.Process;
import com.alipay.iap.android.common.b.c;
import com.alipay.imobile.network.quake.b.a;
import com.alipay.imobile.network.quake.e.b;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f14820a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<e> f14821b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<e> f14822c;

    /* renamed from: d  reason: collision with root package name */
    private final o f14823d;

    /* renamed from: e  reason: collision with root package name */
    private m f14824e;

    public h(BlockingQueue<e> blockingQueue, BlockingQueue<e> blockingQueue2, o oVar, m mVar) {
        this.f14821b = blockingQueue;
        this.f14822c = blockingQueue2;
        this.f14823d = oVar;
        this.f14824e = mVar;
    }

    public final void run() {
        String str = c.f14737a;
        c.b();
        Process.setThreadPriority(10);
        while (true) {
            try {
                final e take = this.f14821b.take();
                take.a("cache-queue-take");
                if (take.j) {
                    take.b("cache-discard-canceled");
                } else {
                    b b2 = take.b();
                    String b3 = b2.b(take);
                    a b4 = this.f14824e.b(take.r);
                    if (!b4.a()) {
                        b4.b();
                    }
                    a.C0201a aVar = null;
                    try {
                        aVar = b4.a(b3);
                    } catch (IOException e2) {
                        String str2 = c.f14737a;
                        c.a("Unhandled exception %s", e2.toString());
                        c.j();
                        b4.b(b3);
                    }
                    if (aVar == null) {
                        take.a("cache-miss");
                        this.f14822c.put(take);
                    } else {
                        if (aVar.f14721d < System.currentTimeMillis()) {
                            take.a("cache-hit-expired");
                            take.n = aVar;
                            this.f14822c.put(take);
                        } else {
                            take.a("cache-hit");
                            g a2 = b2.a(take, new b(0, aVar.f14718a));
                            take.a("cache-hit-parsed");
                            if (!(aVar.f14722e < System.currentTimeMillis())) {
                                this.f14823d.a(take, (g<?>) a2);
                            } else {
                                take.a("cache-hit-refresh-needed");
                                take.a("softExpireTime=" + aVar.f14722e + ", finalExpireTime=" + aVar.f14721d + "currentTime=" + System.currentTimeMillis());
                                take.n = aVar;
                                a2.f14790d = true;
                                this.f14823d.a(take, a2, new Runnable() {
                                    public final void run() {
                                        try {
                                            h.this.f14822c.put(take);
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (InterruptedException e3) {
                String str3 = c.f14737a;
                c.a("Unhandled InterruptedException %s", e3.toString());
                c.j();
                if (this.f14820a) {
                    return;
                }
            } catch (Throwable th) {
                String str4 = c.f14737a;
                c.a("Unhandled throwable %s", th.toString());
                c.j();
            }
        }
    }
}
