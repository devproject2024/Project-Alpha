package net.one97.paytm.upgradeKyc.data.a.a.b;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.h;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3;
import net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity;
import net.one97.paytm.upgradeKyc.data.models.aotpexpire.AOTPExpireApiResponse;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.upgradeKyc.data.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1301a f65782a = new C1301a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f65783c;

    /* renamed from: b  reason: collision with root package name */
    private Application f65784b;

    public final void a(KYCStatusV3 kYCStatusV3) {
        k.c(kYCStatusV3, "kycData");
    }

    private a(Application application) {
        this.f65784b = application;
    }

    public /* synthetic */ a(Application application, byte b2) {
        this(application);
    }

    public final Object a(kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kyc_aotp_expiry_tnc_url") : null;
        Map hashMap = new HashMap();
        String a3 = com.paytm.utility.d.a(this.f65784b);
        k.a((Object) a3, "CJRNetUtility.getSSOToken(application)");
        hashMap.put("session_token", a3);
        hashMap.put("Content-type", "application/json");
        a.C1317a aVar2 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.a l = a.C1317a.a().a((Context) this.f65784b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new KYCFetchTnc()).a(a2).a(a.c.KYC).a(false).f().c(net.one97.paytm.upgradeKyc.aotp.a.a.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new b(dVar2)).l();
        if (com.paytm.utility.b.c((Context) this.f65784b)) {
            l.a();
        } else {
            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a4 = b.a.a(new NetworkCustomError("Internet Connection Unavailable"));
            p.a aVar4 = p.Companion;
            dVar2.resumeWith(p.m530constructorimpl(a4));
        }
        Object a5 = hVar.a();
        if (a5 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a5;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f65785a;

        b(kotlin.d.d dVar) {
            this.f65785a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KYCFetchTnc) {
                kotlin.d.d dVar = this.f65785a;
                b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(iJRPaytmDataModel);
                p.a aVar2 = p.Companion;
                dVar.resumeWith(p.m530constructorimpl(a2));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            kotlin.d.d dVar = this.f65785a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }
    }

    public final Object a(int i2, String str, kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> dVar) {
        String str2;
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                k.a();
            }
            str2 = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_user_url");
        } else {
            str2 = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "esign");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", str);
            jSONObject2.put("version", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put("tnCList", jSONArray);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        String jSONObject3 = jSONObject.toString();
        k.a((Object) jSONObject3, "requestBody.toString()");
        q.d(jSONObject3);
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        Map<String, String> a2 = a.C1317a.a(this.f65784b);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a3 = a.C1317a.a();
        e.a aVar5 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        com.paytm.network.a l = a3.a(e.a.b().a()).a(a.C0715a.PUT).a(a2).a((IJRPaytmDataModel) new KYCTncAccept()).c(net.one97.paytm.upgradeKyc.aotp.a.a.class.getName()).b(jSONObject3).a(str2).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new e(dVar2)).l();
        if (com.paytm.utility.b.c((Context) this.f65784b)) {
            l.a();
        } else {
            b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a4 = b.a.a(new NetworkCustomError("Internet Connection Unavailable"));
            p.a aVar7 = p.Companion;
            dVar2.resumeWith(p.m530constructorimpl(a4));
        }
        Object a5 = hVar.a();
        if (a5 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a5;
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f65788a;

        e(kotlin.d.d dVar) {
            this.f65788a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            if (iJRPaytmDataModel instanceof KYCTncAccept) {
                kotlin.d.d dVar = this.f65788a;
                b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(iJRPaytmDataModel);
                p.a aVar2 = p.Companion;
                dVar.resumeWith(p.m530constructorimpl(a2));
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            kotlin.d.d dVar = this.f65788a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }
    }

    public final Object b(kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<AOTPExpireApiResponse>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        Map hashMap = new HashMap();
        String a2 = com.paytm.utility.d.a(this.f65784b);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(application)");
        hashMap.put("session_token", a2);
        hashMap.put("Content-type", "application/json");
        String n = com.paytm.utility.b.n((Context) this.f65784b);
        k.a((Object) n, "CJRAppCommonUtility.getUserId(application)");
        hashMap.put("userId", n);
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f65784b).a(a.c.KYC).a(a.b.USER_FACING).a(net.one97.paytm.upgradeKyc.helper.d.a("kyc_aotp_expiry_url")).a(0).a(a.C0715a.POST).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new AOTPExpireApiResponse()).c(net.one97.paytm.upgradeKyc.aotp.a.a.class.getName()).a((com.paytm.network.listener.b) new d(dVar2)).l();
        if (com.paytm.utility.b.c((Context) this.f65784b)) {
            l.a();
        }
        Object a3 = hVar.a();
        if (a3 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a3;
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f65787a;

        d(kotlin.d.d dVar) {
            this.f65787a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f65787a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a((AOTPExpireApiResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f65787a;
                p.a aVar2 = p.Companion;
                dVar.resumeWith(p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.data.models.aotpexpire.AOTPExpireApiResponse");
        }
    }

    public final Object c(kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KYCStatusV3>> dVar) {
        String str;
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                k.a();
            }
            str = net.one97.paytm.upgradeKyc.helper.d.a("min_kyc_status_v3_url");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(com.paytm.utility.d.a(this.f65784b))) {
            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(new NetworkCustomError(""));
            p.a aVar4 = p.Companion;
            dVar2.resumeWith(p.m530constructorimpl(a2));
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = com.paytm.utility.b.e((Context) this.f65784b, str);
            Map hashMap = new HashMap();
            String a3 = com.paytm.utility.d.a(this.f65784b);
            k.a((Object) a3, "CJRNetUtility.getSSOToken(application)");
            hashMap.put("session_token", a3);
            KYCStatusV3 kYCStatusV3 = new KYCStatusV3();
            a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.a l = a.C1317a.a().a((Context) this.f65784b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) kYCStatusV3).a(e2).c(MinKycPanAadharUpgradeActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c(dVar2)).l();
            if (com.paytm.utility.b.c((Context) this.f65784b)) {
                l.a();
            } else {
                NetworkCustomError networkCustomError = new NetworkCustomError("Network Unavailable");
                b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                net.one97.paytm.upgradeKyc.kycV3.b.b a4 = b.a.a(networkCustomError);
                p.a aVar7 = p.Companion;
                dVar2.resumeWith(p.m530constructorimpl(a4));
            }
        }
        Object a5 = hVar.a();
        if (a5 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a5;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f65786a;

        c(kotlin.d.d dVar) {
            this.f65786a = dVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            kotlin.d.d dVar = this.f65786a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a((KYCStatusV3) iJRPaytmDataModel);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            kotlin.d.d dVar = this.f65786a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.data.a.a.b.a$a  reason: collision with other inner class name */
    public static final class C1301a {
        private C1301a() {
        }

        public /* synthetic */ C1301a(byte b2) {
            this();
        }

        public static a a(Application application) {
            k.c(application, "application");
            if (a.f65783c == null) {
                synchronized (a.class) {
                    C1301a aVar = a.f65782a;
                    if (a.f65783c == null) {
                        C1301a aVar2 = a.f65782a;
                        a.f65783c = new a(application, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f65783c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
