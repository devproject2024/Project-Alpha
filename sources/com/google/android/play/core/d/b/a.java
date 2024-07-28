package com.google.android.play.core.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.b.au;
import com.google.android.play.core.b.ci;
import com.google.android.play.core.b.r;
import com.google.android.play.core.d.ad;
import com.google.android.play.core.d.ag;
import com.google.android.play.core.d.at;
import com.google.android.play.core.d.aw;
import com.google.android.play.core.d.b;
import com.google.android.play.core.d.d;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class a implements b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final long f37367b = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f37368a = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Context f37369c;

    /* renamed from: d  reason: collision with root package name */
    private final aw f37370d;

    /* renamed from: e  reason: collision with root package name */
    private final au f37371e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ci<d> f37372f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f37373g;

    /* renamed from: h  reason: collision with root package name */
    private final ad f37374h;

    /* renamed from: i  reason: collision with root package name */
    private final File f37375i;
    private final AtomicReference<d> j = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final Set<String> k = Collections.synchronizedSet(new HashSet());
    /* access modifiers changed from: private */
    public final Set<String> l = Collections.synchronizedSet(new HashSet());
    /* access modifiers changed from: private */
    public final AtomicBoolean m = new AtomicBoolean(false);
    private final c n;

    public a(Context context, File file, Executor executor) {
        aw awVar = new aw(context, context.getPackageName());
        au auVar = new au(context);
        c cVar = new c();
        this.n = cVar;
        this.f37372f = new ci<>();
        this.f37369c = context;
        this.f37375i = file;
        this.f37370d = awVar;
        this.f37371e = auVar;
        this.f37373g = executor;
        this.f37374h = at.f37361a;
    }

    private final d a(k kVar) {
        d d2 = d();
        d a2 = kVar.a(d2);
        if (!this.j.compareAndSet(d2, a2)) {
            return null;
        }
        return a2;
    }

    private static String a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    static /* synthetic */ void a(a aVar, List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            File file = (File) list.get(i2);
            String a2 = r.a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, aVar.f37369c.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", a(a2));
            intent.putExtra("split_id", a2);
            arrayList.add(intent);
            arrayList2.add(a(r.a(file)));
        }
        d d2 = aVar.d();
        if (d2 != null) {
            aVar.f37373g.execute(new i(aVar, d2.e(), arrayList, arrayList2, list2));
        }
    }

    private final void a(d dVar) {
        this.f37368a.post(new h(this, dVar));
    }

    /* access modifiers changed from: private */
    public final void a(List<Intent> list, List<String> list2, List<String> list3, long j2, boolean z) {
        List<Intent> list4 = list;
        this.f37374h.a().a(list, new j(this, list2, list3, j2, z, list));
    }

    /* access modifiers changed from: private */
    public final boolean a(int i2, int i3, Long l2, Long l3, List<String> list, Integer num, List<String> list2) {
        d a2 = a((k) new d(num, i2, i3, l2, l3, list, list2));
        if (a2 == null) {
            return false;
        }
        a(a2);
        return true;
    }

    private final d d() {
        return this.j.get();
    }

    private final ag e() {
        ag b2 = this.f37370d.b();
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    public final e<List<d>> a() {
        d d2 = d();
        return g.a(d2 == null ? Collections.emptyList() : Collections.singletonList(d2));
    }

    public final e<Void> a(int i2) {
        try {
            d a2 = a((k) new g(i2));
            if (a2 != null) {
                a(a2);
            }
            return g.a(null);
        } catch (com.google.android.play.core.d.a e2) {
            return g.a((Exception) e2);
        }
    }

    public final e<Void> a(List<String> list) {
        return g.a((Exception) new com.google.android.play.core.d.a(-5));
    }

    public final void a(com.google.android.play.core.d.e eVar) {
        this.f37372f.a(eVar);
    }

    public final boolean a(d dVar, Activity activity, int i2) throws IntentSender.SendIntentException {
        return false;
    }

    public final e<Void> b(List<String> list) {
        return g.a((Exception) new com.google.android.play.core.d.a(-5));
    }

    public final Set<String> b() {
        return new HashSet(this.k);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01ad, code lost:
        if (r4.contains(r15) == false) goto L_0x01af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.e.e<java.lang.Integer> a(com.google.android.play.core.d.c r22) {
        /*
            r21 = this;
            r9 = r21
            r0 = r22
            com.google.android.play.core.d.b.f r1 = new com.google.android.play.core.d.b.f     // Catch:{ a -> 0x0214 }
            r1.<init>(r0)     // Catch:{ a -> 0x0214 }
            com.google.android.play.core.d.d r1 = r9.a((com.google.android.play.core.d.b.k) r1)     // Catch:{ a -> 0x0214 }
            if (r1 != 0) goto L_0x001b
            com.google.android.play.core.d.a r0 = new com.google.android.play.core.d.a     // Catch:{ a -> 0x0214 }
            r1 = -100
            r0.<init>(r1)     // Catch:{ a -> 0x0214 }
            com.google.android.play.core.e.e r0 = com.google.android.play.core.e.g.a((java.lang.Exception) r0)     // Catch:{ a -> 0x0214 }
            return r0
        L_0x001b:
            int r1 = r1.a()     // Catch:{ a -> 0x0214 }
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List<java.util.Locale> r2 = r0.f37403b
            java.util.Iterator r2 = r2.iterator()
        L_0x002a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r2.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r3 = r3.getLanguage()
            r10.add(r3)
            goto L_0x002a
        L_0x003e:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.io.File r3 = r9.f37375i
            java.io.File[] r3 = r3.listFiles()
            if (r3 != 0) goto L_0x005b
            com.google.android.play.core.d.a r0 = new com.google.android.play.core.d.a
            r1 = -5
            r0.<init>(r1)
            com.google.android.play.core.e.e r0 = com.google.android.play.core.e.g.a((java.lang.Exception) r0)
            return r0
        L_0x005b:
            int r4 = r3.length
            r5 = 0
            r12 = r5
            r8 = 0
        L_0x0060:
            if (r8 < r4) goto L_0x00d2
            java.lang.String r3 = java.lang.String.valueOf(r2)
            java.util.List<java.lang.String> r4 = r0.f37402a
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r7 = java.lang.String.valueOf(r3)
            int r7 = r7.length()
            java.lang.String r8 = java.lang.String.valueOf(r4)
            int r8 = r8.length()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            int r7 = r7 + 21
            int r7 = r7 + r8
            r14.<init>(r7)
            java.lang.String r7 = "availableSplits"
            r14.append(r7)
            r14.append(r3)
            java.lang.String r3 = " want "
            r14.append(r3)
            r14.append(r4)
            java.util.HashSet r3 = new java.util.HashSet
            java.util.List<java.lang.String> r4 = r0.f37402a
            r3.<init>(r4)
            boolean r2 = r2.containsAll(r3)
            if (r2 != 0) goto L_0x00ac
            com.google.android.play.core.d.a r0 = new com.google.android.play.core.d.a
            r1 = -2
            r0.<init>(r1)
            com.google.android.play.core.e.e r0 = com.google.android.play.core.e.g.a((java.lang.Exception) r0)
            return r0
        L_0x00ac:
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            java.util.List<java.lang.String> r6 = r0.f37402a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r2 = 1
            r3 = 0
            r1 = r21
            r7 = r0
            r8 = r10
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r1 = r9.f37373g
            com.google.android.play.core.d.b.e r2 = new com.google.android.play.core.d.b.e
            r2.<init>(r9, r11, r10)
            r1.execute(r2)
            com.google.android.play.core.e.e r0 = com.google.android.play.core.e.g.a(r0)
            return r0
        L_0x00d2:
            r14 = r3[r8]
            java.lang.String r15 = com.google.android.play.core.b.r.a(r14)
            java.lang.String r5 = a((java.lang.String) r15)
            java.util.List<java.lang.String> r6 = r0.f37402a
            boolean r5 = r6.contains(r5)
            if (r5 != 0) goto L_0x00ec
            r17 = r1
            r19 = r3
            r18 = r4
            goto L_0x01af
        L_0x00ec:
            java.lang.String r5 = a((java.lang.String) r15)
            java.util.HashSet r6 = new java.util.HashSet
            com.google.android.play.core.b.au r7 = r9.f37371e
            java.util.List r7 = r7.a()
            r6.<init>(r7)
            com.google.android.play.core.d.ag r7 = r21.e()
            r17 = r1
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r16 = 0
            r1[r16] = r5
            java.util.List r1 = java.util.Arrays.asList(r1)
            java.util.Map r1 = r7.a(r1)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Collection r7 = r1.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x011d:
            boolean r18 = r7.hasNext()
            if (r18 == 0) goto L_0x0133
            java.lang.Object r18 = r7.next()
            r19 = r3
            r3 = r18
            java.util.Set r3 = (java.util.Set) r3
            r5.addAll(r3)
            r3 = r19
            goto L_0x011d
        L_0x0133:
            r19 = r3
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x013e:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x016a
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            r18 = r4
            java.lang.String r4 = "_"
            boolean r20 = r7.contains(r4)
            if (r20 == 0) goto L_0x015f
            r20 = r6
            r6 = -1
            java.lang.String[] r4 = r7.split(r4, r6)
            r6 = 0
            r7 = r4[r6]
            goto L_0x0162
        L_0x015f:
            r20 = r6
            r6 = 0
        L_0x0162:
            r3.add(r7)
            r4 = r18
            r6 = r20
            goto L_0x013e
        L_0x016a:
            r18 = r4
            r6 = 0
            java.util.Set<java.lang.String> r4 = r9.l
            r3.addAll(r4)
            r3.addAll(r10)
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0182:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01a3
            java.lang.Object r7 = r1.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r6 = r7.getKey()
            boolean r6 = r3.contains(r6)
            if (r6 == 0) goto L_0x01a1
            java.lang.Object r6 = r7.getValue()
            java.util.Collection r6 = (java.util.Collection) r6
            r4.addAll(r6)
        L_0x01a1:
            r6 = 0
            goto L_0x0182
        L_0x01a3:
            boolean r1 = r5.contains(r15)
            if (r1 == 0) goto L_0x01f9
            boolean r1 = r4.contains(r15)
            if (r1 != 0) goto L_0x01f9
        L_0x01af:
            java.util.List<java.util.Locale> r1 = r0.f37403b
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.Set<java.lang.String> r4 = r9.k
            r3.<init>(r4)
            java.lang.String r4 = ""
            java.lang.String r5 = "base"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.addAll(r4)
            com.google.android.play.core.d.ag r4 = r21.e()
            java.util.Map r3 = r4.a(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x01d3:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0208
            java.lang.Object r4 = r1.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r5 = r4.getLanguage()
            boolean r5 = r3.containsKey(r5)
            if (r5 == 0) goto L_0x01d3
            java.lang.String r4 = r4.getLanguage()
            java.lang.Object r4 = r3.get(r4)
            java.util.Set r4 = (java.util.Set) r4
            boolean r4 = r4.contains(r15)
            if (r4 == 0) goto L_0x01d3
        L_0x01f9:
            long r3 = r14.length()
            long r12 = r12 + r3
            java.lang.String r1 = com.google.android.play.core.b.r.a(r14)
            r2.add(r1)
            r11.add(r14)
        L_0x0208:
            int r8 = r8 + 1
            r1 = r17
            r4 = r18
            r3 = r19
            r5 = 0
            goto L_0x0060
        L_0x0214:
            r0 = move-exception
            com.google.android.play.core.e.e r0 = com.google.android.play.core.e.g.a((java.lang.Exception) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.d.b.a.a(com.google.android.play.core.d.c):com.google.android.play.core.e.e");
    }
}
