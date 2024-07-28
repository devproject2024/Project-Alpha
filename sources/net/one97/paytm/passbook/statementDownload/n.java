package net.one97.paytm.passbook.statementDownload;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.utility.a;
import java.util.HashMap;
import net.one97.paytm.passbook.beans.EmailEditResponse;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.b;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    public static b a(Context context, String str, i.a<IJRDataModel> aVar, g gVar) {
        String a2 = d.b().a("updateEmailV3");
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", a.q(context));
        hashMap.put("Authorization", net.one97.paytm.passbook.mapping.a.m());
        hashMap.put("client_secret", net.one97.paytm.passbook.mapping.a.l());
        hashMap.put("client_id", net.one97.paytm.passbook.mapping.a.k());
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        String str2 = str;
        try {
            jSONObject.put(AppConstants.KEY_EMAIL, str);
        } catch (JSONException unused) {
        }
        return new b(a2, aVar, gVar, new EmailEditResponse(), hashMap, jSONObject.toString(), a.C0715a.PUT, a.c.PASSBOOK, a.b.USER_FACING, n.class.getName());
    }

    public static b a(Context context, String str, String str2, i.a<IJRDataModel> aVar, g gVar) {
        String a2 = d.b().a("profileValidateOTPV3");
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(context));
        hashMap.put("Authorization", net.one97.paytm.passbook.mapping.a.m());
        hashMap.put("client_secret", net.one97.paytm.passbook.mapping.a.l());
        hashMap.put("client_id", net.one97.paytm.passbook.mapping.a.k());
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        String str3 = str;
        try {
            jSONObject.put("state", str);
            String str4 = str2;
            jSONObject.put("currentPhoneOtp", str2);
        } catch (JSONException unused) {
        }
        return new b(a2, aVar, gVar, new EmailEditResponse(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, n.class.getName());
    }
}
