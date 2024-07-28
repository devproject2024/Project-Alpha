package com.google.firebase.crashlytics.a.k;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.h;
import com.google.firebase.crashlytics.a.c.q;
import com.google.firebase.crashlytics.a.c.r;
import com.google.firebase.crashlytics.a.k.a.b;
import com.google.firebase.crashlytics.a.k.a.e;
import com.google.firebase.crashlytics.a.k.a.g;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    final Context f38690a;

    /* renamed from: b  reason: collision with root package name */
    final g f38691b;

    /* renamed from: c  reason: collision with root package name */
    final f f38692c;

    /* renamed from: d  reason: collision with root package name */
    final a f38693d;

    /* renamed from: e  reason: collision with root package name */
    final com.google.firebase.crashlytics.a.k.b.d f38694e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<e> f38695f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<f<b>> f38696g = new AtomicReference<>(new f());

    /* renamed from: h  reason: collision with root package name */
    private final q f38697h;

    /* renamed from: i  reason: collision with root package name */
    private final r f38698i;

    public d(Context context, g gVar, q qVar, f fVar, a aVar, com.google.firebase.crashlytics.a.k.b.d dVar, r rVar) {
        this.f38690a = context;
        this.f38691b = gVar;
        this.f38697h = qVar;
        this.f38692c = fVar;
        this.f38693d = aVar;
        this.f38694e = dVar;
        this.f38698i = rVar;
        AtomicReference<e> atomicReference = this.f38695f;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new com.google.firebase.crashlytics.a.k.a.f(b.a(qVar, 3600, jSONObject), (b) null, b.b(jSONObject), b.a(jSONObject), 0, 3600));
    }

    public final e a() {
        return this.f38695f.get();
    }

    public final Task<b> b() {
        return this.f38696g.get().a();
    }

    public final Task<Void> a(c cVar, Executor executor) {
        com.google.firebase.crashlytics.a.k.a.f a2;
        if (d() || (a2 = a(cVar)) == null) {
            com.google.firebase.crashlytics.a.k.a.f a3 = a(c.IGNORE_CACHE_EXPIRATION);
            if (a3 != null) {
                this.f38695f.set(a3);
                this.f38696g.get().b(a3.f38673a);
            }
            return this.f38698i.c().a(executor, new com.google.android.gms.tasks.e<Void, Void>() {
                public final /* bridge */ /* synthetic */ Task a(Object obj) throws Exception {
                    return a();
                }

                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0043 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private com.google.android.gms.tasks.Task<java.lang.Void> a() throws java.lang.Exception {
                    /*
                        r8 = this;
                        com.google.firebase.crashlytics.a.k.d r0 = com.google.firebase.crashlytics.a.k.d.this
                        com.google.firebase.crashlytics.a.k.b.d r0 = r0.f38694e
                        com.google.firebase.crashlytics.a.k.d r1 = com.google.firebase.crashlytics.a.k.d.this
                        com.google.firebase.crashlytics.a.k.a.g r1 = r1.f38691b
                        org.json.JSONObject r0 = r0.a(r1)
                        r1 = 0
                        if (r0 == 0) goto L_0x0099
                        com.google.firebase.crashlytics.a.k.d r2 = com.google.firebase.crashlytics.a.k.d.this
                        com.google.firebase.crashlytics.a.k.f r2 = r2.f38692c
                        com.google.firebase.crashlytics.a.k.a.f r2 = r2.a((org.json.JSONObject) r0)
                        com.google.firebase.crashlytics.a.k.d r3 = com.google.firebase.crashlytics.a.k.d.this
                        com.google.firebase.crashlytics.a.k.a r3 = r3.f38693d
                        long r4 = r2.f38676d
                        com.google.firebase.crashlytics.a.b r6 = com.google.firebase.crashlytics.a.b.a()
                        r7 = 3
                        r6.a(r7)
                        if (r0 == 0) goto L_0x0055
                        java.lang.String r6 = "expires_at"
                        r0.put(r6, r4)     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
                        java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
                        java.io.File r3 = r3.a()     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
                        r4.<init>(r3)     // Catch:{ Exception -> 0x0042, all -> 0x0040 }
                        java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0043 }
                        r4.write(r3)     // Catch:{ Exception -> 0x0043 }
                        r4.flush()     // Catch:{ Exception -> 0x0043 }
                        goto L_0x004b
                    L_0x0040:
                        r0 = move-exception
                        goto L_0x0051
                    L_0x0042:
                        r4 = r1
                    L_0x0043:
                        com.google.firebase.crashlytics.a.b r3 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x004f }
                        r5 = 6
                        r3.a(r5)     // Catch:{ all -> 0x004f }
                    L_0x004b:
                        com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r4)
                        goto L_0x0055
                    L_0x004f:
                        r0 = move-exception
                        r1 = r4
                    L_0x0051:
                        com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r1)
                        throw r0
                    L_0x0055:
                        java.lang.String r3 = "Loaded settings: "
                        com.google.firebase.crashlytics.a.k.d.a((org.json.JSONObject) r0, (java.lang.String) r3)
                        com.google.firebase.crashlytics.a.k.d r0 = com.google.firebase.crashlytics.a.k.d.this
                        com.google.firebase.crashlytics.a.k.a.g r3 = r0.f38691b
                        java.lang.String r3 = r3.f38684f
                        android.content.Context r0 = r0.f38690a
                        android.content.SharedPreferences r0 = com.google.firebase.crashlytics.a.c.g.a((android.content.Context) r0)
                        android.content.SharedPreferences$Editor r0 = r0.edit()
                        java.lang.String r4 = "existing_instance_identifier"
                        r0.putString(r4, r3)
                        r0.apply()
                        com.google.firebase.crashlytics.a.k.d r0 = com.google.firebase.crashlytics.a.k.d.this
                        java.util.concurrent.atomic.AtomicReference<com.google.firebase.crashlytics.a.k.a.e> r0 = r0.f38695f
                        r0.set(r2)
                        com.google.firebase.crashlytics.a.k.d r0 = com.google.firebase.crashlytics.a.k.d.this
                        java.util.concurrent.atomic.AtomicReference<com.google.android.gms.tasks.f<com.google.firebase.crashlytics.a.k.a.b>> r0 = r0.f38696g
                        java.lang.Object r0 = r0.get()
                        com.google.android.gms.tasks.f r0 = (com.google.android.gms.tasks.f) r0
                        com.google.firebase.crashlytics.a.k.a.b r3 = r2.f38673a
                        r0.b(r3)
                        com.google.android.gms.tasks.f r0 = new com.google.android.gms.tasks.f
                        r0.<init>()
                        com.google.firebase.crashlytics.a.k.a.b r2 = r2.f38673a
                        r0.b(r2)
                        com.google.firebase.crashlytics.a.k.d r2 = com.google.firebase.crashlytics.a.k.d.this
                        java.util.concurrent.atomic.AtomicReference<com.google.android.gms.tasks.f<com.google.firebase.crashlytics.a.k.a.b>> r2 = r2.f38696g
                        r2.set(r0)
                    L_0x0099:
                        com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.h.a(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.k.d.AnonymousClass1.a():com.google.android.gms.tasks.Task");
                }
            });
        }
        this.f38695f.set(a2);
        this.f38696g.get().b(a2.f38673a);
        return h.a(null);
    }

    private com.google.firebase.crashlytics.a.k.a.f a(c cVar) {
        com.google.firebase.crashlytics.a.k.a.f fVar = null;
        try {
            if (c.SKIP_CACHE_LOOKUP.equals(cVar)) {
                return null;
            }
            JSONObject b2 = this.f38693d.b();
            if (b2 != null) {
                com.google.firebase.crashlytics.a.k.a.f a2 = this.f38692c.a(b2);
                if (a2 != null) {
                    a(b2, "Loaded cached settings: ");
                    long a3 = this.f38697h.a();
                    if (!c.IGNORE_CACHE_EXPIRATION.equals(cVar)) {
                        if (a2.f38676d < a3) {
                            com.google.firebase.crashlytics.a.b.a().a(3);
                            return null;
                        }
                    }
                    try {
                        com.google.firebase.crashlytics.a.b.a().a(3);
                        return a2;
                    } catch (Exception unused) {
                        fVar = a2;
                        com.google.firebase.crashlytics.a.b.a().a(6);
                        return fVar;
                    }
                } else {
                    com.google.firebase.crashlytics.a.b.a().a(6);
                    return null;
                }
            } else {
                com.google.firebase.crashlytics.a.b.a().a(3);
                return null;
            }
        } catch (Exception unused2) {
            com.google.firebase.crashlytics.a.b.a().a(6);
            return fVar;
        }
    }

    static void a(JSONObject jSONObject, String str) throws JSONException {
        com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jSONObject.toString());
        a2.a(3);
    }

    private String c() {
        return com.google.firebase.crashlytics.a.c.g.a(this.f38690a).getString("existing_instance_identifier", "");
    }

    private boolean d() {
        return !c().equals(this.f38691b.f38684f);
    }
}
