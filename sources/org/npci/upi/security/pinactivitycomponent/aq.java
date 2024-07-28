package org.npci.upi.security.pinactivitycomponent;

import android.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class aq {

    /* renamed from: a  reason: collision with root package name */
    private String f72957a = a("MS03LTItNA==");

    /* renamed from: b  reason: collision with root package name */
    private c f72958b;

    aq(c cVar) {
        this.f72958b = cVar;
    }

    private String a(String str) {
        String str2 = "";
        for (String str3 : new String(Base64.decode(str, -1)).split("-")) {
            str2 = str2 + this.f72958b.b(str3);
        }
        return new String(Base64.decode(str2, -1));
    }

    private void b(JSONObject jSONObject) {
    }

    public String a(JSONObject jSONObject) {
        try {
            b(jSONObject);
            new StringBuilder();
            ad.b("Common Library", "Salt Format: " + this.f72957a);
            String str = this.f72957a;
            ad.b("Common Library", "Temp Salt Format: ".concat(String.valueOf(str)));
            if (str == null || str.isEmpty()) {
                return null;
            }
            Matcher matcher = Pattern.compile("\\[([^\\]]*)\\]").matcher(str);
            StringBuffer stringBuffer = new StringBuffer(1000);
            while (matcher.find()) {
                String group = matcher.group();
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(group.substring(1, group.length() - 1))));
            }
            matcher.appendTail(stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            ad.b("Common Library", "Output Salt: ".concat(String.valueOf(stringBuffer2)));
            return stringBuffer2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
