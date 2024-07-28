package io.reactivex.rxjava3.i;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.h.o;
import io.reactivex.rxjava3.e.h.p;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final x f47772a;

    /* renamed from: b  reason: collision with root package name */
    static final x f47773b;

    /* renamed from: c  reason: collision with root package name */
    static final x f47774c;

    /* renamed from: d  reason: collision with root package name */
    static final x f47775d = p.c();

    /* renamed from: e  reason: collision with root package name */
    static final x f47776e;

    /* renamed from: io.reactivex.rxjava3.i.a$a  reason: collision with other inner class name */
    static final class C0827a {

        /* renamed from: a  reason: collision with root package name */
        static final x f47777a = new io.reactivex.rxjava3.e.h.b();
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final x f47778a = new io.reactivex.rxjava3.e.h.f();
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final x f47779a = new io.reactivex.rxjava3.e.h.g();
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final x f47780a = new o();
    }

    static {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        h hVar = new h();
        Objects.requireNonNull(hVar, "Scheduler Supplier can't be null");
        io.reactivex.rxjava3.d.h<? super r<x>, ? extends x> hVar2 = io.reactivex.rxjava3.h.a.f47766d;
        if (hVar2 == null) {
            xVar = io.reactivex.rxjava3.h.a.a((r<x>) hVar);
        } else {
            xVar = io.reactivex.rxjava3.h.a.a(hVar2, (r<x>) hVar);
        }
        f47772a = xVar;
        b bVar = new b();
        Objects.requireNonNull(bVar, "Scheduler Supplier can't be null");
        io.reactivex.rxjava3.d.h<? super r<x>, ? extends x> hVar3 = io.reactivex.rxjava3.h.a.f47765c;
        if (hVar3 == null) {
            xVar2 = io.reactivex.rxjava3.h.a.a((r<x>) bVar);
        } else {
            xVar2 = io.reactivex.rxjava3.h.a.a(hVar3, (r<x>) bVar);
        }
        f47773b = xVar2;
        c cVar = new c();
        Objects.requireNonNull(cVar, "Scheduler Supplier can't be null");
        io.reactivex.rxjava3.d.h<? super r<x>, ? extends x> hVar4 = io.reactivex.rxjava3.h.a.f47767e;
        if (hVar4 == null) {
            xVar3 = io.reactivex.rxjava3.h.a.a((r<x>) cVar);
        } else {
            xVar3 = io.reactivex.rxjava3.h.a.a(hVar4, (r<x>) cVar);
        }
        f47774c = xVar3;
        f fVar = new f();
        Objects.requireNonNull(fVar, "Scheduler Supplier can't be null");
        io.reactivex.rxjava3.d.h<? super r<x>, ? extends x> hVar5 = io.reactivex.rxjava3.h.a.f47768f;
        if (hVar5 == null) {
            xVar4 = io.reactivex.rxjava3.h.a.a((r<x>) fVar);
        } else {
            xVar4 = io.reactivex.rxjava3.h.a.a(hVar5, (r<x>) fVar);
        }
        f47776e = xVar4;
    }

    public static x a() {
        x xVar = f47773b;
        io.reactivex.rxjava3.d.h<? super x, ? extends x> hVar = io.reactivex.rxjava3.h.a.f47769g;
        if (hVar == null) {
            return xVar;
        }
        return (x) io.reactivex.rxjava3.h.a.a(hVar, xVar);
    }

    public static x b() {
        x xVar = f47774c;
        io.reactivex.rxjava3.d.h<? super x, ? extends x> hVar = io.reactivex.rxjava3.h.a.f47771i;
        if (hVar == null) {
            return xVar;
        }
        return (x) io.reactivex.rxjava3.h.a.a(hVar, xVar);
    }

    public static x c() {
        return f47775d;
    }

    public static x d() {
        x xVar = f47776e;
        io.reactivex.rxjava3.d.h<? super x, ? extends x> hVar = io.reactivex.rxjava3.h.a.j;
        if (hVar == null) {
            return xVar;
        }
        return (x) io.reactivex.rxjava3.h.a.a(hVar, xVar);
    }

    public static x e() {
        x xVar = f47772a;
        io.reactivex.rxjava3.d.h<? super x, ? extends x> hVar = io.reactivex.rxjava3.h.a.f47770h;
        if (hVar == null) {
            return xVar;
        }
        return (x) io.reactivex.rxjava3.h.a.a(hVar, xVar);
    }

    public static x a(Executor executor) {
        return new io.reactivex.rxjava3.e.h.d(executor);
    }

    static final class c implements r<x> {
        c() {
        }

        public final /* bridge */ /* synthetic */ Object get() throws Throwable {
            return d.f47778a;
        }
    }

    static final class f implements r<x> {
        f() {
        }

        public final /* bridge */ /* synthetic */ Object get() throws Throwable {
            return e.f47779a;
        }
    }

    static final class h implements r<x> {
        h() {
        }

        public final /* bridge */ /* synthetic */ Object get() throws Throwable {
            return g.f47780a;
        }
    }

    static final class b implements r<x> {
        b() {
        }

        public final /* bridge */ /* synthetic */ Object get() throws Throwable {
            return C0827a.f47777a;
        }
    }
}
