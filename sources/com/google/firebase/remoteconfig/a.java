package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.c;
import com.google.firebase.remoteconfig.internal.f;
import com.google.firebase.remoteconfig.internal.g;
import com.google.firebase.remoteconfig.internal.l;
import com.google.firebase.remoteconfig.internal.m;
import com.google.firebase.remoteconfig.internal.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f39305a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public final Executor f39306b;

    /* renamed from: c  reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.a f39307c;

    /* renamed from: d  reason: collision with root package name */
    public final com.google.firebase.remoteconfig.internal.a f39308d;

    /* renamed from: e  reason: collision with root package name */
    final com.google.firebase.remoteconfig.internal.a f39309e;

    /* renamed from: f  reason: collision with root package name */
    public final m f39310f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f39311g;

    /* renamed from: h  reason: collision with root package name */
    private final c f39312h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.firebase.abt.c f39313i;
    private final g j;
    private final l k;
    private final com.google.firebase.installations.g l;

    public static a a() {
        return ((o) c.e().a(o.class)).a("firebase");
    }

    a(Context context, c cVar, com.google.firebase.installations.g gVar, com.google.firebase.abt.c cVar2, Executor executor, com.google.firebase.remoteconfig.internal.a aVar, com.google.firebase.remoteconfig.internal.a aVar2, com.google.firebase.remoteconfig.internal.a aVar3, g gVar2, l lVar, m mVar) {
        this.f39311g = context;
        this.f39312h = cVar;
        this.l = gVar;
        this.f39313i = cVar2;
        this.f39306b = executor;
        this.f39307c = aVar;
        this.f39308d = aVar2;
        this.f39309e = aVar3;
        this.j = gVar2;
        this.k = lVar;
        this.f39310f = mVar;
    }

    static /* synthetic */ void a(a aVar, f fVar) {
        aVar.f39307c.c();
        aVar.a(fVar.f39370c);
    }

    static /* synthetic */ Task a(a aVar, Task task, Task task2) throws Exception {
        if (!task.b() || task.d() == null) {
            return h.a(Boolean.FALSE);
        }
        f fVar = (f) task.d();
        if (!task2.b() || a(fVar, (f) task2.d())) {
            return aVar.f39308d.a(fVar, true).a(aVar.f39306b, new c(aVar));
        }
        return h.a(Boolean.FALSE);
    }

    public final Task<Void> b() {
        return this.j.a().a(f.a());
    }

    public final String a(String str) {
        return this.k.a(str);
    }

    public final boolean b(String str) {
        l lVar = this.k;
        String a2 = l.a(lVar.f39400d, str);
        if (a2 != null) {
            if (l.f39398b.matcher(a2).matches()) {
                return true;
            }
            if (l.f39399c.matcher(a2).matches()) {
                return false;
            }
        }
        String a3 = l.a(lVar.f39401e, str);
        if (a3 != null) {
            if (l.f39398b.matcher(a3).matches()) {
                return true;
            }
            if (l.f39399c.matcher(a3).matches()) {
                return false;
            }
        }
        l.a(str, "Boolean");
        return false;
    }

    public final long c(String str) {
        l lVar = this.k;
        Long b2 = l.b(lVar.f39400d, str);
        if (b2 != null) {
            return b2.longValue();
        }
        Long b3 = l.b(lVar.f39401e, str);
        if (b3 != null) {
            return b3.longValue();
        }
        l.a(str, "Long");
        return 0;
    }

    public final Map<String, Object> c() {
        p pVar;
        l lVar = this.k;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(l.a(lVar.f39400d));
        hashSet.addAll(l.a(lVar.f39401e));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            String a2 = l.a(lVar.f39400d, str);
            if (a2 != null) {
                pVar = new p(a2, 2);
            } else {
                String a3 = l.a(lVar.f39401e, str);
                if (a3 != null) {
                    pVar = new p(a3, 1);
                } else {
                    l.a(str, "FirebaseRemoteConfigValue");
                    pVar = new p("", 0);
                }
            }
            hashMap.put(str, pVar);
        }
        return hashMap;
    }

    static /* synthetic */ Void a(a aVar, n nVar) throws Exception {
        m mVar = aVar.f39310f;
        synchronized (mVar.f39405d) {
            mVar.f39404c.edit().putBoolean("is_developer_mode_enabled", nVar.f39428a).putLong("fetch_timeout_in_seconds", nVar.f39429b).putLong("minimum_fetch_interval_in_seconds", nVar.f39430c).commit();
        }
        return null;
    }

    public final Task<Void> a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof byte[]) {
                hashMap.put((String) next.getKey(), new String((byte[]) value));
            } else {
                hashMap.put((String) next.getKey(), value.toString());
            }
        }
        return b((Map<String, String>) hashMap);
    }

    /* access modifiers changed from: private */
    public boolean a(Task<f> task) {
        if (!task.b()) {
            return false;
        }
        this.f39307c.c();
        if (task.d() == null) {
            return true;
        }
        a(task.d().f39370c);
        return true;
    }

    private Task<Void> b(Map<String, String> map) {
        try {
            return this.f39309e.a(f.a().a(map).a(), true).a(b.a());
        } catch (JSONException unused) {
            return h.a(null);
        }
    }

    private void a(JSONArray jSONArray) {
        if (this.f39313i != null) {
            try {
                this.f39313i.a(b(jSONArray));
            } catch (com.google.firebase.abt.a | JSONException unused) {
            }
        }
    }

    private static List<Map<String, String>> b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public static boolean a(f fVar, f fVar2) {
        return fVar2 == null || !fVar.f39369b.equals(fVar2.f39369b);
    }
}
