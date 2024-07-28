package net.one97.paytm.bankCommon.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.b.a;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.BankToken;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f16329a = new g();

    private g() {
    }

    public static f a(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, String str2) throws Exception {
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        k.c(context2, "context");
        k.c(str3, "enteredPasscode");
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.c(cVar, "verticalId");
        k.c(bVar2, "userFacing");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
        if (a2 == null) {
            a2 = "";
        }
        Map map = hashMap;
        map.put("Authorization", a2);
        map.put("Content-Type", "application/json");
        map.put("client", "ANDROID");
        if (context2.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e(context));
            String stringFromGTM = net.one97.paytm.bankOpen.f.a().getStringFromGTM("passcodeValidateURL");
            k.a((Object) stringFromGTM, "PaymentBankAccOpenHelper…TM(\"passcodeValidateURL\")");
            if (!URLUtil.isValidUrl(stringFromGTM)) {
                net.one97.paytm.bankOpen.c a3 = net.one97.paytm.bankOpen.f.a();
                k.a((Object) a3, "PaymentBankAccOpenHelper.getImplListener()");
                stringFromGTM = p.a(a3.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v2/validate-passcode" : "https://oauth.paytmbank.com/bank-oauth/ext/v2/validate-passcode";
            }
            String str5 = stringFromGTM;
            Map<String, String> b2 = com.paytm.utility.c.b(context2, false);
            k.a((Object) b2, "defaultParams");
            a(b2, context2);
            JSONObject jSONObject = new JSONObject(b2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("passcode", str3);
            jSONObject2.put("device_info", jSONObject);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", str4);
            return new net.one97.paytm.bankCommon.g.b(str5, bVar, aVar, (IJRPaytmDataModel) new ValidatePasscode(), (Map<String, String>) null, (Map<String, String>) map, jSONObject2.toString(), a.C0715a.POST, cVar, bVar2, (HashMap<String, String>) hashMap2);
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, String str) {
        Context context2 = context;
        String str2 = str;
        k.c(context, "context");
        g.b<IJRPaytmDataModel> bVar3 = bVar;
        k.c(bVar, "listener");
        g.a aVar2 = aVar;
        k.c(aVar, "errorListener");
        k.c(cVar, "verticalId");
        k.c(bVar2, "userFacing");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
        if (a2 == null) {
            a2 = "";
        }
        Map map = hashMap;
        map.put("Authorization", a2);
        map.put("Content-Type", "application/json");
        map.put("client", "ANDROID");
        map.put("User-Agent", UpiConstants.B2C_ANDROID);
        if (context.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e(context));
            String stringFromGTM = net.one97.paytm.bankOpen.f.a().getStringFromGTM("passcodeExistsURL");
            k.a((Object) stringFromGTM, "PaymentBankAccOpenHelper…mGTM(\"passcodeExistsURL\")");
            if (!URLUtil.isValidUrl(stringFromGTM)) {
                net.one97.paytm.bankOpen.c a3 = net.one97.paytm.bankOpen.f.a();
                k.a((Object) a3, "PaymentBankAccOpenHelper.getImplListener()");
                stringFromGTM = p.a(a3.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v2/passcode-exists" : "https://oauth.paytmbank.com/bank-oauth/ext/v2/passcode-exists";
            }
            String str3 = (((stringFromGTM + com.paytm.utility.c.a(context, false)) + "&app_version=" + com.paytm.utility.b.Q(context)) + "&os=" + com.paytm.utility.b.d()) + "&registered_mobile_number=" + com.paytm.utility.b.l(context);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", str2);
            return new net.one97.paytm.bankCommon.g.a(str3, (g.b) bVar, aVar, (IJRPaytmDataModel) new ValidatePasscode(), (Map<String, String>) null, (Map<String, String>) map, cVar, bVar2, (HashMap<String, String>) hashMap2);
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static void a(Map<String, String> map, Context context) {
        k.c(map, "defaultParams");
        k.c(context, "context");
        try {
            String Q = com.paytm.utility.b.Q(context);
            k.a((Object) Q, "CJRAppCommonUtility.getAppVersionName(context)");
            map.put("app_version", Q);
            StringBuilder sb = new StringBuilder();
            sb.append(com.paytm.utility.b.d());
            map.put("os", sb.toString());
            String l = com.paytm.utility.b.l(context);
            k.a((Object) l, "CJRAppCommonUtility.getMobile(context)");
            map.put("registered_mobile_number", l);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static f a(Context context, String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, String str4, String str5) {
        Context context2 = context;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        k.c(context2, "context");
        k.c(str6, "passCode");
        k.c(str7, "confirmPassCode");
        k.c(str8, "requestId");
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.c(cVar, "verticalId");
        k.c(bVar2, "userFacing");
        k.c(str9, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str10, "bankToken");
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
        if (a2 == null) {
            a2 = "";
        }
        Map map = hashMap;
        String lowerCase = "Authorization".toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        map.put(lowerCase, str10);
        map.put("Content-Type", "application/json");
        map.put("client", "ANDROID");
        map.put("user-token", a2);
        map.put("Remote-Address", "127.0.0.1");
        map.put("User-Agent", UpiConstants.B2C_ANDROID);
        if (context2.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e(context));
            String stringFromGTM = net.one97.paytm.bankOpen.f.a().getStringFromGTM("passcodeResetURL");
            k.a((Object) stringFromGTM, "PaymentBankAccOpenHelper…omGTM(\"passcodeResetURL\")");
            Map<String, String> b2 = com.paytm.utility.c.b(context2, false);
            k.a((Object) b2, "defaultParams");
            a(b2, context2);
            JSONObject jSONObject = new JSONObject(b2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("passcode", str6);
                jSONObject2.put("confirm_passcode", str7);
                jSONObject2.put("request_id", str8);
                jSONObject2.put("device_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", str9);
            return new net.one97.paytm.bankCommon.g.b(stringFromGTM, bVar, aVar, (IJRPaytmDataModel) new ValidatePasscode(), (Map<String, String>) null, (Map<String, String>) map, jSONObject2.toString(), a.C0715a.POST, cVar, bVar2, (HashMap<String, String>) hashMap2);
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static f a(Context context, String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, String str4) {
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        k.c(context2, "context");
        k.c(str5, "passCode");
        k.c(str6, "confirmPassCode");
        k.c(str7, "requestId");
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.c(cVar, "verticalId");
        k.c(bVar2, "userFacing");
        k.c(str8, SDKConstants.EVENT_KEY_SCREEN_NAME);
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
        if (a2 == null) {
            a2 = "";
        }
        Map map = hashMap;
        map.put("Authorization", a2);
        map.put("Content-Type", "application/json");
        map.put("client", "ANDROID");
        map.put("Remote-Address", "127.0.0.1");
        map.put("User-Agent", "ANDROID");
        if (context2.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e(context));
            String stringFromGTM = net.one97.paytm.bankOpen.f.a().getStringFromGTM("passcodeSetURL");
            k.a((Object) stringFromGTM, "PaymentBankAccOpenHelper…FromGTM(\"passcodeSetURL\")");
            Map<String, String> b2 = com.paytm.utility.c.b(context2, false);
            k.a((Object) b2, "defaultParams");
            a(b2, context2);
            JSONObject jSONObject = new JSONObject(b2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("passcode", str5);
                jSONObject2.put("confirm_passcode", str6);
                jSONObject2.put("request_id", str7);
                jSONObject2.put("device_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", str8);
            return new net.one97.paytm.bankCommon.g.b(stringFromGTM, bVar, aVar, (IJRPaytmDataModel) new ValidatePasscode(), (Map<String, String>) null, (Map<String, String>) map, jSONObject2.toString(), a.C0715a.POST, cVar, bVar2, (HashMap<String, String>) hashMap2);
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    private static f a(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, String str3) {
        Context context2 = context;
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
        if (a2 == null) {
            a2 = "";
        }
        Map map = hashMap;
        map.put("Authorization", a2);
        map.put("Content-Type", "application/json");
        map.put("client", "ANDROID");
        if (context.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
            map.put(SDKConstants.X_DEVICE_IDENTIFIER, com.paytm.utility.b.e(context));
            String stringFromGTM = net.one97.paytm.bankOpen.f.a().getStringFromGTM("passcodeTokenGenerationURL");
            k.a((Object) stringFromGTM, "PaymentBankAccOpenHelper…scodeTokenGenerationURL\")");
            if (!URLUtil.isValidUrl(stringFromGTM)) {
                net.one97.paytm.bankOpen.c a3 = net.one97.paytm.bankOpen.f.a();
                k.a((Object) a3, "PaymentBankAccOpenHelper.getImplListener()");
                stringFromGTM = p.a(a3.getBuildConfigBuildType(), SDKConstants.KEY_STAGING_API, true) ? "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v1/token" : "https://oauth.paytmbank.com/bank-oauth/ext/v1/token";
            }
            String str4 = stringFromGTM;
            Map<String, String> b2 = com.paytm.utility.c.b(context, false);
            k.a((Object) b2, "defaultParams");
            a(b2, context);
            JSONObject jSONObject = new JSONObject(b2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("login_secret", str);
                jSONObject2.put("login_secret_type", "passcode");
                jSONObject2.put("scope", str2);
                jSONObject2.put("device_info", jSONObject);
            } catch (Exception unused) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", str3);
            return new net.one97.paytm.bankCommon.g.b(str4, bVar, aVar, (IJRPaytmDataModel) new BankToken(), (Map<String, String>) null, (Map<String, String>) map, jSONObject2.toString(), a.C0715a.POST, cVar, bVar2, (HashMap<String, String>) hashMap2);
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static f a(Context context, String str, net.one97.paytm.bankCommon.f.b<String> bVar) {
        k.c(context, "context");
        k.c(str, "passcode");
        k.c(bVar, "listener");
        try {
            d.b();
            String a2 = com.paytm.e.a.b.a(d.O(), str);
            k.a((Object) a2, "OfflineDataEncryption.en…sscodeRsaKey(), passcode)");
            return a(context, a2, a.C0220a.BANK_TRANSACTION.getScope(), new a(bVar), new b(bVar), a.c.PAYMENTSBANK, a.b.USER_FACING, "BankUtils");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static final class a implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.bankCommon.f.b f16330a;

        a(net.one97.paytm.bankCommon.f.b bVar) {
            this.f16330a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            if (iJRPaytmDataModel instanceof BankToken) {
                BankToken bankToken = (BankToken) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(bankToken.getAccessToken())) {
                    this.f16330a.a(bankToken.getAccessToken(), "");
                } else {
                    this.f16330a.a("", bankToken.getmMessage());
                }
            }
        }
    }

    public static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.bankCommon.f.b f16331a;

        b(net.one97.paytm.bankCommon.f.b bVar) {
            this.f16331a = bVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f16331a.a(i2, networkCustomError);
        }
    }

    public static f b(Context context, String str, net.one97.paytm.bankCommon.f.b<String> bVar) {
        k.c(context, "context");
        k.c(str, "passcode");
        k.c(bVar, "listener");
        try {
            d.b();
            String a2 = com.paytm.e.a.b.a(d.O(), str);
            k.a((Object) a2, "OfflineDataEncryption.en…sscodeRsaKey(), passcode)");
            return a(context, a2, a.C0220a.RESET_SECRET.getScope(), new c(bVar), new d(bVar), a.c.PAYMENTSBANK, a.b.USER_FACING, "BankUtils");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static final class c implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.bankCommon.f.b f16332a;

        c(net.one97.paytm.bankCommon.f.b bVar) {
            this.f16332a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            if (iJRPaytmDataModel instanceof BankToken) {
                BankToken bankToken = (BankToken) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(bankToken.getAccessToken())) {
                    this.f16332a.a(bankToken.getAccessToken(), "");
                } else {
                    this.f16332a.a("", bankToken.getmMessage());
                }
            }
        }
    }

    public static final class d implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.bankCommon.f.b f16333a;

        d(net.one97.paytm.bankCommon.f.b bVar) {
            this.f16333a = bVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f16333a.a(i2, networkCustomError);
        }
    }
}
