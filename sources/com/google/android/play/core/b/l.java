package com.google.android.play.core.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.e.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l<T extends IInterface> {

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Handler> f37310f = new HashMap();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final b f37311a;

    /* renamed from: b  reason: collision with root package name */
    final String f37312b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final List<c> f37313c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    final WeakReference<g> f37314d;

    /* renamed from: e  reason: collision with root package name */
    public T f37315e;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f37316g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f37317h;

    /* renamed from: i  reason: collision with root package name */
    private final Intent f37318i;
    /* access modifiers changed from: private */
    public final h<T> j;
    private final IBinder.DeathRecipient k = new d(this);
    /* access modifiers changed from: private */
    public ServiceConnection l;

    public l(Context context, b bVar, String str, Intent intent, h<T> hVar) {
        this.f37316g = context;
        this.f37311a = bVar;
        this.f37312b = str;
        this.f37318i = intent;
        this.j = hVar;
        this.f37314d = new WeakReference<>((Object) null);
    }

    /* access modifiers changed from: private */
    public final void b(c cVar) {
        Handler handler;
        synchronized (f37310f) {
            if (!f37310f.containsKey(this.f37312b)) {
                HandlerThread handlerThread = new HandlerThread(this.f37312b, 10);
                handlerThread.start();
                f37310f.put(this.f37312b, new Handler(handlerThread.getLooper()));
            }
            handler = f37310f.get(this.f37312b);
        }
        handler.post(cVar);
    }

    static /* synthetic */ void f(l lVar) {
        lVar.f37311a.d("linkToDeath", new Object[0]);
        try {
            lVar.f37315e.asBinder().linkToDeath(lVar.k, 0);
        } catch (RemoteException unused) {
            lVar.f37311a.c("linkToDeath failed", new Object[0]);
        }
    }

    static /* synthetic */ void h(l lVar) {
        lVar.f37311a.d("unlinkToDeath", new Object[0]);
        lVar.f37315e.asBinder().unlinkToDeath(lVar.k, 0);
    }

    public final void a() {
        b((c) new f(this));
    }

    public final void a(c cVar) {
        b((c) new e(this, cVar.f37300g, cVar));
    }

    static /* synthetic */ void a(l lVar, c cVar) {
        if (lVar.f37315e == null && !lVar.f37317h) {
            lVar.f37311a.d("Initiate binding to the service.", new Object[0]);
            lVar.f37313c.add(cVar);
            lVar.l = new k(lVar);
            lVar.f37317h = true;
            if (!lVar.f37316g.bindService(lVar.f37318i, lVar.l, 1)) {
                lVar.f37311a.d("Failed to bind to the service.", new Object[0]);
                lVar.f37317h = false;
                List<c> list = lVar.f37313c;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    p<?> pVar = list.get(i2).f37300g;
                    if (pVar != null) {
                        pVar.b((Exception) new m());
                    }
                }
                lVar.f37313c.clear();
            }
        } else if (lVar.f37317h) {
            lVar.f37311a.d("Waiting to bind to the service.", new Object[0]);
            lVar.f37313c.add(cVar);
        } else {
            cVar.run();
        }
    }
}
