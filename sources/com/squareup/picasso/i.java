package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sendbird.android.constant.StringSet;
import com.squareup.picasso.u;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

final class i {

    /* renamed from: a  reason: collision with root package name */
    final b f45414a = new b();

    /* renamed from: b  reason: collision with root package name */
    final Context f45415b;

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f45416c;

    /* renamed from: d  reason: collision with root package name */
    final j f45417d;

    /* renamed from: e  reason: collision with root package name */
    final Map<String, c> f45418e;

    /* renamed from: f  reason: collision with root package name */
    final Map<Object, a> f45419f;

    /* renamed from: g  reason: collision with root package name */
    final Map<Object, a> f45420g;

    /* renamed from: h  reason: collision with root package name */
    final Set<Object> f45421h;

    /* renamed from: i  reason: collision with root package name */
    final Handler f45422i;
    final Handler j;
    final d k;
    final ad l;
    final List<c> m;
    final c n;
    final boolean o;
    boolean p;

    i(Context context, ExecutorService executorService, Handler handler, j jVar, d dVar, ad adVar) {
        this.f45414a.start();
        ai.a(this.f45414a.getLooper());
        this.f45415b = context;
        this.f45416c = executorService;
        this.f45418e = new LinkedHashMap();
        this.f45419f = new WeakHashMap();
        this.f45420g = new WeakHashMap();
        this.f45421h = new LinkedHashSet();
        this.f45422i = new a(this.f45414a.getLooper(), this);
        this.f45417d = jVar;
        this.j = handler;
        this.k = dVar;
        this.l = adVar;
        this.m = new ArrayList(4);
        this.p = ai.c(this.f45415b);
        this.o = ai.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        c cVar = this.n;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (cVar.f45426a.o) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        cVar.f45426a.f45415b.registerReceiver(cVar, intentFilter);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        Handler handler = this.f45422i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        Handler handler = this.f45422i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(c cVar) {
        Handler handler = this.f45422i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, boolean z) {
        if (this.f45421h.contains(aVar.j)) {
            this.f45420g.put(aVar.b(), aVar);
            if (aVar.f45341a.n) {
                String a2 = aVar.f45342b.a();
                ai.a("Dispatcher", "paused", a2, "because tag '" + aVar.j + "' is paused");
                return;
            }
            return;
        }
        c cVar = this.f45418e.get(aVar.f45349i);
        if (cVar != null) {
            boolean z2 = cVar.f45394b.n;
            z zVar = aVar.f45342b;
            if (cVar.k == null) {
                cVar.k = aVar;
                if (!z2) {
                    return;
                }
                if (cVar.l == null || cVar.l.isEmpty()) {
                    ai.a("Hunter", StringSet.joined, zVar.a(), "to empty hunter");
                } else {
                    ai.a("Hunter", StringSet.joined, zVar.a(), ai.a(cVar, "to "));
                }
            } else {
                if (cVar.l == null) {
                    cVar.l = new ArrayList(3);
                }
                cVar.l.add(aVar);
                if (z2) {
                    ai.a("Hunter", StringSet.joined, zVar.a(), ai.a(cVar, "to "));
                }
                w.e eVar = aVar.f45342b.t;
                if (eVar.ordinal() > cVar.s.ordinal()) {
                    cVar.s = eVar;
                }
            }
        } else if (!this.f45416c.isShutdown()) {
            c a3 = c.a(aVar.f45341a, this, this.k, this.l, aVar);
            a3.n = this.f45416c.submit(a3);
            this.f45418e.put(aVar.f45349i, a3);
            if (z) {
                this.f45419f.remove(aVar.b());
            }
            if (aVar.f45341a.n) {
                ai.a("Dispatcher", "enqueued", aVar.f45342b.a());
            }
        } else if (aVar.f45341a.n) {
            ai.a("Dispatcher", "ignored", aVar.f45342b.a(), "because shut down");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj) {
        if (this.f45421h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<a> it2 = this.f45420g.values().iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next.j.equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it2.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(c cVar) {
        boolean z;
        if (!cVar.c()) {
            if (this.f45416c.isShutdown()) {
                a(cVar, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.o) {
                networkInfo = ((ConnectivityManager) ai.a(this.f45415b, "connectivity")).getActiveNetworkInfo();
            }
            boolean z2 = true;
            if (!(cVar.r > 0)) {
                z = false;
            } else {
                cVar.r--;
                z = cVar.j.a(networkInfo);
            }
            if (z) {
                if (cVar.f45394b.n) {
                    ai.a("Dispatcher", "retrying", ai.a(cVar));
                }
                if (cVar.p instanceof u.a) {
                    cVar.f45401i |= t.NO_CACHE.index;
                }
                cVar.n = this.f45416c.submit(cVar);
                return;
            }
            if (!this.o || !cVar.j.b()) {
                z2 = false;
            }
            a(cVar, z2);
            if (z2) {
                a aVar = cVar.k;
                if (aVar != null) {
                    c(aVar);
                }
                List<a> list = cVar.l;
                if (list != null) {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c(list.get(i2));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f45416c;
        if (executorService instanceof y) {
            y yVar = (y) executorService;
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                int type = networkInfo.getType();
                if (type == 0) {
                    int subtype = networkInfo.getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                            yVar.a(1);
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            yVar.a(2);
                            break;
                        default:
                            switch (subtype) {
                                case 12:
                                    break;
                                case 13:
                                case 14:
                                case 15:
                                    yVar.a(3);
                                    break;
                                default:
                                    yVar.a(3);
                                    break;
                            }
                            yVar.a(2);
                            break;
                    }
                } else if (type == 1 || type == 6 || type == 9) {
                    yVar.a(4);
                } else {
                    yVar.a(3);
                }
            } else {
                yVar.a(3);
            }
        }
        if (networkInfo != null && networkInfo.isConnected() && !this.f45419f.isEmpty()) {
            Iterator<a> it2 = this.f45419f.values().iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                it2.remove();
                if (next.f45341a.n) {
                    ai.a("Dispatcher", "replaying", next.f45342b.a());
                }
                a(next, false);
            }
        }
    }

    private void c(a aVar) {
        Object b2 = aVar.b();
        if (b2 != null) {
            aVar.k = true;
            this.f45419f.put(b2, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(c cVar) {
        if (!cVar.c()) {
            if (cVar.m != null) {
                cVar.m.prepareToDraw();
            }
            this.m.add(cVar);
            if (!this.f45422i.hasMessages(7)) {
                this.f45422i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    static void a(List<c> list) {
        if (!list.isEmpty() && list.get(0).f45394b.n) {
            StringBuilder sb = new StringBuilder();
            for (c next : list) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(ai.a(next));
            }
            ai.a("Dispatcher", "delivered", sb.toString());
        }
    }

    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final i f45423a;

        a(Looper looper, i iVar) {
            super(looper);
            this.f45423a = iVar;
        }

        public final void handleMessage(Message message) {
            final Message message2 = message;
            switch (message2.what) {
                case 1:
                    this.f45423a.a((a) message2.obj, true);
                    return;
                case 2:
                    a aVar = (a) message2.obj;
                    i iVar = this.f45423a;
                    String str = aVar.f45349i;
                    c cVar = iVar.f45418e.get(str);
                    if (cVar != null) {
                        cVar.a(aVar);
                        if (cVar.b()) {
                            iVar.f45418e.remove(str);
                            if (aVar.f45341a.n) {
                                ai.a("Dispatcher", "canceled", aVar.f45342b.a());
                            }
                        }
                    }
                    if (iVar.f45421h.contains(aVar.j)) {
                        iVar.f45420g.remove(aVar.b());
                        if (aVar.f45341a.n) {
                            ai.a("Dispatcher", "canceled", aVar.f45342b.a(), "because paused request got canceled");
                        }
                    }
                    a remove = iVar.f45419f.remove(aVar.b());
                    if (remove != null && remove.f45341a.n) {
                        ai.a("Dispatcher", "canceled", remove.f45342b.a(), "from replaying");
                        return;
                    }
                    return;
                case 4:
                    c cVar2 = (c) message2.obj;
                    i iVar2 = this.f45423a;
                    if (s.shouldWriteToMemoryCache(cVar2.f45400h)) {
                        iVar2.k.a(cVar2.f45398f, cVar2.m);
                    }
                    iVar2.f45418e.remove(cVar2.f45398f);
                    iVar2.c(cVar2);
                    if (cVar2.f45394b.n) {
                        ai.a("Dispatcher", "batched", ai.a(cVar2), "for completion");
                        return;
                    }
                    return;
                case 5:
                    this.f45423a.b((c) message2.obj);
                    return;
                case 6:
                    this.f45423a.a((c) message2.obj, false);
                    return;
                case 7:
                    i iVar3 = this.f45423a;
                    ArrayList arrayList = new ArrayList(iVar3.m);
                    iVar3.m.clear();
                    iVar3.j.sendMessage(iVar3.j.obtainMessage(8, arrayList));
                    i.a((List<c>) arrayList);
                    return;
                case 9:
                    this.f45423a.a((NetworkInfo) message2.obj);
                    return;
                case 10:
                    this.f45423a.p = message2.arg1 == 1;
                    return;
                case 11:
                    Object obj = message2.obj;
                    i iVar4 = this.f45423a;
                    if (iVar4.f45421h.add(obj)) {
                        Iterator<c> it2 = iVar4.f45418e.values().iterator();
                        while (it2.hasNext()) {
                            c next = it2.next();
                            boolean z = next.f45394b.n;
                            a aVar2 = next.k;
                            List<a> list = next.l;
                            boolean z2 = list != null && !list.isEmpty();
                            if (aVar2 != null || z2) {
                                if (aVar2 != null && aVar2.j.equals(obj)) {
                                    next.a(aVar2);
                                    iVar4.f45420g.put(aVar2.b(), aVar2);
                                    if (z) {
                                        ai.a("Dispatcher", "paused", aVar2.f45342b.a(), "because tag '" + obj + "' was paused");
                                    }
                                }
                                if (z2) {
                                    for (int size = list.size() - 1; size >= 0; size--) {
                                        a aVar3 = list.get(size);
                                        if (aVar3.j.equals(obj)) {
                                            next.a(aVar3);
                                            iVar4.f45420g.put(aVar3.b(), aVar3);
                                            if (z) {
                                                ai.a("Dispatcher", "paused", aVar3.f45342b.a(), "because tag '" + obj + "' was paused");
                                            }
                                        }
                                    }
                                }
                                if (next.b()) {
                                    it2.remove();
                                    if (z) {
                                        ai.a("Dispatcher", "canceled", ai.a(next), "all actions paused");
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                case 12:
                    this.f45423a.a(message2.obj);
                    return;
                default:
                    w.f45444a.post(new Runnable() {
                        public final void run() {
                            throw new AssertionError("Unknown handler message received: " + message2.what);
                        }
                    });
                    return;
            }
        }
    }

    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final i f45426a;

        c(i iVar) {
            this.f45426a = iVar;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        i iVar = this.f45426a;
                        iVar.f45422i.sendMessage(iVar.f45422i.obtainMessage(10, intent.getBooleanExtra("state", false) ? 1 : 0, 0));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    i iVar2 = this.f45426a;
                    iVar2.f45422i.sendMessage(iVar2.f45422i.obtainMessage(9, ((ConnectivityManager) ai.a(context, "connectivity")).getActiveNetworkInfo()));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(c cVar, boolean z) {
        if (cVar.f45394b.n) {
            String a2 = ai.a(cVar);
            StringBuilder sb = new StringBuilder("for error");
            sb.append(z ? " (will replay)" : "");
            ai.a("Dispatcher", "batched", a2, sb.toString());
        }
        this.f45418e.remove(cVar.f45398f);
        c(cVar);
    }
}
