package net.one97.paytm.wallet.d;

import android.app.Activity;
import android.content.Context;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.common.entity.wallet.CJRBranch;
import net.one97.paytm.common.entity.wallet.CJRCity;
import net.one97.paytm.common.entity.wallet.CJRState;
import net.one97.paytm.j.c;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.t;
import org.json.JSONObject;

public final class d {
    public static void a(Activity activity, String str, b bVar) {
        c.a();
        String o = c.o();
        if (URLUtil.isValidUrl(o)) {
            String e2 = com.paytm.utility.b.e((Context) activity, o);
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", t.b((Context) activity));
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("bankName", str);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
                String Q = com.paytm.utility.b.Q((Context) activity);
                if (Q != null) {
                    jSONObject.put("version", Q);
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.b(e3.getMessage());
                }
            }
            net.one97.paytm.common.b.d.a(activity, e2, bVar, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRState(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    public static void a(Activity activity, String str, String str2, b bVar) {
        c.a();
        String o = c.o();
        if (URLUtil.isValidUrl(o)) {
            String e2 = com.paytm.utility.b.e((Context) activity, o);
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", t.b((Context) activity));
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("bankName", str);
                jSONObject2.put("state", str2);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
                String Q = com.paytm.utility.b.Q((Context) activity);
                if (Q != null) {
                    jSONObject.put("version", Q);
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.b(e3.getMessage());
                }
            }
            net.one97.paytm.common.b.d.a(activity, e2, bVar, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRCity(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    public static void a(Activity activity, String str, String str2, String str3, b bVar) {
        c.a();
        String o = c.o();
        if (URLUtil.isValidUrl(o)) {
            Activity activity2 = activity;
            String e2 = com.paytm.utility.b.e((Context) activity, o);
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", t.b((Context) activity));
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str4 = str;
            try {
                jSONObject2.put("bankName", str);
                String str5 = str2;
                jSONObject2.put("state", str2);
                String str6 = str3;
                jSONObject2.put("city", str3);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
                String Q = com.paytm.utility.b.Q((Context) activity);
                if (Q != null) {
                    jSONObject.put("version", Q);
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.b(e3.getMessage());
                }
            }
            net.one97.paytm.common.b.d.a(activity, e2, bVar, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRBranch(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    public static void a(Context context, String str, b bVar) {
        if (context != null) {
            c.a();
            String p = c.p();
            if (URLUtil.isValidUrl(p)) {
                String e2 = com.paytm.utility.b.e(context, p);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", t.b(context));
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ifscCode", str);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String Q = com.paytm.utility.b.Q(context);
                    if (Q != null) {
                        jSONObject.put("version", Q);
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.b(e3.getMessage());
                    }
                }
                net.one97.paytm.common.b.d.a(context, e2, bVar, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRBankDetails(), a.c.PAYMENTS, a.b.SILENT).a();
            }
        }
    }
}
