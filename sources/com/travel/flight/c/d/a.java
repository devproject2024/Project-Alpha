package com.travel.flight.c.d;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class a {
    public static String a(ArrayList<CJRFlightStops> arrayList, Context context) {
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        if (arrayList == null || arrayList.size() > 3) {
            return arrayList.size() + " " + context.getString(R.string.flight_stops);
        }
        String str = "";
        for (int i2 = 1; i2 <= arrayList.size() - 1; i2++) {
            str = str + arrayList.get(i2).getmOrigin();
            if (i2 != arrayList.size() - 1) {
                str = str + AppConstants.COMMA;
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3) {
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException unused) {
        }
        return new SimpleDateFormat(str3, Locale.ENGLISH).format(date);
    }

    public static String a(boolean z, String str, String str2) {
        String str3;
        String str4;
        String str5 = "dd MMM yy, EEE";
        if (z) {
            if (str == null || str2 == null) {
                str4 = "";
                str3 = str4;
            } else {
                if (b.c(str, "yyyy-MM-dd")) {
                    str5 = "yyyy-MM-dd";
                }
                str4 = b.d(str, str5, "dd MMM");
                str3 = b.d(str2, str5, "dd MMM");
            }
            if (str4 == null || str3 == null) {
                return "";
            }
            String[] split = str4.split(" ");
            if (split == null || split.length <= 1 || !str3.contains(split[1])) {
                return str4 + " - " + str3;
            }
            return split[0] + " - " + str3;
        } else if (str == null) {
            return "";
        } else {
            if (b.c(str, "yyyy-MM-dd")) {
                str5 = "yyyy-MM-dd";
            }
            return b.d(str, str5, "dd MMM");
        }
    }

    public static String a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        if (cJRFlightDetailsItem == null || cJRFlightDetailsItem.getmFlights() == null || cJRFlightDetailsItem.getmFlights().size() <= 1) {
            return "";
        }
        String str = cJRFlightDetailsItem.getmFlights().get(1).getmLayover();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format("%s at %s", new Object[]{str, cJRFlightDetailsItem.getmFlights().get(0).getmDestination()});
    }

    public static Map<String, String> a(URL url) throws UnsupportedEncodingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : url.getQuery().split(AppConstants.AND_SIGN)) {
            int indexOf = str.indexOf("=");
            linkedHashMap.put(URLDecoder.decode(str.substring(0, indexOf), AppConstants.UTF_8), URLDecoder.decode(str.substring(indexOf + 1), AppConstants.UTF_8));
        }
        return linkedHashMap;
    }
}
