package com.alipay.imobile.network.quake;

import android.os.Process;
import com.alipay.iap.android.common.b.c;
import com.alipay.imobile.network.quake.e.b;
import com.alipay.mobile.b.b.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

public final class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f14893a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<j> f14894b;

    /* renamed from: c  reason: collision with root package name */
    private final o f14895c;

    /* renamed from: d  reason: collision with root package name */
    private m f14896d;

    public i(BlockingQueue<j> blockingQueue, o oVar, m mVar) {
        this.f14894b = blockingQueue;
        this.f14895c = oVar;
        this.f14896d = mVar;
    }

    public final void run() {
        a aVar;
        Process.setThreadPriority(10);
        while (true) {
            try {
                j take = this.f14894b.take();
                e eVar = take.f14911a;
                b bVar = take.f14912b;
                take.f14911a = null;
                take.f14912b = null;
                try {
                    eVar.a("Deserialize-queue-take");
                    if (eVar.j) {
                        eVar.b("Deserialize-discard-cancelled");
                    } else if (!bVar.notModified || !eVar.l) {
                        Iterator<Object> it2 = c.g().e().iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                        b b2 = eVar.b();
                        g a2 = b2.a(eVar, bVar);
                        eVar.a("network-parse-complete");
                        if (eVar.f14777i && a2.f14788b != null) {
                            this.f14896d.b(eVar.r).a(b2.b(eVar), a2.f14788b);
                            eVar.a("network-cache-written");
                        }
                        eVar.l = true;
                        this.f14895c.a(eVar, (g<?>) a2);
                    } else {
                        eVar.b("not-modified");
                        return;
                    }
                } catch (a e2) {
                    aVar = e.a(e2);
                    this.f14895c.a(eVar, aVar);
                } catch (Throwable th) {
                    String str = c.f14737a;
                    c.a("Unhandled throwable %s", th.toString());
                    c.j();
                    aVar = new com.alipay.imobile.network.quake.c.a((Integer) 0, th);
                    this.f14895c.a(eVar, aVar);
                }
            } catch (InterruptedException unused) {
                if (this.f14893a) {
                    return;
                }
            }
        }
    }
}
