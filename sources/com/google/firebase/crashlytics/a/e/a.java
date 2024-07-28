package com.google.firebase.crashlytics.a.e;

import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.crashlytics.a.e.v;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import easypay.manager.Constants;
import java.io.IOException;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

public final class a implements com.google.firebase.encoders.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.firebase.encoders.a.a f38378a = new a();

    private a() {
    }

    public final void a(com.google.firebase.encoders.a.b<?> bVar) {
        bVar.a(v.class, b.f38382a);
        bVar.a(b.class, b.f38382a);
        bVar.a(v.d.class, h.f38394a);
        bVar.a(f.class, h.f38394a);
        bVar.a(v.d.a.class, e.f38388a);
        bVar.a(g.class, e.f38388a);
        bVar.a(v.d.a.b.class, f.f38390a);
        bVar.a(h.class, f.f38390a);
        bVar.a(v.d.f.class, t.f38406a);
        bVar.a(u.class, t.f38406a);
        bVar.a(v.d.e.class, s.f38405a);
        bVar.a(t.class, s.f38405a);
        bVar.a(v.d.c.class, g.f38392a);
        bVar.a(i.class, g.f38392a);
        bVar.a(v.d.C0634d.class, q.f38403a);
        bVar.a(j.class, q.f38403a);
        bVar.a(v.d.C0634d.a.class, i.f38395a);
        bVar.a(k.class, i.f38395a);
        bVar.a(v.d.C0634d.a.b.class, k.f38397a);
        bVar.a(l.class, k.f38397a);
        bVar.a(v.d.C0634d.a.b.e.class, n.f38400a);
        bVar.a(p.class, n.f38400a);
        bVar.a(v.d.C0634d.a.b.e.C0643b.class, o.f38401a);
        bVar.a(q.class, o.f38401a);
        bVar.a(v.d.C0634d.a.b.c.class, l.f38398a);
        bVar.a(n.class, l.f38398a);
        bVar.a(v.d.C0634d.a.b.C0640d.class, m.f38399a);
        bVar.a(o.class, m.f38399a);
        bVar.a(v.d.C0634d.a.b.C0636a.class, j.f38396a);
        bVar.a(m.class, j.f38396a);
        bVar.a(v.b.class, C0631a.f38380a);
        bVar.a(c.class, C0631a.f38380a);
        bVar.a(v.d.C0634d.c.class, p.f38402a);
        bVar.a(r.class, p.f38402a);
        bVar.a(v.d.C0634d.C0645d.class, r.f38404a);
        bVar.a(s.class, r.f38404a);
        bVar.a(v.c.class, c.f38384a);
        bVar.a(d.class, c.f38384a);
        bVar.a(v.c.b.class, d.f38386a);
        bVar.a(e.class, d.f38386a);
    }

    static final class b implements com.google.firebase.encoders.d<v> {

        /* renamed from: a  reason: collision with root package name */
        static final b f38382a = new b();

        private b() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v vVar = (v) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a(Constants.RISK_SDK_VERSION, (Object) vVar.a());
            eVar.a("gmpAppId", (Object) vVar.b());
            eVar.a("platform", vVar.c());
            eVar.a("installationUuid", (Object) vVar.d());
            eVar.a("buildVersion", (Object) vVar.e());
            eVar.a("displayVersion", (Object) vVar.f());
            eVar.a("session", (Object) vVar.g());
            eVar.a("ndkPayload", (Object) vVar.h());
        }
    }

    static final class h implements com.google.firebase.encoders.d<v.d> {

        /* renamed from: a  reason: collision with root package name */
        static final h f38394a = new h();

        private h() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d dVar = (v.d) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("generator", (Object) dVar.a());
            eVar.a("identifier", (Object) dVar.b().getBytes(v.f38572a));
            eVar.a("startedAt", dVar.c());
            eVar.a("endedAt", (Object) dVar.d());
            eVar.a("crashed", dVar.e());
            eVar.a(AppManagerUtil.EXTEND_PREFIX_DEFAULT, (Object) dVar.f());
            eVar.a(StringSet.user, (Object) dVar.g());
            eVar.a("os", (Object) dVar.h());
            eVar.a(AppConstants.TAG_DEVICE, (Object) dVar.i());
            eVar.a(EventsModuleManager.MODULE_NAME, (Object) dVar.j());
            eVar.a("generatorType", dVar.k());
        }
    }

    static final class e implements com.google.firebase.encoders.d<v.d.a> {

        /* renamed from: a  reason: collision with root package name */
        static final e f38388a = new e();

        private e() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.a aVar = (v.d.a) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("identifier", (Object) aVar.a());
            eVar.a("version", (Object) aVar.b());
            eVar.a("displayVersion", (Object) aVar.c());
            eVar.a("organization", (Object) aVar.d());
            eVar.a("installationUuid", (Object) aVar.e());
        }
    }

    static final class f implements com.google.firebase.encoders.d<v.d.a.b> {

        /* renamed from: a  reason: collision with root package name */
        static final f f38390a = new f();

        private f() {
        }

        public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            ((com.google.firebase.encoders.e) obj2).a("clsId", (Object) ((v.d.a.b) obj).a());
        }
    }

    static final class t implements com.google.firebase.encoders.d<v.d.f> {

        /* renamed from: a  reason: collision with root package name */
        static final t f38406a = new t();

        private t() {
        }

        public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            ((com.google.firebase.encoders.e) obj2).a("identifier", (Object) ((v.d.f) obj).a());
        }
    }

    static final class s implements com.google.firebase.encoders.d<v.d.e> {

        /* renamed from: a  reason: collision with root package name */
        static final s f38405a = new s();

        private s() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.e eVar = (v.d.e) obj;
            com.google.firebase.encoders.e eVar2 = (com.google.firebase.encoders.e) obj2;
            eVar2.a("platform", eVar.a());
            eVar2.a("version", (Object) eVar.b());
            eVar2.a("buildVersion", (Object) eVar.c());
            eVar2.a("jailbroken", eVar.d());
        }
    }

    static final class g implements com.google.firebase.encoders.d<v.d.c> {

        /* renamed from: a  reason: collision with root package name */
        static final g f38392a = new g();

        private g() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.c cVar = (v.d.c) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("arch", cVar.a());
            eVar.a("model", (Object) cVar.b());
            eVar.a("cores", cVar.c());
            eVar.a("ram", cVar.d());
            eVar.a("diskSpace", cVar.e());
            eVar.a("simulator", cVar.f());
            eVar.a("state", cVar.g());
            eVar.a("manufacturer", (Object) cVar.h());
            eVar.a("modelClass", (Object) cVar.i());
        }
    }

    static final class q implements com.google.firebase.encoders.d<v.d.C0634d> {

        /* renamed from: a  reason: collision with root package name */
        static final q f38403a = new q();

        private q() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d dVar = (v.d.C0634d) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("timestamp", dVar.a());
            eVar.a("type", (Object) dVar.b());
            eVar.a(AppManagerUtil.EXTEND_PREFIX_DEFAULT, (Object) dVar.c());
            eVar.a(AppConstants.TAG_DEVICE, (Object) dVar.d());
            eVar.a("log", (Object) dVar.e());
        }
    }

    static final class i implements com.google.firebase.encoders.d<v.d.C0634d.a> {

        /* renamed from: a  reason: collision with root package name */
        static final i f38395a = new i();

        private i() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a aVar = (v.d.C0634d.a) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("execution", (Object) aVar.a());
            eVar.a("customAttributes", (Object) aVar.b());
            eVar.a("background", (Object) aVar.c());
            eVar.a("uiOrientation", aVar.d());
        }
    }

    static final class k implements com.google.firebase.encoders.d<v.d.C0634d.a.b> {

        /* renamed from: a  reason: collision with root package name */
        static final k f38397a = new k();

        private k() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a.b bVar = (v.d.C0634d.a.b) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("threads", (Object) bVar.a());
            eVar.a("exception", (Object) bVar.b());
            eVar.a("signal", (Object) bVar.c());
            eVar.a("binaries", (Object) bVar.d());
        }
    }

    static final class n implements com.google.firebase.encoders.d<v.d.C0634d.a.b.e> {

        /* renamed from: a  reason: collision with root package name */
        static final n f38400a = new n();

        private n() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a.b.e eVar = (v.d.C0634d.a.b.e) obj;
            com.google.firebase.encoders.e eVar2 = (com.google.firebase.encoders.e) obj2;
            eVar2.a("name", (Object) eVar.a());
            eVar2.a("importance", eVar.b());
            eVar2.a("frames", (Object) eVar.c());
        }
    }

    static final class o implements com.google.firebase.encoders.d<v.d.C0634d.a.b.e.C0643b> {

        /* renamed from: a  reason: collision with root package name */
        static final o f38401a = new o();

        private o() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a.b.e.C0643b bVar = (v.d.C0634d.a.b.e.C0643b) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("pc", bVar.a());
            eVar.a("symbol", (Object) bVar.b());
            eVar.a(CommunityPostActivity.TYPE_FILE, (Object) bVar.c());
            eVar.a("offset", bVar.d());
            eVar.a("importance", bVar.e());
        }
    }

    static final class l implements com.google.firebase.encoders.d<v.d.C0634d.a.b.c> {

        /* renamed from: a  reason: collision with root package name */
        static final l f38398a = new l();

        private l() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a.b.c cVar = (v.d.C0634d.a.b.c) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("type", (Object) cVar.a());
            eVar.a(Item.KEY_REASON, (Object) cVar.b());
            eVar.a("frames", (Object) cVar.c());
            eVar.a("causedBy", (Object) cVar.d());
            eVar.a("overflowCount", cVar.e());
        }
    }

    static final class m implements com.google.firebase.encoders.d<v.d.C0634d.a.b.C0640d> {

        /* renamed from: a  reason: collision with root package name */
        static final m f38399a = new m();

        private m() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a.b.C0640d dVar = (v.d.C0634d.a.b.C0640d) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("name", (Object) dVar.a());
            eVar.a("code", (Object) dVar.b());
            eVar.a(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, dVar.c());
        }
    }

    static final class j implements com.google.firebase.encoders.d<v.d.C0634d.a.b.C0636a> {

        /* renamed from: a  reason: collision with root package name */
        static final j f38396a = new j();

        private j() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.a.b.C0636a aVar = (v.d.C0634d.a.b.C0636a) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("baseAddress", aVar.a());
            eVar.a(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, aVar.b());
            eVar.a("name", (Object) aVar.c());
            String d2 = aVar.d();
            eVar.a("uuid", (Object) d2 != null ? d2.getBytes(v.f38572a) : null);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.a.e.a$a  reason: collision with other inner class name */
    static final class C0631a implements com.google.firebase.encoders.d<v.b> {

        /* renamed from: a  reason: collision with root package name */
        static final C0631a f38380a = new C0631a();

        private C0631a() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.b bVar = (v.b) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("key", (Object) bVar.a());
            eVar.a("value", (Object) bVar.b());
        }
    }

    static final class p implements com.google.firebase.encoders.d<v.d.C0634d.c> {

        /* renamed from: a  reason: collision with root package name */
        static final p f38402a = new p();

        private p() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.d.C0634d.c cVar = (v.d.C0634d.c) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("batteryLevel", (Object) cVar.a());
            eVar.a("batteryVelocity", cVar.b());
            eVar.a("proximityOn", cVar.c());
            eVar.a("orientation", cVar.d());
            eVar.a("ramUsed", cVar.e());
            eVar.a("diskUsed", cVar.f());
        }
    }

    static final class r implements com.google.firebase.encoders.d<v.d.C0634d.C0645d> {

        /* renamed from: a  reason: collision with root package name */
        static final r f38404a = new r();

        private r() {
        }

        public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            ((com.google.firebase.encoders.e) obj2).a("content", (Object) ((v.d.C0634d.C0645d) obj).a());
        }
    }

    static final class c implements com.google.firebase.encoders.d<v.c> {

        /* renamed from: a  reason: collision with root package name */
        static final c f38384a = new c();

        private c() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.c cVar = (v.c) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("files", (Object) cVar.a());
            eVar.a("orgId", (Object) cVar.b());
        }
    }

    static final class d implements com.google.firebase.encoders.d<v.c.b> {

        /* renamed from: a  reason: collision with root package name */
        static final d f38386a = new d();

        private d() {
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            v.c.b bVar = (v.c.b) obj;
            com.google.firebase.encoders.e eVar = (com.google.firebase.encoders.e) obj2;
            eVar.a("filename", (Object) bVar.a());
            eVar.a("contents", (Object) bVar.b());
        }
    }
}
