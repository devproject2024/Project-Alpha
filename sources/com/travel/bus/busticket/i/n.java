package com.travel.bus.busticket.i;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.utility.q;
import com.travel.bus.pojo.busticket.CJRBusUserProfile;
import com.travel.bus.pojo.common.entity.travel.CJRBusTpUserProfileContact;
import com.travel.bus.pojo.common.entity.travel.a;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static String f22463b = "CJRBusTpTravellersProfileSingleton";

    /* renamed from: c  reason: collision with root package name */
    private static n f22464c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRBusTpUserProfileContact> f22465a;

    public static n a() {
        if (f22464c == null) {
            f22464c = new n();
        }
        return f22464c;
    }

    private n() {
    }

    public final void a(ArrayList<CJRBusTpUserProfileContact> arrayList) {
        this.f22465a = new ArrayList<>();
        this.f22465a = arrayList;
    }

    public static void a(Context context, a aVar, b bVar) {
        String str;
        if (context != null && !o.b(context)) {
            com.travel.bus.a.a();
            String z = com.travel.bus.a.b().z();
            if (aVar == a.all) {
                str = z + "?vertical=";
            } else {
                str = z + "?vertical=" + aVar;
            }
            String s = com.paytm.utility.b.s(context, str);
            HashMap hashMap = new HashMap();
            com.travel.bus.a.a();
            hashMap.put("sso-token", com.travel.bus.a.b().b(context));
            if (URLUtil.isValidUrl(s)) {
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context;
                bVar2.f42878b = a.c.BUS;
                bVar2.f42879c = a.C0715a.GET;
                bVar2.f42880d = s;
                bVar2.f42881e = null;
                bVar2.f42882f = hashMap;
                bVar2.f42883g = null;
                bVar2.f42884h = null;
                bVar2.f42885i = new CJRBusUserProfile();
                bVar2.j = bVar;
                bVar2.t = b();
                bVar2.n = a.b.SILENT;
                bVar2.o = "bus-traveller-page";
                com.paytm.network.a l = bVar2.l();
                l.f42860d = true;
                l.a();
            }
        }
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusTravellersScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }
}
