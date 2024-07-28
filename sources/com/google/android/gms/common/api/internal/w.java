package com.google.android.gms.common.api.internal;

import androidx.a.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import java.util.Collections;
import java.util.Map;

final class w implements c<Map<b<?>, String>> {

    /* renamed from: a  reason: collision with root package name */
    private q f8633a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ cw f8634b;

    w(cw cwVar, q qVar) {
        this.f8634b = cwVar;
        this.f8633a = qVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f8633a.a();
    }

    public final void a(Task<Map<b<?>, String>> task) {
        this.f8634b.f8555d.lock();
        try {
            if (!this.f8634b.f8558g) {
                this.f8633a.a();
                return;
            }
            if (task.b()) {
                this.f8634b.f8560i = new a(this.f8634b.f8553b.size());
                for (cx<?> apiKey : this.f8634b.f8553b.values()) {
                    this.f8634b.f8560i.put(apiKey.getApiKey(), ConnectionResult.f8333a);
                }
            } else if (task.e() instanceof b) {
                b bVar = (b) task.e();
                if (this.f8634b.f8557f) {
                    this.f8634b.f8560i = new a(this.f8634b.f8553b.size());
                    for (cx next : this.f8634b.f8553b.values()) {
                        b apiKey2 = next.getApiKey();
                        ConnectionResult connectionResult = bVar.getConnectionResult((d<? extends a.d>) next);
                        if (this.f8634b.a(next, connectionResult)) {
                            this.f8634b.f8560i.put(apiKey2, new ConnectionResult(16));
                        } else {
                            this.f8634b.f8560i.put(apiKey2, connectionResult);
                        }
                    }
                } else {
                    this.f8634b.f8560i = bVar.zaj();
                }
            } else {
                this.f8634b.f8560i = Collections.emptyMap();
            }
            if (this.f8634b.d()) {
                this.f8634b.f8559h.putAll(this.f8634b.f8560i);
                if (this.f8634b.i() == null) {
                    this.f8634b.c();
                    this.f8634b.h();
                    this.f8634b.f8556e.signalAll();
                }
            }
            this.f8633a.a();
            this.f8634b.f8555d.unlock();
        } finally {
            this.f8634b.f8555d.unlock();
        }
    }
}
