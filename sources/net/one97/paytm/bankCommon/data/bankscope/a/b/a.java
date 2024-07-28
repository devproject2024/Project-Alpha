package net.one97.paytm.bankCommon.data.bankscope.a.b;

import android.app.Application;
import android.content.Context;
import android.util.Base64;
import android.webkit.URLUtil;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.h;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONObject;

public final class a implements net.one97.paytm.bankCommon.data.bankscope.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0223a f16249a = new C0223a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f16250c;

    /* renamed from: b  reason: collision with root package name */
    private final Application f16251b;

    public final void a(String str, String str2) {
        k.c(str, "bankScopeToken");
        k.c(str2, "bankRefreshToken");
    }

    private a(Application application) {
        this.f16251b = application;
    }

    public /* synthetic */ a(Application application, byte b2) {
        this(application);
    }

    public final Object a(String str, String str2, kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String R = net.one97.paytm.bankCommon.utils.d.R();
        k.a((Object) R, "PBGTMHelper.getInstance().bankscopeClientId");
        String n = com.paytm.utility.b.n((Context) this.f16251b);
        k.a((Object) n, "CJRAppCommonUtility.getUserId(application)");
        String b2 = b(R, n);
        HashMap hashMap = new HashMap();
        if (this.f16251b.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            Map map = hashMap;
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e((Context) this.f16251b));
            map.put("Authorization", b2);
            map.put("Client-Id", R);
            map.put("Platform", "ANDROID");
            map.put("Customer-Id", n);
            map.put("Grant-Type", "client_credentials");
            map.put("Content-Type", "application/json");
            map.put("client", "ANDROID");
            k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
            String P = net.one97.paytm.bankCommon.utils.d.P();
            k.a((Object) P, "PBGTMHelper.getInstance().bankScopeTokenUrl");
            if (!URLUtil.isValidUrl(P)) {
                net.one97.paytm.bankOpen.c a2 = f.a();
                k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
                P = p.a(a2.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-ite.paytmbank.com/bank-oauth/ext/v1/client/token" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/client/token";
            }
            Map<String, String> b3 = com.paytm.utility.c.b((Context) this.f16251b, false);
            g gVar = g.f16329a;
            k.a((Object) b3, "defaultParams");
            g.a(b3, this.f16251b);
            JSONObject jSONObject = new JSONObject(b3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("login_secret", str);
            jSONObject2.put("login_secret_type", "passcode");
            jSONObject2.put("scopes", "login");
            jSONObject2.put("device_info", jSONObject);
            new HashMap().put("screen_name", str2);
            com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f16251b).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(P).a(0).a(a.C0715a.POST).a((Map<String, String>) map).b(jSONObject2.toString()).a((IJRPaytmDataModel) new ValidateTokenApiResponse()).c(str2).a((com.paytm.network.listener.b) new d(dVar2)).l();
            if (com.paytm.utility.b.c((Context) this.f16251b)) {
                l.a();
            }
            Object a3 = hVar.a();
            if (a3 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
                k.d(dVar, "frame");
            }
            return a3;
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f16254a;

        d(kotlin.d.d dVar) {
            this.f16254a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f16254a;
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (networkCustomError != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((Throwable) networkCustomError);
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((ValidateTokenApiResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f16254a;
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
        }
    }

    public final Object b(String str, String str2, kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String R = net.one97.paytm.bankCommon.utils.d.R();
        k.a((Object) R, "PBGTMHelper.getInstance().bankscopeClientId");
        String n = com.paytm.utility.b.n((Context) this.f16251b);
        k.a((Object) n, "CJRAppCommonUtility.getUserId(application)");
        String b2 = b(R, n);
        HashMap hashMap = new HashMap();
        net.one97.paytm.bankCommon.mapping.d.a(this.f16251b);
        if (this.f16251b.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            Map map = hashMap;
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e((Context) this.f16251b));
            map.put("Authorization", b2);
            map.put("Client-Id", R);
            map.put("Platform", "ANDROID");
            map.put("Customer-Id", n);
            map.put("Grant-Type", "client_credentials");
            map.put("Content-Type", "application/json");
            map.put("client", "ANDROID");
            k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
            String P = net.one97.paytm.bankCommon.utils.d.P();
            k.a((Object) P, "PBGTMHelper.getInstance().bankScopeTokenUrl");
            if (!URLUtil.isValidUrl(P)) {
                net.one97.paytm.bankOpen.c a2 = f.a();
                k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
                P = kotlin.m.p.a(a2.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-ite.paytmbank.com/bank-oauth/ext/v1/client/token" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/client/token";
            }
            Map<String, String> b3 = com.paytm.utility.c.b((Context) this.f16251b, false);
            g gVar = g.f16329a;
            k.a((Object) b3, "defaultParams");
            g.a(b3, this.f16251b);
            JSONObject jSONObject = new JSONObject(b3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("login_secret", str);
            jSONObject2.put("login_secret_type", "passcode");
            jSONObject2.put("scopes", BuildConfig.BANK_TXN_SCOPE);
            jSONObject2.put("device_info", jSONObject);
            jSONObject2.put("is_single_used_token", true);
            new HashMap().put("screen_name", str2);
            com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f16251b).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(P).a(0).a(a.C0715a.POST).a((Map<String, String>) map).b(jSONObject2.toString()).a((IJRPaytmDataModel) new ValidateTokenApiResponse()).c(str2).a((com.paytm.network.listener.b) new e(dVar2)).l();
            if (com.paytm.utility.b.c((Context) this.f16251b)) {
                l.a();
            }
            Object a3 = hVar.a();
            if (a3 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
                k.d(dVar, "frame");
            }
            return a3;
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f16255a;

        e(kotlin.d.d dVar) {
            this.f16255a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f16255a;
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (networkCustomError != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((Throwable) networkCustomError);
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((ValidateTokenApiResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f16255a;
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
        }
    }

    public final Object a(String str, kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String R = net.one97.paytm.bankCommon.utils.d.R();
        k.a((Object) R, "PBGTMHelper.getInstance().bankscopeClientId");
        String n = com.paytm.utility.b.n((Context) this.f16251b);
        k.a((Object) n, "CJRAppCommonUtility.getUserId(application)");
        String b2 = b(R, n);
        HashMap hashMap = new HashMap();
        if (this.f16251b.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            net.one97.paytm.bankCommon.mapping.d.a(this.f16251b);
            Map map = hashMap;
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e((Context) this.f16251b));
            map.put("Authorization", b2);
            map.put("Client-Id", R);
            map.put("Platform", "ANDROID");
            map.put("Customer-Id", n);
            map.put("Grant-Type", "refresh_token");
            map.put("Authorization-Type", "jwt_token");
            map.put("Content-Type", "application/json");
            map.put("client", "ANDROID");
            k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
            String P = net.one97.paytm.bankCommon.utils.d.P();
            k.a((Object) P, "PBGTMHelper.getInstance().bankScopeTokenUrl");
            if (!URLUtil.isValidUrl(P)) {
                net.one97.paytm.bankOpen.c a2 = f.a();
                k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
                P = kotlin.m.p.a(a2.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-ite.paytmbank.com/bank-oauth/ext/v1/client/token" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/client/token";
            }
            Map<String, String> b3 = com.paytm.utility.c.b((Context) this.f16251b, false);
            g gVar = g.f16329a;
            k.a((Object) b3, "defaultParams");
            g.a(b3, this.f16251b);
            JSONObject jSONObject = new JSONObject(b3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("login_secret_type", "passcode");
            jSONObject2.put("scopes", "login");
            jSONObject2.put("device_info", jSONObject);
            new HashMap().put("screen_name", str);
            com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f16251b).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(P).a(0).a(a.C0715a.POST).a((Map<String, String>) map).b(jSONObject2.toString()).a((IJRPaytmDataModel) new ValidateTokenApiResponse()).c(str).a((com.paytm.network.listener.b) new b(dVar2)).l();
            if (com.paytm.utility.b.c((Context) this.f16251b)) {
                l.a();
            } else {
                c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
                net.one97.paytm.bankCommon.b.c a3 = c.a.a(new Throwable("No Network Error"));
                p.a aVar2 = kotlin.p.Companion;
                dVar2.resumeWith(kotlin.p.m530constructorimpl(a3));
            }
            Object a4 = hVar.a();
            if (a4 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
                k.d(dVar, "frame");
            }
            return a4;
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f16252a;

        b(kotlin.d.d dVar) {
            this.f16252a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f16252a;
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (networkCustomError != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((Throwable) networkCustomError);
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((ValidateTokenApiResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f16252a;
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
        }
    }

    public final Object a(kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>> dVar) {
        h hVar = new h(kotlin.d.a.b.a(dVar));
        kotlin.d.d dVar2 = hVar;
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String R = net.one97.paytm.bankCommon.utils.d.R();
        k.a((Object) R, "PBGTMHelper.getInstance().bankscopeClientId");
        String n = com.paytm.utility.b.n((Context) this.f16251b);
        boolean z = true;
        if (n == null) {
            StringBuilder sb = new StringBuilder("isAppInstanceNull :");
            if (this.f16251b != null) {
                z = false;
            }
            sb.append(z);
            l.a(sb.toString());
        } else {
            String b2 = b(R, n);
            HashMap hashMap = new HashMap();
            if (this.f16251b.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
                Map map = hashMap;
                map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e((Context) this.f16251b));
                map.put("Authorization", b2);
                map.put("Client-Id", R);
                map.put("Platform", "ANDROID");
                map.put("Customer-Id", n);
                map.put("Authorization-Type", "jwt_token");
                map.put("Scopes", "login");
                map.put("Content-Type", "application/json");
                map.put("client", "ANDROID");
                k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
                String P = net.one97.paytm.bankCommon.utils.d.P();
                k.a((Object) P, "PBGTMHelper.getInstance().bankScopeTokenUrl");
                if (!URLUtil.isValidUrl(P)) {
                    net.one97.paytm.bankOpen.c a2 = f.a();
                    k.a((Object) a2, "PaymentBankAccOpenHelper.getImplListener()");
                    P = kotlin.m.p.a(a2.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-ite.paytmbank.com/bank-oauth/ext/v1/client/token" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/client/token";
                }
                Map<String, String> b3 = com.paytm.utility.c.b((Context) this.f16251b, false);
                g gVar = g.f16329a;
                k.a((Object) b3, "defaultParams");
                g.a(b3, this.f16251b);
                JSONObject jSONObject = new JSONObject(b3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scopes", "login");
                jSONObject2.put("device_info", jSONObject);
                new HashMap();
                com.paytm.network.a l = new com.paytm.network.b().a((Context) this.f16251b).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(P).a(0).a(a.C0715a.DELETE).a((Map<String, String>) map).b(jSONObject2.toString()).a((IJRPaytmDataModel) new ValidateTokenApiResponse()).c("BankTabPassCode").a((com.paytm.network.listener.b) new c(dVar2)).l();
                if (com.paytm.utility.b.c((Context) this.f16251b)) {
                    l.a();
                } else {
                    c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
                    net.one97.paytm.bankCommon.b.c a3 = c.a.a(new Throwable("No Network Error"));
                    p.a aVar2 = kotlin.p.Companion;
                    dVar2.resumeWith(kotlin.p.m530constructorimpl(a3));
                }
            } else {
                throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
            }
        }
        Object a4 = hVar.a();
        if (a4 == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return a4;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.d.d f16253a;

        c(kotlin.d.d dVar) {
            this.f16253a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            kotlin.d.d dVar = this.f16253a;
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (networkCustomError != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((Throwable) networkCustomError);
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            if (iJRPaytmDataModel != null) {
                net.one97.paytm.bankCommon.b.c a2 = c.a.a((ValidateTokenApiResponse) iJRPaytmDataModel);
                kotlin.d.d dVar = this.f16253a;
                p.a aVar2 = kotlin.p.Companion;
                dVar.resumeWith(kotlin.p.m530constructorimpl(a2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse");
        }
    }

    private static String b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("typ", "JWT");
        hashMap.put("alg", "HS256");
        Map hashMap2 = new HashMap();
        hashMap2.put("customer_id", str2);
        hashMap2.put("client-id", str);
        hashMap2.put("iss", "bos");
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String S = net.one97.paytm.bankCommon.utils.d.S();
        k.a((Object) S, "PBGTMHelper.getInstance().bankscopeSeceretKey");
        defpackage.b bVar = defpackage.b.f14580a;
        k.c(S, "key");
        com.google.gson.f fVar = new com.google.gson.f();
        String b2 = fVar.b(hashMap);
        k.a((Object) b2, "gson.toJson(header)");
        String b3 = fVar.b(hashMap2);
        k.a((Object) b3, "gson.toJson(claims)");
        StringBuilder sb = new StringBuilder();
        Charset charset = kotlin.m.d.f47971a;
        if (b2 != null) {
            byte[] bytes = b2.getBytes(charset);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            sb.append(Base64.encodeToString(bytes, 1));
            sb.append(AppUtility.CENTER_DOT);
            Charset charset2 = kotlin.m.d.f47971a;
            if (b3 != null) {
                byte[] bytes2 = b3.getBytes(charset2);
                k.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
                sb.append(Base64.encodeToString(bytes2, 1));
                String sb2 = sb.toString();
                k.a((Object) sb2, "dataBase64EncodedBuilder.toString()");
                String replace = new kotlin.m.l("\r").replace((CharSequence) new kotlin.m.l(StringUtility.NEW_LINE).replace((CharSequence) sb2, ""), "");
                String str3 = replace + AppUtility.CENTER_DOT + Base64.encodeToString(defpackage.b.a(replace, S), 9);
                k.a((Object) str3, "jwtTokenBuilder.toString()");
                String replace2 = new kotlin.m.l("\r").replace((CharSequence) new kotlin.m.l(StringUtility.NEW_LINE).replace((CharSequence) str3, ""), "");
                if (replace2 != null) {
                    return replace2;
                }
                return "";
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: net.one97.paytm.bankCommon.data.bankscope.a.b.a$a  reason: collision with other inner class name */
    public static final class C0223a {
        private C0223a() {
        }

        public /* synthetic */ C0223a(byte b2) {
            this();
        }

        public static a a(Application application) {
            k.c(application, "application");
            if (a.f16250c == null) {
                synchronized (a.class) {
                    if (a.f16250c == null) {
                        a.f16250c = new a(application, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f16250c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
