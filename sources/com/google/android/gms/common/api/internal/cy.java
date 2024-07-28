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

final class cy implements c<Map<b<?>, String>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ cw f8565a;

    private cy(cw cwVar) {
        this.f8565a = cwVar;
    }

    public final void a(Task<Map<b<?>, String>> task) {
        this.f8565a.f8555d.lock();
        try {
            if (this.f8565a.f8558g) {
                if (task.b()) {
                    this.f8565a.f8559h = new a(this.f8565a.f8552a.size());
                    for (cx<?> apiKey : this.f8565a.f8552a.values()) {
                        this.f8565a.f8559h.put(apiKey.getApiKey(), ConnectionResult.f8333a);
                    }
                } else if (task.e() instanceof b) {
                    b bVar = (b) task.e();
                    if (this.f8565a.f8557f) {
                        this.f8565a.f8559h = new a(this.f8565a.f8552a.size());
                        for (cx next : this.f8565a.f8552a.values()) {
                            b apiKey2 = next.getApiKey();
                            ConnectionResult connectionResult = bVar.getConnectionResult((d<? extends a.d>) next);
                            if (this.f8565a.a(next, connectionResult)) {
                                this.f8565a.f8559h.put(apiKey2, new ConnectionResult(16));
                            } else {
                                this.f8565a.f8559h.put(apiKey2, connectionResult);
                            }
                        }
                    } else {
                        this.f8565a.f8559h = bVar.zaj();
                    }
                    this.f8565a.j = this.f8565a.i();
                } else {
                    this.f8565a.f8559h = Collections.emptyMap();
                    this.f8565a.j = new ConnectionResult(8);
                }
                if (this.f8565a.f8560i != null) {
                    this.f8565a.f8559h.putAll(this.f8565a.f8560i);
                    this.f8565a.j = this.f8565a.i();
                }
                if (this.f8565a.j == null) {
                    this.f8565a.c();
                    this.f8565a.h();
                } else {
                    this.f8565a.f8558g = false;
                    this.f8565a.f8554c.a(this.f8565a.j);
                }
                this.f8565a.f8556e.signalAll();
                this.f8565a.f8555d.unlock();
            }
        } finally {
            this.f8565a.f8555d.unlock();
        }
    }

    /* synthetic */ cy(cw cwVar, byte b2) {
        this(cwVar);
    }
}
