package net.one97.paytm.o2o.movies.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieUpvoteResponse;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailsV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.entity.EmptyModel;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            c.a();
            sb.append(c.a("orderdetail", (String) null));
            sb.append(str);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2, b bVar) {
        String str3;
        if (str == null || TextUtils.isEmpty(str)) {
            AJRMovieOrderSummary aJRMovieOrderSummary = (AJRMovieOrderSummary) context;
            AlertDialog.Builder builder = new AlertDialog.Builder(aJRMovieOrderSummary);
            builder.setTitle(aJRMovieOrderSummary.getResources().getString(R.string.error));
            builder.setMessage(aJRMovieOrderSummary.getResources().getString(R.string.msg_invalid_url)).setCancelable(false).setPositiveButton(aJRMovieOrderSummary.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRMovieOrderSummary.this.finish();
                }
            });
            builder.create().show();
        } else if (!TextUtils.isEmpty(x.a(context.getApplicationContext()).b("sso_token=", "", true))) {
            if (str.contains("?")) {
                String a2 = com.paytm.utility.c.a(context.getApplicationContext(), false);
                if (a2.contains("?")) {
                    a2 = a2.replace("?", AppConstants.AND_SIGN);
                }
                str3 = str + a2;
            } else {
                str3 = str + com.paytm.utility.c.a(context.getApplicationContext(), false);
            }
            String str4 = str3 + "&actions=1";
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                str4 = str4 + "&pg_screen=" + str2;
            }
            HashMap<String, String> a3 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), context);
            c cVar = new c();
            cVar.f42877a = context;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.GET;
            cVar.f42880d = str4;
            cVar.f42881e = null;
            cVar.f42882f = a3;
            cVar.f42883g = null;
            cVar.f42884h = null;
            cVar.f42885i = new CJROrderSummary();
            cVar.j = bVar;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = n.h("MovieOrderSummary");
            a l = cVar.l();
            l.f42859c = false;
            l.a();
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
            jSONObject2.put(str, str2);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        jSONObject.put(str, obj);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, String str, Object obj) throws JSONException {
        jSONObject.put(str, obj);
        jSONObject2.put(str, obj);
    }

    public static void a(Context context, CJRMoviesSession cJRMoviesSession, int i2, String str, CJRObjSeat cJRObjSeat, b bVar) {
        c.a();
        String a2 = c.a("moviesConvenienceFeeV2", (String) null);
        if (URLUtil.isValidUrl(a2)) {
            String d2 = com.paytm.utility.b.d(context, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            JSONObject jSONObject = new JSONObject();
            if (cJRMoviesSession != null) {
                try {
                    if (!TextUtils.isEmpty(cJRMoviesSession.getCinemaID())) {
                        jSONObject.put("cinemaId", cJRMoviesSession.getCinemaID());
                    }
                    if (!TextUtils.isEmpty(cJRMoviesSession.getProviderId())) {
                        jSONObject.put("providerId", cJRMoviesSession.getProviderId());
                    }
                    if (!TextUtils.isEmpty(cJRMoviesSession.getSessionID())) {
                        jSONObject.put(H5Param.SESSION_ID, cJRMoviesSession.getSessionID());
                    }
                } catch (JSONException unused) {
                }
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(SDKConstants.KEY_TRANS_ID, str);
            }
            if (cJRObjSeat != null) {
                if (!TextUtils.isEmpty(cJRObjSeat.getAreaCode())) {
                    jSONObject.put("areaCatCode", cJRObjSeat.getAreaCode());
                }
                if (!TextUtils.isEmpty(cJRObjSeat.getTypeCode())) {
                    jSONObject.put("ticketType", cJRObjSeat.getTypeCode());
                }
                jSONObject.put("noOfTickets", i2);
                jSONObject.put("ticketPrice", cJRObjSeat.getPrice() + cJRObjSeat.getVoucherPrice());
            }
            String jSONObject2 = jSONObject.toString();
            if (com.paytm.utility.b.c(context)) {
                c cVar = new c();
                cVar.f42877a = context.getApplicationContext();
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.POST;
                cVar.f42880d = d2;
                cVar.f42881e = null;
                cVar.f42882f = hashMap;
                cVar.f42883g = null;
                cVar.f42884h = jSONObject2;
                cVar.f42885i = new CJRConvenienceFee();
                cVar.j = bVar;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("FJRFoodAndbeverages");
                a l = cVar.l();
                l.f42859c = false;
                l.a();
            }
        }
    }

    public static String a(Context context, String str) {
        c.a();
        String a2 = c.a("movieMoviesURLV3", (String) null);
        try {
            if (!TextUtils.isEmpty(str)) {
                a2 = (a2 + "?city=" + URLEncoder.encode(str, AppConstants.UTF_8)) + "&groupResult=true";
            }
        } catch (UnsupportedEncodingException unused) {
        }
        if (!URLUtil.isValidUrl(a2)) {
            return "";
        }
        return com.paytm.utility.b.s(context, a2).replace("custId", "userId");
    }

    public static void a(Context context, String str, b bVar) {
        String str2;
        c.a();
        String a2 = c.a("moviesSearch_v2", (String) null);
        try {
            str2 = (a2 + "?filter=imax&") + "city=" + URLEncoder.encode(str, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            str2 = a2;
        }
        if (URLUtil.isValidUrl(str2)) {
            String b2 = com.paytm.utility.b.b(context, str2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            if (com.paytm.utility.b.c(context)) {
                c cVar = new c();
                cVar.f42877a = context.getApplicationContext();
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.GET;
                cVar.f42880d = b2;
                cVar.f42881e = null;
                cVar.f42882f = hashMap;
                cVar.f42883g = null;
                cVar.f42884h = null;
                cVar.f42885i = new CJRMovieDetailsV2();
                cVar.j = bVar;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("CJRMoviesApiUtils");
                a l = cVar.l();
                l.f42859c = false;
                l.a();
                return;
            }
            com.paytm.utility.b.b(context, "Network Error", "Check your network connectvity and try again.");
        }
    }

    public static String b(Context context, String str) {
        String str2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            c.a();
            sb.append(c.a("moviesSearch_v2", (String) null));
            sb.append("?city=");
            sb.append(URLEncoder.encode(str, AppConstants.UTF_8));
            sb.append("&filter=freemovie&groupResult=true");
            str2 = sb.toString();
        } catch (UnsupportedEncodingException e2) {
            j.class.getName();
            e2.getMessage();
        }
        if (!URLUtil.isValidUrl(str2)) {
            return "";
        }
        return com.paytm.utility.b.s(context, str2);
    }

    public static String a(Context context) {
        c.a();
        String a2 = c.a("freemoviesHomePageBanner_v2", (String) null);
        if (!URLUtil.isValidUrl(a2)) {
            return "";
        }
        return com.paytm.utility.b.s(context, a2);
    }

    public static String a(Context context, b bVar) {
        String b2 = d.b(context);
        c.a();
        String a2 = n.a("city", b2, c.d());
        if (!URLUtil.isValidUrl(a2)) {
            return "";
        }
        String s = com.paytm.utility.b.s(context, a2);
        if (com.paytm.utility.b.c(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ClientId", "paytm");
            c cVar = new c();
            cVar.f42877a = context.getApplicationContext();
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.GET;
            cVar.f42880d = s;
            cVar.f42881e = null;
            cVar.f42882f = hashMap;
            cVar.f42883g = null;
            cVar.f42884h = null;
            cVar.f42885i = new CJRUpcomingMovies();
            cVar.j = bVar;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = n.h("AJRUpcomingMoviesGridPage");
            a l = cVar.l();
            l.f42859c = false;
            l.a();
            return s;
        }
        j.class.getName();
        return "";
    }

    public static void a(Activity activity, String str, b bVar, String str2, String str3) {
        try {
            HashMap<String, String> n = com.paytm.utility.b.n();
            n.put("ClientId", "paytm");
            n.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, x.a(activity.getApplicationContext()).b("sso_token=", "", true));
            c.a();
            String a2 = c.a("URLMoviesLikeAndDislike", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                String s = com.paytm.utility.b.s(activity, a2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                if (com.paytm.utility.b.r((Context) activity)) {
                    jSONObject.put("custId", com.paytm.utility.b.n((Context) activity));
                }
                jSONObject.put("value", str3);
                jSONObject.put("metricType", str2);
                String jSONObject2 = jSONObject.toString();
                if (com.paytm.utility.b.c((Context) activity)) {
                    c cVar = new c();
                    cVar.f42877a = activity;
                    cVar.f42878b = a.c.MOVIES;
                    cVar.f42879c = a.C0715a.PUT;
                    cVar.f42880d = s;
                    cVar.f42881e = null;
                    cVar.f42882f = n;
                    cVar.f42883g = null;
                    cVar.f42884h = jSONObject2;
                    cVar.f42885i = new CJRMovieUpvoteResponse();
                    cVar.j = bVar;
                    cVar.n = a.b.USER_FACING;
                    cVar.o = "movies";
                    cVar.t = n.h("AJRUpcomingMoviesGridPage");
                    a l = cVar.l();
                    l.f42859c = false;
                    l.a();
                    return;
                }
                com.paytm.utility.b.b((Context) activity, activity.getResources().getString(R.string.no_connection), activity.getResources().getString(R.string.no_internet));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity, String str, b bVar, String str2) {
        try {
            HashMap<String, String> n = com.paytm.utility.b.n();
            n.put("ClientId", "paytm");
            n.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, x.a(activity.getApplicationContext()).b("sso_token=", "", true));
            c.a();
            String a2 = c.a("URLMoviesLikeAndDislikeDelete", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                if (com.paytm.utility.b.c((Context) activity)) {
                    c cVar = new c();
                    cVar.f42877a = activity;
                    cVar.f42878b = a.c.MOVIES;
                    cVar.f42879c = a.C0715a.DELETE;
                    cVar.f42880d = com.paytm.utility.b.s(activity, a2) + "&id=" + str + "&custId=" + com.paytm.utility.b.n((Context) activity) + "&metricType=" + str2;
                    cVar.f42881e = null;
                    cVar.f42882f = n;
                    cVar.f42883g = null;
                    cVar.f42885i = new EmptyModel();
                    cVar.j = bVar;
                    cVar.n = a.b.USER_FACING;
                    cVar.o = "movies";
                    cVar.t = n.h("AJRUpcomingMoviesGridPage");
                    a l = cVar.l();
                    l.f42859c = false;
                    l.a();
                    return;
                }
                com.paytm.utility.b.b((Context) activity, activity.getResources().getString(R.string.no_connection), activity.getResources().getString(R.string.no_internet));
            }
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str) {
        if (context != null) {
            c.a();
            String a2 = c.a("movies_seat_release", (String) null);
            if (URLUtil.isValidUrl(a2)) {
                String s = com.paytm.utility.b.s(context, a2 + "?order_id=" + str);
                HashMap hashMap = new HashMap();
                hashMap.put("ClientId", "paytm");
                c cVar = new c();
                cVar.f42877a = context;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.GET;
                cVar.f42880d = s;
                cVar.f42881e = null;
                cVar.f42882f = hashMap;
                cVar.f42883g = null;
                cVar.f42884h = null;
                cVar.f42885i = null;
                cVar.j = new b() {
                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    }

                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    }
                };
                cVar.n = a.b.SILENT;
                cVar.o = "movies";
                cVar.t = n.h("CJRbookingAPI");
                a l = cVar.l();
                l.f42859c = false;
                l.a();
            }
        }
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(com.paytm.utility.b.n(context))) {
            return null;
        }
        c.a();
        String a2 = c.a("URLUpcommingBookingV2", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://apiproxy.paytm.com/v2/movies/upcoming-bookings";
        }
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        return com.paytm.utility.b.s(context, a2);
    }

    public static void b(Context context, b bVar) {
        if (com.paytm.utility.b.c(context)) {
            String b2 = d.b(context);
            String n = com.paytm.utility.b.n(context);
            String a2 = a(context, b2);
            HashMap hashMap = new HashMap();
            hashMap.put("ClientId", "paytm");
            if (!v.a(n) && n.c(context)) {
                a2 = n.a("userId", n, a2);
            }
            String a3 = n.a("lang", com.paytm.utility.b.a(context) + "-IN", a2);
            c cVar = new c();
            cVar.f42877a = context;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.GET;
            cVar.f42880d = a3;
            cVar.f42882f = hashMap;
            cVar.f42885i = new CJRMovieHomeDataResponse();
            cVar.j = bVar;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = n.h("Upcoming Movies");
            a l = cVar.l();
            l.f42859c = false;
            l.a();
        }
    }
}
