package com.travel.flight.flightticket.e;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.a;
import com.travel.flight.utils.c;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static void a(Context context, IJRPaytmDataModel iJRPaytmDataModel, com.paytm.network.listener.b bVar) {
        if (context != null) {
            com.travel.flight.b.a();
            String B = com.travel.flight.b.b().B();
            if (URLUtil.isValidUrl(B)) {
                Uri.Builder buildUpon = Uri.parse(B).buildUpon();
                buildUpon.appendQueryParameter("vertical", "flights");
                String uri = buildUpon.build().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("sso-token", a.q(context));
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context;
                bVar2.n = a.b.SILENT;
                bVar2.o = context.getClass().getSimpleName();
                bVar2.f42878b = a.c.FLIGHT;
                bVar2.f42879c = a.C0715a.GET;
                bVar2.f42880d = uri;
                bVar2.f42881e = null;
                bVar2.f42882f = hashMap;
                bVar2.f42883g = null;
                bVar2.f42884h = null;
                bVar2.f42885i = iJRPaytmDataModel;
                bVar2.j = bVar;
                bVar2.t = null;
                com.paytm.network.a l = bVar2.l();
                l.f42860d = true;
                l.a();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, IJRPaytmDataModel iJRPaytmDataModel, com.paytm.network.listener.b bVar) {
        com.travel.flight.b.a();
        String C = com.travel.flight.b.b().C();
        HashMap hashMap = new HashMap();
        hashMap.put("travel_class", "E");
        hashMap.put("destination", str3);
        hashMap.put("onward_date", str);
        hashMap.put("source", str2);
        hashMap.put("adults", "1");
        hashMap.put("children", "0");
        hashMap.put("infants", "0");
        String a2 = new f().a((Object) hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap2.put("sso-token", com.paytm.utility.a.q(context));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("metadata", a2);
        String a3 = c.a((HashMap<String, String>) hashMap3);
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context.getApplicationContext();
        bVar2.n = a.b.SILENT;
        bVar2.o = context.getClass().getSimpleName();
        bVar2.f42878b = a.c.FLIGHT;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = C;
        bVar2.f42881e = null;
        bVar2.f42882f = hashMap2;
        bVar2.f42883g = null;
        bVar2.f42884h = a3;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.j = bVar;
        bVar2.t = a();
        com.paytm.network.a l = bVar2.l();
        l.f42860d = true;
        l.a();
    }

    public static void b(Context context, String str, String str2, String str3, IJRPaytmDataModel iJRPaytmDataModel, com.paytm.network.listener.b bVar) {
        com.travel.flight.b.a();
        String D = com.travel.flight.b.b().D();
        HashMap hashMap = new HashMap();
        hashMap.put("travel_class", "E");
        hashMap.put("destination", str2);
        hashMap.put("onward_date", str3);
        hashMap.put("source", str);
        String a2 = new f().a((Object) hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap2.put("sso-token", com.paytm.utility.a.q(context));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("metadata", a2);
        String a3 = c.a((HashMap<String, String>) hashMap3);
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context.getApplicationContext();
        bVar2.n = a.b.SILENT;
        bVar2.o = context.getClass().getSimpleName();
        bVar2.f42878b = a.c.FLIGHT;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = D;
        bVar2.f42881e = null;
        bVar2.f42882f = hashMap2;
        bVar2.f42883g = null;
        bVar2.f42884h = a3;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.j = bVar;
        bVar2.t = a();
        com.paytm.network.a l = bVar2.l();
        l.f42860d = true;
        l.a();
    }

    public static void a(Context context, String str, String str2, String str3, String str4, IJRPaytmDataModel iJRPaytmDataModel, com.paytm.network.listener.b bVar) {
        if (context != null) {
            com.travel.flight.b.a();
            String F = com.travel.flight.b.b().F();
            if (URLUtil.isValidUrl(F)) {
                Uri.Builder buildUpon = Uri.parse(F).buildUpon();
                buildUpon.appendQueryParameter("vertical", "flights");
                buildUpon.appendQueryParameter("source", str);
                buildUpon.appendQueryParameter("destination", str2);
                buildUpon.appendQueryParameter("fare_class", str3);
                buildUpon.appendQueryParameter("doj", str4);
                String uri = buildUpon.build().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("sso-token", com.paytm.utility.a.q(context));
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context.getApplicationContext();
                bVar2.n = a.b.SILENT;
                bVar2.o = context.getClass().getSimpleName();
                bVar2.f42878b = a.c.FLIGHT;
                bVar2.f42879c = a.C0715a.GET;
                bVar2.f42880d = uri;
                bVar2.f42881e = null;
                bVar2.f42882f = hashMap;
                bVar2.f42883g = null;
                bVar2.f42884h = null;
                bVar2.f42885i = iJRPaytmDataModel;
                bVar2.j = bVar;
                bVar2.t = a();
                com.paytm.network.a l = bVar2.l();
                l.f42860d = true;
                l.a((Object) "NETWORK_TAG_FLIGHT_SRP_V2");
                l.a();
            }
        }
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FlightFareAlertScreen");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
