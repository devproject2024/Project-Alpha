package com.alipay.imobile.network.quake;

import android.os.Handler;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.common.b.d;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class k implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f14913a;

    public k(final Handler handler) {
        this.f14913a = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void a(e eVar, g<?> gVar) {
        a(eVar, gVar, (Runnable) null);
    }

    public final void a(e eVar, com.alipay.mobile.b.b.a aVar) {
        eVar.a("post-error");
        this.f14913a.execute(new a(eVar, g.a(aVar), (Runnable) null));
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final e f14917b;

        /* renamed from: c  reason: collision with root package name */
        private final g f14918c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f14919d;

        public a(e eVar, g gVar, Runnable runnable) {
            this.f14917b = eVar;
            this.f14918c = gVar;
            this.f14919d = runnable;
        }

        public final void run() {
            if (this.f14917b.j) {
                this.f14917b.b("canceled-at-delivery");
                return;
            }
            if (this.f14918c.f14789c == null) {
                e eVar = this.f14917b;
                T t = this.f14918c.f14787a;
                if (eVar.f14773e != null) {
                    eVar.f14773e.a(t);
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("result", "T");
                hashMap.put("operation_type", eVar.a());
                eVar.b((Map<String, String>) hashMap);
                eVar.a((Map<String, String>) hashMap);
                d.a();
            } else {
                e eVar2 = this.f14917b;
                com.alipay.mobile.b.b.a aVar = this.f14918c.f14789c;
                String str = c.f14737a;
                c.a("error[code=%s, msg=%s] need to be handle ", Integer.valueOf(aVar.getCode()), aVar.getMessage());
                c.i();
                if (eVar2.f14772d != null) {
                    eVar2.f14772d.a(aVar);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put("code", String.valueOf(aVar.getCode()));
                hashMap2.put("message", aVar.getMessage());
                hashMap2.put("operation_type", eVar2.a());
                eVar2.b((Map<String, String>) hashMap2);
                eVar2.a((Map<String, String>) hashMap2);
                d.a();
                HashMap hashMap3 = new HashMap(4);
                hashMap3.put("result", AppConstants.FEED_SUB_TYPE);
                hashMap3.put("operation_type", eVar2.a());
                eVar2.b((Map<String, String>) hashMap3);
                eVar2.a((Map<String, String>) hashMap3);
                d.a();
            }
            if (this.f14918c.f14790d) {
                this.f14917b.a("intermediate-response");
            } else {
                this.f14917b.b("done");
            }
            Runnable runnable = this.f14919d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void a(e eVar, g<?> gVar, Runnable runnable) {
        eVar.l = true;
        eVar.a("post-response");
        this.f14913a.execute(new a(eVar, gVar, runnable));
    }
}
