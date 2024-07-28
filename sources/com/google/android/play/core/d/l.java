package com.google.android.play.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class l implements b {

    /* renamed from: a  reason: collision with root package name */
    final i f37429a;

    /* renamed from: b  reason: collision with root package name */
    private final z f37430b;

    /* renamed from: c  reason: collision with root package name */
    private final aw f37431c;

    /* renamed from: d  reason: collision with root package name */
    private final ab f37432d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f37433e = new Handler(Looper.getMainLooper());

    l(z zVar, Context context) {
        String packageName = context.getPackageName();
        this.f37431c = new aw(context, packageName);
        this.f37430b = zVar;
        this.f37429a = i.a(context);
        this.f37432d = new ab(context);
    }

    static List<String> c(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Locale next : list) {
            if (Build.VERSION.SDK_INT >= 21) {
                arrayList.add(next.toLanguageTag());
            }
        }
        return arrayList;
    }

    public final synchronized void a(e eVar) {
        this.f37429a.a(eVar);
    }

    public final Set<String> b() {
        return this.f37431c.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008c, code lost:
        if (r4.containsAll(r3) != false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.e.e<java.lang.Integer> a(com.google.android.play.core.d.c r10) {
        /*
            r9 = this;
            java.util.List<java.util.Locale> r0 = r10.f37403b
            boolean r0 = r0.isEmpty()
            r1 = 21
            if (r0 != 0) goto L_0x001a
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            com.google.android.play.core.d.a r10 = new com.google.android.play.core.d.a
            r0 = -5
            r10.<init>(r0)
            com.google.android.play.core.e.e r10 = com.google.android.play.core.e.g.a((java.lang.Exception) r10)
            return r10
        L_0x001a:
            java.util.List<java.util.Locale> r0 = r10.f37403b
            com.google.android.play.core.d.aw r2 = r9.f37431c
            com.google.android.play.core.d.ag r3 = r2.b()
            if (r3 == 0) goto L_0x0067
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.Set r5 = r2.c()
            java.lang.String r6 = ""
            r5.add(r6)
            java.util.Set r2 = r2.a()
            r2.add(r6)
            java.util.Map r2 = r3.a(r2)
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0045:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r6 = r3.getValue()
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r5.containsAll(r6)
            if (r6 == 0) goto L_0x0045
            java.lang.Object r3 = r3.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r4.add(r3)
            goto L_0x0045
        L_0x0067:
            r4 = 0
        L_0x0068:
            r2 = 0
            if (r4 == 0) goto L_0x008e
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0074:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0088
            java.lang.Object r5 = r0.next()
            java.util.Locale r5 = (java.util.Locale) r5
            java.lang.String r5 = r5.getLanguage()
            r3.add(r5)
            goto L_0x0074
        L_0x0088:
            boolean r0 = r4.containsAll(r3)
            if (r0 == 0) goto L_0x00ae
        L_0x008e:
            java.util.List<java.lang.String> r0 = r10.f37402a
            java.util.Set r3 = r9.b()
            boolean r0 = r3.containsAll(r0)
            if (r0 != 0) goto L_0x009b
            goto L_0x00ae
        L_0x009b:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L_0x00e6
            java.util.List<java.lang.String> r0 = r10.f37402a
            com.google.android.play.core.d.ab r1 = r9.f37432d
            java.util.Set r1 = r1.a()
            boolean r0 = java.util.Collections.disjoint(r0, r1)
            if (r0 == 0) goto L_0x00ae
            goto L_0x00e6
        L_0x00ae:
            com.google.android.play.core.d.z r4 = r9.f37430b
            java.util.List<java.lang.String> r6 = r10.f37402a
            java.util.List<java.util.Locale> r10 = r10.f37403b
            java.util.List r7 = c(r10)
            com.google.android.play.core.b.l<com.google.android.play.core.b.ar> r10 = r4.f37454b
            if (r10 == 0) goto L_0x00e1
            com.google.android.play.core.b.b r10 = com.google.android.play.core.d.z.f37452a
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r6
            r1 = 1
            r0[r1] = r7
            java.lang.String r1 = "startInstall(%s,%s)"
            r10.d(r1, r0)
            com.google.android.play.core.e.p r10 = new com.google.android.play.core.e.p
            r10.<init>()
            com.google.android.play.core.b.l<com.google.android.play.core.b.ar> r0 = r4.f37454b
            com.google.android.play.core.d.o r1 = new com.google.android.play.core.d.o
            r3 = r1
            r5 = r10
            r8 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r0.a((com.google.android.play.core.b.c) r1)
            com.google.android.play.core.e.t<ResultT> r10 = r10.f37476a
            return r10
        L_0x00e1:
            com.google.android.play.core.e.e r10 = com.google.android.play.core.d.z.a()
            return r10
        L_0x00e6:
            android.os.Handler r0 = r9.f37433e
            com.google.android.play.core.d.j r1 = new com.google.android.play.core.d.j
            r1.<init>(r9, r10)
            r0.post(r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            com.google.android.play.core.e.e r10 = com.google.android.play.core.e.g.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.d.l.a(com.google.android.play.core.d.c):com.google.android.play.core.e.e");
    }

    public final boolean a(d dVar, Activity activity, int i2) throws IntentSender.SendIntentException {
        k kVar = new k(activity);
        if (dVar.b() != 8 || dVar.h() == null) {
            return false;
        }
        kVar.a(dVar.h().getIntentSender(), i2);
        return true;
    }

    public final e<Void> a(int i2) {
        z zVar = this.f37430b;
        if (zVar.f37454b == null) {
            return z.a();
        }
        z.f37452a.d("cancelInstall(%d)", Integer.valueOf(i2));
        p pVar = new p();
        zVar.f37454b.a((c) new s(zVar, pVar, i2, pVar));
        return pVar.f37476a;
    }

    public final e<List<d>> a() {
        z zVar = this.f37430b;
        if (zVar.f37454b == null) {
            return z.a();
        }
        z.f37452a.d("getSessionStates", new Object[0]);
        p pVar = new p();
        zVar.f37454b.a((c) new r(zVar, pVar, pVar));
        return pVar.f37476a;
    }

    public final e<Void> a(List<String> list) {
        this.f37432d.a(list);
        z zVar = this.f37430b;
        if (zVar.f37454b == null) {
            return z.a();
        }
        z.f37452a.d("deferredUninstall(%s)", list);
        p pVar = new p();
        zVar.f37454b.a((c) new p(zVar, pVar, list, pVar));
        return pVar.f37476a;
    }

    public final e<Void> b(List<String> list) {
        z zVar = this.f37430b;
        if (zVar.f37454b == null) {
            return z.a();
        }
        z.f37452a.d("deferredInstall(%s)", list);
        p pVar = new p();
        zVar.f37454b.a((c) new q(zVar, pVar, list, pVar));
        return pVar.f37476a;
    }
}
