package com.paytm.notification.schedulers;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.ListenableWorker;
import androidx.work.c;
import androidx.work.g;
import androidx.work.m;
import androidx.work.n;
import androidx.work.u;
import androidx.work.v;
import androidx.work.w;
import com.paytm.notification.b.e;
import com.paytm.notification.schedulers.c;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0728a f43247a = new C0728a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private v f43248b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f43249c;

    protected a(Context context) {
        k.c(context, "context");
        this.f43249c = context;
    }

    /* access modifiers changed from: package-private */
    public final v a() {
        if (this.f43248b == null) {
            try {
                this.f43248b = v.a(this.f43249c);
            } catch (Exception e2) {
                e.f43014a.b(e2);
            }
        }
        return this.f43248b;
    }

    /* access modifiers changed from: package-private */
    public final LiveData<u> a(String str, d dVar, n.a aVar) {
        g gVar = g.KEEP;
        int i2 = dVar.f43299a;
        c.b.a aVar2 = c.b.f43295a;
        if (i2 == c.b.a.a()) {
            gVar = g.REPLACE;
        } else {
            c.b.a aVar3 = c.b.f43295a;
            if (i2 == c.b.a.b()) {
                gVar = g.KEEP;
            }
        }
        w c2 = aVar.c();
        k.a((Object) c2, "builder.build()");
        n nVar = (n) c2;
        v a2 = a();
        if (a2 != null) {
            a2.a(str, gVar, nVar);
        }
        v a3 = a();
        if (a3 == null) {
            k.a();
        }
        LiveData<u> a4 = a3.a(nVar.a());
        k.a((Object) a4, "getWorkManager()!!.getWo…ationListenableWorker.id)");
        return a4;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        k.c(str, "tag");
        v a2 = a();
        if (a2 != null) {
            a2.a(str);
        }
    }

    /* renamed from: com.paytm.notification.schedulers.a$a  reason: collision with other inner class name */
    public static final class C0728a {
        private C0728a() {
        }

        public /* synthetic */ C0728a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(Class<? extends ListenableWorker> cls, String str, d dVar) throws Exception {
        long j;
        if (dVar.f43303e >= 10000) {
            j = dVar.f43303e;
        } else {
            j = 30000;
        }
        w.a a2 = ((n.a) ((n.a) ((n.a) new n.a(cls).a(dVar.f43302d, TimeUnit.MILLISECONDS)).a(androidx.work.a.LINEAR, j, TimeUnit.MILLISECONDS)).a(new c.a().a(m.CONNECTED).a().b())).a(str);
        k.a((Object) a2, "OneTimeWorkRequest.Build…          .addTag(jobTag)");
        a(str, dVar, (n.a) a2);
        return 1;
    }
}
