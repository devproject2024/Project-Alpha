package net.one97.paytm.o2o.movies.seat_selection;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import io.reactivex.rxjava3.a.p;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import net.one97.paytm.o2o.movies.common.e;
import net.one97.paytm.o2o.movies.common.i;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;

public final class g extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    final kotlin.g f75839a = h.a(new c(this));

    /* renamed from: b  reason: collision with root package name */
    final y<Intent> f75840b = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final io.reactivex.rxjava3.b.b f75841c = new io.reactivex.rxjava3.b.b();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final e f75842d = new e(new d(this.f75843e), this.f75841c);

    /* renamed from: e  reason: collision with root package name */
    private final Application f75843e;

    static final class b<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f75845a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class a<T> implements io.reactivex.rxjava3.d.g<Intent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f75844a;

        a(g gVar) {
            this.f75844a = gVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f75844a.f75840b.setValue((Intent) obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Application application) {
        super(application);
        p<Intent> a2;
        io.reactivex.rxjava3.b.c subscribe;
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f75843e = application;
        Application application2 = this.f75843e;
        Context context = !(application2 instanceof Context) ? null : application2;
        if (context != null && (a2 = e.a(context, "action.order.session.expire")) != null && (subscribe = a2.subscribe(new a(this), b.f75845a)) != null) {
            i.a(subscribe, this.f75841c);
        }
    }

    static final class c extends l implements kotlin.g.a.a<LiveData<net.one97.paytm.o2o.movies.common.h<CJRSeat, Throwable>>> {
        final /* synthetic */ g this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(0);
            this.this$0 = gVar;
        }

        public final LiveData<net.one97.paytm.o2o.movies.common.h<CJRSeat, Throwable>> invoke() {
            io.reactivex.rxjava3.j.b<net.one97.paytm.o2o.movies.common.h<CJRSeat, Throwable>> bVar = this.this$0.f75842d.f75832a;
            io.reactivex.rxjava3.b.b b2 = this.this$0.f75841c;
            k.c(bVar, "$this$toLiveData");
            k.c(b2, "compositeDisposable");
            y yVar = new y();
            b2.a(bVar.observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new i.a(yVar)));
            return yVar;
        }
    }

    public final void a(CJRMoviesSession cJRMoviesSession) {
        if (cJRMoviesSession != null) {
            this.f75842d.a(cJRMoviesSession);
        }
    }

    public final void onCleared() {
        super.onCleared();
        try {
            this.f75841c.a();
        } catch (Exception unused) {
        }
    }
}
