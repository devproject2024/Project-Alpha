package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.d.n;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.o;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.f;
import com.google.firebase.components.h;
import com.google.firebase.components.i;
import com.google.firebase.components.t;
import com.google.firebase.e.e;
import com.google.firebase.e.g;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, c> f38071a = new androidx.a.a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Object f38072b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f38073c = new b((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private final Context f38074d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38075e;

    /* renamed from: f  reason: collision with root package name */
    private final g f38076f;

    /* renamed from: g  reason: collision with root package name */
    private final i f38077g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f38078h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f38079i = new AtomicBoolean();
    private final t<com.google.firebase.d.a> j;
    private final List<Object> k = new CopyOnWriteArrayList();
    private final List<Object> l = new CopyOnWriteArrayList();

    public final Context a() {
        j();
        return this.f38074d;
    }

    public final String b() {
        j();
        return this.f38075e;
    }

    public final g c() {
        j();
        return this.f38076f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f38075e.equals(((c) obj).b());
    }

    public int hashCode() {
        return this.f38075e.hashCode();
    }

    public String toString() {
        return q.a((Object) this).a("name", this.f38075e).a("options", this.f38076f).toString();
    }

    public static List<c> d() {
        ArrayList arrayList;
        synchronized (f38072b) {
            arrayList = new ArrayList(f38071a.values());
        }
        return arrayList;
    }

    public static c e() {
        c cVar;
        synchronized (f38072b) {
            cVar = f38071a.get("[DEFAULT]");
            if (cVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + o.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return cVar;
    }

    public static c a(String str) {
        c cVar;
        String str2;
        synchronized (f38072b) {
            cVar = f38071a.get(str.trim());
            if (cVar == null) {
                List<String> k2 = k();
                if (k2.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", k2);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return cVar;
    }

    public static c a(Context context) {
        synchronized (f38072b) {
            if (f38071a.containsKey("[DEFAULT]")) {
                c e2 = e();
                return e2;
            }
            g a2 = g.a(context);
            if (a2 == null) {
                return null;
            }
            c a3 = a(context, a2, "[DEFAULT]");
            return a3;
        }
    }

    public static c a(Context context, g gVar, String str) {
        c cVar;
        a.a(context);
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f38072b) {
            boolean z = !f38071a.containsKey(trim);
            s.a(z, (Object) "FirebaseApp name " + trim + " already exists!");
            s.a(context, (Object) "Application context cannot be null.");
            cVar = new c(context, trim, gVar);
            f38071a.put(trim, cVar);
        }
        cVar.l();
        return cVar;
    }

    public final <T> T a(Class<T> cls) {
        j();
        return this.f38077g.a((Class) cls);
    }

    public final boolean f() {
        j();
        return this.j.a().f38722a.get();
    }

    private c(Context context, String str, g gVar) {
        this.f38074d = (Context) s.a(context);
        this.f38075e = s.a(str);
        this.f38076f = (g) s.a(gVar);
        f fVar = new f(context, new f.a(ComponentDiscoveryService.class, (byte) 0));
        List<h> a2 = f.a(fVar.f38099b.a(fVar.f38098a));
        String a3 = e.a();
        Executor executor = f38073c;
        com.google.firebase.components.b[] bVarArr = new com.google.firebase.components.b[8];
        bVarArr[0] = com.google.firebase.components.b.a(context, Context.class, new Class[0]);
        bVarArr[1] = com.google.firebase.components.b.a(this, c.class, new Class[0]);
        bVarArr[2] = com.google.firebase.components.b.a(gVar, g.class, new Class[0]);
        bVarArr[3] = g.a("fire-android", "");
        bVarArr[4] = g.a("fire-core", "19.3.0");
        bVarArr[5] = a3 != null ? g.a("kotlin", a3) : null;
        bVarArr[6] = com.google.firebase.e.b.b();
        bVarArr[7] = com.google.firebase.b.a.a();
        this.f38077g = new i(executor, a2, bVarArr);
        this.j = new t<>(new d(this, context));
    }

    static /* synthetic */ com.google.firebase.d.a a(c cVar, Context context) {
        return new com.google.firebase.d.a(context, cVar.h(), (com.google.firebase.a.c) cVar.f38077g.a(com.google.firebase.a.c.class));
    }

    private void j() {
        s.a(!this.f38079i.get(), (Object) "FirebaseApp was deleted");
    }

    public final boolean g() {
        return "[DEFAULT]".equals(b());
    }

    public final String h() {
        return com.google.android.gms.common.util.c.c(b().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.c.c(c().f38755b.getBytes(Charset.defaultCharset()));
    }

    private static List<String> k() {
        ArrayList arrayList = new ArrayList();
        synchronized (f38072b) {
            for (c b2 : f38071a.values()) {
                arrayList.add(b2.b());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!n.a(this.f38074d)) {
            C0627c.a(this.f38074d);
        } else {
            this.f38077g.a(g());
        }
    }

    /* renamed from: com.google.firebase.c$c  reason: collision with other inner class name */
    static class C0627c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<C0627c> f38082a = new AtomicReference<>();

        /* renamed from: b  reason: collision with root package name */
        private final Context f38083b;

        private C0627c(Context context) {
            this.f38083b = context;
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (c.f38072b) {
                for (c a2 : c.f38071a.values()) {
                    a2.l();
                }
            }
            this.f38083b.unregisterReceiver(this);
        }

        static /* synthetic */ void a(Context context) {
            if (f38082a.get() == null) {
                C0627c cVar = new C0627c(context);
                if (f38082a.compareAndSet((Object) null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
    }

    static class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<a> f38080a = new AtomicReference<>();

        private a() {
        }

        public final void a(boolean z) {
            synchronized (c.f38072b) {
                Iterator it2 = new ArrayList(c.f38071a.values()).iterator();
                while (it2.hasNext()) {
                    c cVar = (c) it2.next();
                    if (cVar.f38078h.get()) {
                        c.c(cVar);
                    }
                }
            }
        }

        static /* synthetic */ void a(Context context) {
            if (context.getApplicationContext() instanceof Application) {
                Application application = (Application) context.getApplicationContext();
                if (f38080a.get() == null) {
                    a aVar = new a();
                    if (f38080a.compareAndSet((Object) null, aVar)) {
                        com.google.android.gms.common.api.internal.c.a(application);
                        com.google.android.gms.common.api.internal.c.a().a((c.a) aVar);
                    }
                }
            }
        }
    }

    static class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private static final Handler f38081a = new Handler(Looper.getMainLooper());

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void execute(Runnable runnable) {
            f38081a.post(runnable);
        }
    }

    static /* synthetic */ void c(c cVar) {
        Iterator<Object> it2 = cVar.k.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }
}
