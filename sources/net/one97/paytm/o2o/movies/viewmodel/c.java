package net.one97.paytm.o2o.movies.viewmodel;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.LayoutType;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeList;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.GroupFormatObject;
import net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse;
import net.one97.paytm.o2o.movies.entity.CJRBrowseByCinema;
import net.one97.paytm.o2o.movies.entity.CJRBrowseByCinemaMeta;
import net.one97.paytm.o2o.movies.entity.CJRBrowseByData;
import net.one97.paytm.o2o.movies.entity.CJRCinemaV1;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse;
import net.one97.paytm.o2o.movies.entity.CJRHomePageResponse;
import net.one97.paytm.o2o.movies.entity.EmptyModel;
import net.one97.paytm.o2o.movies.entity.Optional;
import net.one97.paytm.o2o.movies.entity.events.Events;
import net.one97.paytm.o2o.movies.storefront.model.StorefrontResponse;
import net.one97.paytm.o2o.movies.utils.s;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    public Context f76061a;

    /* renamed from: b  reason: collision with root package name */
    public y<Boolean> f76062b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f76063c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f76064d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<String> f76065e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<Boolean> f76066f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<Boolean> f76067g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public y<Boolean> f76068h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<Optional<CJRHomePageV2>> f76069i = new y<>();
    public y<Optional<CJRGetMetricInfoResponse>> j = new y<>();
    public y<Optional<CJRCinemaV1>> k = new y<>();
    public y<Optional<CJRUpcomingMovies>> l = new y<>();
    public y<com.google.gson.o> m = new y<>();
    public Optional<CJRCinemaV1> n;
    public y<CJRHomePageResponse> o = new y<>();
    public y<SanitizedResponseModel> p = new y<>();
    public Optional<CJRHomePageV2> q;
    public y<CJRMoviePassHomeModel> r = new y<>();
    public y<CJRBookedMovieTicketResponse> s = new y<>();
    public y<Events> t = new y<>();
    public final net.one97.paytm.o2o.movies.e.a u;
    /* access modifiers changed from: private */
    public Optional<CJRGetMetricInfoResponse> v;
    /* access modifiers changed from: private */
    public Optional<CJRUpcomingMovies> w;
    private y<StorefrontResponse> x = new y<>();
    /* access modifiers changed from: private */
    public final Object y = new Object();

    static final class d<T> implements io.reactivex.rxjava3.d.g<SanitizedResponseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f76073a;

        d(c cVar) {
            this.f76073a = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            SanitizedResponseModel sanitizedResponseModel = (SanitizedResponseModel) obj;
            synchronized (this.f76073a.y) {
                this.f76073a.p.setValue(sanitizedResponseModel);
                s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
                net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", String.valueOf(this.f76073a.p.getValue()));
                x xVar = x.f47997a;
            }
        }
    }

    static final class e<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f76074a = new e();

        e() {
        }

        public final /* synthetic */ void accept(Object obj) {
            Throwable th = (Throwable) obj;
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            String a2 = net.one97.paytm.o2o.movies.utils.s.f75981b;
            StringBuilder sb = new StringBuilder();
            sb.append(th != null ? th.getMessage() : null);
            sb.append(" homeViewModel top banners call");
            net.one97.paytm.o2o.movies.utils.u.a(a2, "Friday", sb.toString());
        }
    }

    static final class k<T1, T2, R> implements io.reactivex.rxjava3.d.c<Optional<CJRBookedMovieTicketResponse>, Optional<CJRMovieHomeDataResponse>, CJRHomePageResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f76080a;

        k(c cVar) {
            this.f76080a = cVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object a(java.lang.Object r6, java.lang.Object r7) {
            /*
                r5 = this;
                net.one97.paytm.o2o.movies.entity.Optional r6 = (net.one97.paytm.o2o.movies.entity.Optional) r6
                net.one97.paytm.o2o.movies.entity.Optional r7 = (net.one97.paytm.o2o.movies.entity.Optional) r7
                java.lang.String r0 = "cjrMovieHomeDataResponse"
                kotlin.g.b.k.c(r7, r0)
                boolean r0 = r7.isEmpty()
                r1 = 0
                if (r0 != 0) goto L_0x0092
                java.lang.Object r0 = r7.get()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r0
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeList r0 = r0.getData()
                if (r0 == 0) goto L_0x0092
                java.lang.Object r0 = r7.get()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r0
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeList r0 = r0.getData()
                if (r0 != 0) goto L_0x002b
                kotlin.g.b.k.a()
            L_0x002b:
                java.util.ArrayList r0 = r0.getMovies()
                if (r0 == 0) goto L_0x0092
                net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
                java.lang.String r2 = "CJRMovieSearchResponseHo…erSingleton.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                java.util.ArrayList r2 = new java.util.ArrayList
                java.lang.Object r3 = r7.get()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r3
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeList r3 = r3.getData()
                if (r3 != 0) goto L_0x004b
                kotlin.g.b.k.a()
            L_0x004b:
                java.util.ArrayList r3 = r3.getMovies()
                if (r3 != 0) goto L_0x0054
                kotlin.g.b.k.a()
            L_0x0054:
                java.util.Collection r3 = (java.util.Collection) r3
                r2.<init>(r3)
                r0.a(r2)
                java.lang.Object r0 = r7.get()
                java.lang.String r2 = "cjrMovieHomeDataResponse.get()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r0
                net.one97.paytm.o2o.movies.viewmodel.c.a((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r0)
                java.lang.Object r0 = r7.get()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r0 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r0
                java.util.ArrayList r0 = net.one97.paytm.o2o.movies.viewmodel.c.b((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r0)
                java.lang.Object r7 = r7.get()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r7 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse) r7
                if (r7 == 0) goto L_0x0090
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeList r2 = r7.getData()
                if (r2 == 0) goto L_0x0090
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeList r2 = r7.getData()
                if (r2 != 0) goto L_0x008b
                kotlin.g.b.k.a()
            L_0x008b:
                java.util.ArrayList r2 = r2.getMovies()
                goto L_0x0095
            L_0x0090:
                r2 = r1
                goto L_0x0095
            L_0x0092:
                r7 = r1
                r0 = r7
                r2 = r0
            L_0x0095:
                if (r6 == 0) goto L_0x00ce
                boolean r3 = r6.isEmpty()
                if (r3 != 0) goto L_0x00ce
                java.lang.Object r3 = r6.get()
                java.lang.String r4 = "upcommingMovieTicket.get()"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse r3 = (net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse) r3
                java.util.ArrayList r3 = r3.getResult()
                if (r3 == 0) goto L_0x00ce
                java.lang.Object r3 = r6.get()
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse r3 = (net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse) r3
                java.util.ArrayList r3 = r3.getResult()
                int r3 = r3.size()
                if (r3 <= 0) goto L_0x00ce
                java.lang.Object r6 = r6.get()
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
                net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse r6 = (net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse) r6
                java.util.ArrayList r1 = r6.getResult()
            L_0x00ce:
                net.one97.paytm.o2o.movies.entity.CJRHomePageResponse r6 = new net.one97.paytm.o2o.movies.entity.CJRHomePageResponse
                r6.<init>(r0, r2, r7, r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.c.k.a(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public c(net.one97.paytm.o2o.movies.e.a aVar) {
        kotlin.g.b.k.c(aVar, "moviesHomeModel");
        this.u = aVar;
    }

    public final void a(CJRSelectCityModel cJRSelectCityModel, String str, String str2) {
        kotlin.g.b.k.c(cJRSelectCityModel, "selectedLocation");
        kotlin.g.b.k.c(str, "urlType");
        kotlin.g.b.k.c(str2, "localLang");
        a(cJRSelectCityModel, str);
        a();
        a(cJRSelectCityModel);
        a(cJRSelectCityModel.getValue());
        b(cJRSelectCityModel);
        c(cJRSelectCityModel);
        this.f76068h.setValue(Boolean.TRUE);
        Context context = this.f76061a;
        io.reactivex.rxjava3.a.y.a(context != null ? a(context) : null, a(cJRSelectCityModel.getValue(), str, str2), new k(this)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new j(this));
    }

    public static final class j extends io.reactivex.rxjava3.g.d<CJRHomePageResponse> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76079b;

        j(c cVar) {
            this.f76079b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional e2;
            CJRHomePageResponse cJRHomePageResponse = (CJRHomePageResponse) obj;
            synchronized (this.f76079b.y) {
                this.f76079b.o.setValue(cJRHomePageResponse);
                if (this.f76079b.q != null) {
                    this.f76079b.f76069i.setValue(this.f76079b.q);
                }
                if (this.f76079b.n != null) {
                    this.f76079b.k.setValue(this.f76079b.n);
                }
                if (this.f76079b.v != null) {
                    this.f76079b.j.setValue(this.f76079b.v);
                }
                if (!(this.f76079b.w == null || (e2 = this.f76079b.w) == null || e2.isEmpty())) {
                    this.f76079b.l.setValue(this.f76079b.w);
                    c.f(this.f76079b);
                }
                x xVar = x.f47997a;
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel make all api calls");
        }
    }

    private final void a() {
        Context context = this.f76061a;
        if (context != null) {
            net.one97.paytm.o2o.movies.storefront.a.a(context, "paytm-movies-ott").b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new d(this), (io.reactivex.rxjava3.d.g<? super Throwable>) e.f76074a);
        }
    }

    private final void a(CJRSelectCityModel cJRSelectCityModel, String str) {
        io.reactivex.rxjava3.a.y<Optional<CJRHomePageV2>> b2;
        io.reactivex.rxjava3.a.y<Optional<CJRHomePageV2>> a2;
        io.reactivex.rxjava3.a.y<Optional<CJRHomePageV2>> b3 = b(cJRSelectCityModel, str);
        if (b3 != null && (b2 = b3.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b2.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
            a2.c(new f(this));
        }
    }

    public static final class f extends io.reactivex.rxjava3.g.d<Optional<CJRHomePageV2>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76075b;

        f(c cVar) {
            this.f76075b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            synchronized (this.f76075b.y) {
                this.f76075b.q = optional;
                if (!optional.isEmpty() && this.f76075b.o.getValue() != null) {
                    this.f76075b.f76069i.setValue(this.f76075b.q);
                }
                x xVar = x.f47997a;
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel top banners call");
        }
    }

    private void a(CJRSelectCityModel cJRSelectCityModel) {
        io.reactivex.rxjava3.a.y<Optional<CJRGetMetricInfoResponse>> d2;
        io.reactivex.rxjava3.a.y<Optional<CJRGetMetricInfoResponse>> b2;
        io.reactivex.rxjava3.a.y<Optional<CJRGetMetricInfoResponse>> a2;
        if (cJRSelectCityModel != null && (d2 = d(cJRSelectCityModel)) != null && (b2 = d2.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b2.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
            a2.c(new C1500c(this));
        }
    }

    /* renamed from: net.one97.paytm.o2o.movies.viewmodel.c$c  reason: collision with other inner class name */
    public static final class C1500c extends io.reactivex.rxjava3.g.d<Optional<CJRGetMetricInfoResponse>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76072b;

        C1500c(c cVar) {
            this.f76072b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            this.f76072b.v = optional;
            if (!optional.isEmpty() && this.f76072b.o.getValue() != null) {
                this.f76072b.j.setValue(optional);
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel like dislike data");
        }
    }

    public final void a(String str) {
        io.reactivex.rxjava3.a.y<Optional<CJRMoviePassHomeModel>> b2;
        io.reactivex.rxjava3.a.y<Optional<CJRMoviePassHomeModel>> b3;
        io.reactivex.rxjava3.a.y<Optional<CJRMoviePassHomeModel>> a2;
        if (str != null && (b2 = b(str)) != null && (b3 = b2.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b3.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
            a2.c(new q(this));
        }
    }

    public static final class q extends io.reactivex.rxjava3.g.d<Optional<CJRMoviePassHomeModel>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76086b;

        q(c cVar) {
            this.f76086b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            if (!optional.isEmpty()) {
                this.f76086b.r.setValue(optional.get());
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel movie pass api call");
        }
    }

    private final void b(CJRSelectCityModel cJRSelectCityModel) {
        io.reactivex.rxjava3.a.y<Optional<CJRUpcomingMovies>> b2;
        io.reactivex.rxjava3.a.y<Optional<CJRUpcomingMovies>> a2;
        io.reactivex.rxjava3.a.y<Optional<CJRUpcomingMovies>> c2 = c(cJRSelectCityModel != null ? cJRSelectCityModel.getValue() : null);
        if (c2 != null && (b2 = c2.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b2.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
            a2.c(new h(this));
        }
    }

    public static final class h extends io.reactivex.rxjava3.g.d<Optional<CJRUpcomingMovies>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76077b;

        h(c cVar) {
            this.f76077b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            this.f76077b.w = optional;
            if (!optional.isEmpty()) {
                this.f76077b.l.setValue(this.f76077b.w);
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel upcoming movies api call");
        }
    }

    public static final class g extends io.reactivex.rxjava3.g.d<Optional<EmptyModel>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76076b;

        g(c cVar) {
            this.f76076b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            try {
                com.google.gson.f fVar = new com.google.gson.f();
                EmptyModel emptyModel = (EmptyModel) optional.get();
                com.google.gson.o e2 = ((com.google.gson.o) fVar.a(emptyModel != null ? emptyModel.jsonData : null, com.google.gson.o.class)).e("metricInfos");
                this.f76076b.m.setValue(e2);
                net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
                kotlin.g.b.k.a((Object) a2, "CJRMovieSearchResponseHo…erSingleton.getInstance()");
                a2.l = e2;
            } catch (Exception unused) {
                s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
                net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel make all api calls");
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel upcoming movies api call");
        }
    }

    private final void c(CJRSelectCityModel cJRSelectCityModel) {
        io.reactivex.rxjava3.a.y<Optional<EmptyModel>> b2;
        io.reactivex.rxjava3.a.y<Optional<EmptyModel>> a2;
        io.reactivex.rxjava3.a.y<Optional<EmptyModel>> e2 = e(cJRSelectCityModel);
        if (e2 != null && (b2 = e2.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b2.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
            a2.c(new b(this));
        }
    }

    public static final class b extends io.reactivex.rxjava3.g.d<Optional<EmptyModel>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76071b;

        b(c cVar) {
            this.f76071b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            if (!optional.isEmpty()) {
                try {
                    this.f76071b.t.setValue(new com.google.gson.f().a(((EmptyModel) optional.get()).jsonData, Events.class));
                } catch (Exception unused) {
                }
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            s.a aVar = net.one97.paytm.o2o.movies.utils.s.f75980a;
            net.one97.paytm.o2o.movies.utils.u.a(net.one97.paytm.o2o.movies.utils.s.f75981b, "Friday", "homeviewmodel upcoming movies api call");
        }
    }

    public final io.reactivex.rxjava3.a.y<Optional<CJRBookedMovieTicketResponse>> a(Context context) {
        String b2 = net.one97.paytm.o2o.movies.utils.j.b(context);
        if (TextUtils.isEmpty(b2) || !com.paytm.utility.b.r(context)) {
            return io.reactivex.rxjava3.a.y.a(new Optional(null));
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(b());
        HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) hashMap, context);
        kotlin.g.b.k.a((Object) a2, "CJRAppCommonUtility.addS…r(tempHeader, appContext)");
        return a(b2, CJRBookedMovieTicketResponse.class, (Map<String, String>) a2).c(l.f76081a);
    }

    private final io.reactivex.rxjava3.a.y<Optional<CJRMovieHomeDataResponse>> a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return io.reactivex.rxjava3.a.y.a(new Optional(null));
        }
        if (str2 == null || !kotlin.m.p.a(str2, "freemovie", true)) {
            str4 = net.one97.paytm.o2o.movies.utils.j.a(this.f76061a, str);
            kotlin.g.b.k.a((Object) str4, "CJRMoviesApiUtils.getMov…ontext, selectedLocation)");
        } else {
            str4 = net.one97.paytm.o2o.movies.utils.j.b(this.f76061a, str);
            kotlin.g.b.k.a((Object) str4, "CJRMoviesApiUtils.getFre…ontext, selectedLocation)");
        }
        String n2 = com.paytm.utility.b.n(this.f76061a);
        if (!com.paytm.utility.v.a(n2) && net.one97.paytm.o2o.movies.utils.n.c(this.f76061a)) {
            str4 = str4 + "&userId=" + n2;
        }
        return a(str4 + "&lang=" + str3, CJRMovieHomeDataResponse.class, b()).c(p.f76085a);
    }

    static final class v<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f76091a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f76092b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f76093c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f76094d;

        v(c cVar, String str, Map map, Class cls) {
            this.f76091a = cVar;
            this.f76092b = str;
            this.f76093c = map;
            this.f76094d = cls;
        }

        public static final class a implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ v f76095a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ z f76096b;

            a(v vVar, z zVar) {
                this.f76095a = vVar;
                this.f76096b = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
                if (this.f76095a.f76094d.isInstance(iJRPaytmDataModel)) {
                    this.f76096b.onSuccess(new Optional(this.f76095a.f76094d.cast(iJRPaytmDataModel)));
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
                kotlin.g.b.k.c(networkCustomError, "networkCustomError");
                this.f76096b.onError(new ClassCastException("Class Can not be casted"));
            }
        }

        public final void subscribe(z<Optional<T>> zVar) {
            kotlin.g.b.k.c(zVar, "emitter");
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = this.f76091a.f76061a;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.GET;
            cVar.f42880d = this.f76092b;
            cVar.f42881e = null;
            cVar.f42882f = this.f76093c;
            cVar.f42883g = null;
            cVar.f42884h = null;
            cVar.f42885i = (IJRPaytmDataModel) this.f76094d.newInstance();
            cVar.j = new a(this, zVar);
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = net.one97.paytm.o2o.movies.utils.n.h("MovieHomeViewModel");
            com.paytm.network.a l = cVar.l();
            l.f42859c = false;
            l.a();
        }
    }

    private <T extends IJRPaytmDataModel> io.reactivex.rxjava3.a.y<Optional<T>> a(String str, Class<T> cls, Map<String, String> map) {
        kotlin.g.b.k.c(cls, "tClass");
        kotlin.g.b.k.c(map, H5Logger.HEADER);
        io.reactivex.rxjava3.a.y<Optional<T>> a2 = io.reactivex.rxjava3.a.y.a(new v(this, str, map, cls));
        kotlin.g.b.k.a((Object) a2, "Single.create { emitter:…etworkRequest()\n        }");
        return a2;
    }

    static final class w<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f76097a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f76098b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f76099c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f76100d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Class f76101e;

        w(c cVar, String str, Map map, String str2, Class cls) {
            this.f76097a = cVar;
            this.f76098b = str;
            this.f76099c = map;
            this.f76100d = str2;
            this.f76101e = cls;
        }

        public static final class a implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ w f76102a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ z f76103b;

            a(w wVar, z zVar) {
                this.f76102a = wVar;
                this.f76103b = zVar;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
                if (this.f76102a.f76101e.isInstance(iJRPaytmDataModel)) {
                    this.f76103b.onSuccess(new Optional(this.f76102a.f76101e.cast(iJRPaytmDataModel)));
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                kotlin.g.b.k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
                kotlin.g.b.k.c(networkCustomError, "networkCustomError");
                this.f76103b.onError(new ClassCastException("Class Can not be casted"));
            }
        }

        public final void subscribe(z<Optional<T>> zVar) {
            kotlin.g.b.k.c(zVar, "emitter");
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = this.f76097a.f76061a;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.POST;
            cVar.f42880d = this.f76098b;
            cVar.f42881e = null;
            cVar.f42882f = this.f76099c;
            cVar.f42883g = null;
            cVar.f42884h = this.f76100d;
            cVar.f42885i = (IJRPaytmDataModel) this.f76101e.newInstance();
            cVar.j = new a(this, zVar);
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = net.one97.paytm.o2o.movies.utils.n.h("MovieHomeViewModel");
            com.paytm.network.a l = cVar.l();
            l.f42859c = false;
            l.a();
        }
    }

    private <T extends IJRPaytmDataModel> io.reactivex.rxjava3.a.y<Optional<T>> a(String str, Class<T> cls, Map<String, String> map, String str2) {
        kotlin.g.b.k.c(cls, "tClass");
        kotlin.g.b.k.c(map, "headers");
        return io.reactivex.rxjava3.a.y.a(new w(this, str, map, str2, cls));
    }

    public static final class u extends io.reactivex.rxjava3.g.d<Optional<CJRBookedMovieTicketResponse>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76090b;

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
        }

        public u(c cVar) {
            this.f76090b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "t");
            if (!optional.isEmpty()) {
                this.f76090b.s.setValue(optional.get());
            }
        }
    }

    private final io.reactivex.rxjava3.a.y<Optional<CJRHomePageV2>> b(CJRSelectCityModel cJRSelectCityModel, String str) {
        String str2;
        String str3;
        if (kotlin.m.p.a(str, "freemovie", true)) {
            str3 = net.one97.paytm.o2o.movies.utils.j.a(this.f76061a);
            str2 = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.postRequestBodyForV2(this.f76061a, "paytm-home", "movies page");
        } else {
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesHomePageBanner_v2", (String) null);
            str2 = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.createRequestBodyForV2(this.f76061a, "paytm-home", "movies page", cJRSelectCityModel);
            str3 = a2;
        }
        String s2 = com.paytm.utility.b.s(this.f76061a, str3);
        HashMap<String, String> n2 = com.paytm.utility.b.n();
        kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.postRequestHeaderForV2()");
        Map map = n2;
        map.put("ClientId", "paytm");
        io.reactivex.rxjava3.a.y<Optional<CJRHomePageV2>> a3 = a(s2, CJRHomePageV2.class, map, str2);
        if (a3 != null) {
            return a3.c((io.reactivex.rxjava3.d.h<Throwable, ? extends Optional<CJRHomePageV2>>) r.f76087a);
        }
        return null;
    }

    private final io.reactivex.rxjava3.a.y<Optional<CJRGetMetricInfoResponse>> d(CJRSelectCityModel cJRSelectCityModel) {
        kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        StringBuilder sb = new StringBuilder(net.one97.paytm.o2o.movies.common.b.c.f());
        sb.append("?cityName=" + cJRSelectCityModel.getValue());
        String n2 = com.paytm.utility.b.n(this.f76061a);
        if (!com.paytm.utility.v.a(n2) && net.one97.paytm.o2o.movies.utils.n.c(this.f76061a)) {
            sb.append("&custId=");
            sb.append(n2);
        }
        return a(sb.toString(), CJRGetMetricInfoResponse.class, b()).c(o.f76084a);
    }

    private final io.reactivex.rxjava3.a.y<Optional<CJRMoviePassHomeModel>> b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return io.reactivex.rxjava3.a.y.a(new Optional(null));
        }
        kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviePassBannerURL_v2", (String) null);
        if (!com.paytm.utility.v.a(str)) {
            a2 = net.one97.paytm.o2o.movies.utils.n.a("city", str, a2);
        }
        String n2 = com.paytm.utility.b.n(this.f76061a);
        if (!com.paytm.utility.v.a(n2) && net.one97.paytm.o2o.movies.utils.n.c(this.f76061a)) {
            a2 = net.one97.paytm.o2o.movies.utils.n.a("customerId", n2, a2);
        }
        CJRHomePageResponse.Language language = this.u.f75235e;
        if (language != null) {
            str2 = language.languageForOperation;
        }
        return a(net.one97.paytm.o2o.movies.utils.n.a(ContactsConstant.LOCALE, str2, a2).toString(), CJRMoviePassHomeModel.class, b()).c(i.f76078a);
    }

    private static Map<String, String> b() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("ClientId", "paytm");
        return hashMap;
    }

    private final io.reactivex.rxjava3.a.y<Optional<CJRUpcomingMovies>> c(String str) {
        CJRHomePageResponse.Language language = this.u.f75235e;
        String str2 = language != null ? language.languageForOperation : null;
        kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        return a(net.one97.paytm.o2o.movies.utils.n.a("city", str, net.one97.paytm.o2o.movies.utils.n.a(ContactsConstant.LOCALE, str2, net.one97.paytm.o2o.movies.common.b.c.d())), CJRUpcomingMovies.class, b()).c(t.f76089a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        if (kotlin.m.p.a(r3.getLayout(), net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_CAROUSEL1.getName(), true) == false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 a(net.one97.paytm.common.entity.shopping.CJRHomePageV2 r7) {
        /*
            java.lang.String r0 = "moviesBannerResponse"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r0 = new net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2
            r0.<init>()
            java.util.ArrayList r7 = c((net.one97.paytm.common.entity.shopping.CJRHomePageV2) r7)     // Catch:{ Exception -> 0x0076 }
            r1 = 0
            r2 = r7
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x0076 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0076 }
        L_0x0016:
            if (r1 >= r2) goto L_0x0076
            java.lang.Object r3 = r7.get(r1)     // Catch:{ Exception -> 0x0076 }
            r4 = 1
            java.lang.String r5 = "mHomePageLyt[i]"
            if (r3 == 0) goto L_0x0049
            java.lang.Object r3 = r7.get(r1)     // Catch:{ Exception -> 0x0076 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r3     // Catch:{ Exception -> 0x0076 }
            java.lang.String r3 = r3.getLayout()     // Catch:{ Exception -> 0x0076 }
            if (r3 == 0) goto L_0x0049
            java.lang.Object r3 = r7.get(r1)     // Catch:{ Exception -> 0x0076 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r3     // Catch:{ Exception -> 0x0076 }
            java.lang.String r3 = r3.getLayout()     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.LayoutType r6 = net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_CAROUSEL1     // Catch:{ Exception -> 0x0076 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0076 }
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r4)     // Catch:{ Exception -> 0x0076 }
            if (r3 != 0) goto L_0x0069
        L_0x0049:
            java.lang.Object r3 = r7.get(r1)     // Catch:{ Exception -> 0x0076 }
            if (r3 != 0) goto L_0x0052
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0076 }
        L_0x0052:
            java.lang.String r6 = "mHomePageLyt[i]!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r3     // Catch:{ Exception -> 0x0076 }
            java.lang.String r3 = r3.getLayout()     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.LayoutType r6 = net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_CAROUSEL_1     // Catch:{ Exception -> 0x0076 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0076 }
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r4)     // Catch:{ Exception -> 0x0076 }
            if (r3 == 0) goto L_0x0073
        L_0x0069:
            java.lang.Object r3 = r7.get(r1)     // Catch:{ Exception -> 0x0076 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r3     // Catch:{ Exception -> 0x0076 }
            r0 = r3
        L_0x0073:
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.viewmodel.c.a(net.one97.paytm.common.entity.shopping.CJRHomePageV2):net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2");
    }

    private static ArrayList<CJRHomePageLayoutV2> c(CJRHomePageV2 cJRHomePageV2) {
        ArrayList<CJRHomePageDetailV2> arrayList = cJRHomePageV2.getmPage();
        ArrayList<CJRHomePageLayoutV2> arrayList2 = new ArrayList<>();
        Iterator<CJRHomePageDetailV2> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRHomePageDetailV2 next = it2.next();
            kotlin.g.b.k.a((Object) next, "c");
            arrayList2.addAll(next.getHomePageLayoutList());
        }
        return arrayList2;
    }

    public static ArrayList<CJRHomePageLayoutV2> b(CJRHomePageV2 cJRHomePageV2) {
        ArrayList<CJRHomePageLayoutV2> arrayList;
        ArrayList<CJRHomePageLayoutV2> arrayList2 = new ArrayList<>();
        if (cJRHomePageV2 != null) {
            try {
                arrayList = c(cJRHomePageV2);
            } catch (Exception unused) {
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                CJRHomePageLayoutV2 cJRHomePageLayoutV2 = arrayList.get(i2);
                kotlin.g.b.k.a((Object) cJRHomePageLayoutV2, "mHomePageLyt[i]");
                if (cJRHomePageLayoutV2.getLayout() != null) {
                    CJRHomePageLayoutV2 cJRHomePageLayoutV22 = arrayList.get(i2);
                    kotlin.g.b.k.a((Object) cJRHomePageLayoutV22, "mHomePageLyt[i]");
                    if (!kotlin.m.p.a(cJRHomePageLayoutV22.getLayout(), LayoutType.LAYOUT_CAROUSEL4.getName(), true)) {
                        CJRHomePageLayoutV2 cJRHomePageLayoutV23 = arrayList.get(i2);
                        if (cJRHomePageLayoutV23 == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) cJRHomePageLayoutV23, "mHomePageLyt[i]!!");
                        if (!kotlin.m.p.a(cJRHomePageLayoutV23.getLayout(), LayoutType.LAYOUT_CAROUSEL_4.getName(), true)) {
                            CJRHomePageLayoutV2 cJRHomePageLayoutV24 = arrayList.get(i2);
                            kotlin.g.b.k.a((Object) cJRHomePageLayoutV24, "mHomePageLyt[i]");
                            if (!kotlin.m.p.a(cJRHomePageLayoutV24.getLayout(), LayoutType.LAYOUT_CAROUSEL_5.getName(), true)) {
                                CJRHomePageLayoutV2 cJRHomePageLayoutV25 = arrayList.get(i2);
                                kotlin.g.b.k.a((Object) cJRHomePageLayoutV25, "mHomePageLyt[i]");
                                if (!kotlin.m.p.a(cJRHomePageLayoutV25.getLayout(), LayoutType.LAYOUT_CAROUSEL5.getName(), true)) {
                                }
                            }
                        }
                    }
                    CJRHomePageLayoutV2 cJRHomePageLayoutV26 = arrayList.get(i2);
                    kotlin.g.b.k.a((Object) cJRHomePageLayoutV26, "mHomePageLyt[i]");
                    if (cJRHomePageLayoutV26.getHomePageItemList() != null) {
                        CJRHomePageLayoutV2 cJRHomePageLayoutV27 = arrayList.get(i2);
                        kotlin.g.b.k.a((Object) cJRHomePageLayoutV27, "mHomePageLyt[i]");
                        if (cJRHomePageLayoutV27.getHomePageItemList().size() > 0) {
                            arrayList2.add(arrayList.get(i2));
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public final void a(CJRSelectCityModel cJRSelectCityModel, Location location, String str) {
        io.reactivex.rxjava3.a.y<Optional<CJRBrowseByCinema>> b2;
        io.reactivex.rxjava3.a.y<Optional<CJRBrowseByCinema>> b3;
        io.reactivex.rxjava3.a.y<Optional<CJRBrowseByCinema>> a2;
        kotlin.g.b.k.c(cJRSelectCityModel, "selectedLocation");
        if (this.n == null && !TextUtils.isEmpty(cJRSelectCityModel.getValue())) {
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            if (!TextUtils.isEmpty(net.one97.paytm.o2o.movies.common.b.c.a("movieCinemaURLV3", (String) null)) && str != null && (b2 = b(cJRSelectCityModel, location, str)) != null && (b3 = b2.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b3.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
                a2.c(new a(this));
            }
        }
    }

    public static final class a extends io.reactivex.rxjava3.g.d<Optional<CJRBrowseByCinema>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f76070b;

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "p0");
        }

        a(c cVar) {
            this.f76070b = cVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "p0");
            synchronized (this.f76070b.y) {
                if (this.f76070b.n == null) {
                    this.f76070b.n = c.a(optional);
                    if (!(optional.isEmpty() || this.f76070b.o == null || this.f76070b.o.getValue() == null)) {
                        this.f76070b.k.setValue(this.f76070b.n);
                    }
                }
                x xVar = x.f47997a;
            }
        }
    }

    private final io.reactivex.rxjava3.a.y<Optional<CJRBrowseByCinema>> b(CJRSelectCityModel cJRSelectCityModel, Location location, String str) {
        String str2;
        kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        StringBuilder sb = new StringBuilder(net.one97.paytm.o2o.movies.common.b.c.a("movieCinemaURLV3", (String) null));
        sb.append("?city=" + cJRSelectCityModel.getValue());
        String str3 = "";
        if (location != null) {
            str3 = String.valueOf(location.getLatitude());
            str2 = String.valueOf(location.getLongitude());
        } else {
            str2 = str3;
        }
        String n2 = com.paytm.utility.b.n(this.f76061a);
        if (!com.paytm.utility.v.a(n2) && net.one97.paytm.o2o.movies.utils.n.c(this.f76061a)) {
            sb.append("&userId=");
            sb.append(n2);
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            sb.append("&lat=".concat(String.valueOf(str3)));
            sb.append("&lon=".concat(String.valueOf(str2)));
        }
        sb.append("&lang=".concat(String.valueOf(str)));
        return a(sb.toString(), CJRBrowseByCinema.class, b()).c(m.f76082a);
    }

    private io.reactivex.rxjava3.a.y<Optional<EmptyModel>> e(CJRSelectCityModel cJRSelectCityModel) {
        String str;
        kotlin.g.b.k.c(cJRSelectCityModel, "selectedLocation");
        String value = cJRSelectCityModel.getValue();
        kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        if (!TextUtils.isEmpty(net.one97.paytm.o2o.movies.common.b.c.a("events_home_url", (String) null))) {
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            str = net.one97.paytm.o2o.movies.common.b.c.a("events_home_url", (String) null);
            kotlin.g.b.k.a((Object) str, "MoviesGTMLoader.getInstance().eventsOnHomeUrl");
        } else {
            str = "https://apiproxy.paytm.com/v3/movies/search/events/home?";
        }
        return a((str + "city=" + value).toString(), EmptyModel.class, (Map<String, String>) new HashMap()).c(n.f76083a);
    }

    static final class l<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRBookedMovieTicketResponse>> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f76081a = new l();

        l() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class p<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRMovieHomeDataResponse>> {

        /* renamed from: a  reason: collision with root package name */
        public static final p f76085a = new p();

        p() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class r<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRHomePageV2>> {

        /* renamed from: a  reason: collision with root package name */
        public static final r f76087a = new r();

        r() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class o<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRGetMetricInfoResponse>> {

        /* renamed from: a  reason: collision with root package name */
        public static final o f76084a = new o();

        o() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class i<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRMoviePassHomeModel>> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f76078a = new i();

        i() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class t<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRUpcomingMovies>> {

        /* renamed from: a  reason: collision with root package name */
        public static final t f76089a = new t();

        t() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class m<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<CJRBrowseByCinema>> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f76082a = new m();

        m() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class s<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<EmptyModel>> {

        /* renamed from: a  reason: collision with root package name */
        public static final s f76088a = new s();

        s() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    static final class n<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Optional<EmptyModel>> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f76083a = new n();

        n() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Optional(null);
        }
    }

    public static final /* synthetic */ void a(CJRMovieHomeDataResponse cJRMovieHomeDataResponse) {
        CJRMovieHomeList data = cJRMovieHomeDataResponse.getData();
        if (data == null) {
            kotlin.g.b.k.a();
        }
        ArrayList<CJRMovieHomeListItem> movies = data.getMovies();
        ArrayList arrayList = new ArrayList();
        if (movies != null) {
            Iterator<CJRMovieHomeListItem> it2 = movies.iterator();
            while (it2.hasNext()) {
                CJRMovieHomeListItem next = it2.next();
                if (!arrayList.contains(next)) {
                    if (next.getScrnFmtList() == null) {
                        next.setScrnFmtList(new ArrayList());
                        GroupFormatObject groupFormatObject = new GroupFormatObject(next.getId(), next.getScrnFmt());
                        ArrayList<GroupFormatObject> scrnFmtList = next.getScrnFmtList();
                        if (scrnFmtList == null) {
                            kotlin.g.b.k.a();
                        }
                        scrnFmtList.add(groupFormatObject);
                    }
                    arrayList.add(next);
                } else {
                    Object obj = arrayList.get(arrayList.indexOf(next));
                    kotlin.g.b.k.a(obj, "newCjrMovieHomeListItems…Of(cjrMovieHomeListItem)]");
                    CJRMovieHomeListItem cJRMovieHomeListItem = (CJRMovieHomeListItem) obj;
                    cJRMovieHomeListItem.setTotalSessionCount(cJRMovieHomeListItem.getTotalSessionCount() + next.getTotalSessionCount());
                    GroupFormatObject groupFormatObject2 = new GroupFormatObject(next.getId(), next.getScrnFmt());
                    if (cJRMovieHomeListItem.getScrnFmtList() != null) {
                        ArrayList<GroupFormatObject> scrnFmtList2 = cJRMovieHomeListItem.getScrnFmtList();
                        if (scrnFmtList2 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!scrnFmtList2.contains(groupFormatObject2)) {
                            ArrayList<GroupFormatObject> scrnFmtList3 = cJRMovieHomeListItem.getScrnFmtList();
                            if (scrnFmtList3 == null) {
                                kotlin.g.b.k.a();
                            }
                            scrnFmtList3.add(groupFormatObject2);
                        }
                    }
                }
            }
            CJRMovieHomeList data2 = cJRMovieHomeDataResponse.getData();
            if (data2 == null) {
                kotlin.g.b.k.a();
            }
            data2.setMovies(arrayList);
        }
    }

    public static final /* synthetic */ ArrayList b(CJRMovieHomeDataResponse cJRMovieHomeDataResponse) {
        ArrayList arrayList = new ArrayList();
        if (cJRMovieHomeDataResponse == null || cJRMovieHomeDataResponse.getData() == null) {
            return null;
        }
        CJRMovieHomeList data = cJRMovieHomeDataResponse.getData();
        if (data == null) {
            kotlin.g.b.k.a();
        }
        if (data.getMovies() == null) {
            return null;
        }
        CJRMovieHomeList data2 = cJRMovieHomeDataResponse.getData();
        if (data2 == null) {
            kotlin.g.b.k.a();
        }
        ArrayList<CJRMovieHomeListItem> movies = data2.getMovies();
        if (movies == null) {
            kotlin.g.b.k.a();
        }
        ArrayList arrayList2 = new ArrayList(movies);
        if (arrayList2.size() > 0) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList2.get(i2) != null) {
                    Object obj = arrayList2.get(i2);
                    if (obj == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!TextUtils.isEmpty(((CJRMovieHomeListItem) obj).getLang())) {
                        CJRHomePageResponse.Language language = new CJRHomePageResponse.Language();
                        Object obj2 = arrayList2.get(i2);
                        if (obj2 == null) {
                            kotlin.g.b.k.a();
                        }
                        language.languageToDisplay = ((CJRMovieHomeListItem) obj2).getLang();
                        Object obj3 = arrayList2.get(i2);
                        if (obj3 == null) {
                            kotlin.g.b.k.a();
                        }
                        language.languageForOperation = ((CJRMovieHomeListItem) obj3).getLang();
                        Object obj4 = arrayList2.get(i2);
                        if (obj4 == null) {
                            kotlin.g.b.k.a();
                        }
                        language.sessionCount = ((CJRMovieHomeListItem) obj4).getTotalSessionCount();
                        if (!arrayList.contains(language)) {
                            arrayList.add(language);
                        } else {
                            int indexOf = arrayList.indexOf(language);
                            Object obj5 = arrayList.get(indexOf);
                            if (obj5 == null) {
                                kotlin.g.b.k.a();
                            }
                            CJRHomePageResponse.Language language2 = (CJRHomePageResponse.Language) obj5;
                            Object obj6 = arrayList.get(indexOf);
                            if (obj6 == null) {
                                kotlin.g.b.k.a();
                            }
                            int i3 = ((CJRHomePageResponse.Language) obj6).sessionCount;
                            Object obj7 = arrayList2.get(i2);
                            if (obj7 == null) {
                                kotlin.g.b.k.a();
                            }
                            language2.sessionCount = i3 + ((CJRMovieHomeListItem) obj7).getTotalSessionCount();
                        }
                    }
                }
            }
        }
        List list = arrayList;
        Collections.sort(list);
        Collections.reverse(list);
        return arrayList;
    }

    public static final /* synthetic */ void f(c cVar) {
        String str;
        io.reactivex.rxjava3.a.y<Optional<EmptyModel>> b2;
        io.reactivex.rxjava3.a.y<Optional<EmptyModel>> a2;
        String n2 = com.paytm.utility.b.n(cVar.f76061a);
        kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        if (!TextUtils.isEmpty(net.one97.paytm.o2o.movies.common.b.c.a("interested_data_url", (String) null))) {
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            str = net.one97.paytm.o2o.movies.common.b.c.a("interested_data_url", (String) null);
            kotlin.g.b.k.a((Object) str, "MoviesGTMLoader.getInstance().interestedDataUrl");
        } else {
            str = "https://apiproxy.paytm.com/v1/movies/content/get-upcoming-metrics-info?metricType=INTERESTED";
        }
        io.reactivex.rxjava3.a.y<Optional<EmptyModel>> c2 = cVar.a((str + "&customerId=" + n2).toString(), EmptyModel.class, (Map<String, String>) new HashMap()).c(s.f76088a);
        if (c2 != null && (b2 = c2.b(io.reactivex.rxjava3.i.a.b())) != null && (a2 = b2.a(io.reactivex.rxjava3.android.b.a.a())) != null) {
            a2.c(new g(cVar));
        }
    }

    public static final /* synthetic */ Optional a(Optional optional) {
        CJRBrowseByCinema cJRBrowseByCinema;
        if (optional.isEmpty() || (cJRBrowseByCinema = (CJRBrowseByCinema) optional.get()) == null || cJRBrowseByCinema.getData() == null) {
            return null;
        }
        CJRBrowseByData data = cJRBrowseByCinema.getData();
        if (data == null) {
            kotlin.g.b.k.a();
        }
        if (data.getCinemas() == null) {
            return null;
        }
        CJRBrowseByData data2 = cJRBrowseByCinema.getData();
        if (data2 == null) {
            kotlin.g.b.k.a();
        }
        ArrayList<CJRCinemas> cinemas = data2.getCinemas();
        CJRCinemaV1 cJRCinemaV1 = new CJRCinemaV1();
        cJRCinemaV1.setCinemas(cinemas);
        if (((CJRBrowseByCinema) optional.get()).getMeta() != null) {
            CJRBrowseByCinemaMeta meta = cJRBrowseByCinema.getMeta();
            if (meta == null) {
                kotlin.g.b.k.a();
            }
            cJRCinemaV1.setCjrAmenities(meta.getAmenities());
        }
        return new Optional(cJRCinemaV1);
    }
}
