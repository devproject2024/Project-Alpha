package net.one97.paytm.nativesdk.walletOtp;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import org.json.JSONException;
import org.json.JSONObject;

public final class WalletOtpRequestHelper {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static WalletOtpRequestHelper INSTANCE;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WalletOtpRequestHelper getInstance() {
            if (WalletOtpRequestHelper.INSTANCE == null) {
                WalletOtpRequestHelper.INSTANCE = new WalletOtpRequestHelper();
            }
            WalletOtpRequestHelper access$getINSTANCE$cp = WalletOtpRequestHelper.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroy() {
            WalletOtpRequestHelper.INSTANCE = null;
        }
    }

    public final String createSenOtpRequest(String str) {
        if (str == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("Content-Type", "application/json");
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            jSONObject2.put("txnToken", merchantInstance.getToken());
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject3.put(SDKConstants.MOBILE_NUMBER, str);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        return jSONObject.toString();
    }

    public final String validateOtpRequest(String str) {
        if (str == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("Content-Type", "application/json");
            jSONObject2.put(SDKConstants.VERSION, "v1");
            jSONObject2.put(SDKConstants.REQUEST_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("channelId", SDKConstants.WAP);
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            jSONObject2.put("txnToken", merchantInstance.getToken());
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject3.put(SDKConstants.OTP, str);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        return jSONObject.toString();
    }
}
