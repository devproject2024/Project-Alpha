package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.a.a;
import com.google.firebase.remoteconfig.internal.f;
import com.google.firebase.remoteconfig.internal.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;

final /* synthetic */ class q implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.internal.q f39444a;

    private q(com.google.firebase.remoteconfig.internal.q qVar) {
        this.f39444a = qVar;
    }

    public static Callable a(com.google.firebase.remoteconfig.internal.q qVar) {
        return new q(qVar);
    }

    public final Object call() {
        com.google.firebase.remoteconfig.internal.q qVar = this.f39444a;
        boolean z = true;
        if (qVar.f39422b.getBoolean("save_legacy_configs", true)) {
            a.g a2 = qVar.a();
            HashMap hashMap = new HashMap();
            if (a2 != null) {
                Map<String, f> a3 = com.google.firebase.remoteconfig.internal.q.a(a2.f39331b == null ? a.C0659a.a() : a2.f39331b);
                Map<String, f> a4 = com.google.firebase.remoteconfig.internal.q.a(a2.f39330a == null ? a.C0659a.a() : a2.f39330a);
                Map<String, f> a5 = com.google.firebase.remoteconfig.internal.q.a(a2.f39332c == null ? a.C0659a.a() : a2.f39332c);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.addAll(a3.keySet());
                hashSet.addAll(a4.keySet());
                hashSet.addAll(a5.keySet());
                for (String str : hashSet) {
                    q.a aVar = new q.a((byte) 0);
                    if (a3.containsKey(str)) {
                        aVar.f39426b = a3.get(str);
                    }
                    if (a4.containsKey(str)) {
                        aVar.f39425a = a4.get(str);
                    }
                    if (a5.containsKey(str)) {
                        aVar.f39427c = a5.get(str);
                    }
                    hashMap.put(str, aVar);
                }
            }
            qVar.a((Map<String, q.a>) hashMap);
            qVar.f39422b.edit().putBoolean("save_legacy_configs", false).commit();
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
