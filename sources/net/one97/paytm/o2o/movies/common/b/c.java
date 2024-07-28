package net.one97.paytm.o2o.movies.common.b;

import android.text.TextUtils;
import java.util.HashMap;
import net.one97.paytm.o2o.movies.common.c.b;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f75015b;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f75016a = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f75017c = new HashMap<>();

    private c() {
    }

    public static c a() {
        if (f75015b == null) {
            f75015b = new c();
        }
        return f75015b;
    }

    public static String a(String str, String str2) {
        return b.f75032a.f75033b.getStringFromGTM(str, str2);
    }

    public static String b() {
        String a2 = a("moviesQRImageV2", (String) null);
        return TextUtils.isEmpty(a2) ? "https://tickets.paytm.com/v2/movies/getqrimage" : a2;
    }

    public static String c() {
        String a2 = a("moviesVerifyUrl", (String) null);
        return TextUtils.isEmpty(a2) ? "https://apiproxy-moviesv2.paytm.com/v1/movies/expresscart/verify" : a2;
    }

    public static String d() {
        String a2 = a("upcomingMoviesUrlV2", (String) null);
        return TextUtils.isEmpty(a2) ? "https://apiproxy.paytm.com/v2/movies/upcoming" : a2;
    }

    public static String e() {
        String a2 = a("moviesPreclaim", (String) null);
        return TextUtils.isEmpty(a2) ? "https://apiproxy.paytm.com/v1/movies/preclaim" : a2;
    }

    public static String f() {
        String a2 = a("URLMoviesMetaInfo", (String) null);
        return TextUtils.isEmpty(a2) ? "https://apiproxy.paytm.com/v1/movies/content/get-movies-meta-info" : a2;
    }
}
