package net.one97.travelpass.ordersummary.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.travelpass.d;
import net.one97.travelpass.ordersummary.model.OrderSummary;
import org.json.JSONObject;

public final class a {
    public static void a(Context context, b bVar, String str) {
        com.paytm.network.b bVar2;
        k.c(context, "context");
        k.c(bVar, "paytmCommonApiListener");
        k.c(str, "orderId");
        k.a((Object) d.a(), "TravelPassController.getInstance()");
        String a2 = d.b().a("tpassOrderSummary");
        com.paytm.network.a aVar = null;
        if (TextUtils.isEmpty(a2) || context == null) {
            bVar2 = null;
        } else {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(AppConstants.SSO_TOKEN, com.paytm.utility.d.a(context));
            hashMap.putAll(hashMap2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orderId", str);
            bVar2 = new com.paytm.network.b().a(context).a(a.c.TRAVEL_PASS).a(a.C0715a.POST).a(Uri.parse(a2).buildUpon().build().toString()).a((Map<String, String>) hashMap).a(a.b.SILENT).c("travel_pass_home").b(jSONObject.toString()).a((IJRPaytmDataModel) new OrderSummary()).a(bVar);
        }
        if (bVar2 != null) {
            aVar = bVar2.l();
        }
        if (aVar != null) {
            aVar.b(true);
        }
        if (aVar != null) {
            aVar.a();
        }
    }
}
