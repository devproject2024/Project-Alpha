package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.base.k;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class h implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final a f8838a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<e.b> f8839b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<e.b> f8840c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<e.c> f8841d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f8842e = false;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f8843f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    public boolean f8844g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f8845h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f8846i = new Object();

    public interface a {
        boolean g();
    }

    public h(Looper looper, a aVar) {
        this.f8838a = aVar;
        this.f8845h = new k(looper, this);
    }

    public final void a() {
        this.f8842e = false;
        this.f8843f.incrementAndGet();
    }

    public final void a(e.b bVar) {
        s.a(bVar);
        synchronized (this.f8846i) {
            if (this.f8839b.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
            } else {
                this.f8839b.add(bVar);
            }
        }
        if (this.f8838a.g()) {
            Handler handler = this.f8845h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void a(e.c cVar) {
        s.a(cVar);
        synchronized (this.f8846i) {
            if (this.f8841d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
            } else {
                this.f8841d.add(cVar);
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            e.b bVar = (e.b) message.obj;
            synchronized (this.f8846i) {
                if (this.f8842e && this.f8838a.g() && this.f8839b.contains(bVar)) {
                    bVar.onConnected((Bundle) null);
                }
            }
            return true;
        }
        int i2 = message.what;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i2);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }
}
