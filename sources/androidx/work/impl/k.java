package androidx.work.impl;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.b;
import androidx.work.e;
import androidx.work.impl.b.p;
import androidx.work.impl.b.q;
import androidx.work.impl.b.t;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.a.c;
import androidx.work.impl.utils.m;
import androidx.work.j;
import androidx.work.l;
import androidx.work.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final String f5369a = l.a("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    Context f5370b;

    /* renamed from: c  reason: collision with root package name */
    p f5371c;

    /* renamed from: d  reason: collision with root package name */
    ListenableWorker f5372d;

    /* renamed from: e  reason: collision with root package name */
    ListenableWorker.a f5373e = new ListenableWorker.a.C0076a();

    /* renamed from: f  reason: collision with root package name */
    c<Boolean> f5374f = c.a();

    /* renamed from: g  reason: collision with root package name */
    com.google.b.a.a.a<ListenableWorker.a> f5375g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f5376h;

    /* renamed from: i  reason: collision with root package name */
    private List<e> f5377i;
    private WorkerParameters.a j;
    private b k;
    private androidx.work.impl.utils.b.a l;
    private androidx.work.impl.foreground.a m;
    private WorkDatabase n;
    private q o;
    private androidx.work.impl.b.b p;
    private t q;
    private List<String> r;
    private String s;
    private volatile boolean t;

    k(a aVar) {
        this.f5370b = aVar.f5383a;
        this.l = aVar.f5386d;
        this.m = aVar.f5385c;
        this.f5376h = aVar.f5389g;
        this.f5377i = aVar.f5390h;
        this.j = aVar.f5391i;
        this.f5372d = aVar.f5384b;
        this.k = aVar.f5387e;
        this.n = aVar.f5388f;
        this.o = this.n.b();
        this.p = this.n.c();
        this.q = this.n.d();
    }

    public final void run() {
        e a2;
        this.r = this.q.a(this.f5376h);
        List<String> list = this.r;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f5376h);
        sb.append(", tags={ ");
        boolean z = true;
        for (String next : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append(" } ]");
        this.s = sb.toString();
        if (!d()) {
            this.n.beginTransaction();
            try {
                this.f5371c = this.o.b(this.f5376h);
                if (this.f5371c == null) {
                    l.a();
                    String.format("Didn't find WorkSpec for id %s", new Object[]{this.f5376h});
                    a(false);
                } else if (this.f5371c.f5181b != u.a.ENQUEUED) {
                    c();
                    this.n.setTransactionSuccessful();
                    l.a();
                    String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f5371c.f5182c});
                    this.n.endTransaction();
                } else {
                    if (this.f5371c.a() || this.f5371c.b()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!(this.f5371c.n == 0) && currentTimeMillis < this.f5371c.c()) {
                            l.a();
                            String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f5371c.f5182c});
                            a(true);
                            this.n.endTransaction();
                            return;
                        }
                    }
                    this.n.setTransactionSuccessful();
                    this.n.endTransaction();
                    if (this.f5371c.a()) {
                        a2 = this.f5371c.f5184e;
                    } else {
                        j a3 = j.a(this.f5371c.f5183d);
                        if (a3 == null) {
                            l.a();
                            String.format("Could not create Input Merger %s", new Object[]{this.f5371c.f5183d});
                            f();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f5371c.f5184e);
                        arrayList.addAll(this.o.h(this.f5376h));
                        a2 = a3.a((List<e>) arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f5376h), a2, this.r, this.j, this.f5371c.k, this.k.f5054a, this.l, this.k.f5056c, new m(this.n, this.l), new androidx.work.impl.utils.l(this.n, this.m, this.l));
                    if (this.f5372d == null) {
                        this.f5372d = this.k.f5056c.a(this.f5370b, this.f5371c.f5182c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f5372d;
                    if (listenableWorker == null) {
                        l.a();
                        String.format("Could not create Worker %s", new Object[]{this.f5371c.f5182c});
                        f();
                    } else if (listenableWorker.isUsed()) {
                        l.a();
                        String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f5371c.f5182c});
                        f();
                    } else {
                        this.f5372d.setUsed();
                        if (!e()) {
                            c();
                        } else if (!d()) {
                            final c a4 = c.a();
                            this.l.a().execute(new Runnable() {
                                public final void run() {
                                    try {
                                        l.a();
                                        String str = k.f5369a;
                                        String.format("Starting work for %s", new Object[]{k.this.f5371c.f5182c});
                                        k.this.f5375g = k.this.f5372d.startWork();
                                        a4.a(k.this.f5375g);
                                    } catch (Throwable th) {
                                        a4.a(th);
                                    }
                                }
                            });
                            final String str = this.s;
                            a4.a((Runnable) new Runnable() {
                                public final void run() {
                                    try {
                                        ListenableWorker.a aVar = (ListenableWorker.a) a4.get();
                                        if (aVar == null) {
                                            l.a();
                                            String str = k.f5369a;
                                            String.format("%s returned a null result. Treating it as a failure.", new Object[]{k.this.f5371c.f5182c});
                                        } else {
                                            l.a();
                                            String str2 = k.f5369a;
                                            String.format("%s returned a %s result.", new Object[]{k.this.f5371c.f5182c, aVar});
                                            k.this.f5373e = aVar;
                                        }
                                    } catch (CancellationException e2) {
                                        l.a();
                                        String str3 = k.f5369a;
                                        String.format("%s was cancelled", new Object[]{str});
                                        new Throwable[1][0] = e2;
                                    } catch (InterruptedException | ExecutionException e3) {
                                        l.a();
                                        String str4 = k.f5369a;
                                        String.format("%s failed because it threw an exception/error", new Object[]{str});
                                        new Throwable[1][0] = e3;
                                    } catch (Throwable th) {
                                        k.this.a();
                                        throw th;
                                    }
                                    k.this.a();
                                }
                            }, (Executor) this.l.b());
                        }
                    }
                }
            } finally {
                this.n.endTransaction();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void a() {
        if (!d()) {
            this.n.beginTransaction();
            try {
                u.a f2 = this.o.f(this.f5376h);
                this.n.g().a(this.f5376h);
                if (f2 == null) {
                    a(false);
                } else if (f2 == u.a.RUNNING) {
                    ListenableWorker.a aVar = this.f5373e;
                    if (aVar instanceof ListenableWorker.a.c) {
                        l.a();
                        String.format("Worker result SUCCESS for %s", new Object[]{this.s});
                        if (this.f5371c.a()) {
                            h();
                        } else {
                            this.n.beginTransaction();
                            this.o.a(u.a.SUCCEEDED, this.f5376h);
                            this.o.a(this.f5376h, ((ListenableWorker.a.c) this.f5373e).f5040a);
                            long currentTimeMillis = System.currentTimeMillis();
                            for (String next : this.p.b(this.f5376h)) {
                                if (this.o.f(next) == u.a.BLOCKED && this.p.a(next)) {
                                    l.a();
                                    String.format("Setting status to enqueued for %s", new Object[]{next});
                                    this.o.a(u.a.ENQUEUED, next);
                                    this.o.a(next, currentTimeMillis);
                                }
                            }
                            this.n.setTransactionSuccessful();
                            this.n.endTransaction();
                            a(false);
                        }
                    } else if (aVar instanceof ListenableWorker.a.b) {
                        l.a();
                        String.format("Worker result RETRY for %s", new Object[]{this.s});
                        g();
                    } else {
                        l.a();
                        String.format("Worker result FAILURE for %s", new Object[]{this.s});
                        if (this.f5371c.a()) {
                            h();
                        } else {
                            f();
                        }
                    }
                } else if (!f2.isFinished()) {
                    g();
                }
                this.n.setTransactionSuccessful();
                this.n.endTransaction();
            } catch (Throwable th) {
                this.n.endTransaction();
                throw th;
            }
        }
        List<e> list = this.f5377i;
        if (list != null) {
            for (e a2 : list) {
                a2.a(this.f5376h);
            }
            f.a(this.k, this.n, this.f5377i);
        }
    }

    public final void b() {
        boolean z;
        this.t = true;
        d();
        com.google.b.a.a.a<ListenableWorker.a> aVar = this.f5375g;
        if (aVar != null) {
            z = aVar.isDone();
            this.f5375g.cancel(true);
        } else {
            z = false;
        }
        ListenableWorker listenableWorker = this.f5372d;
        if (listenableWorker == null || z) {
            String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.f5371c});
            l.a();
            return;
        }
        listenableWorker.stop();
    }

    private void c() {
        u.a f2 = this.o.f(this.f5376h);
        if (f2 == u.a.RUNNING) {
            l.a();
            String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.f5376h});
            a(true);
            return;
        }
        l.a();
        String.format("Status for %s is %s; not doing any work", new Object[]{this.f5376h, f2});
        a(false);
    }

    private boolean d() {
        boolean z = false;
        if (!this.t) {
            return false;
        }
        l.a();
        String.format("Work interrupted for %s", new Object[]{this.s});
        u.a f2 = this.o.f(this.f5376h);
        if (f2 != null && !f2.isFinished()) {
            z = true;
        }
        a(z);
        return true;
    }

    /* JADX INFO: finally extract failed */
    private void a(boolean z) {
        this.n.beginTransaction();
        try {
            if (this.n.b().a().isEmpty()) {
                androidx.work.impl.utils.e.a(this.f5370b, RescheduleReceiver.class, false);
            }
            if (z) {
                this.o.b(this.f5376h, -1);
            }
            if (!(this.f5371c == null || this.f5372d == null || !this.f5372d.isRunInForeground())) {
                this.m.d(this.f5376h);
            }
            this.n.setTransactionSuccessful();
            this.n.endTransaction();
            this.f5374f.a(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.n.endTransaction();
            throw th;
        }
    }

    private boolean e() {
        this.n.beginTransaction();
        try {
            boolean z = true;
            if (this.o.f(this.f5376h) == u.a.ENQUEUED) {
                this.o.a(u.a.RUNNING, this.f5376h);
                this.o.d(this.f5376h);
            } else {
                z = false;
            }
            this.n.setTransactionSuccessful();
            return z;
        } finally {
            this.n.endTransaction();
        }
    }

    private void f() {
        this.n.beginTransaction();
        try {
            a(this.f5376h);
            this.o.a(this.f5376h, ((ListenableWorker.a.C0076a) this.f5373e).f5039a);
            this.n.setTransactionSuccessful();
        } finally {
            this.n.endTransaction();
            a(false);
        }
    }

    private void a(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.o.f(str2) != u.a.CANCELLED) {
                this.o.a(u.a.FAILED, str2);
            }
            linkedList.addAll(this.p.b(str2));
        }
    }

    private void g() {
        this.n.beginTransaction();
        try {
            this.o.a(u.a.ENQUEUED, this.f5376h);
            this.o.a(this.f5376h, System.currentTimeMillis());
            this.o.b(this.f5376h, -1);
            this.n.setTransactionSuccessful();
        } finally {
            this.n.endTransaction();
            a(true);
        }
    }

    private void h() {
        this.n.beginTransaction();
        try {
            this.o.a(this.f5376h, System.currentTimeMillis());
            this.o.a(u.a.ENQUEUED, this.f5376h);
            this.o.e(this.f5376h);
            this.o.b(this.f5376h, -1);
            this.n.setTransactionSuccessful();
        } finally {
            this.n.endTransaction();
            a(false);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Context f5383a;

        /* renamed from: b  reason: collision with root package name */
        ListenableWorker f5384b;

        /* renamed from: c  reason: collision with root package name */
        androidx.work.impl.foreground.a f5385c;

        /* renamed from: d  reason: collision with root package name */
        androidx.work.impl.utils.b.a f5386d;

        /* renamed from: e  reason: collision with root package name */
        b f5387e;

        /* renamed from: f  reason: collision with root package name */
        WorkDatabase f5388f;

        /* renamed from: g  reason: collision with root package name */
        String f5389g;

        /* renamed from: h  reason: collision with root package name */
        List<e> f5390h;

        /* renamed from: i  reason: collision with root package name */
        WorkerParameters.a f5391i = new WorkerParameters.a();

        public a(Context context, b bVar, androidx.work.impl.utils.b.a aVar, androidx.work.impl.foreground.a aVar2, WorkDatabase workDatabase, String str) {
            this.f5383a = context.getApplicationContext();
            this.f5386d = aVar;
            this.f5385c = aVar2;
            this.f5387e = bVar;
            this.f5388f = workDatabase;
            this.f5389g = str;
        }
    }
}
