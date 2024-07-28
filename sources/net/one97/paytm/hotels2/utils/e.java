package net.one97.paytm.hotels2.utils;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f29993a;

    private e() {
    }

    public static e a() {
        if (f29993a == null) {
            f29993a = new e();
        }
        return f29993a;
    }

    public static String a(String str) {
        return a(str, (String) null);
    }

    public static String a(String str, String str2) {
        String a2 = c.b().a(str);
        return TextUtils.isEmpty(a2) ? str2 : a2;
    }

    public static String b() {
        return a("hotelConfiguration", c.b().b().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://hotels-staging.paytm.com/hotels/v2/configuration" : "https://hotels.paytm.com/hotels/v2/configuration");
    }

    public static String c() {
        return a("Hotel_SRP_API_V3", (String) null);
    }

    public static int d() {
        return c.b().b("hotel_max_room_count").intValue();
    }

    public static String e() {
        return a("BOOKING_PRODUCT_ID", (String) null);
    }

    public static String f() {
        return a("HOTEL_ORDER_STATUS_API", (String) null);
    }

    public static String g() {
        return a("hotel_booking_status_list", (String) null);
    }

    public static String h() {
        return a("orderdetail_wrapper", (String) null);
    }

    public static String i() {
        return a("uberClientId", (String) null);
    }

    public static String j() {
        return a("travelHotelsGetHelpineCallingNumberBooking", (String) null);
    }

    public static String k() {
        return a("travelHotelsGetHelpineCallingNumber", (String) null);
    }

    public static String l() {
        return a("Hotel_TrendingSearch_API_V2", (String) null);
    }

    public static String m() {
        return a("Hotel_AutoSuggest_API_V4", (String) null);
    }

    public static String n() {
        return a("KEY_HOTEL_PROMO_CODE_URL_V2", c.b().b().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://hotels-staging.paytm.com/hotels/v2/promocode/check/" : "https://hotels.paytm.com/hotels/v2/promocode/check/");
    }

    public static String o() {
        return a("HTCancellationPolicy", c.b().b().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://hotels-staging.paytm.com/hotels/v2/get-cancellation-policy/" : "https://hotels.paytm.com/hotels/v2/get-cancellation-policy/");
    }

    public static String p() {
        return a("KEY_HOTEL_PROVISIONAL_BOOK_URL_V2", (String) null);
    }

    public static String q() {
        return a("HTReviewBookingEvent", (String) null);
    }

    public static String r() {
        return a("KEY_HOTEL_DETAILS_URL_V2", c.b().b().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://hotels-staging.paytm.com/hotels/v2/details/" : "https://hotels.paytm.com/hotels/v2/details/");
    }

    public static String s() {
        return a("PROMOCODE_SEARCH_PRODUCT", (String) null);
    }
}
