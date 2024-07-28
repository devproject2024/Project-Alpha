package com.travel.bus.busticket.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.pojo.busticket.BusRecentsData;
import com.travel.bus.pojo.busticket.CJRBusOriginCityItem;
import com.travel.bus.pojo.busticket.CJRBusRating;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final DateFormat f22466a = new SimpleDateFormat("H");

    /* renamed from: b  reason: collision with root package name */
    private static final DateFormat f22467b = new SimpleDateFormat("h a");

    public static boolean a(Context context, NetworkResponse networkResponse) {
        if (networkResponse == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(networkResponse.data)).getJSONObject("status").getJSONObject("message");
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("message");
            jSONObject.getString("button_text");
            jSONObject.getString("action");
            if (context != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(string).setMessage(string2).setCancelable(false);
                builder.setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
            return true;
        } catch (JSONException e2) {
            q.c(e2.getMessage());
            return false;
        }
    }

    public static void a(String str) {
        a.a();
        com.travel.bus.b.a.a(a.b().D()).a(str, false);
    }

    public static void a(Context context, String str, String str2, String str3) {
        a.a();
        a.b().a(context, str2, str3, str, "bus");
    }

    public static void a(final Context context, String str, String str2, String str3, final Intent intent, LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.pre_b_bus_custom_error_popup, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(R.id.custom_dialog_btn);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(inflate);
        ((RoboTextView) inflate.findViewById(R.id.custom_dialog_title)).setText(str);
        ((RoboTextView) inflate.findViewById(R.id.custom_dialog_message)).setText(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = context.getString(R.string.ok);
        }
        button.setText(str3);
        final AlertDialog create = builder.create();
        create.show();
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = intent;
                if (intent != null) {
                    context.startActivity(intent);
                }
                create.dismiss();
            }
        });
    }

    public static String a(CJRBusTicketFilterItem cJRBusTicketFilterItem) {
        String title = cJRBusTicketFilterItem.getTitle();
        if (title.equals("Opr") || title.equals("B.Pt") || title.equals("D.Pt")) {
            return cJRBusTicketFilterItem.getDisplayValue();
        }
        if (!title.equals("Deprture Time")) {
            return cJRBusTicketFilterItem.getTitle();
        }
        return a(cJRBusTicketFilterItem.getTimeMinValue(), cJRBusTicketFilterItem.getTimeMaxValue()).toUpperCase();
    }

    private static String a(String str, String str2) {
        try {
            String substring = str.substring(0, 2);
            String substring2 = str2.substring(0, 2);
            return f22467b.format(f22466a.parse(substring)) + " - " + f22467b.format(f22466a.parse(substring2));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, CJRBusOriginCityItem cJRBusOriginCityItem, boolean z, String str) {
        String str2;
        if (cJRBusOriginCityItem != null) {
            boolean z2 = true;
            cJRBusOriginCityItem.setItemType(1);
            if (z) {
                str2 = str + "RecentSearchOriginCity";
            } else {
                str2 = str + "RecentSearchDestinationCity";
            }
            com.paytm.b.a.a a2 = com.travel.bus.b.a.a(context.getApplicationContext());
            if (a2.b(str2, false)) {
                List list = (List) new f().a(a2.b(str2, "", false), new com.google.gson.b.a<List<CJRBusOriginCityItem>>() {
                }.getType());
                if (list != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < list.size()) {
                            if (list.get(i2) != null && ((CJRBusOriginCityItem) list.get(i2)).getShortCityName() != null && ((CJRBusOriginCityItem) list.get(i2)).getShortCityName().equals(cJRBusOriginCityItem.getShortCityName())) {
                                list.remove(i2);
                                list.add(cJRBusOriginCityItem);
                                break;
                            }
                            i2++;
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (!z2) {
                        if (list.size() == 3) {
                            list.remove(0);
                        }
                        list.add(cJRBusOriginCityItem);
                    }
                } else {
                    list = new ArrayList();
                    list.add(cJRBusOriginCityItem);
                }
                a2.a(str2, new f().a((Object) list), false);
            }
        }
    }

    public static void a(Context context, CJRBusOriginCityItem cJRBusOriginCityItem, CJRBusOriginCityItem cJRBusOriginCityItem2, String str, String str2) {
        boolean z;
        if (cJRBusOriginCityItem != null && cJRBusOriginCityItem2 != null && !TextUtils.isEmpty(str)) {
            List a2 = a(str2, context);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            BusRecentsData busRecentsData = new BusRecentsData();
            Date date = null;
            try {
                date = new SimpleDateFormat("dd MMMM yy", Locale.ENGLISH).parse(str);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            if (date != null) {
                busRecentsData.setDateValue(date.getTime());
            }
            busRecentsData.setSource(cJRBusOriginCityItem);
            busRecentsData.setDate(str);
            busRecentsData.setDestination(cJRBusOriginCityItem2);
            Iterator it2 = a2.iterator();
            while (true) {
                z = true;
                if (it2.hasNext()) {
                    BusRecentsData busRecentsData2 = (BusRecentsData) it2.next();
                    if (busRecentsData2 == null || busRecentsData2.getSource() == null || busRecentsData2.getDestination() == null || busRecentsData.getSource() == null || busRecentsData.getDestination() == null || TextUtils.isEmpty(busRecentsData2.getDate()) || TextUtils.isEmpty(busRecentsData2.getSource().getShortCityName()) || TextUtils.isEmpty(busRecentsData2.getDestination().getShortCityName()) || TextUtils.isEmpty(busRecentsData.getDate()) || TextUtils.isEmpty(busRecentsData.getSource().getShortCityName()) || TextUtils.isEmpty(busRecentsData.getDestination().getShortCityName()) || !busRecentsData2.getSource().getShortCityName().equalsIgnoreCase(busRecentsData.getSource().getShortCityName()) || !busRecentsData2.getDestination().getShortCityName().equalsIgnoreCase(busRecentsData.getDestination().getShortCityName())) {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                a2.add(busRecentsData);
                a((List<BusRecentsData>) a2, context, str2);
            }
        }
    }

    private static void a(List<BusRecentsData> list, Context context, String str) {
        if (list != null && list.size() != 0) {
            if (list.size() > 5) {
                int size = list.size() - 5;
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    BusRecentsData busRecentsData = list.get(i2);
                    if (a(busRecentsData.getSource()) && a(busRecentsData.getDestination())) {
                        arrayList.add(list.get(i2));
                    }
                }
                list.removeAll(arrayList);
            }
            String a2 = new f().a((Object) list);
            if (!TextUtils.isEmpty(a2)) {
                com.paytm.b.a.a a3 = com.travel.bus.b.a.a(context.getApplicationContext());
                a3.a(str + "recent-search-list", a2, false);
            }
        }
    }

    public static List<BusRecentsData> a(String str, Context context) {
        com.paytm.b.a.a a2 = com.travel.bus.b.a.a(context.getApplicationContext());
        String b2 = a2.b(str + "recent-search-list", "", false);
        AnonymousClass4 r3 = new com.google.gson.b.a<List<BusRecentsData>>() {
        };
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(b2)) {
            try {
                return (List) new f().a(b2, r3.getType());
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        return arrayList;
    }

    public static boolean a(CJRBusOriginCityItem cJRBusOriginCityItem) {
        if (cJRBusOriginCityItem != null) {
            String name = cJRBusOriginCityItem.getName();
            String displayCityName = cJRBusOriginCityItem.getDisplayCityName();
            String shortCityName = cJRBusOriginCityItem.getShortCityName();
            String cityName = cJRBusOriginCityItem.getCityName();
            String headingCityName = cJRBusOriginCityItem.getHeadingCityName();
            if (name == null || cityName == null || displayCityName == null || shortCityName == null || headingCityName == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static int a(ArrayList<CJRPassengerDetails> arrayList) {
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJRPassengerDetails> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRPassengerDetails next = it2.next();
                if (next != null && "female".equalsIgnoreCase(next.getGender())) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public static int b(ArrayList<TripBusDetailsItem> arrayList) {
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<TripBusDetailsItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TripBusDetailsItem next = it2.next();
                if (next != null && next.getAvailable() && next.getLadiesSeat().booleanValue()) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public static int c(ArrayList<TripBusDetailsItem> arrayList) {
        Iterator<TripBusDetailsItem> it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (it2.next().getAvailable()) {
                i2++;
            }
        }
        return i2;
    }

    public static int d(ArrayList<TripBusDetailsItem> arrayList) {
        Iterator<TripBusDetailsItem> it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            TripBusDetailsItem next = it2.next();
            if (next.getAvailable() && (next.getWidth() > 1 || next.getLength() > 1)) {
                i2++;
            }
        }
        return i2;
    }

    public static String a(List<String> list, String str) {
        if (list == null || list.size() <= 0) {
            return !TextUtils.isEmpty(str) ? str : "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static ArrayList<String> a(ArrayList<Integer> arrayList, HashMap<String, CJRBusSearchOperatorTagInfo> hashMap) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!(hashMap == null || arrayList == null || arrayList.size() <= 0)) {
            Iterator<Integer> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(hashMap.get(String.valueOf(it2.next().intValue())).getLabel());
            }
        }
        return arrayList2;
    }

    public static Map<String, Integer> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            hashMap.put("Height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("Width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static String b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return new SimpleDateFormat("EEE, d MMM HH:mm").format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    public static int a(TripBusDetailsItem tripBusDetailsItem, boolean z, String str) {
        if (tripBusDetailsItem.getAvailable()) {
            if (str != null && !str.equalsIgnoreCase("") && !z) {
                String fare = tripBusDetailsItem.getFare();
                if (!(tripBusDetailsItem.detailedFare == null || tripBusDetailsItem.detailedFare.getDeal() == null)) {
                    fare = String.valueOf(tripBusDetailsItem.detailedFare.getBaseFare());
                }
                if (fare == null || !fare.equalsIgnoreCase(str)) {
                    if (tripBusDetailsItem.getLadiesSeat().booleanValue()) {
                        if (tripBusDetailsItem.getLength() > 1) {
                            return R.drawable.bus_sleeper_seat_for_ladies;
                        }
                        if (tripBusDetailsItem.getWidth() > 1) {
                            return R.drawable.bus_seat_land_ladies;
                        }
                        return R.drawable.bus_ladies_available_port;
                    } else if (tripBusDetailsItem.getLength() > 1) {
                        return R.drawable.bus_seat_available_land;
                    } else {
                        if (tripBusDetailsItem.getWidth() > 1) {
                            return R.drawable.bus_greyed_sleeper_land;
                        }
                        return R.drawable.bus_greyedout_available;
                    }
                } else if (tripBusDetailsItem.getLadiesSeat().booleanValue()) {
                    if (tripBusDetailsItem.getLength() > 1) {
                        return R.drawable.bus_ladies_sleeper_port_highlited;
                    }
                    if (tripBusDetailsItem.getWidth() > 1) {
                        return R.drawable.bus_ladies_sleeper_highlited_landscape;
                    }
                    return R.drawable.bus_available_seat_ladies_highlited;
                } else if (tripBusDetailsItem.getLength() > 1) {
                    return R.drawable.bus_hihghlighted_seats_available_land;
                } else {
                    if (tripBusDetailsItem.getWidth() > 1) {
                        return R.drawable.bus_seat_land_highlited;
                    }
                    return R.drawable.bus_highlightedseats_available;
                }
            } else if (z) {
                if (tripBusDetailsItem.getLength() > 1) {
                    return R.drawable.bus_sleeper_selected;
                }
                if (tripBusDetailsItem.getWidth() > 1) {
                    return R.drawable.bus_seat_layout_selected_sleeper_seat_land;
                }
                return R.drawable.bus_selected_seat_port;
            } else if (tripBusDetailsItem.getLadiesSeat().booleanValue()) {
                if (tripBusDetailsItem.getLength() > 1) {
                    return R.drawable.bus_sleeper_seat_for_ladies;
                }
                if (tripBusDetailsItem.getWidth() > 1) {
                    return R.drawable.bus_seat_land_ladies;
                }
                return R.drawable.bus_ladies_available_port;
            } else if (tripBusDetailsItem.getLength() > 1) {
                return R.drawable.bus_seat_available_land;
            } else {
                if (tripBusDetailsItem.getWidth() > 1) {
                    return R.drawable.bus_greyed_sleeper_land;
                }
                return R.drawable.bus_greyedout_available;
            }
        } else if (tripBusDetailsItem.isBlockedForSocialDistancing()) {
            if (tripBusDetailsItem.getLength() > 1) {
                return R.drawable.ic_bus_covid_v_sleeper_icon;
            }
            if (tripBusDetailsItem.getWidth() > 1) {
                return R.drawable.ic_bus_covid_hori_sleeper_icon;
            }
            return R.drawable.ic_bus_covid_seat_icon;
        } else if (tripBusDetailsItem.getLadiesSeat().booleanValue()) {
            if (tripBusDetailsItem.getLength() > 1) {
                return R.drawable.bus_sleeper_booked_ladies;
            }
            if (tripBusDetailsItem.getWidth() > 1) {
                return R.drawable.bus_seat_layout_ladies_booked_sleeper_seat_land;
            }
            return R.drawable.bus_seat_ladies_booked;
        } else if (tripBusDetailsItem.getLength() > 1) {
            return R.drawable.bus_sleeper_seat_occupied;
        } else {
            if (tripBusDetailsItem.getWidth() > 1) {
                return R.drawable.bus_seat_layout_booked_sleeper_seat_land;
            }
            return R.drawable.bus_booked_port;
        }
    }

    public static String a() {
        a.a();
        return a.b().f("busRecentsSearchContainer");
    }

    public static Date c(String str) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse(str);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static boolean a(Date date, Date date2) {
        long time = date2.getTime() - date.getTime();
        long j = time / 86400000;
        long j2 = time % 86400000;
        boolean z = j > 0;
        long j3 = j2 / 3600000;
        long j4 = j2 % 3600000;
        if (j3 > 0) {
            z = true;
        }
        if (j4 / 60000 > 0) {
            return true;
        }
        return z;
    }

    public static void a(Context context, int i2, String str, String str2) {
        a.a();
        String f2 = a.b().f("busRatingSubmitNew");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rating", i2);
            jSONObject.put("secret", str);
            jSONObject.put("channel", str2);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        new HashMap().put("Content-Type", "application/json");
        if (b.c(context)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = context;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = f2;
            bVar.f42884h = jSONObject.toString();
            bVar.f42881e = null;
            bVar.f42882f = null;
            bVar.f42883g = null;
            bVar.f42885i = new CJRBusRating();
            bVar.j = new com.paytm.network.listener.b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                }
            };
            bVar.t = b();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-rating-page";
            bVar.l().a();
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusRatingScreen");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public static String d(String str) {
        StringBuilder sb;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("?")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "&native_withdraw=1";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "?native_withdraw=1";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static boolean b(Context context) {
        com.travel.bus.a.a();
        String d2 = com.travel.bus.a.b().d(context);
        return !TextUtils.isEmpty(d2) && e.b.RESELLER.name().equalsIgnoreCase(d2.toUpperCase());
    }

    public static void a(Activity activity) {
        if (activity != null) {
            n.b(activity.getApplicationContext(), n.a(activity.getApplicationContext(), n.a()));
            Intent intent = new Intent();
            intent.setClassName(activity.getApplicationContext().getPackageName(), "net.one97.paytm.landingpage.activity.AJRMainActivity");
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "featured");
            intent.putExtra("resultant fragment position", 0);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            activity.startActivity(intent);
            activity.finish();
        }
    }
}
