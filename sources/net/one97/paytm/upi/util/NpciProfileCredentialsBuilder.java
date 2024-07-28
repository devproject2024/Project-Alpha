package net.one97.paytm.upi.util;

import android.content.Context;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class NpciProfileCredentialsBuilder {
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

    private static JSONObject getDefaultOtpCredBlock() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "OTP");
            jSONObject.put(CLConstants.FIELD_SUBTYPE, "SMS");
            jSONObject.put(CLConstants.FIELD_DTYPE, "NUM | ALPH");
            jSONObject.put(CLConstants.FIELD_DLENGTH, "6");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject getDefaultMpinCredBlock() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "PIN");
            jSONObject.put(CLConstants.FIELD_SUBTYPE, "MPIN");
            jSONObject.put(CLConstants.FIELD_DTYPE, "NUM | ALPH");
            jSONObject.put(CLConstants.FIELD_DLENGTH, "6");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject getDefaultAtmPinCredBlock() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "PIN");
            jSONObject.put(CLConstants.FIELD_SUBTYPE, "ATMPIN");
            jSONObject.put(CLConstants.FIELD_DTYPE, "NUM");
            jSONObject.put(CLConstants.FIELD_DLENGTH, "4");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject getDefaultNMpinCredBlock() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "PIN");
            jSONObject.put(CLConstants.FIELD_SUBTYPE, "NMPIN");
            jSONObject.put(CLConstants.FIELD_DTYPE, "NUM | ALPH");
            jSONObject.put(CLConstants.FIELD_DLENGTH, "6");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject getMpinCredBlock(BankAccountDetails.BankAccount bankAccount) {
        JSONObject defaultMpinCredBlock = getDefaultMpinCredBlock();
        if (bankAccount.getCredsAllowed() == null || bankAccount.getCredsAllowed().getChild() == null) {
            return null;
        }
        try {
            for (BankAccountDetails.BankAccountCredentials next : bankAccount.getCredsAllowed().getChild()) {
                if ("MPIN".equalsIgnoreCase(next.getCredsAllowedSubType())) {
                    defaultMpinCredBlock.put("type", next.getCredsAllowedType());
                    defaultMpinCredBlock.put(CLConstants.FIELD_SUBTYPE, next.getCredsAllowedSubType());
                    defaultMpinCredBlock.put(CLConstants.FIELD_DTYPE, next.getCredsAllowedDType());
                    defaultMpinCredBlock.put(CLConstants.FIELD_DLENGTH, next.getCredsAllowedDLength());
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return defaultMpinCredBlock;
    }

    private static JSONObject getOtpCredBlock(BankAccountDetails.BankAccount bankAccount) {
        JSONObject defaultOtpCredBlock = getDefaultOtpCredBlock();
        if (bankAccount.getCredsAllowed() == null || bankAccount.getCredsAllowed().getChild() == null) {
            return null;
        }
        try {
            for (BankAccountDetails.BankAccountCredentials next : bankAccount.getCredsAllowed().getChild()) {
                if (next.getCredsAllowedSubType().equalsIgnoreCase("OTP") || next.getCredsAllowedSubType().equalsIgnoreCase("SMS")) {
                    defaultOtpCredBlock.put("type", next.getCredsAllowedType());
                    defaultOtpCredBlock.put(CLConstants.FIELD_SUBTYPE, next.getCredsAllowedSubType());
                    defaultOtpCredBlock.put(CLConstants.FIELD_DTYPE, next.getCredsAllowedDType());
                    defaultOtpCredBlock.put(CLConstants.FIELD_DLENGTH, next.getCredsAllowedDLength());
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return defaultOtpCredBlock;
    }

    private static JSONObject getAtmpinCredBlock(BankAccountDetails.BankAccount bankAccount) {
        JSONObject defaultAtmPinCredBlock = getDefaultAtmPinCredBlock();
        if (bankAccount.getCredsAllowed() == null) {
            return null;
        }
        try {
            for (BankAccountDetails.BankAccountCredentials next : bankAccount.getCredsAllowed().getChild()) {
                if (next.getCredsAllowedSubType().equalsIgnoreCase("ATMPIN")) {
                    defaultAtmPinCredBlock.put("type", next.getCredsAllowedType());
                    defaultAtmPinCredBlock.put(CLConstants.FIELD_SUBTYPE, next.getCredsAllowedSubType());
                    defaultAtmPinCredBlock.put(CLConstants.FIELD_DTYPE, next.getCredsAllowedDType());
                    defaultAtmPinCredBlock.put(CLConstants.FIELD_DLENGTH, next.getCredsAllowedDLength());
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return defaultAtmPinCredBlock;
    }

    private static JSONObject getNmpinCredBlock(BankAccountDetails.BankAccount bankAccount) {
        JSONObject defaultNMpinCredBlock = getDefaultNMpinCredBlock();
        if (bankAccount.getCredsAllowed() == null || bankAccount.getCredsAllowed().getChild() == null) {
            return null;
        }
        try {
            for (BankAccountDetails.BankAccountCredentials next : bankAccount.getCredsAllowed().getChild()) {
                if (next.getCredsAllowedSubType().equalsIgnoreCase("MPIN")) {
                    defaultNMpinCredBlock.put("type", next.getCredsAllowedType());
                    defaultNMpinCredBlock.put(CLConstants.FIELD_SUBTYPE, "NMPIN");
                    defaultNMpinCredBlock.put(CLConstants.FIELD_DTYPE, next.getCredsAllowedDType());
                    defaultNMpinCredBlock.put(CLConstants.FIELD_DLENGTH, next.getCredsAllowedDLength());
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return defaultNMpinCredBlock;
    }

    public static String getControlsForChangePin(BankAccountDetails.BankAccount bankAccount) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(getMpinCredBlock(bankAccount));
            jSONArray.put(getNmpinCredBlock(bankAccount));
            jSONObject.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getControlsForResetPin(BankAccountDetails.BankAccount bankAccount) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(getOtpCredBlock(bankAccount));
            jSONArray.put(getMpinCredBlock(bankAccount));
            if (bankAccount.isFormat2Bank()) {
                jSONArray.put(getAtmpinCredBlock(bankAccount));
            }
            jSONObject.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getControlsForCheckBalance(BankAccountDetails.BankAccount bankAccount) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(getMpinCredBlock(bankAccount));
            jSONObject.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getConfiguration(BankAccountDetails.BankAccount bankAccount) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(CLConstants.FIELD_PAYER_BANK_NAME, bankAccount.getBankName());
                jSONObject.put("backgroundColor", "#FFFFFF");
                jSONObject.put(CLConstants.CONFIGURATION_RESEND_OTP_FEATURE, true);
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
            e.printStackTrace();
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    public static String getSalt(String str, Context context) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("txnId", str);
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put("appId", UpiUtils.getAppId(context));
                jSONObject.put("mobileNumber", UpiUtils.getMobile(context));
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObject = null;
            e.printStackTrace();
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    public static String getTrust(String str, String str2, Context context) {
        try {
            return TrustCreator.createTrust(str + "|" + UpiUtils.getAppId(context) + "|" + UpiUtils.getMobile(context) + "|" + UpiUtils.getDeviceId(context), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getPayerInfo(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "account");
            jSONObject.put("value", UpiUtils.maskNumber(str));
            jSONArray.put(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }
}
