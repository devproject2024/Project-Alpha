package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.d.c;
import androidx.core.d.f;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.firebase_ml.bg;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.e;
import com.google.firebase.components.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class dt {

    /* renamed from: a  reason: collision with root package name */
    static final j f9818a = new j("MlStatsLogger", "");
    public static final com.google.firebase.components.b<?> j = com.google.firebase.components.b.a(a.class).a(n.b(ds.class)).a(n.b(Context.class)).a(n.b(ef.class)).a(n.b(b.class)).a(dx.f9835a).a();
    private static List<String> k;
    private static boolean o = false;
    private static boolean p = false;

    /* renamed from: b  reason: collision with root package name */
    final String f9819b;

    /* renamed from: c  reason: collision with root package name */
    final String f9820c;

    /* renamed from: d  reason: collision with root package name */
    final String f9821d;

    /* renamed from: e  reason: collision with root package name */
    final String f9822e;

    /* renamed from: f  reason: collision with root package name */
    final String f9823f;

    /* renamed from: g  reason: collision with root package name */
    final b f9824g;

    /* renamed from: h  reason: collision with root package name */
    final Task<String> f9825h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<br, Long> f9826i;
    private final ef l;
    private final Task<String> m;
    private final Map<br, Object> n;
    private final int q;

    public interface b {
        void a(bg.e eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001b, code lost:
        r6 = r6.c().f38757d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private dt(com.google.android.gms.internal.firebase_ml.ds r2, android.content.Context r3, com.google.android.gms.internal.firebase_ml.ef r4, com.google.android.gms.internal.firebase_ml.dt.b r5, int r6) {
        /*
            r1 = this;
            r1.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.f9826i = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1.n = r0
            r1.q = r6
            com.google.firebase.c r6 = r2.f9817b
            java.lang.String r0 = ""
            if (r6 != 0) goto L_0x001b
        L_0x0019:
            r6 = r0
            goto L_0x0024
        L_0x001b:
            com.google.firebase.g r6 = r6.c()
            java.lang.String r6 = r6.f38757d
            if (r6 != 0) goto L_0x0024
            goto L_0x0019
        L_0x0024:
            r1.f9821d = r6
            com.google.firebase.c r6 = r2.f9817b
            if (r6 != 0) goto L_0x002c
        L_0x002a:
            r6 = r0
            goto L_0x0035
        L_0x002c:
            com.google.firebase.g r6 = r6.c()
            java.lang.String r6 = r6.f38756c
            if (r6 != 0) goto L_0x0035
            goto L_0x002a
        L_0x0035:
            r1.f9822e = r6
            com.google.firebase.c r2 = r2.f9817b
            if (r2 != 0) goto L_0x003c
            goto L_0x0046
        L_0x003c:
            com.google.firebase.g r2 = r2.c()
            java.lang.String r2 = r2.f38754a
            if (r2 != 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r0 = r2
        L_0x0046:
            r1.f9823f = r0
            java.lang.String r2 = r3.getPackageName()
            r1.f9819b = r2
            java.lang.String r2 = com.google.android.gms.internal.firebase_ml.dh.a((android.content.Context) r3)
            r1.f9820c = r2
            r1.l = r4
            r1.f9824g = r5
            com.google.android.gms.internal.firebase_ml.dl r2 = com.google.android.gms.internal.firebase_ml.dl.b()
            java.util.concurrent.Callable r3 = com.google.android.gms.internal.firebase_ml.dw.f9834a
            com.google.android.gms.tasks.Task r2 = r2.a(r3)
            r1.f9825h = r2
            com.google.android.gms.internal.firebase_ml.dl r2 = com.google.android.gms.internal.firebase_ml.dl.b()
            r4.getClass()
            java.util.concurrent.Callable r3 = com.google.android.gms.internal.firebase_ml.dv.a(r4)
            com.google.android.gms.tasks.Task r2 = r2.a(r3)
            r1.m = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.dt.<init>(com.google.android.gms.internal.firebase_ml.ds, android.content.Context, com.google.android.gms.internal.firebase_ml.ef, com.google.android.gms.internal.firebase_ml.dt$b, int):void");
    }

    public static class a extends dg<Integer, dt> {

        /* renamed from: a  reason: collision with root package name */
        private final ds f9827a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f9828b;

        /* renamed from: c  reason: collision with root package name */
        private final ef f9829c;

        /* renamed from: d  reason: collision with root package name */
        private final b f9830d;

        private a(ds dsVar, Context context, ef efVar, b bVar) {
            this.f9827a = dsVar;
            this.f9828b = context;
            this.f9829c = efVar;
            this.f9830d = bVar;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object b(Object obj) {
            return new dt(this.f9827a, this.f9828b, this.f9829c, this.f9830d, ((Integer) obj).intValue(), (byte) 0);
        }

        /* synthetic */ a(ds dsVar, Context context, ef efVar, b bVar, byte b2) {
            this(dsVar, context, efVar, bVar);
        }
    }

    public static dt a(ds dsVar) {
        s.a(dsVar);
        return (dt) ((a) dsVar.a(a.class)).a(1);
    }

    public final void a(bg.e.a aVar, br brVar) {
        dl.a().execute(new dy(this, aVar, brVar));
    }

    public final boolean a() {
        int i2 = this.q;
        if (i2 == 1) {
            return this.l.a();
        }
        if (i2 != 2) {
            return i2 == 3 || i2 == 4 || i2 == 5;
        }
        return this.l.b();
    }

    static synchronized List<String> b() {
        synchronized (dt.class) {
            if (k != null) {
                List<String> list = k;
                return list;
            }
            f a2 = c.a(Resources.getSystem().getConfiguration());
            k = new ArrayList(a2.a());
            for (int i2 = 0; i2 < a2.a(); i2++) {
                k.add(dh.a(a2.a(i2)));
            }
            List<String> list2 = k;
            return list2;
        }
    }

    static final /* synthetic */ a a(e eVar) {
        return new a((ds) eVar.a(ds.class), (Context) eVar.a(Context.class), (ef) eVar.a(ef.class), (b) eVar.a(b.class), (byte) 0);
    }

    /* synthetic */ dt(ds dsVar, Context context, ef efVar, b bVar, int i2, byte b2) {
        this(dsVar, context, efVar, bVar, i2);
    }
}
