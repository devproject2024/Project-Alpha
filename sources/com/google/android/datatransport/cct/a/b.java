package com.google.android.datatransport.cct.a;

import com.business.merchant_payments.common.utility.AppConstants;
import easypay.manager.Constants;
import java.io.IOException;

public final class b implements com.google.firebase.encoders.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.firebase.encoders.a.a f7646a = new b();

    static final class a implements com.google.firebase.encoders.d<a> {

        /* renamed from: a  reason: collision with root package name */
        static final a f7647a = new a();

        private a() {
        }

        public final void a(Object obj, Object obj2) throws IOException {
            a aVar = (a) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a(Constants.RISK_SDK_VERSION, (Object) aVar.b());
            eVar.a("model", (Object) aVar.c());
            eVar.a("hardware", (Object) aVar.d());
            eVar.a(AppConstants.TAG_DEVICE, (Object) aVar.e());
            eVar.a("product", (Object) aVar.f());
            eVar.a("osBuild", (Object) aVar.g());
            eVar.a("manufacturer", (Object) aVar.h());
            eVar.a("fingerprint", (Object) aVar.i());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.b$b  reason: collision with other inner class name */
    static final class C0113b implements com.google.firebase.encoders.d<j> {

        /* renamed from: a  reason: collision with root package name */
        static final C0113b f7648a = new C0113b();

        private C0113b() {
        }

        public final void a(Object obj, Object obj2) throws IOException {
            ((com.google.firebase.encoders.e) obj2).a("logRequest", (Object) ((j) obj).a());
        }
    }

    static final class c implements com.google.firebase.encoders.d<k> {

        /* renamed from: a  reason: collision with root package name */
        static final c f7649a = new c();

        private c() {
        }

        public final void a(Object obj, Object obj2) throws IOException {
            k kVar = (k) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("clientType", (Object) kVar.a());
            eVar.a("androidClientInfo", (Object) kVar.b());
        }
    }

    static final class d implements com.google.firebase.encoders.d<l> {

        /* renamed from: a  reason: collision with root package name */
        static final d f7650a = new d();

        private d() {
        }

        public final void a(Object obj, Object obj2) throws IOException {
            l lVar = (l) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("eventTimeMs", lVar.a());
            eVar.a("eventCode", (Object) lVar.b());
            eVar.a("eventUptimeMs", lVar.c());
            eVar.a("sourceExtension", (Object) lVar.d());
            eVar.a("sourceExtensionJsonProto3", (Object) lVar.e());
            eVar.a("timezoneOffsetSeconds", lVar.f());
            eVar.a("networkConnectionInfo", (Object) lVar.g());
        }
    }

    static final class e implements com.google.firebase.encoders.d<m> {

        /* renamed from: a  reason: collision with root package name */
        static final e f7651a = new e();

        private e() {
        }

        public final void a(Object obj, Object obj2) throws IOException {
            m mVar = (m) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("requestTimeMs", mVar.a());
            eVar.a("requestUptimeMs", mVar.b());
            eVar.a("clientInfo", (Object) mVar.c());
            eVar.a("logSource", (Object) mVar.d());
            eVar.a("logSourceName", (Object) mVar.e());
            eVar.a("logEvent", (Object) mVar.f());
            eVar.a("qosTier", (Object) mVar.g());
        }
    }

    static final class f implements com.google.firebase.encoders.d<o> {

        /* renamed from: a  reason: collision with root package name */
        static final f f7652a = new f();

        private f() {
        }

        public final void a(Object obj, Object obj2) throws IOException {
            o oVar = (o) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("networkType", (Object) oVar.a());
            eVar.a("mobileSubtype", (Object) oVar.b());
        }
    }

    private b() {
    }

    public final void a(com.google.firebase.encoders.a.b<?> bVar) {
        bVar.a(j.class, C0113b.f7648a);
        bVar.a(d.class, C0113b.f7648a);
        bVar.a(m.class, e.f7651a);
        bVar.a(g.class, e.f7651a);
        bVar.a(k.class, c.f7649a);
        bVar.a(e.class, c.f7649a);
        bVar.a(a.class, a.f7647a);
        bVar.a(c.class, a.f7647a);
        bVar.a(l.class, d.f7650a);
        bVar.a(f.class, d.f7650a);
        bVar.a(o.class, f.f7652a);
        bVar.a(i.class, f.f7652a);
    }
}
