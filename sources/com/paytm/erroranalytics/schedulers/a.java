package com.paytm.erroranalytics.schedulers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.c;
import androidx.work.g;
import androidx.work.m;
import androidx.work.n;
import androidx.work.p;
import androidx.work.v;
import com.paytm.erroranalytics.e;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected v f42812a = v.a();

    /* renamed from: b  reason: collision with root package name */
    private Context f42813b;

    protected a(Context context) {
        this.f42813b = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, p.a aVar) {
        try {
            if (((List) this.f42812a.c(str).get()).isEmpty()) {
                v.a().a(aVar.c());
            }
        } catch (InterruptedException e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
        } catch (ExecutionException e3) {
            if (e3.getMessage() != null) {
                e3.getMessage();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(Class<? extends ListenableWorker> cls, String str, d dVar) {
        String str2 = e.f42808a;
        c.a aVar = new c.a();
        aVar.f5083c = m.CONNECTED;
        aVar.f5084d = true;
        n.a aVar2 = (n.a) ((n.a) ((n.a) ((n.a) new n.a(cls).a(dVar.f42822c, TimeUnit.MILLISECONDS)).a(androidx.work.a.LINEAR, 30000, TimeUnit.MILLISECONDS)).a(aVar.b())).a(str);
        g gVar = g.KEEP;
        int i2 = dVar.f42820a;
        if (i2 == 1) {
            gVar = g.REPLACE;
        } else if (i2 == 2) {
            gVar = g.KEEP;
        }
        this.f42812a.a(str, gVar, (n) aVar2.c());
        return 1;
    }
}
