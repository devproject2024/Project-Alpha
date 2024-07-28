package com.travel.flight.flightSRPV2.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.d;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.travel.flight.c;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.utils.j;
import com.travel.model.CalendarPriceModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24137a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(Context context, CJRFlightSearchInput cJRFlightSearchInput, String str, b bVar) {
            String str2;
            k.c(context, "context");
            k.c(cJRFlightSearchInput, "searchInput");
            k.c(bVar, "responseListener");
            boolean z = false;
            if (!com.paytm.utility.b.c(context)) {
                return false;
            }
            if (cJRFlightSearchInput.getBookingSegment() == com.travel.flight.flightticket.d.b.Modify) {
                k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                c b2 = com.travel.flight.b.b();
                k.a((Object) b2, "FlightController.getInstance().flightEventListener");
                Uri.Builder buildUpon = Uri.parse(b2.U()).buildUpon();
                buildUpon.appendQueryParameter("order_id", cJRFlightSearchInput.getModifyBookingOrderId());
                buildUpon.appendQueryParameter("departureDate", com.travel.flight.utils.c.g(cJRFlightSearchInput.getDate()));
                str2 = buildUpon.build().toString();
            } else {
                k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                c b3 = com.travel.flight.b.b();
                k.a((Object) b3, "FlightController.getInstance().flightEventListener");
                Uri.Builder buildUpon2 = Uri.parse(b3.s()).buildUpon();
                buildUpon2.appendQueryParameter("origin", cJRFlightSearchInput.getSourceCityCode());
                buildUpon2.appendQueryParameter("destination", cJRFlightSearchInput.getDestCityCode());
                buildUpon2.appendQueryParameter("departureDate", com.travel.flight.utils.c.g(cJRFlightSearchInput.getDate()));
                if (cJRFlightSearchInput.getReturnDate() != null) {
                    buildUpon2.appendQueryParameter("returnDate", com.travel.flight.utils.c.g(cJRFlightSearchInput.getReturnDate()));
                }
                if (cJRFlightSearchInput.getClassType() != null) {
                    buildUpon2.appendQueryParameter(Item.KEY_CLASS, cJRFlightSearchInput.getClassType());
                }
                buildUpon2.appendQueryParameter("adults", String.valueOf(cJRFlightSearchInput.getmCount_adults()));
                buildUpon2.appendQueryParameter("children", String.valueOf(cJRFlightSearchInput.getmCount_childerns()));
                buildUpon2.appendQueryParameter("infants", String.valueOf(cJRFlightSearchInput.getmCount_infants()));
                if (str != null) {
                    buildUpon2.appendQueryParameter("requestid", str);
                }
                buildUpon2.appendQueryParameter("enable", "{\"multiPrice\": true, \"handBaggageFare\": true,\"paxWiseConvFee\": true,\"minirules\": true}");
                str2 = com.paytm.utility.b.s(context, buildUpon2.build().toString());
            }
            HashMap hashMap = new HashMap();
            String a2 = d.a(context.getApplicationContext());
            CharSequence charSequence = a2;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (!z) {
                hashMap.put(AppConstants.SSO_TOKEN, a2);
            }
            com.paytm.network.a l = new com.paytm.network.b().a(context.getApplicationContext()).a(a.b.SILENT).c(context.getClass().getSimpleName()).a(a.c.FLIGHT).a(a.C0715a.GET).a(str2).h().a((Map<String, String>) hashMap).b((Map) null).b((String) null).a((IJRPaytmDataModel) new CJRFlightSearchResult()).a(bVar).a(a()).l();
            k.a((Object) l, "networking");
            l.a(true);
            l.a((Object) "NETWORK_TAG_FLIGHT_SRP_V2");
            l.a();
            return true;
        }

        public static JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FlightSearchScreen");
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public static boolean a(Context context, CJRFlightSearchInput cJRFlightSearchInput, String str, String str2, b bVar, boolean z) {
            String str3;
            k.c(context, "context");
            k.c(cJRFlightSearchInput, "searchInput");
            k.c(str, "openedFrom");
            k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            k.c(bVar, "responseListener");
            if (com.paytm.utility.b.c(context)) {
                try {
                    Map linkedHashMap = new LinkedHashMap();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    Date parse = simpleDateFormat.parse(cJRFlightSearchInput.getDate());
                    Calendar instance = Calendar.getInstance();
                    k.a((Object) instance, "calendar");
                    instance.setTime(parse);
                    instance.add(5, -15);
                    Date time = instance.getTime();
                    Date date = new Date();
                    if (time.compareTo(date) < 0) {
                        time = date;
                    }
                    instance.setTime(time);
                    instance.add(5, 70);
                    Date time2 = instance.getTime();
                    String sourceCityCode = cJRFlightSearchInput.getSourceCityCode();
                    k.a((Object) sourceCityCode, "searchInput.sourceCityCode");
                    linkedHashMap.put("source", sourceCityCode);
                    String destCityCode = cJRFlightSearchInput.getDestCityCode();
                    k.a((Object) destCityCode, "searchInput.destCityCode");
                    linkedHashMap.put("destination", destCityCode);
                    String format = simpleDateFormat.format(time);
                    k.a((Object) format, "dateFormat.format(startDate)");
                    linkedHashMap.put("start_date", format);
                    String format2 = simpleDateFormat.format(time2);
                    k.a((Object) format2, "dateFormat.format(endDate)");
                    linkedHashMap.put("end_date", format2);
                    linkedHashMap.put("opened_from", str);
                    String classType = cJRFlightSearchInput.getClassType();
                    k.a((Object) classType, "searchInput.classType");
                    linkedHashMap.put(Item.KEY_CLASS, classType);
                    linkedHashMap.put("adults", "1");
                    if (z) {
                        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                        c b2 = com.travel.flight.b.b();
                        k.a((Object) b2, "FlightController.getInstance().flightEventListener");
                        str3 = b2.j();
                    } else {
                        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
                        c b3 = com.travel.flight.b.b();
                        k.a((Object) b3, "FlightController.getInstance().flightEventListener");
                        str3 = b3.i();
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        HashMap hashMap = new HashMap();
                        com.paytm.utility.b.a((HashMap<String, String>) hashMap, context.getApplicationContext());
                        com.paytm.network.a l = new com.paytm.network.b().a(context).a(a.b.SILENT).c(str2).a(a.c.FLIGHT).a(a.C0715a.GET).a(str3).h().a((Map<String, String>) hashMap).b(linkedHashMap).b((String) null).a((IJRPaytmDataModel) new CalendarPriceModel()).a(bVar).a(a()).l();
                        k.a((Object) l, "networking");
                        l.a(true);
                        l.a((Object) "NETWORK_TAG_FLIGHT_SRP_V2");
                        l.a();
                        return true;
                    }
                } catch (Exception e2) {
                    m mVar = new m("fireFareCalendarAPI Exception", e2.toString(), cJRFlightSearchInput.getSourceCityCode(), cJRFlightSearchInput.getDestCityCode(), cJRFlightSearchInput.getDate(), "NA", "NA");
                    j.a aVar = j.f25593a;
                    j.a.a(mVar);
                }
            }
            return false;
        }
    }
}
