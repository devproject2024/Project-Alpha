package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.stats.a;
import com.google.android.gms.internal.d.h;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

final class ao extends i implements Handler.Callback {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<i.a, an> f8775a = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f8776b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Handler f8777c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f8778d;

    /* renamed from: e  reason: collision with root package name */
    private final long f8779e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final long f8780f;

    ao(Context context) {
        this.f8776b = context.getApplicationContext();
        this.f8777c = new h(context.getMainLooper(), this);
        this.f8778d = a.a();
        this.f8779e = 5000;
        this.f8780f = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean a(i.a aVar, ServiceConnection serviceConnection) {
        boolean z;
        s.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f8775a) {
            an anVar = this.f8775a.get(aVar);
            if (anVar == null) {
                anVar = new an(this, aVar);
                anVar.a(serviceConnection, serviceConnection);
                anVar.a();
                this.f8775a.put(aVar, anVar);
            } else {
                this.f8777c.removeMessages(0, aVar);
                if (!anVar.a(serviceConnection)) {
                    anVar.a(serviceConnection, serviceConnection);
                    int i2 = anVar.f8769b;
                    if (i2 == 1) {
                        serviceConnection.onServiceConnected(anVar.f8773f, anVar.f8771d);
                    } else if (i2 == 2) {
                        anVar.a();
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = anVar.f8770c;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public final void b(i.a aVar, ServiceConnection serviceConnection) {
        s.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f8775a) {
            an anVar = this.f8775a.get(aVar);
            if (anVar == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (anVar.a(serviceConnection)) {
                anVar.f8768a.remove(serviceConnection);
                if (anVar.b()) {
                    this.f8777c.sendMessageDelayed(this.f8777c.obtainMessage(0, aVar), this.f8779e);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f8775a) {
                i.a aVar = (i.a) message.obj;
                an anVar = this.f8775a.get(aVar);
                if (anVar != null && anVar.b()) {
                    if (anVar.f8770c) {
                        anVar.f8774g.f8777c.removeMessages(1, anVar.f8772e);
                        a.a(anVar.f8774g.f8776b, anVar);
                        anVar.f8770c = false;
                        anVar.f8769b = 2;
                    }
                    this.f8775a.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f8775a) {
                i.a aVar2 = (i.a) message.obj;
                an anVar2 = this.f8775a.get(aVar2);
                if (anVar2 != null && anVar2.f8769b == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    new Exception();
                    ComponentName componentName = anVar2.f8773f;
                    if (componentName == null) {
                        componentName = aVar2.f8852b;
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(aVar2.f8851a, SDKConstants.UNKNOWN);
                    }
                    anVar2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
