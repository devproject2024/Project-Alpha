package com.google.android.play.core.e;

import com.google.android.play.core.splitcompat.r;
import java.util.concurrent.Executor;

final class t<ResultT> extends e<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f37478a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final o<ResultT> f37479b = new o<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f37480c;

    /* renamed from: d  reason: collision with root package name */
    private ResultT f37481d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f37482e;

    t() {
    }

    private final void e() {
        r.a(!this.f37480c, (Object) "Task is already complete");
    }

    private final void f() {
        synchronized (this.f37478a) {
            if (this.f37480c) {
                this.f37479b.a(this);
            }
        }
    }

    public final e<ResultT> a(a<ResultT> aVar) {
        this.f37479b.a(new i(f.f37456a, aVar));
        f();
        return this;
    }

    public final e<ResultT> a(b bVar) {
        a(f.f37456a, bVar);
        return this;
    }

    public final e<ResultT> a(c<? super ResultT> cVar) {
        a(f.f37456a, cVar);
        return this;
    }

    public final e<ResultT> a(Executor executor, b bVar) {
        this.f37479b.a(new k(executor, bVar));
        f();
        return this;
    }

    public final e<ResultT> a(Executor executor, c<? super ResultT> cVar) {
        this.f37479b.a(new m(executor, cVar));
        f();
        return this;
    }

    public final void a(Exception exc) {
        r.a(exc, (Object) "Exception must not be null");
        synchronized (this.f37478a) {
            e();
            this.f37480c = true;
            this.f37482e = exc;
        }
        this.f37479b.a(this);
    }

    public final void a(ResultT resultt) {
        synchronized (this.f37478a) {
            e();
            this.f37480c = true;
            this.f37481d = resultt;
        }
        this.f37479b.a(this);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f37478a) {
            z = this.f37480c;
        }
        return z;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f37478a) {
            z = false;
            if (this.f37480c && this.f37482e == null) {
                z = true;
            }
        }
        return z;
    }

    public final boolean b(Exception exc) {
        r.a(exc, (Object) "Exception must not be null");
        synchronized (this.f37478a) {
            if (this.f37480c) {
                return false;
            }
            this.f37480c = true;
            this.f37482e = exc;
            this.f37479b.a(this);
            return true;
        }
    }

    public final boolean b(ResultT resultt) {
        synchronized (this.f37478a) {
            if (this.f37480c) {
                return false;
            }
            this.f37480c = true;
            this.f37481d = resultt;
            this.f37479b.a(this);
            return true;
        }
    }

    public final Exception d() {
        Exception exc;
        synchronized (this.f37478a) {
            exc = this.f37482e;
        }
        return exc;
    }

    public final ResultT c() {
        ResultT resultt;
        synchronized (this.f37478a) {
            r.a(this.f37480c, (Object) "Task is not yet complete");
            Exception exc = this.f37482e;
            if (exc == null) {
                resultt = this.f37481d;
            } else {
                throw new d(exc);
            }
        }
        return resultt;
    }
}
