package net.one97.paytm.o2o.amusementpark.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.utility.c;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f73647a;

    /* renamed from: b  reason: collision with root package name */
    private com.paytm.network.listener.b f73648b;

    public b(Context context, com.paytm.network.listener.b bVar) {
        this.f73647a = context;
        this.f73648b = bVar;
    }

    public final void a(String str, JSONObject jSONObject, String str2) {
        if (a.a() == null || TextUtils.isEmpty(a.a().getStringFromGTM("amparks_list_url"))) {
            Context context = this.f73647a;
            com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), this.f73647a.getResources().getString(R.string.some_went_wrong));
            return;
        }
        String u = com.paytm.utility.b.u(this.f73647a, a(a.a().getStringFromGTM("amparks_list_url").trim() + str.replace(" ", "%20")));
        if (!TextUtils.isEmpty(str2) && "price".equalsIgnoreCase(str2)) {
            u = u + "&priceSort=1";
        } else if (!TextUtils.isEmpty(str2)) {
            "distance".equalsIgnoreCase(str2);
        }
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f73647a;
        bVar.f42878b = a.c.AM_PARK;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = u;
        bVar.f42881e = null;
        bVar.f42882f = null;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJRAmParkModel();
        bVar.n = a.b.USER_FACING;
        bVar.j = this.f73648b;
        bVar.o = "AmPark";
        bVar.t = jSONObject;
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    public final void a(JSONObject jSONObject) {
        if (net.one97.paytm.o2o.amusementpark.a.a() == null || TextUtils.isEmpty(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_cities_url"))) {
            Context context = this.f73647a;
            com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), this.f73647a.getResources().getString(R.string.some_went_wrong));
            return;
        }
        String u = com.paytm.utility.b.u(this.f73647a, a(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_cities_url")));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f73647a;
        bVar.f42878b = a.c.AM_PARK;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = u;
        bVar.f42881e = null;
        bVar.f42882f = null;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.n = a.b.USER_FACING;
        bVar.f42885i = new CJRSelectCitiesModel();
        bVar.j = this.f73648b;
        bVar.o = "AmPark";
        bVar.t = jSONObject;
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    public final void a(CJRSelectCityModel cJRSelectCityModel, JSONObject jSONObject) {
        if (net.one97.paytm.o2o.amusementpark.a.a() == null || TextUtils.isEmpty(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_home_banner_v2"))) {
            Context context = this.f73647a;
            com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), this.f73647a.getResources().getString(R.string.some_went_wrong));
            return;
        }
        String stringFromGTM = net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_home_banner_v2");
        String createRequestBodyForV2 = net.one97.paytm.o2o.amusementpark.a.a().createRequestBodyForV2(this.f73647a, "paytm-home", "amusement page", cJRSelectCityModel);
        HashMap<String, String> n = com.paytm.utility.b.n();
        n.put("ClientId", "paytm");
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f73647a;
        bVar.f42878b = a.c.AM_PARK;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = stringFromGTM;
        bVar.f42881e = null;
        bVar.f42882f = n;
        bVar.f42883g = null;
        bVar.f42884h = createRequestBodyForV2;
        bVar.f42885i = new CJRHomePageV2();
        bVar.n = a.b.USER_FACING;
        bVar.j = this.f73648b;
        bVar.o = "AmPark";
        bVar.t = jSONObject;
        com.paytm.network.a l = bVar.l();
        l.f42859c = false;
        l.a();
    }

    private String a(String str) {
        return c.b(str, this.f73647a);
    }
}
