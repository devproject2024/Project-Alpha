package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class ab<TResult> extends Task<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12466a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final z<TResult> f12467b = new z<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f12468c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f12469d;

    /* renamed from: e  reason: collision with root package name */
    private TResult f12470e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f12471f;

    ab() {
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f12466a) {
            z = this.f12468c;
        }
        return z;
    }

    static class a extends LifecycleCallback {

        /* renamed from: b  reason: collision with root package name */
        private final List<WeakReference<y<?>>> f12472b = new ArrayList();

        public static a b(Activity activity) {
            j a2 = a(activity);
            a aVar = (a) a2.a("TaskOnStopCallback", a.class);
            return aVar == null ? new a(a2) : aVar;
        }

        private a(j jVar) {
            super(jVar);
            this.f8394a.a("TaskOnStopCallback", (LifecycleCallback) this);
        }

        public final <T> void a(y<T> yVar) {
            synchronized (this.f12472b) {
                this.f12472b.add(new WeakReference(yVar));
            }
        }

        public final void d() {
            synchronized (this.f12472b) {
                for (WeakReference<y<?>> weakReference : this.f12472b) {
                    y yVar = (y) weakReference.get();
                    if (yVar != null) {
                        yVar.P_();
                    }
                }
                this.f12472b.clear();
            }
        }
    }

    public final boolean c() {
        return this.f12469d;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f12466a) {
            z = this.f12468c && !this.f12469d && this.f12471f == null;
        }
        return z;
    }

    public final TResult d() {
        TResult tresult;
        synchronized (this.f12466a) {
            g();
            i();
            if (this.f12471f == null) {
                tresult = this.f12470e;
            } else {
                throw new d(this.f12471f);
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult a(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f12466a) {
            g();
            i();
            if (cls.isInstance(this.f12471f)) {
                throw ((Throwable) cls.cast(this.f12471f));
            } else if (this.f12471f == null) {
                tresult = this.f12470e;
            } else {
                throw new d(this.f12471f);
            }
        }
        return tresult;
    }

    public final Exception e() {
        Exception exc;
        synchronized (this.f12466a) {
            exc = this.f12471f;
        }
        return exc;
    }

    public final Task<TResult> a(OnSuccessListener<? super TResult> onSuccessListener) {
        return a(g.f12479a, onSuccessListener);
    }

    public final Task<TResult> a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f12467b.a(new v(ad.a(executor), onSuccessListener));
        j();
        return this;
    }

    public final Task<TResult> a(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        v vVar = new v(ad.a(g.f12479a), onSuccessListener);
        this.f12467b.a(vVar);
        a.b(activity).a(vVar);
        j();
        return this;
    }

    public final Task<TResult> a(OnFailureListener onFailureListener) {
        return a(g.f12479a, onFailureListener);
    }

    public final Task<TResult> a(Executor executor, OnFailureListener onFailureListener) {
        this.f12467b.a(new s(ad.a(executor), onFailureListener));
        j();
        return this;
    }

    public final Task<TResult> a(Activity activity, OnFailureListener onFailureListener) {
        s sVar = new s(ad.a(g.f12479a), onFailureListener);
        this.f12467b.a(sVar);
        a.b(activity).a(sVar);
        j();
        return this;
    }

    public final Task<TResult> a(c<TResult> cVar) {
        return a(g.f12479a, cVar);
    }

    public final Task<TResult> a(Executor executor, c<TResult> cVar) {
        this.f12467b.a(new q(ad.a(executor), cVar));
        j();
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> a(a<TResult, TContinuationResult> aVar) {
        return a(g.f12479a, aVar);
    }

    public final <TContinuationResult> Task<TContinuationResult> a(Executor executor, a<TResult, TContinuationResult> aVar) {
        ab abVar = new ab();
        this.f12467b.a(new j(ad.a(executor), aVar, abVar));
        j();
        return abVar;
    }

    public final <TContinuationResult> Task<TContinuationResult> b(a<TResult, Task<TContinuationResult>> aVar) {
        return b(g.f12479a, aVar);
    }

    public final Task<TResult> a(b bVar) {
        return a(g.f12479a, bVar);
    }

    public final Task<TResult> a(Executor executor, b bVar) {
        this.f12467b.a(new m(ad.a(executor), bVar));
        j();
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> b(Executor executor, a<TResult, Task<TContinuationResult>> aVar) {
        ab abVar = new ab();
        this.f12467b.a(new k(ad.a(executor), aVar, abVar));
        j();
        return abVar;
    }

    public final <TContinuationResult> Task<TContinuationResult> a(Executor executor, e<TResult, TContinuationResult> eVar) {
        ab abVar = new ab();
        this.f12467b.a(new w(ad.a(executor), eVar, abVar));
        j();
        return abVar;
    }

    public final <TContinuationResult> Task<TContinuationResult> a(e<TResult, TContinuationResult> eVar) {
        return a(g.f12479a, eVar);
    }

    public final void a(TResult tresult) {
        synchronized (this.f12466a) {
            h();
            this.f12468c = true;
            this.f12470e = tresult;
        }
        this.f12467b.a(this);
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f12466a) {
            if (this.f12468c) {
                return false;
            }
            this.f12468c = true;
            this.f12470e = tresult;
            this.f12467b.a(this);
            return true;
        }
    }

    public final void a(Exception exc) {
        s.a(exc, (Object) "Exception must not be null");
        synchronized (this.f12466a) {
            h();
            this.f12468c = true;
            this.f12471f = exc;
        }
        this.f12467b.a(this);
    }

    public final boolean b(Exception exc) {
        s.a(exc, (Object) "Exception must not be null");
        synchronized (this.f12466a) {
            if (this.f12468c) {
                return false;
            }
            this.f12468c = true;
            this.f12471f = exc;
            this.f12467b.a(this);
            return true;
        }
    }

    public final boolean f() {
        synchronized (this.f12466a) {
            if (this.f12468c) {
                return false;
            }
            this.f12468c = true;
            this.f12469d = true;
            this.f12467b.a(this);
            return true;
        }
    }

    private final void g() {
        s.a(this.f12468c, (Object) "Task is not yet complete");
    }

    private final void h() {
        s.a(!this.f12468c, (Object) "Task is already complete");
    }

    private final void i() {
        if (this.f12469d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void j() {
        synchronized (this.f12466a) {
            if (this.f12468c) {
                this.f12467b.a(this);
            }
        }
    }
}
