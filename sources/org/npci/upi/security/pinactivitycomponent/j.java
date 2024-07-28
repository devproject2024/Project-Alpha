package org.npci.upi.security.pinactivitycomponent;

import com.business.merchant_payments.utility.StringUtility;
import in.org.npci.commonlibrary.Data;
import in.org.npci.commonlibrary.Message;
import in.org.npci.commonlibrary.e;
import in.org.npci.commonlibrary.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private e f72991a;

    /* renamed from: b  reason: collision with root package name */
    private String f72992b;

    /* renamed from: c  reason: collision with root package name */
    private i f72993c;

    public j(e eVar, i iVar, String str) {
        this.f72991a = eVar;
        this.f72992b = str;
        this.f72993c = iVar;
    }

    private Message a(String str, String str2, String str3, String str4, String str5, String str6) {
        Message message = null;
        try {
            message = this.f72991a.a(this.f72992b, str4, str5, str, str6);
            message.setType(str2);
            message.setSubType(str3);
            Data data = message.getData();
            data.setEncryptedBase64String("2.0|" + message.getData().getEncryptedBase64String());
            return message;
        } catch (f e2) {
            e2.printStackTrace();
            return message;
        }
    }

    public Message a(String str, String str2, String str3, JSONObject jSONObject) {
        Message message = null;
        try {
            String string = jSONObject.getString("txnId");
            String string2 = jSONObject.getString(CLConstants.SALT_FIELD_CREDENTIAL);
            String string3 = jSONObject.getString("appId");
            String string4 = jSONObject.getString("deviceId");
            String string5 = jSONObject.getString("mobileNumber");
            i iVar = this.f72993c;
            ad.b("DBH in encryptor", iVar == null ? "null" : iVar.toString());
            String a2 = this.f72993c.a(string3, string4, string5);
            ad.b("K0 in encryptor", a2);
            Matcher matcher = Pattern.compile("\\{([^}]*)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            if (matcher.find()) {
                String group = matcher.group();
                message = a(group.substring(1, group.length() - 1), str2, str3, string, string2, a2);
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(message.getData().getEncryptedBase64String().replaceAll(StringUtility.NEW_LINE, "")));
            }
            if (stringBuffer.length() > 0) {
                matcher.appendTail(stringBuffer);
            }
            if (message != null) {
                String stringBuffer2 = stringBuffer.toString();
                ad.b("CommonLibrary", "Encrypted Data: ".concat(String.valueOf(stringBuffer2)));
                message.getData().setEncryptedBase64String(stringBuffer2);
            }
            return message;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
