package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.work.R;
import androidx.work.WorkerParameters;
import androidx.work.b;
import androidx.work.g;
import androidx.work.impl.b.p;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.b.a;
import androidx.work.impl.utils.f;
import androidx.work.impl.utils.h;
import androidx.work.impl.utils.i;
import androidx.work.l;
import androidx.work.n;
import androidx.work.o;
import androidx.work.t;
import androidx.work.u;
import androidx.work.v;
import androidx.work.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class j extends v {
    private static j j;
    private static j k;
    private static final Object l = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f5359a;

    /* renamed from: b  reason: collision with root package name */
    public b f5360b;

    /* renamed from: c  reason: collision with root package name */
    public WorkDatabase f5361c;

    /* renamed from: d  reason: collision with root package name */
    public a f5362d;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f5363e;

    /* renamed from: f  reason: collision with root package name */
    public d f5364f;

    /* renamed from: g  reason: collision with root package name */
    public f f5365g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5366h;

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver.PendingResult f5367i;

    @Deprecated
    public static j c() {
        synchronized (l) {
            if (j != null) {
                j jVar = j;
                return jVar;
            }
            j jVar2 = k;
            return jVar2;
        }
    }

    public static j b(Context context) {
        j c2;
        synchronized (l) {
            c2 = c();
            if (c2 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof b.C0077b) {
                    a(applicationContext, ((b.C0077b) applicationContext).a());
                    c2 = b(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return c2;
    }

    public static void a(Context context, b bVar) {
        synchronized (l) {
            if (j != null) {
                if (k != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (j == null) {
                Context applicationContext = context.getApplicationContext();
                if (k == null) {
                    k = new j(applicationContext, bVar, new androidx.work.impl.utils.b.b(bVar.f5055b));
                }
                j = k;
            }
        }
    }

    private j(Context context, b bVar, a aVar) {
        this(context, bVar, aVar, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    private j(Context context, b bVar, a aVar, boolean z) {
        this(context, bVar, aVar, WorkDatabase.a(context.getApplicationContext(), aVar.b(), z));
    }

    private j(Context context, b bVar, a aVar, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        l.a((l) new l.a(bVar.f5059f));
        List<e> asList = Arrays.asList(new e[]{f.a(applicationContext, this), new androidx.work.impl.background.a.b(applicationContext, bVar, aVar, this)});
        d dVar = new d(context, bVar, aVar, workDatabase, asList);
        Context applicationContext2 = context.getApplicationContext();
        this.f5359a = applicationContext2;
        this.f5360b = bVar;
        this.f5362d = aVar;
        this.f5361c = workDatabase;
        this.f5363e = asList;
        this.f5364f = dVar;
        this.f5365g = new f(workDatabase);
        this.f5366h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext2.isDeviceProtectedStorage()) {
            this.f5362d.a(new ForceStopRunnable(applicationContext2, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public final o a(List<? extends w> list) {
        if (!list.isEmpty()) {
            return new g(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public final t b(List<n> list) {
        if (!list.isEmpty()) {
            return new g(this, list);
        }
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    public final o a(String str, g gVar, List<n> list) {
        return new g(this, str, gVar, list).a();
    }

    public final o a(String str) {
        androidx.work.impl.utils.a a2 = androidx.work.impl.utils.a.a(str, this);
        this.f5362d.a(a2);
        return a2.f5397a;
    }

    public final o b(String str) {
        androidx.work.impl.utils.a a2 = androidx.work.impl.utils.a.a(str, this, true);
        this.f5362d.a(a2);
        return a2.f5397a;
    }

    public final o b() {
        androidx.work.impl.utils.a b2 = androidx.work.impl.utils.a.b(this);
        this.f5362d.a(b2);
        return b2.f5397a;
    }

    public final LiveData<u> a(UUID uuid) {
        LiveData<List<p.b>> a2 = this.f5361c.b().a((List<String>) Collections.singletonList(uuid.toString()));
        AnonymousClass1 r0 = new androidx.arch.core.c.a<List<p.b>, u>() {
            public final /* synthetic */ Object apply(Object obj) {
                List list = (List) obj;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return ((p.b) list.get(0)).a();
            }
        };
        a aVar = this.f5362d;
        Object obj = new Object();
        androidx.lifecycle.w wVar = new androidx.lifecycle.w();
        wVar.addSource(a2, new z<In>(obj, r0, wVar) {

            /* renamed from: a  reason: collision with root package name */
            Out f5441a = null;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Object f5443c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ androidx.arch.core.c.a f5444d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ androidx.lifecycle.w f5445e;

            {
                this.f5443c = r2;
                this.f5444d = r3;
                this.f5445e = r4;
            }

            public final void onChanged(final In in2) {
                a.this.a(new Runnable() {
                    public final void run() {
                        synchronized (AnonymousClass1.this.f5443c) {
                            Out apply = AnonymousClass1.this.f5444d.apply(in2);
                            if (AnonymousClass1.this.f5441a == null && apply != null) {
                                AnonymousClass1.this.f5441a = apply;
                                AnonymousClass1.this.f5445e.postValue(apply);
                            } else if (AnonymousClass1.this.f5441a != null && !AnonymousClass1.this.f5441a.equals(apply)) {
                                AnonymousClass1.this.f5441a = apply;
                                AnonymousClass1.this.f5445e.postValue(apply);
                            }
                        }
                    }
                });
            }
        });
        return wVar;
    }

    public final com.google.b.a.a.a<List<u>> c(String str) {
        i<List<u>> a2 = i.a(this, str);
        this.f5362d.b().execute(a2);
        return a2.f5459a;
    }

    public final void a(String str, WorkerParameters.a aVar) {
        this.f5362d.a(new h(this, str, aVar));
    }

    public final void d(String str) {
        this.f5362d.a(new androidx.work.impl.utils.j(this, str, false));
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.a(this.f5359a);
        }
        this.f5361c.b().b();
        f.a(this.f5360b, this.f5361c, this.f5363e);
    }

    public final void e() {
        synchronized (l) {
            this.f5366h = true;
            if (this.f5367i != null) {
                this.f5367i.finish();
                this.f5367i = null;
            }
        }
    }

    public final void a(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (l) {
            this.f5367i = pendingResult;
            if (this.f5366h) {
                this.f5367i.finish();
                this.f5367i = null;
            }
        }
    }

    public final o a(String str, androidx.work.f fVar, androidx.work.p pVar) {
        g gVar;
        if (fVar == androidx.work.f.KEEP) {
            gVar = g.KEEP;
        } else {
            gVar = g.REPLACE;
        }
        return new g(this, str, gVar, Collections.singletonList(pVar)).a();
    }
}
