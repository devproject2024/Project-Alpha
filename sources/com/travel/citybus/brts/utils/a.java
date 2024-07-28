package com.travel.citybus.brts.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.listener.b;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.citybus.brts.f;
import com.travel.citybus.brts.model.CJRBCLLWithdraw;
import com.travel.citybus.brts.model.CJRBrtsFareInfo;
import com.travel.citybus.brts.model.CJRBrtsPaxInfo;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f23388a = "https://travel.paytm.com/citytransport/citybus/v2";

    /* renamed from: b  reason: collision with root package name */
    public static String f23389b = "http://citybus-staging.paytmdgt.io/citybus/v2";

    /* renamed from: c  reason: collision with root package name */
    public static String f23390c = f23388a;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f23391d = 10;

    /* renamed from: e  reason: collision with root package name */
    public static String f23392e = "BCLL";

    /* renamed from: f  reason: collision with root package name */
    public static String f23393f = "BMTC";

    /* renamed from: g  reason: collision with root package name */
    public static String f23394g = "RMTS";

    /* renamed from: h  reason: collision with root package name */
    public static String f23395h = "BRTS Ahmedabad";

    /* renamed from: i  reason: collision with root package name */
    public static String f23396i = "Rajkot";

    public static void a(Context context, String str, CJRBrtsFareInfo cJRBrtsFareInfo, String str2, String str3, b bVar) {
        String str4;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("wallet_token", str);
        hashMap.put("request_id", cJRBrtsFareInfo.getRequestId());
        com.paytm.utility.b.a((HashMap<String, String>) hashMap, context);
        f.d();
        String a2 = f.d().a("cityBusBaseUrlV2");
        if (TextUtils.isEmpty(a2)) {
            a2 = f23390c;
        }
        f.d();
        if (TextUtils.isEmpty(f.d().c())) {
            str4 = a2 + "/getPayment";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            f.d();
            sb.append(f.d().c());
            str4 = sb.toString();
        }
        String a3 = a(cJRBrtsFareInfo, str2, str3);
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, str4 + c.a(context, false), hashMap2, hashMap, a3, new CJRBCLLWithdraw(), bVar);
    }

    private static String a(CJRBrtsFareInfo cJRBrtsFareInfo, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("total_amount", Double.parseDouble(str));
            jSONObject2.put("currencyCode", "INR");
            jSONObject2.put("merchant_id", cJRBrtsFareInfo.getResponse().getMerchantGuid());
            jSONObject2.put("merchant_logo", str2);
            jSONObject2.put(CJRQRScanResultModel.KEY_INDUSTRY_TYPE, cJRBrtsFareInfo.getResponse().getIndustryType());
            jSONObject2.put("source_id", Integer.parseInt(cJRBrtsFareInfo.getResponse().getSourceId()));
            jSONObject2.put("source_name", cJRBrtsFareInfo.getResponse().getSourceName());
            jSONObject2.put("destination_id", Integer.parseInt(cJRBrtsFareInfo.getResponse().getDestinationId()));
            jSONObject2.put("destination_name", cJRBrtsFareInfo.getResponse().getDestinationName());
            jSONObject2.put("bus_type", cJRBrtsFareInfo.getResponse().getBusType());
            jSONObject2.put("route_id", Integer.parseInt(cJRBrtsFareInfo.getResponse().getRouteId()));
            jSONObject2.put(CLPConstants.PRODUCT_ID, cJRBrtsFareInfo.getResponse().getProductId());
            jSONObject2.put("route_name", cJRBrtsFareInfo.getResponse().getRouteName());
            jSONObject2.put("brand_type_id", cJRBrtsFareInfo.getResponse().getBrandId());
            jSONObject2.put("vehicle_no", cJRBrtsFareInfo.getResponse().getVehicleNumber());
            jSONObject2.put("city", cJRBrtsFareInfo.getResponse().getCity());
            jSONObject2.put("is_fast_forward", 0);
            JSONArray jSONArray = new JSONArray();
            Iterator<CJRBrtsPaxInfo> it2 = cJRBrtsFareInfo.getResponse().getPaxInfo().iterator();
            while (it2.hasNext()) {
                CJRBrtsPaxInfo next = it2.next();
                if (next.getCount() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pax_type", next.getPaxName());
                    jSONObject3.put("count", next.getCount());
                    jSONObject3.put("value", next.getFare());
                    jSONArray.put(jSONObject3);
                }
            }
            jSONObject2.put("pax_info", jSONArray);
            jSONObject.put("request", jSONObject2);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject2.toString();
        } catch (Throwable unused) {
            return jSONObject2.toString();
        }
    }

    public static String a() {
        return new SimpleDateFormat("EEE,dd MMM").format(new Date());
    }

    public static String a(Double d2) {
        return new DecimalFormat("###.#").format(d2);
    }

    public static boolean a(CJRCityAutoSuggest cJRCityAutoSuggest) {
        if (cJRCityAutoSuggest != null) {
            String name = cJRCityAutoSuggest.getName();
            String id = cJRCityAutoSuggest.getId();
            String stationId = cJRCityAutoSuggest.getStationId();
            if (name == null || id == null || stationId == null) {
                return false;
            }
            return true;
        }
        return false;
    }
}
