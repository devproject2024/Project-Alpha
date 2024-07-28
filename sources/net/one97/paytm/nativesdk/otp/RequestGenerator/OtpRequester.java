package net.one97.paytm.nativesdk.otp.RequestGenerator;

import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class OtpRequester {
    public static final String CHANNEL_ID = "channelId";

    public static String createSendOtpRequest(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(SDKConstants.VERSION, "v1");
            String str2 = SDKConstants.REQUEST_TIMESTAMP;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(str2, sb.toString());
            jSONObject2.put("channelId", "WEB");
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject3.put(SDKConstants.MOBILE_NUMBER, str);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        return jSONObject.toString();
    }

    public static String createValidateOtpRequest(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(SDKConstants.VERSION, "v1");
            String str2 = SDKConstants.REQUEST_TIMESTAMP;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(str2, sb.toString());
            jSONObject2.put("channelId", "WEB");
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject3.put(SDKConstants.OTP, str);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        return jSONObject.toString();
    }
}
