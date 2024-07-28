package net.one97.paytm.passbook.utility;

import android.app.Activity;
import android.content.Context;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.utility.a;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static void a(Activity activity, i.a<IJRDataModel> aVar, g gVar) {
        if (activity != null) {
            String a2 = d.b().a("p2bStatus");
            if (URLUtil.isValidUrl(a2)) {
                String e2 = b.e((Context) activity, a2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", a.q(activity));
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SDKConstants.TXN_TYPE, "PAYER_TO_BANK_TRANSFER");
                    jSONObject2.put("ssoId", b.n((Context) activity));
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String Q = b.Q((Context) activity);
                    if (Q != null) {
                        jSONObject.put("version", Q);
                    }
                } catch (JSONException unused) {
                }
                activity.getApplicationContext();
                c.a();
                c.b(new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new CJRP2BStatus(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, e.class.getName()));
            }
        }
    }
}
