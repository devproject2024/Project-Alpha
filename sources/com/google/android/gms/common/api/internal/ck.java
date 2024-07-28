package com.google.android.gms.common.api.internal;

import androidx.a.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.b;
import com.google.android.gms.tasks.f;
import java.util.Map;

public final class ck {

    /* renamed from: a  reason: collision with root package name */
    final a<b<?>, ConnectionResult> f8522a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    final f<Map<b<?>, String>> f8523b = new f<>();

    /* renamed from: c  reason: collision with root package name */
    private final a<b<?>, String> f8524c = new a<>();

    /* renamed from: d  reason: collision with root package name */
    private int f8525d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8526e = false;

    public ck(Iterable<? extends com.google.android.gms.common.api.f<?>> iterable) {
        for (com.google.android.gms.common.api.f apiKey : iterable) {
            this.f8522a.put(apiKey.getApiKey(), null);
        }
        this.f8525d = this.f8522a.keySet().size();
    }

    public final void a(b<?> bVar, ConnectionResult connectionResult, String str) {
        this.f8522a.put(bVar, connectionResult);
        this.f8524c.put(bVar, str);
        this.f8525d--;
        if (!connectionResult.b()) {
            this.f8526e = true;
        }
        if (this.f8525d != 0) {
            return;
        }
        if (this.f8526e) {
            this.f8523b.a((Exception) new b(this.f8522a));
            return;
        }
        this.f8523b.a(this.f8524c);
    }
}
