package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.b;
import androidx.work.h;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.k;
import androidx.work.impl.utils.a.c;
import androidx.work.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public final class d implements b, androidx.work.impl.foreground.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5298a = l.a("Processor");

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f5299b;

    /* renamed from: c  reason: collision with root package name */
    private Context f5300c;

    /* renamed from: d  reason: collision with root package name */
    private b f5301d;

    /* renamed from: e  reason: collision with root package name */
    private androidx.work.impl.utils.b.a f5302e;

    /* renamed from: f  reason: collision with root package name */
    private WorkDatabase f5303f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, k> f5304g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Map<String, k> f5305h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private List<e> f5306i;
    private Set<String> j;
    private final List<b> k;
    private final Object l;

    public d(Context context, b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.f5300c = context;
        this.f5301d = bVar;
        this.f5302e = aVar;
        this.f5303f = workDatabase;
        this.f5306i = list;
        this.j = new HashSet();
        this.k = new ArrayList();
        this.f5299b = null;
        this.l = new Object();
    }

    public final boolean a(String str, WorkerParameters.a aVar) {
        synchronized (this.l) {
            if (f(str)) {
                l.a();
                String.format("Work %s is already enqueued for processing", new Object[]{str});
                return false;
            }
            k.a aVar2 = new k.a(this.f5300c, this.f5301d, this.f5302e, this, this.f5303f, str);
            aVar2.f5390h = this.f5306i;
            if (aVar != null) {
                aVar2.f5391i = aVar;
            }
            k kVar = new k(aVar2);
            c<Boolean> cVar = kVar.f5374f;
            cVar.a(new a(this, str, cVar), this.f5302e.a());
            this.f5305h.put(str, kVar);
            this.f5302e.b().execute(kVar);
            l.a();
            String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str});
            return true;
        }
    }

    public final void a(String str, h hVar) {
        synchronized (this.l) {
            l.a();
            String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str});
            k remove = this.f5305h.remove(str);
            if (remove != null) {
                if (this.f5299b == null) {
                    this.f5299b = androidx.work.impl.utils.k.a(this.f5300c, "ProcessorForegroundLck");
                    this.f5299b.acquire();
                }
                this.f5304g.put(str, remove);
                androidx.core.content.b.a(this.f5300c, androidx.work.impl.foreground.b.a(this.f5300c, str, hVar));
            }
        }
    }

    public final boolean a(String str) {
        boolean a2;
        synchronized (this.l) {
            l.a();
            String.format("Processor stopping foreground work %s", new Object[]{str});
            a2 = a(str, this.f5304g.remove(str));
        }
        return a2;
    }

    public final boolean b(String str) {
        boolean a2;
        synchronized (this.l) {
            l.a();
            String.format("Processor stopping background work %s", new Object[]{str});
            a2 = a(str, this.f5305h.remove(str));
        }
        return a2;
    }

    public final boolean c(String str) {
        boolean a2;
        synchronized (this.l) {
            l.a();
            boolean z = true;
            String.format("Processor cancelling %s", new Object[]{str});
            this.j.add(str);
            k remove = this.f5304g.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = this.f5305h.remove(str);
            }
            a2 = a(str, remove);
            if (z) {
                a();
            }
        }
        return a2;
    }

    public final void d(String str) {
        synchronized (this.l) {
            this.f5304g.remove(str);
            a();
        }
    }

    public final boolean e(String str) {
        boolean contains;
        synchronized (this.l) {
            contains = this.j.contains(str);
        }
        return contains;
    }

    public final boolean f(String str) {
        boolean z;
        synchronized (this.l) {
            if (!this.f5305h.containsKey(str)) {
                if (!this.f5304g.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final boolean g(String str) {
        boolean containsKey;
        synchronized (this.l) {
            containsKey = this.f5304g.containsKey(str);
        }
        return containsKey;
    }

    public final void a(b bVar) {
        synchronized (this.l) {
            this.k.add(bVar);
        }
    }

    public final void b(b bVar) {
        synchronized (this.l) {
            this.k.remove(bVar);
        }
    }

    public final void a(String str, boolean z) {
        synchronized (this.l) {
            this.f5305h.remove(str);
            l.a();
            String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z)});
            for (b a2 : this.k) {
                a2.a(str, z);
            }
        }
    }

    private void a() {
        synchronized (this.l) {
            if (!(!this.f5304g.isEmpty())) {
                SystemForegroundService c2 = SystemForegroundService.c();
                if (c2 != null) {
                    l.a();
                    c2.b();
                } else {
                    l.a();
                }
                if (this.f5299b != null) {
                    this.f5299b.release();
                    this.f5299b = null;
                }
            }
        }
    }

    private static boolean a(String str, k kVar) {
        if (kVar != null) {
            kVar.b();
            l.a();
            String.format("WorkerWrapper interrupted for %s", new Object[]{str});
            return true;
        }
        l.a();
        String.format("WorkerWrapper could not be found for %s", new Object[]{str});
        return false;
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private b f5307a;

        /* renamed from: b  reason: collision with root package name */
        private String f5308b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.b.a.a.a<Boolean> f5309c;

        a(b bVar, String str, com.google.b.a.a.a<Boolean> aVar) {
            this.f5307a = bVar;
            this.f5308b = str;
            this.f5309c = aVar;
        }

        public final void run() {
            boolean z;
            try {
                z = ((Boolean) this.f5309c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f5307a.a(this.f5308b, z);
        }
    }
}
