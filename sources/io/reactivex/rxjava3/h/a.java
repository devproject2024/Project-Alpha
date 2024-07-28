package io.reactivex.rxjava3.h;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.c.f;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.d.e;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.k.j;
import java.util.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile g<? super Throwable> f47763a;

    /* renamed from: b  reason: collision with root package name */
    static volatile h<? super Runnable, ? extends Runnable> f47764b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile h<? super r<x>, ? extends x> f47765c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile h<? super r<x>, ? extends x> f47766d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h<? super r<x>, ? extends x> f47767e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile h<? super r<x>, ? extends x> f47768f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile h<? super x, ? extends x> f47769g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile h<? super x, ? extends x> f47770h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile h<? super x, ? extends x> f47771i;
    public static volatile h<? super x, ? extends x> j;
    static volatile h<? super io.reactivex.rxjava3.a.h, ? extends io.reactivex.rxjava3.a.h> k;
    static volatile h<? super p, ? extends p> l;
    static volatile h<? super io.reactivex.rxjava3.f.a, ? extends io.reactivex.rxjava3.f.a> m;
    static volatile h<? super l, ? extends l> n;
    static volatile h<? super y, ? extends y> o;
    static volatile h<? super b, ? extends b> p;
    static volatile c<? super io.reactivex.rxjava3.a.h, ? super org.a.b, ? extends org.a.b> q;
    static volatile c<? super l, ? super m, ? extends m> r;
    public static volatile c<? super p, ? super w, ? extends w> s;
    static volatile c<? super y, ? super aa, ? extends aa> t;
    static volatile c<? super b, ? super d, ? extends d> u;
    static volatile e v;
    public static volatile boolean w;

    public static void a(Throwable th) {
        g<? super Throwable> gVar = f47763a;
        if (th == null) {
            th = j.a("onError called with a null Throwable.");
        } else if (!b(th)) {
            th = new f(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    private static boolean b(Throwable th) {
        if (!(th instanceof io.reactivex.rxjava3.c.d) && !(th instanceof io.reactivex.rxjava3.c.c) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof io.reactivex.rxjava3.c.a)) {
            return false;
        }
        return true;
    }

    private static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Runnable a(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = f47764b;
        if (hVar == null) {
            return runnable;
        }
        return (Runnable) a(hVar, runnable);
    }

    public static <T> org.a.b<? super T> a(io.reactivex.rxjava3.a.h<T> hVar, org.a.b<? super T> bVar) {
        c<? super io.reactivex.rxjava3.a.h, ? super org.a.b, ? extends org.a.b> cVar = q;
        return cVar != null ? (org.a.b) a(cVar, hVar, bVar) : bVar;
    }

    public static <T> aa<? super T> a(y<T> yVar, aa<? super T> aaVar) {
        c<? super y, ? super aa, ? extends aa> cVar = t;
        return cVar != null ? (aa) a(cVar, yVar, aaVar) : aaVar;
    }

    public static d a(b bVar, d dVar) {
        c<? super b, ? super d, ? extends d> cVar = u;
        return cVar != null ? (d) a(cVar, bVar, dVar) : dVar;
    }

    public static <T> m<? super T> a(l<T> lVar, m<? super T> mVar) {
        c<? super l, ? super m, ? extends m> cVar = r;
        return cVar != null ? (m) a(cVar, lVar, mVar) : mVar;
    }

    public static <T> l<T> a(l<T> lVar) {
        h<? super l, ? extends l> hVar = n;
        return hVar != null ? (l) a(hVar, lVar) : lVar;
    }

    public static <T> io.reactivex.rxjava3.a.h<T> a(io.reactivex.rxjava3.a.h<T> hVar) {
        h<? super io.reactivex.rxjava3.a.h, ? extends io.reactivex.rxjava3.a.h> hVar2 = k;
        return hVar2 != null ? (io.reactivex.rxjava3.a.h) a(hVar2, hVar) : hVar;
    }

    public static <T> p<T> a(p<T> pVar) {
        h<? super p, ? extends p> hVar = l;
        return hVar != null ? (p) a(hVar, pVar) : pVar;
    }

    public static <T> io.reactivex.rxjava3.f.a<T> a(io.reactivex.rxjava3.f.a<T> aVar) {
        h<? super io.reactivex.rxjava3.f.a, ? extends io.reactivex.rxjava3.f.a> hVar = m;
        return hVar != null ? (io.reactivex.rxjava3.f.a) a(hVar, aVar) : aVar;
    }

    public static <T> y<T> a(y<T> yVar) {
        h<? super y, ? extends y> hVar = o;
        return hVar != null ? (y) a(hVar, yVar) : yVar;
    }

    public static b a(b bVar) {
        h<? super b, ? extends b> hVar = p;
        return hVar != null ? (b) a(hVar, bVar) : bVar;
    }

    public static boolean a() {
        e eVar = v;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.a();
        } catch (Throwable th) {
            throw j.a(th);
        }
    }

    public static <T, R> R a(h<T, R> hVar, T t2) {
        try {
            return hVar.apply(t2);
        } catch (Throwable th) {
            throw j.a(th);
        }
    }

    public static <T, U, R> R a(c<T, U, R> cVar, T t2, U u2) {
        try {
            return cVar.a(t2, u2);
        } catch (Throwable th) {
            throw j.a(th);
        }
    }

    public static x a(r<x> rVar) {
        try {
            return (x) Objects.requireNonNull(rVar.get(), "Scheduler Supplier result can't be null");
        } catch (Throwable th) {
            throw j.a(th);
        }
    }

    public static x a(h<? super r<x>, ? extends x> hVar, r<x> rVar) {
        return (x) Objects.requireNonNull(a(hVar, rVar), "Scheduler Supplier result can't be null");
    }
}
