package net.one97.paytm.upgradeKyc.data.a.c;

import android.app.Application;
import android.content.Context;
import android.util.Base64;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.h;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.m.l;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse;
import net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a implements net.one97.paytm.upgradeKyc.data.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1304a f65795a = new C1304a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f65796c;

    /* renamed from: b  reason: collision with root package name */
    private final Application f65797b;

    private a(Application application) {
        this.f65797b = application;
    }

    public /* synthetic */ a(Application application, byte b2) {
        this(application);
    }

    public final Object a(String str, String str2, kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<RequestOtpResponse>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        String a2 = net.one97.paytm.upgradeKyc.helper.d.a("MinKycOTPClientID");
        Map hashMap = new HashMap();
        hashMap.put("authorization", b());
        hashMap.put("clientid", a2);
        hashMap.put("Content-type", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("actionType", "AUTHENTICATE");
        jSONObject.put("phoneNumber", str);
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f65797b).a(a.c.KYC).a(a.b.USER_FACING).a(net.one97.paytm.upgradeKyc.helper.d.a("MinkycSendOTPURL")).a(0).a(a.C0715a.POST).a((Map<String, String>) hashMap).b(jSONObject.toString()).a((IJRPaytmDataModel) new RequestOtpResponse()).c(net.one97.paytm.upgradeKyc.minkycotp.b.class.getName()).a((com.paytm.network.listener.b) new b(dVar2)).l();
        if (com.paytm.utility.b.c((Context) this.f65797b)) {
            l.a();
        }
        Object a3 = hVar.a();
        if (a3 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a3;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f65798a;

        b(kotlin.d.d dVar) {
            this.f65798a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f65798a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a((RequestOtpResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f65798a;
                p.a aVar2 = p.Companion;
                dVar.resumeWith(p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.data.models.requestotp.RequestOtpResponse");
        }
    }

    public final Object a(String str, kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KycResendOtpResponse>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        String a2 = net.one97.paytm.upgradeKyc.helper.d.a("MinKycOTPClientID");
        Map hashMap = new HashMap();
        hashMap.put("authorization", b());
        hashMap.put("clientid", a2);
        hashMap.put("Content-type", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("actionType", "AUTHENTICATE");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", str);
        jSONObject2.put("channel", "sms");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        jSONObject.put("otpDetails", jSONArray);
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f65797b).a(a.c.KYC).a(a.b.USER_FACING).a(a.C0715a.POST).a((Map<String, String>) hashMap).a(net.one97.paytm.upgradeKyc.helper.d.a("MinkycReSendOTPURL")).a(0).a(true).b(jSONObject.toString()).a((IJRPaytmDataModel) new KycResendOtpResponse()).c(net.one97.paytm.upgradeKyc.minkycotp.b.class.getName()).a((com.paytm.network.listener.b) new c(dVar2)).l();
        if (com.paytm.utility.b.c((Context) this.f65797b)) {
            l.a();
        }
        Object a3 = hVar.a();
        if (a3 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a3;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f65799a;

        c(kotlin.d.d dVar) {
            this.f65799a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f65799a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a((KycResendOtpResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f65799a;
                p.a aVar2 = p.Companion;
                dVar.resumeWith(p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.data.models.resendotp.KycResendOtpResponse");
        }
    }

    public final Object b(String str, String str2, kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KycVerifyOtpResponse>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        HashMap hashMap = new HashMap();
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        String a2 = net.one97.paytm.upgradeKyc.helper.d.a("MinKycOTPClientID");
        Map map = hashMap;
        map.put("authorization", b());
        map.put("clientid", a2);
        map.put("Content-type", "application/json");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("actionType", "AUTHENTICATE");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", str);
        jSONObject2.put("channel", "sms");
        jSONObject2.put("otp", str2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        jSONObject.put("otpDetails", jSONArray);
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f65797b).a(a.c.KYC).a(a.b.USER_FACING).a(a.C0715a.POST).a((Map<String, String>) map).a(net.one97.paytm.upgradeKyc.helper.d.a("MinkycVerifyOTPUrl")).a(0).b(jSONObject.toString()).a((IJRPaytmDataModel) new KycVerifyOtpResponse()).c(net.one97.paytm.upgradeKyc.minkycotp.b.class.getName()).a((com.paytm.network.listener.b) new d(dVar2)).l();
        if (com.paytm.utility.b.c((Context) this.f65797b)) {
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
        final /* synthetic */ kotlin.d.d f65800a;

        d(kotlin.d.d dVar) {
            this.f65800a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f65800a;
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a(networkCustomError);
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(a2));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.upgradeKyc.kycV3.b.b a2 = b.a.a((KycVerifyOtpResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f65800a;
                p.a aVar2 = p.Companion;
                dVar.resumeWith(p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.data.models.verifykycotp.KycVerifyOtpResponse");
        }
    }

    private static String b() {
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        String a2 = net.one97.paytm.upgradeKyc.helper.d.a("MinKycOTPClientID");
        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        String a3 = net.one97.paytm.upgradeKyc.helper.d.a("MinKycOTPClientSecret");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clientId", a2);
        try {
            net.one97.paytm.upgradeKyc.utils.h hVar = net.one97.paytm.upgradeKyc.utils.h.f66333a;
            k.c(a3, "key");
            f fVar = new f();
            String b2 = fVar.b(hashMap);
            k.a((Object) b2, "gson.toJson(header)");
            String b3 = fVar.b(hashMap2);
            k.a((Object) b3, "gson.toJson(claims)");
            StringBuilder sb = new StringBuilder();
            Charset charset = kotlin.m.d.f47971a;
            if (b2 != null) {
                byte[] bytes = b2.getBytes(charset);
                k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                boolean z = true;
                sb.append(Base64.encodeToString(bytes, 1));
                sb.append(AppUtility.CENTER_DOT);
                Charset charset2 = kotlin.m.d.f47971a;
                if (b3 != null) {
                    byte[] bytes2 = b3.getBytes(charset2);
                    k.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
                    sb.append(Base64.encodeToString(bytes2, 1));
                    String sb2 = sb.toString();
                    k.a((Object) sb2, "dataBase64EncodedBuilder.toString()");
                    String replace = new l("\r").replace((CharSequence) new l(StringUtility.NEW_LINE).replace((CharSequence) sb2, ""), "");
                    String str = replace + AppUtility.CENTER_DOT + Base64.encodeToString(net.one97.paytm.upgradeKyc.utils.h.a(replace, a3), 9);
                    k.a((Object) str, "jwtTokenBuilder.toString()");
                    String replace2 = new l("\r").replace((CharSequence) new l(StringUtility.NEW_LINE).replace((CharSequence) str, ""), "");
                    CharSequence charSequence = replace2;
                    if (charSequence != null) {
                        if (charSequence.length() != 0) {
                            z = false;
                        }
                    }
                    if (z) {
                        return "";
                    }
                    return replace2;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e2) {
            System.out.print(e2);
            return "";
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.data.a.c.a$a  reason: collision with other inner class name */
    public static final class C1304a {
        private C1304a() {
        }

        public /* synthetic */ C1304a(byte b2) {
            this();
        }

        public static a a(Application application) {
            k.c(application, "application");
            if (a.f65796c == null) {
                synchronized (y.b(a.class)) {
                    C1304a aVar = a.f65795a;
                    if (a.f65796c == null) {
                        C1304a aVar2 = a.f65795a;
                        a.f65796c = new a(application, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f65796c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
