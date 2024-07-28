package net.one97.paytm.v2.features.cashbacklanding.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.TotalCashbackResponseModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.v2.features.cashbacklanding.b.a;
import net.one97.paytm.v2.features.cashbacklanding.model.ScratchCardPromo;
import net.one97.paytm.vipcashback.f.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f20147a;

    public b(a aVar) {
        k.c(aVar, "dataSource");
        this.f20147a = aVar;
    }

    public static void a(y<h<Object>> yVar, Context context) {
        k.c(yVar, "liveData");
        k.c(yVar, "result");
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String G = f.G();
        if (!TextUtils.isEmpty(G)) {
            d.a aVar = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(G);
            d.a aVar2 = d.f20859a;
            a l = a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new ScratchCardPromo()).c("CashbackLanding").a((com.paytm.network.listener.b) new a.C0360a(yVar)).l();
            if (com.paytm.utility.b.c(context)) {
                l.a();
                yVar.setValue(h.a());
                return;
            }
            yVar.setValue(h.b(l));
        }
    }

    public static void b(y<h<Object>> yVar, Context context) {
        k.c(yVar, "liveData");
        k.c(yVar, "result");
        a.C0397a aVar = net.one97.paytm.vipcashback.f.a.f20855a;
        com.paytm.network.listener.b bVar = new a.b(yVar);
        k.c(bVar, "apiListener");
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String x = f.x();
        CharSequence charSequence = x;
        com.paytm.network.a aVar2 = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            d.a aVar3 = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.POST).a(x);
            HashMap<String, String> appCommonHeaders = net.one97.paytm.vipcashback.c.a.b().getAppCommonHeaders();
            if (appCommonHeaders == null) {
                appCommonHeaders = new HashMap<>();
            }
            appCommonHeaders.put("Content-Type", "application/json");
            appCommonHeaders.put("Accept", "application/json");
            net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
            k.a((Object) b2, "CashbackHelper.getImplListener()");
            appCommonHeaders.put("ssotoken", b2.getSSOToken());
            appCommonHeaders.put("mktplace-apikey", "7S4h-4jl4-115D");
            appCommonHeaders.put("x-client-id", "APP_CLIENT");
            appCommonHeaders.put("api_role", "detailed");
            com.paytm.network.b a3 = a2.a((Map<String, String>) appCommonHeaders).a((IJRPaytmDataModel) new TotalCashbackResponseModel((List) null, 1, (g) null));
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            jSONObject2.put("from", f.t());
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            jSONObject2.put("to", f.u());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("SUM");
            jSONObject2.put("metrics", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put("TXN_TYPE");
            jSONObject2.put("filters", jSONArray2);
            jSONObject2.put(SDKConstants.TXN_TYPE, "CASHBACK");
            jSONObject2.put("visualization", "COUNT");
            jSONObject.put("request", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            k.a((Object) jSONObject3, "requestObject.toString()");
            aVar2 = a3.b(jSONObject3).c("myvoucherdetails").a(bVar).l();
        }
        if (com.paytm.utility.b.c(context) && aVar2 != null) {
            aVar2.a();
        }
    }
}
