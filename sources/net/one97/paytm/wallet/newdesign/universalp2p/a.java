package net.one97.paytm.wallet.newdesign.universalp2p;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.gson.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.q;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsReqDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.communicator.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f71351a;

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.a$a  reason: collision with other inner class name */
    public enum C1448a {
        PAYMENT_OPTIONS,
        CHECK_WALLET_BALANCE,
        PPB_AVAILABILITY,
        PPB_BALANCE,
        WALLET_LIMITS,
        CONSOLIDATE_PAYMENT_INST,
        FETCH_STRATEGY,
        FETCH_MERCHANTINFO,
        CONSOLIDATE_PAYMENT_INST_V1
    }

    public a(Context context) {
        this.f71351a = context;
    }

    public final Map<String, String> a(C1448a aVar, Object... objArr) {
        HashMap hashMap = new HashMap();
        switch (aVar) {
            case WALLET_LIMITS:
                return b();
            case PAYMENT_OPTIONS:
                return b(objArr);
            case CHECK_WALLET_BALANCE:
                return d();
            case CONSOLIDATE_PAYMENT_INST_V1:
            case CONSOLIDATE_PAYMENT_INST:
                return a(objArr);
            case FETCH_STRATEGY:
                return c();
            default:
                return hashMap;
        }
    }

    public final String b(C1448a aVar, Object... objArr) {
        switch (aVar) {
            case WALLET_LIMITS:
                return e();
            case PAYMENT_OPTIONS:
                return e(objArr);
            case CHECK_WALLET_BALANCE:
                return h();
            case CONSOLIDATE_PAYMENT_INST_V1:
                return a();
            case CONSOLIDATE_PAYMENT_INST:
                return g();
            case FETCH_STRATEGY:
                return d(objArr);
            case FETCH_MERCHANTINFO:
                return f();
            default:
                return "";
        }
    }

    private String a() {
        StringBuilder sb = new StringBuilder(b.a().getStringFromGTM(this.f71351a, "paymentCombinations"));
        int indexOf = sb.indexOf("{userID}");
        sb.replace(indexOf, indexOf + 8, com.paytm.utility.b.n(this.f71351a));
        sb.append("?nonDefaultBankAccounts=true");
        return sb.toString();
    }

    public final String c(C1448a aVar, Object... objArr) {
        int i2 = AnonymousClass1.f71352a[aVar.ordinal()];
        if (i2 == 1) {
            return g(objArr);
        }
        if (i2 != 3) {
            return "";
        }
        return f(objArr);
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71351a));
        hashMap.put("tokentype", "OAUTH");
        hashMap.put("is_admin", "false");
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    private Map<String, String> a(Object... objArr) {
        HashMap hashMap = new HashMap();
        String str = (!TextUtils.isEmpty(com.paytm.utility.b.af(this.f71351a)) ? com.paytm.utility.b.af(this.f71351a) : "") + System.currentTimeMillis();
        hashMap.put(UpiConstants.DESTINATION_PHONE, objArr[0]);
        hashMap.put(UpiConstants.USER_TOKEN, com.paytm.utility.a.q(this.f71351a));
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap.put(UpiConstants.REQUEST_TOKEN, str);
        return hashMap;
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("data", com.paytm.utility.a.q(this.f71351a));
        hashMap.put("verification_type", "oauth_token");
        hashMap.put("Authorization", com.paytm.utility.b.m());
        return hashMap;
    }

    private Map<String, String> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f71351a));
        hashMap.put("Accept-Encoding", "gzip");
        return hashMap;
    }

    private Map<String, String> b(Object... objArr) {
        String str = (!TextUtils.isEmpty(com.paytm.utility.b.af(this.f71351a)) ? com.paytm.utility.b.af(this.f71351a) : "") + System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("Session-Token", com.paytm.utility.a.q(this.f71351a));
        hashMap.put(UpiConstants.REQUEST_TOKEN, str);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Client-Id", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        hashMap.put("jwt", c(str, objArr[0]));
        return hashMap;
    }

    private String c(Object... objArr) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(UpiConstants.REQUEST_TOKEN, objArr[0]);
        hashMap.put("Session-Token", com.paytm.utility.a.q(this.f71351a));
        hashMap.put(ContactColumn.PHONE_NUMBER, objArr[1]);
        hashMap.put("Client-Id", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("alg", "HS256");
        hashMap2.put("typ", "JWT");
        if (b.a().getBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API)) {
            str = "S5rstARx4TcpV9NLx3QKrUT53CkVpMKLw";
        } else {
            str = TextUtils.isEmpty(b.a().getStringFromGTM(this.f71351a, "jwt_secret_key")) ? "" : b.a().getStringFromGTM(this.f71351a.getApplicationContext(), "jwt_secret_key");
        }
        return b.a().getJWTToken(hashMap2, hashMap, "bank-transfer", str);
    }

    private String e() {
        String stringFromGTM = b.a().getStringFromGTM(this.f71351a, "walletLimitV2");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return null;
        }
        return stringFromGTM;
    }

    private String d(Object... objArr) {
        return b.a().getStringFromGTM(this.f71351a, "nearex_userid_url") + "?fetch_strategy=PUBLIC_PROFILE&phone=" + objArr[0];
    }

    private String f() {
        return b.a().getStringFromGTM(this.f71351a, "urlMerchantInfo");
    }

    private String g() {
        String stringFromGTM = b.a().getStringFromGTM(this.f71351a, "paymentCombinationsv5");
        if (TextUtils.isEmpty(stringFromGTM)) {
            stringFromGTM = "https://transfer.paytmbank.com/v4/ext/users/{userID}/payment-combinations";
        }
        StringBuilder sb = new StringBuilder(stringFromGTM);
        int indexOf = sb.indexOf("{userID}");
        if (!TextUtils.isEmpty(com.paytm.utility.b.n(this.f71351a))) {
            sb.replace(indexOf, indexOf + 8, com.paytm.utility.b.n(this.f71351a));
        }
        sb.append("?nonDefaultBankAccounts=true");
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String e(java.lang.Object... r6) {
        /*
            r5 = this;
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r1 = r5.f71351a
            java.lang.String r2 = "walletPaymentOption"
            java.lang.String r0 = r0.getStringFromGTM(r1, r2)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x003d
            r0 = 0
            r3 = r6[r0]     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0034 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0034 }
            if (r3 != 0) goto L_0x0034
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0034 }
            android.content.Context r4 = r5.f71351a     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = r3.getStringFromGTM(r4, r2)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = "\\{.*?\\}"
            r6 = r6[r0]     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0034 }
            java.lang.String r6 = r2.replaceAll(r3, r6)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0035
        L_0x0034:
            r6 = r1
        L_0x0035:
            boolean r0 = android.webkit.URLUtil.isValidUrl(r6)
            if (r0 != 0) goto L_0x003c
            return r1
        L_0x003c:
            return r6
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.universalp2p.a.e(java.lang.Object[]):java.lang.String");
    }

    private String h() {
        String stringFromGTM = b.a().getStringFromGTM(this.f71351a, "check_user_balance_service");
        if (stringFromGTM == null || !URLUtil.isValidUrl(stringFromGTM)) {
            return null;
        }
        return com.paytm.utility.b.e(this.f71351a, stringFromGTM);
    }

    private static String f(Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request", new JSONObject().put("payeePhoneNo", objArr[0]));
        } catch (JSONException e2) {
            q.d(String.valueOf(e2));
        }
        return jSONObject.toString();
    }

    private String g(Object... objArr) {
        WalletLimitsReqDataModel walletLimitsReqDataModel = new WalletLimitsReqDataModel();
        walletLimitsReqDataModel.setOperationType("WALLET_LIMIT");
        walletLimitsReqDataModel.setPlatformName("PayTM");
        WalletLimitsReqDataModel.Request request = new WalletLimitsReqDataModel.Request();
        request.setTargetPhoneNo(objArr[1]);
        request.setSsoId(com.paytm.utility.b.n(this.f71351a));
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(objArr[2]);
            arrayList.add("P2P_TRANSFER");
        } catch (Exception unused) {
        }
        request.setWalletOperationTypeList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList2.add(Double.valueOf(Double.parseDouble(objArr[0]) - objArr[3].doubleValue()));
            arrayList2.add(Double.valueOf(Double.parseDouble(objArr[0])));
        } catch (Exception unused2) {
        }
        request.setWalletOperationTypeBasedAmountList(arrayList2);
        walletLimitsReqDataModel.setRequest(request);
        return new f().a((Object) walletLimitsReqDataModel, (Type) WalletLimitsReqDataModel.class);
    }
}
