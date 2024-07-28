package net.one97.paytm.o2o.movies.seat_selection;

import io.reactivex.rxjava3.d.g;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.common.h;
import net.one97.paytm.o2o.movies.common.i;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;
import net.one97.paytm.o2o.movies.seat_selection.c;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final io.reactivex.rxjava3.j.b<h<CJRSeat, Throwable>> f75832a;

    /* renamed from: b  reason: collision with root package name */
    private io.reactivex.rxjava3.b.c f75833b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f75834c;

    /* renamed from: d  reason: collision with root package name */
    private final io.reactivex.rxjava3.b.b f75835d;

    static final class a<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f75836a = new a();

        a() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            CJRSeat cJRSeat = (CJRSeat) obj;
            cJRSeat.sortSeats();
            return cJRSeat;
        }
    }

    static final class b<T> implements g<CJRSeat> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f75837a;

        b(e eVar) {
            this.f75837a = eVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJRSeat cJRSeat = (CJRSeat) obj;
            io.reactivex.rxjava3.j.b<h<CJRSeat, Throwable>> bVar = this.f75837a.f75832a;
            k.a((Object) cJRSeat, "result");
            k.c(bVar, "$this$success");
            bVar.observeOn(io.reactivex.rxjava3.android.b.a.a());
            h.a aVar = h.f75124e;
            bVar.onNext(new h(false, true, cJRSeat, null));
        }
    }

    static final class c<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f75838a;

        c(e eVar) {
            this.f75838a = eVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Throwable th = (Throwable) obj;
            io.reactivex.rxjava3.j.b<h<CJRSeat, Throwable>> bVar = this.f75838a.f75832a;
            k.a((Object) th, "error");
            k.c(bVar, "$this$failed");
            k.c(th, "e");
            bVar.observeOn(io.reactivex.rxjava3.android.b.a.a());
            h.a aVar = h.f75124e;
            k.c(th, "error");
            bVar.onNext(new h(false, false, null, th));
        }
    }

    public e(c.a aVar, io.reactivex.rxjava3.b.b bVar) {
        k.c(aVar, "remote");
        k.c(bVar, "compositeDisposable");
        this.f75834c = aVar;
        this.f75835d = bVar;
        io.reactivex.rxjava3.j.b<h<CJRSeat, Throwable>> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.f75832a = a2;
    }

    public final void a(CJRMoviesSession cJRMoviesSession) {
        k.c(cJRMoviesSession, "session");
        io.reactivex.rxjava3.b.c cVar = this.f75833b;
        if (cVar != null) {
            cVar.dispose();
        }
        io.reactivex.rxjava3.j.b<h<CJRSeat, Throwable>> bVar = this.f75832a;
        k.c(bVar, "$this$loading");
        bVar.observeOn(io.reactivex.rxjava3.android.b.a.a());
        h.a aVar = h.f75124e;
        bVar.onNext(new h(true, false, null, null));
        this.f75833b = this.f75834c.a(cJRMoviesSession).b(a.f75836a).a(new b(this), (g<? super Throwable>) new c(this));
        io.reactivex.rxjava3.b.c cVar2 = this.f75833b;
        if (cVar2 != null) {
            i.a(cVar2, this.f75835d);
        }
    }
}
