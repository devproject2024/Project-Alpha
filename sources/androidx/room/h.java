package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.d;
import androidx.room.e;
import androidx.room.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

final class h {

    /* renamed from: a  reason: collision with root package name */
    final Context f4439a;

    /* renamed from: b  reason: collision with root package name */
    final String f4440b;

    /* renamed from: c  reason: collision with root package name */
    int f4441c;

    /* renamed from: d  reason: collision with root package name */
    final g f4442d;

    /* renamed from: e  reason: collision with root package name */
    final g.b f4443e;

    /* renamed from: f  reason: collision with root package name */
    e f4444f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f4445g;

    /* renamed from: h  reason: collision with root package name */
    final d f4446h = new d.a() {
        public final void a(final String[] strArr) {
            h.this.f4445g.execute(new Runnable() {
                public final void run() {
                    g gVar = h.this.f4442d;
                    String[] strArr = strArr;
                    synchronized (gVar.f4423g) {
                        Iterator<Map.Entry<g.b, g.c>> it2 = gVar.f4423g.iterator();
                        while (it2.hasNext()) {
                            Map.Entry next = it2.next();
                            if (!((g.b) next.getKey()).a()) {
                                g.c cVar = (g.c) next.getValue();
                                Set<String> set = null;
                                if (cVar.f4434b.length == 1) {
                                    int length = strArr.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length) {
                                            break;
                                        } else if (strArr[i2].equalsIgnoreCase(cVar.f4434b[0])) {
                                            set = cVar.f4436d;
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                } else {
                                    HashSet hashSet = new HashSet();
                                    for (String str : strArr) {
                                        String[] strArr2 = cVar.f4434b;
                                        int length2 = strArr2.length;
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= length2) {
                                                break;
                                            }
                                            String str2 = strArr2[i3];
                                            if (str2.equalsIgnoreCase(str)) {
                                                hashSet.add(str2);
                                                break;
                                            }
                                            i3++;
                                        }
                                    }
                                    if (hashSet.size() > 0) {
                                        set = hashSet;
                                    }
                                }
                                if (set != null) {
                                    cVar.f4435c.a(set);
                                }
                            }
                        }
                    }
                }
            });
        }
    };

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f4447i = new AtomicBoolean(false);
    final ServiceConnection j = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f4444f = e.a.a(iBinder);
            h.this.f4445g.execute(h.this.k);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            h.this.f4445g.execute(h.this.l);
            h.this.f4444f = null;
        }
    };
    final Runnable k = new Runnable() {
        public final void run() {
            try {
                e eVar = h.this.f4444f;
                if (eVar != null) {
                    h.this.f4441c = eVar.a(h.this.f4446h, h.this.f4440b);
                    h.this.f4442d.a(h.this.f4443e);
                }
            } catch (RemoteException unused) {
            }
        }
    };
    final Runnable l = new Runnable() {
        public final void run() {
            h.this.f4442d.c(h.this.f4443e);
        }
    };

    h(Context context, String str, g gVar, Executor executor) {
        this.f4439a = context.getApplicationContext();
        this.f4440b = str;
        this.f4442d = gVar;
        this.f4445g = executor;
        this.f4443e = new g.b((String[]) gVar.f4417a.keySet().toArray(new String[0])) {
            /* access modifiers changed from: package-private */
            public final boolean a() {
                return true;
            }

            public final void a(Set<String> set) {
                if (!h.this.f4447i.get()) {
                    try {
                        e eVar = h.this.f4444f;
                        if (eVar != null) {
                            eVar.a(h.this.f4441c, (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException unused) {
                    }
                }
            }
        };
        this.f4439a.bindService(new Intent(this.f4439a, MultiInstanceInvalidationService.class), this.j, 1);
    }
}
