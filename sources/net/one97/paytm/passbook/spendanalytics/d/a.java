package net.one97.paytm.passbook.spendanalytics.d;

import android.content.Context;
import com.paytm.network.a;
import java.util.HashMap;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.b;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static b a(Context context, String str, String str2, String str3, String str4, String str5, i.a<IJRDataModel> aVar, g gVar) {
        String a2 = d.b().a("PaytmCashLedgerSearchAPI");
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(context));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept-encoding", "gzip");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str6 = str;
        try {
            jSONObject.put("from", str);
            String str7 = str2;
            jSONObject.put("startLimit", str2);
            jSONObject.put("to", str3);
            jSONObject.put("payeeId", str4);
            jSONObject.put("lastLimit", str5);
            jSONObject.put("txnMessage", "SUCCESS");
            jSONObject2.put("request", jSONObject);
        } catch (JSONException unused) {
        }
        return new b(a2, aVar, gVar, new CJRLedger(), hashMap, jSONObject2.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, a.class.getName());
    }
}
