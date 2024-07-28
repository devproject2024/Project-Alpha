package net.one97.paytm.hotel4.utils;

import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28643a = "https://d274ft55l0imju.cloudfront.net/hotels_app_img/";

    public static final String a() {
        return f28643a;
    }

    public static final String a(String str) {
        k.c(str, "item");
        String str2 = "breakfast";
        if (p.b(str, "Conference space", true) || p.b(str, "Conference Room", true)) {
            str2 = "conferenceroom";
        } else if (p.a(str, "bar", true)) {
            str2 = "bar";
        } else if (p.a(str, "restaurant", true)) {
            str2 = "restaurant";
        } else if (p.a(str, "swimmingPool", true)) {
            str2 = "swimmingpool";
        } else if (p.a(str, "parking", true)) {
            str2 = "parking";
        } else if (p.a(str, "airconditioning", true)) {
            str2 = "airconditioning";
        } else if (p.a(str, "roomService", true)) {
            str2 = "roomservice";
        } else if (p.a(str, "gym", true)) {
            str2 = "gym";
        } else if (p.a(str, "wifi", true)) {
            str2 = "wifi";
        } else if (!p.a(str, str2, true)) {
            str2 = p.a(str, "Dry Cleaning", true) ? "drycleaning" : p.a(str, "Elevator", true) ? "elevator" : p.a(str, "Laundry", true) ? "laundry" : p.a(str, "Salon", true) ? "salon" : p.a(str, "Turkish/Steam Bath", true) ? "turkishsteambath" : p.a(str, "Yoga Classes", true) ? "yoga" : p.a(str, "businessCentre", true) ? "businesscentre" : p.a(str, "twentyFourHrCheckIn", true) ? "247checkIn" : "defaultplaceholder";
        }
        return f28643a + str2 + ".png";
    }

    public static final String b(String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
        return f28643a + str + ".png";
    }

    public static final String c(String str) {
        k.c(str, "item");
        String str2 = "hotelsoldout";
        if (!p.a(str, str2, true)) {
            str2 = p.a(str, "lookingformorehotels", true) ? "lookingformorehotels" : p.a(str, "noroomsavailable", true) ? "noroomsavailable" : p.a(str, "searchemptyresult", true) ? "searchemptyresult" : p.a(str, "gps", true) ? "gps" : p.a(str, "circularsearch", true) ? "circularsearch" : (!p.a(str, "circularmap", true) && !p.a(str, "circularmap", true)) ? p.a(str, "backarrow", true) ? "backarrow" : p.a(str, "dealtag", true) ? "dealtag" : p.a(str, "hotelBlue", true) ? "hotel_blue" : "defaultplaceholder" : "circularmap";
        }
        return f28643a + str2 + ".png";
    }

    public static final String b() {
        return f28643a + "loader.json";
    }
}
