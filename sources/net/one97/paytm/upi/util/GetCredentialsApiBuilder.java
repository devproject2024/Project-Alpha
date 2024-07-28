package net.one97.paytm.upi.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.h.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public class GetCredentialsApiBuilder {
    private static List<BankAccountDetails.BankAccountCredentials> childObject = null;
    private static String mAccount = "";
    private static String mAmount = "0.00";
    private static String mBankName = null;
    private static String mMCC = null;
    private static String mNote = "";
    private static String mPayeeAddress = "";
    private static String mPayeeName = "";
    private static String mPayerAddress = "";
    private static String mRefId;
    private static String mRefUrl;
    private static String mTxnId;
    private static String token;

    public static String getKeycode() {
        return "NPCI";
    }

    public static String getLanguagePref() {
        return CLConstants.DEFAULT_LANGUAGE_PREFERENCE;
    }

    public static String getXmlPayload(Context context) {
        String b2 = PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b(UpiConstants.KEY_LIST_KEYS_RESPONSE, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String getCredsAllowed(BankAccountDetails.BankAccount bankAccount) {
        return bankAccount.getCredsAsJson();
    }

    public static JSONObject getmPinJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "PIN");
            jSONObject.put(CLConstants.FIELD_SUBTYPE, "MPIN");
            jSONObject.put(CLConstants.FIELD_DTYPE, "NUM");
            for (BankAccountDetails.BankAccountCredentials next : childObject) {
                if ("MPIN".equalsIgnoreCase(next.getCredsAllowedSubType())) {
                    jSONObject.put(CLConstants.FIELD_DLENGTH, next.getCredsAllowedDLength());
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject getSalt(Context context) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("txnId", mTxnId);
                jSONObject.put("txnAmount", mAmount);
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put("appId", UpiUtils.getAppId(context));
                jSONObject.put("mobileNumber", UpiUtils.getMobile(context));
                jSONObject.put(CLConstants.SALT_FIELD_PAYER_ADDR, mPayerAddress);
                jSONObject.put(CLConstants.SALT_FIELD_PAYEE_ADDR, mPayeeAddress);
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    public static JSONObject getControlsJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(getmPinJsonObject());
            jSONObject.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static String getConfiguration() {
        JSONObject jSONObject;
        JSONException e2;
        try {
            jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(mBankName)) {
                    jSONObject.put(CLConstants.FIELD_PAYER_BANK_NAME, "NA");
                } else {
                    jSONObject.put(CLConstants.FIELD_PAYER_BANK_NAME, mBankName);
                }
                jSONObject.put("backgroundColor", "#FFFFFF");
                jSONObject.put(CLConstants.CONFIGURATION_RESEND_OTP_FEATURE, true);
            } catch (JSONException e3) {
                e2 = e3;
                e2.printStackTrace();
                return jSONObject.toString();
            }
        } catch (JSONException e4) {
            JSONException jSONException = e4;
            jSONObject = null;
            e2 = jSONException;
            e2.printStackTrace();
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    public static String getTrust(Context context) {
        try {
            return TrustCreator.createTrust(mAmount + "|" + mTxnId + "|" + mPayerAddress + "|" + mPayeeAddress + "|" + UpiUtils.getAppId(context) + "|" + UpiUtils.getMobile(context) + "|" + UpiUtils.getDeviceId(context), token);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONArray getPayInfoArray() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "payeeName");
            jSONObject.put("value", mPayeeName);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "txnAmount");
            jSONObject2.put("value", mAmount);
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", "note");
            jSONObject3.put("value", mNote);
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("name", "refId");
            if (TextUtils.isEmpty(mRefId)) {
                jSONObject4.put("value", mTxnId);
            } else {
                jSONObject4.put("value", mRefId);
            }
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("name", "refUrl");
            jSONObject5.put("value", mRefUrl);
            jSONArray.put(jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("name", "account");
            jSONObject6.put("value", mAccount);
            jSONArray.put(jSONObject6);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static void getPinFromCommonLib(Context context, String str, String str2, String str3, String str4, String str5, String str6, CLRemoteResultReceiver cLRemoteResultReceiver, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12) {
        mAmount = str;
        mPayeeAddress = str2;
        mPayerAddress = str3;
        mPayeeName = str4;
        mNote = str5;
        mAccount = str6;
        token = str11;
        mTxnId = str7;
        childObject = list;
        mRefId = str9;
        mRefUrl = str10;
        mMCC = str8;
        mBankName = str12;
        Context context2 = context;
        a.a(context, (a.C1347a) null).a(getKeycode(), getXmlPayload(context), getControlsJsonObject().toString(), getConfiguration().toString(), getSalt(context).toString(), getPayInfoArray().toString(), getTrust(context), getLanguagePref(), cLRemoteResultReceiver);
    }

    public static String getPayerInfo(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "account");
            jSONObject.put("value", str);
            jSONArray.put(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }

    public JSONObject getOTPJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "OTP");
            jSONObject.put(CLConstants.FIELD_SUBTYPE, "SMS");
            jSONObject.put("dtype", "NUM | ALPH");
            jSONObject.put("dlength", "6");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
