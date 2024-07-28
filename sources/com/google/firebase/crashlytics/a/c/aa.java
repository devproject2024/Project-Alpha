package com.google.firebase.crashlytics.a.c;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.crashlytics.a.d.b;
import com.google.firebase.crashlytics.a.e.v;
import com.google.firebase.crashlytics.a.e.w;
import com.google.firebase.crashlytics.a.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

final class aa {

    /* renamed from: a  reason: collision with root package name */
    final n f38153a;

    /* renamed from: b  reason: collision with root package name */
    final a f38154b;

    /* renamed from: c  reason: collision with root package name */
    final ae f38155c;

    /* renamed from: d  reason: collision with root package name */
    String f38156d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.crashlytics.a.j.a f38157e;

    /* renamed from: f  reason: collision with root package name */
    private final b f38158f;

    aa(n nVar, a aVar, com.google.firebase.crashlytics.a.j.a aVar2, b bVar, ae aeVar) {
        this.f38153a = nVar;
        this.f38154b = aVar;
        this.f38157e = aVar2;
        this.f38158f = bVar;
        this.f38155c = aeVar;
    }

    public final void a(long j) {
        this.f38154b.a(this.f38156d, j);
    }

    /* access modifiers changed from: package-private */
    public final Task<Void> a(Executor executor, s sVar) {
        if (sVar == s.NONE) {
            com.google.firebase.crashlytics.a.b.a().a(3);
            this.f38154b.a();
            return h.a(null);
        }
        List<o> b2 = this.f38154b.b();
        ArrayList arrayList = new ArrayList();
        for (o next : b2) {
            if (next.a().k() != v.e.NATIVE || sVar == s.ALL) {
                arrayList.add(this.f38157e.a(next).a(executor, ab.a(this)));
            } else {
                com.google.firebase.crashlytics.a.b.a().a(3);
                this.f38154b.a(next.b());
            }
        }
        return h.a((Collection<? extends Task<?>>) arrayList);
    }

    /* access modifiers changed from: package-private */
    public final void a(Throwable th, Thread thread, String str, long j, boolean z) {
        String str2 = this.f38156d;
        if (str2 == null) {
            com.google.firebase.crashlytics.a.b.a().a(3);
            return;
        }
        boolean equals = str.equals("crash");
        v.d.C0634d a2 = this.f38153a.a(th, thread, str, j, z);
        v.d.C0634d.b f2 = a2.f();
        String a3 = this.f38158f.a();
        if (a3 != null) {
            f2.a(v.d.C0634d.C0645d.b().a(a3).a());
        } else {
            com.google.firebase.crashlytics.a.b.a().a(3);
        }
        List<v.b> a4 = a(Collections.unmodifiableMap(this.f38155c.f38162b));
        if (!a4.isEmpty()) {
            f2.a(a2.c().e().a(w.a(a4)).a());
        }
        this.f38154b.a(f2.a(), str2, equals);
    }

    private static List<v.b> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(v.b.c().a((String) next.getKey()).b((String) next.getValue()).a());
        }
        Collections.sort(arrayList, ac.a());
        return arrayList;
    }
}
