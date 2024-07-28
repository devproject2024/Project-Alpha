package net.one97.paytm.moneytransfer.utils;

import android.content.Context;
import android.webkit.URLUtil;
import com.android.volley.Response;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.a;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.contacts.entities.beans.ContactBeneficiaryBean;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONObject;

public final class h {
    public static void a(Context context, Response.Listener<IJRPaytmDataModel> listener, Response.ErrorListener errorListener, int i2, int i3) {
        if (context != null) {
            String a2 = c.a(c.g().o);
            if (URLUtil.isValidUrl(a2)) {
                d.c();
                StringBuilder sb = new StringBuilder();
                sb.append(b.e(context, a2));
                sb.append("&offset=");
                int i4 = i2;
                sb.append(i2);
                sb.append("&limit=");
                sb.append(i3);
                sb.append("&type=upi,otherBank");
                String sb2 = sb.toString();
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", a.q(context));
                f.b(context).add(new com.paytm.network.c(context, a.c.MONEYTRANSFER, a.C0715a.GET, sb2, hashMap, listener, errorListener, new CJRKYCBeneficiaryBase(), ""));
            }
        }
    }

    public static void a(Context context, Response.Listener<IJRPaytmDataModel> listener, Response.ErrorListener errorListener) {
        if (context != null) {
            String a2 = c.a(c.g().u);
            if (URLUtil.isValidUrl(a2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                    jSONObject.put("contactType", e.b.TRANSFER_BENEFICIARY.name());
                    jSONObject.put("offset", 0);
                    jSONObject.put("limit", 3);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                f.b(context).add(new com.paytm.network.c(context, a.c.MONEYTRANSFER, a.C0715a.POST, a2, a(context), listener, errorListener, new ContactBeneficiaryBean(), jSONObject.toString()));
            }
        }
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(UpiRequestBuilder.SESSION_TOKEN, com.paytm.utility.a.q(context));
        hashMap.put("clientId", "PAYTM");
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }
}
