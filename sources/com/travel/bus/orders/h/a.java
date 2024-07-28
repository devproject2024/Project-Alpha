package com.travel.bus.orders.h;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.utility.q;
import com.travel.bus.pojo.busticket.CJRBusNpsTrackingResponse;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f22643a = "CJRApiUtils";

    public static void a(Context context, int i2, String str, String str2, ArrayList<String> arrayList, b bVar) {
        com.travel.bus.a.a();
        String J = com.travel.bus.a.b().J();
        if (URLUtil.isValidUrl(J)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Payload.RESPONSE, i2);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("orderid", str);
                }
                jSONObject.put("category", str2);
                jSONObject.put("items", new JSONArray(arrayList));
                jSONObject.put("utm_source", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
            if (com.paytm.utility.b.c(context)) {
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context;
                bVar2.f42878b = a.c.BUS;
                bVar2.f42879c = a.C0715a.POST;
                bVar2.f42880d = J;
                bVar2.f42884h = jSONObject.toString();
                bVar2.f42881e = null;
                bVar2.f42882f = hashMap;
                bVar2.f42883g = null;
                bVar2.f42885i = new CJRBusNpsTrackingResponse();
                bVar2.j = bVar;
                bVar2.t = null;
                bVar2.n = a.b.SILENT;
                bVar2.o = "bus-order-summary-page";
                bVar2.l().a();
            }
        }
    }
}
