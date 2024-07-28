package net.one97.paytm.o2o.movies.a.a;

import android.content.Context;
import androidx.lifecycle.ai;
import dagger.a.e;
import java.util.Map;
import net.one97.paytm.o2o.movies.a.b.b;
import net.one97.paytm.o2o.movies.a.b.c;
import net.one97.paytm.o2o.movies.a.b.d;
import net.one97.paytm.o2o.movies.activity.MoviesHomeActivity;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final net.one97.paytm.o2o.movies.a.b.a f73869a;

    /* renamed from: b  reason: collision with root package name */
    private final c f73870b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a<Context> f73871c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.o2o.movies.e.a> f73872d;

    /* renamed from: e  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.o2o.movies.viewmodel.c> f73873e;

    /* renamed from: f  reason: collision with root package name */
    private javax.a.a<Map<Class<? extends ai>, javax.a.a<ai>>> f73874f;

    /* renamed from: g  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.o2o.movies.viewmodel.a.a> f73875g;

    public /* synthetic */ a(c cVar, net.one97.paytm.o2o.movies.a.b.a aVar, byte b2) {
        this(cVar, aVar);
    }

    private a(c cVar, net.one97.paytm.o2o.movies.a.b.a aVar) {
        this.f73869a = aVar;
        this.f73870b = cVar;
        this.f73871c = new b(aVar);
        this.f73872d = new d(cVar, this.f73871c);
        this.f73873e = new net.one97.paytm.o2o.movies.viewmodel.d(this.f73872d);
        this.f73874f = e.a(1).a(net.one97.paytm.o2o.movies.viewmodel.c.class, this.f73873e).a();
        this.f73875g = dagger.a.b.a(new net.one97.paytm.o2o.movies.viewmodel.a.b(this.f73874f));
    }

    /* renamed from: net.one97.paytm.o2o.movies.a.a.a$a  reason: collision with other inner class name */
    public static final class C1480a {

        /* renamed from: a  reason: collision with root package name */
        public c f73876a;

        /* renamed from: b  reason: collision with root package name */
        public net.one97.paytm.o2o.movies.a.b.a f73877b;

        public /* synthetic */ C1480a(byte b2) {
            this();
        }

        private C1480a() {
        }
    }

    public final void a(MoviesHomeActivity moviesHomeActivity) {
        moviesHomeActivity.f74169b = this.f73875g.get();
    }
}
