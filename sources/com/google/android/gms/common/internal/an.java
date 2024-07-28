package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.stats.a;
import java.util.HashMap;
import java.util.Map;

final class an implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final Map<ServiceConnection, ServiceConnection> f8768a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    int f8769b = 2;

    /* renamed from: c  reason: collision with root package name */
    boolean f8770c;

    /* renamed from: d  reason: collision with root package name */
    IBinder f8771d;

    /* renamed from: e  reason: collision with root package name */
    final i.a f8772e;

    /* renamed from: f  reason: collision with root package name */
    ComponentName f8773f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ ao f8774g;

    public an(ao aoVar, i.a aVar) {
        this.f8774g = aoVar;
        this.f8772e = aVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f8774g.f8775a) {
            this.f8774g.f8777c.removeMessages(1, this.f8772e);
            this.f8771d = iBinder;
            this.f8773f = componentName;
            for (ServiceConnection onServiceConnected : this.f8768a.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f8769b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f8774g.f8775a) {
            this.f8774g.f8777c.removeMessages(1, this.f8772e);
            this.f8771d = null;
            this.f8773f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f8768a.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f8769b = 2;
        }
    }

    public final void a() {
        this.f8769b = 3;
        a unused = this.f8774g.f8778d;
        this.f8770c = a.a(this.f8774g.f8776b, this.f8772e.a(this.f8774g.f8776b), this, this.f8772e.f8853c);
        if (this.f8770c) {
            this.f8774g.f8777c.sendMessageDelayed(this.f8774g.f8777c.obtainMessage(1, this.f8772e), this.f8774g.f8780f);
            return;
        }
        this.f8769b = 2;
        try {
            a unused2 = this.f8774g.f8778d;
            a.a(this.f8774g.f8776b, this);
        } catch (IllegalArgumentException unused3) {
        }
    }

    public final void a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2) {
        a unused = this.f8774g.f8778d;
        Context unused2 = this.f8774g.f8776b;
        this.f8772e.a(this.f8774g.f8776b);
        this.f8768a.put(serviceConnection, serviceConnection2);
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f8768a.containsKey(serviceConnection);
    }

    public final boolean b() {
        return this.f8768a.isEmpty();
    }
}
