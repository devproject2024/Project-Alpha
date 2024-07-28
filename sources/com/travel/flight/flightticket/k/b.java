package com.travel.flight.flightticket.k;

import android.app.Application;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.flightticket.e.i;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot;
import java.util.List;
import kotlin.a.w;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.x;

public final class b extends androidx.lifecycle.a implements i.c {

    /* renamed from: a  reason: collision with root package name */
    public List<com.travel.flight.flightticket.e.f> f25266a = w.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    public int f25267b;

    /* renamed from: c  reason: collision with root package name */
    public int f25268c;

    /* renamed from: d  reason: collision with root package name */
    public int f25269d;

    /* renamed from: e  reason: collision with root package name */
    public String f25270e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f25271f = "";

    /* renamed from: g  reason: collision with root package name */
    private final g f25272g = h.a(a.INSTANCE);

    /* renamed from: h  reason: collision with root package name */
    private final g f25273h = h.a(C0472b.INSTANCE);

    /* renamed from: i  reason: collision with root package name */
    private final g f25274i = h.a(c.INSTANCE);
    private final g j = h.a(d.INSTANCE);
    private final g k = h.a(e.INSTANCE);
    private final g l = h.a(f.INSTANCE);

    public final y<com.travel.flight.pojo.a> b() {
        return (y) this.f25272g.getValue();
    }

    public final y<Boolean> c() {
        return (y) this.f25273h.getValue();
    }

    public final y<CJRFlightMBChargesRoot> d() {
        return (y) this.f25274i.getValue();
    }

    public final y<x> e() {
        return (y) this.j.getValue();
    }

    public final y<Boolean> f() {
        return (y) this.k.getValue();
    }

    public final y<x> g() {
        return (y) this.l.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002a, code lost:
        r6 = (r6 = r6.getOnwardItem()).getPassenger_info();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r5, java.util.List<com.travel.flight.flightticket.e.f> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "dataModel"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "cards"
            kotlin.g.b.k.c(r6, r0)
            androidx.lifecycle.y r0 = r4.f()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.setValue(r1)
            r4.f25266a = r6
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot r5 = (com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesRoot) r5
            r6 = 0
            r4.f25267b = r6
            r4.f25268c = r6
            r4.f25269d = r6
            com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody r6 = r5.getBody()
            if (r6 == 0) goto L_0x0035
            com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r6 = r6.getOnwardItem()
            if (r6 == 0) goto L_0x0035
            com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails r6 = r6.getPassenger_info()
            if (r6 == 0) goto L_0x0035
            java.util.List r6 = r6.getPassenger_details()
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            if (r6 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            java.util.Iterator r6 = r6.iterator()
        L_0x003f:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0082
            java.lang.Object r0 = r6.next()
            com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger r0 = (com.travel.flight.pojo.modifyBooking.CJRFlightMBPassenger) r0
            java.lang.String r1 = r0.getType()
            r2 = 1
            java.lang.String r3 = "adult"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 == 0) goto L_0x005e
            int r0 = r4.f25267b
            int r0 = r0 + r2
            r4.f25267b = r0
            goto L_0x003f
        L_0x005e:
            java.lang.String r1 = r0.getType()
            java.lang.String r3 = "child"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 == 0) goto L_0x0070
            int r0 = r4.f25268c
            int r0 = r0 + r2
            r4.f25268c = r0
            goto L_0x003f
        L_0x0070:
            java.lang.String r0 = r0.getType()
            java.lang.String r1 = "infant"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            if (r0 == 0) goto L_0x003f
            int r0 = r4.f25269d
            int r0 = r0 + r2
            r4.f25269d = r0
            goto L_0x003f
        L_0x0082:
            androidx.lifecycle.y r6 = r4.d()
            r6.setValue(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.k.b.a(com.paytm.network.model.IJRPaytmDataModel, java.util.List):void");
    }

    public final void a() {
        f().setValue(Boolean.FALSE);
        c().setValue(Boolean.TRUE);
    }

    public final void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        f().setValue(Boolean.FALSE);
        b().setValue(new com.travel.flight.pojo.a(i2, iJRPaytmDataModel, networkCustomError));
    }

    public static final class a extends l implements kotlin.g.a.a<y<com.travel.flight.pojo.a>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        public final y<com.travel.flight.pojo.a> invoke() {
            return y.class.newInstance();
        }
    }

    /* renamed from: com.travel.flight.flightticket.k.b$b  reason: collision with other inner class name */
    public static final class C0472b extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final C0472b INSTANCE = new C0472b();

        public C0472b() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return y.class.newInstance();
        }
    }

    public static final class c extends l implements kotlin.g.a.a<y<CJRFlightMBChargesRoot>> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        public final y<CJRFlightMBChargesRoot> invoke() {
            return y.class.newInstance();
        }
    }

    public static final class d extends l implements kotlin.g.a.a<y<x>> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        public final y<x> invoke() {
            return y.class.newInstance();
        }
    }

    public static final class e extends l implements kotlin.g.a.a<y<Boolean>> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        public final y<Boolean> invoke() {
            return y.class.newInstance();
        }
    }

    public static final class f extends l implements kotlin.g.a.a<y<x>> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        public final y<x> invoke() {
            return y.class.newInstance();
        }
    }
}
