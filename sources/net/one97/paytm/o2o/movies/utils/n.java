package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.gson.f;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMPMataDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCardWidgetModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.o2o.movies.entity.CJRCitiesResponse;
import net.one97.paytm.o2o.movies.entity.CJRCityInfo;
import net.one97.paytm.o2o.movies.entity.SentimentInterestedItem;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<CJRSelectCityModel> f75964a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<CJRSelectCityModel> f75965b;

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<CJRSelectCityModel> f75966c;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<CJRSelectCityModel> f75967d;

    /* renamed from: e  reason: collision with root package name */
    private static Context f75968e = b.f75032a.f75033b.getAppContext();

    /* renamed from: f  reason: collision with root package name */
    private static ArrayList<CJRSelectCityModel> f75969f;

    /* renamed from: g  reason: collision with root package name */
    private static f f75970g = new f();

    /* renamed from: h  reason: collision with root package name */
    private static final DecimalFormat f75971h = new DecimalFormat("0.00");

    /* renamed from: i  reason: collision with root package name */
    private static final DecimalFormat f75972i = new DecimalFormat("#.##");

    private static double b(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public static String b(int i2, int i3) {
        if (i3 == 0) {
            return "Not Available";
        }
        float f2 = ((float) (i2 * 100)) / ((float) i3);
        return f2 == 0.0f ? "Not Available" : f2 < 10.0f ? "Almost filled" : (f2 < 10.0f || f2 >= 50.0f) ? "Available" : "Filling fast";
    }

    public static boolean a(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String a(Double d2) {
        if (d2 == null) {
            return null;
        }
        try {
            return f75968e.getResources().getString(R.string.rupee_symbol) + f75971h.format(d2);
        } catch (Resources.NotFoundException unused) {
            return FilterPriceSliderFragment.RUPEE_SYMBOL + f75971h.format(d2);
        }
    }

    public static String b(Double d2) {
        if (d2 == null) {
            return null;
        }
        try {
            return f75968e.getResources().getString(R.string.rupee_symbol) + f75972i.format(d2);
        } catch (Resources.NotFoundException unused) {
            return FilterPriceSliderFragment.RUPEE_SYMBOL + f75972i.format(d2);
        }
    }

    public static void a(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (v.a(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str.trim());
    }

    public static void b(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(textView, str.toUpperCase());
        }
    }

    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Image, Filmography, Videos, Information credit- IMDb, Youtube.");
        arrayList.add("This page may contain some hyperlinks which lead out of this site. Information contained in any site linked from this site has not been reviewed for accuracy or legal sufficiency. One97 Communications Limited is not responsible for the content of any such external hyperlinks and references to any external links should not be construed as an endorsement of the links or their content.");
        return arrayList;
    }

    public static boolean a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(b(str2, "yyyy-MM-dd'T'HH:mm:ss"));
            return parse.after(parse2) && !parse.equals(parse2);
        } catch (ParseException unused) {
            return false;
        }
    }

    public static int a(Context context) {
        return b(context) / 16;
    }

    public static CJRMPMataDataModel a(CJROrderedCart cJROrderedCart) {
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        f fVar = new f();
        return (CJRMPMataDataModel) fVar.a(fVar.b(metaDataResponse), CJRMPMataDataModel.class);
    }

    public static String b() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
    }

    public static CJROrderSummaryMetadataResponseV2 b(CJROrderedCart cJROrderedCart) {
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        f fVar = new f();
        return (CJROrderSummaryMetadataResponseV2) fVar.a(fVar.b(metaDataResponse), CJROrderSummaryMetadataResponseV2.class);
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean c(Context context) {
        String b2 = x.a(context.getApplicationContext()).b("sso_token=", "", true);
        if (b2 == null || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    public static Context c() {
        return f75968e;
    }

    public static String b(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat2.format(parse);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int a(Context context, int i2) {
        if (context == null) {
            return 0;
        }
        return (int) ((((float) i2) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(String str) {
        return str != null ? str.replaceAll("(?m)(^ *| +(?= |$))", "").replaceAll("(?m)^$([\r\n]+?)(^$[\r\n]+?^)+", "$1") : str;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "" + Character.toUpperCase(str.charAt(0));
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (str.charAt(i2 - 1) == ' ') {
                str2 = str2 + Character.toUpperCase(charAt);
            } else {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    public static ArrayList<CJRMovieHomeListItem> a(String str, ArrayList<CJRMovieHomeListItem> arrayList) {
        ArrayList<CJRMovieHomeListItem> arrayList2 = new ArrayList<>();
        if (!(str == null || arrayList == null || arrayList.size() <= 0)) {
            Iterator<CJRMovieHomeListItem> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRMovieHomeListItem next = it2.next();
                if (next.getLang() != null && next.getLang().equalsIgnoreCase(str)) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    public static String a(long j) {
        if (j == 0) {
            return null;
        }
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r5) {
        /*
            if (r5 == 0) goto L_0x0064
            java.lang.String r0 = r5.trim()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0064
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mm:ss"
            r0.<init>(r2, r1)
            java.lang.String r1 = "GMT"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            r1 = 0
            java.util.Date r0 = r0.parse(r5)     // Catch:{ ParseException -> 0x0025 }
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r4 = "yyyy-MM-dd'T'HH:mm"
            r2.<init>(r4, r3)
            java.lang.String r3 = "UTC"
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r3)
            r2.setTimeZone(r3)
            java.util.Date r0 = r2.parse(r5)     // Catch:{ ParseException -> 0x003d }
        L_0x003d:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = "h:mm a"
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0054 }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = "GMT+05:30"
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r3)     // Catch:{ Exception -> 0x0054 }
            r2.setTimeZone(r3)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r1 = r2.format(r0)     // Catch:{ Exception -> 0x0054 }
            goto L_0x0055
        L_0x0054:
        L_0x0055:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0063
            java.lang.String r5 = "-"
            java.lang.String r0 = " "
            java.lang.String r5 = r1.replace(r5, r0)
        L_0x0063:
            return r5
        L_0x0064:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.n.c(java.lang.String):java.lang.String");
    }

    public static int a(int i2, int i3) {
        if (i3 == 0) {
            return R.color.black;
        }
        float f2 = ((float) (i2 * 100)) / ((float) i3);
        if (f2 == 0.0f) {
            return R.color.movie_not_available;
        }
        if (f2 < 10.0f) {
            return R.color.saffran_offer_color;
        }
        if (f2 < 10.0f || f2 >= 50.0f) {
            return R.color.movie_half_available;
        }
        return R.color.movie_tentofifty_available;
    }

    public static int d(String str) {
        if (str == null || str.isEmpty()) {
            return R.color.black;
        }
        if (str.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
            return R.color.movie_not_available;
        }
        if (str.equalsIgnoreCase("R")) {
            return R.color.saffran_offer_color;
        }
        if (str.equalsIgnoreCase("Y")) {
            return R.color.movie_tentofifty_available;
        }
        if (str.equalsIgnoreCase("G")) {
            return R.color.movie_half_available;
        }
        return R.color.movie_half_available;
    }

    public static String a(int i2) {
        String str;
        int i3 = i2 >= 60 ? i2 / 60 : 0;
        int i4 = i2 % 60;
        if (i3 > 0) {
            str = i3 + "Hrs ";
        } else {
            str = "";
        }
        if (i4 <= 0) {
            return str;
        }
        return str + i4 + "Mins";
    }

    private static String c(int i2) {
        if (i2 > 3 && i2 < 21) {
            return "th";
        }
        int i3 = i2 % 10;
        if (i3 == 1) {
            return H5Param.SHOW_TITLEBAR;
        }
        if (i3 != 2) {
            return i3 != 3 ? "th" : "rd";
        }
        return "nd";
    }

    public static int a(int i2, Context context) {
        return (int) ((((float) i2) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(View view) {
        int i2;
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i3 = layoutParams.height;
            if (i3 > 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, i2);
        } catch (Exception unused) {
        }
    }

    public static String a(CJRMovies cJRMovies, CJRMoviesSession cJRMoviesSession) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/movies");
            if (cJRMovies != null) {
                if (!TextUtils.isEmpty(cJRMovies.getTitle())) {
                    sb.append("/");
                    sb.append(cJRMovies.getTitle());
                }
            }
            if (cJRMoviesSession != null) {
                if (!TextUtils.isEmpty(cJRMoviesSession.getCinemaName())) {
                    sb.append("/");
                    sb.append(cJRMoviesSession.getCinemaName());
                }
                if (!TextUtils.isEmpty(cJRMoviesSession.getRealShowDateTime())) {
                    sb.append("/");
                    sb.append(cJRMoviesSession.getRealShowDateTime());
                }
            }
            sb.append("/seat-map");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(String str) {
        SimpleDateFormat simpleDateFormat;
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat2.parse(str);
            int a2 = a(parse);
            if (a2 >= 0) {
                simpleDateFormat = new SimpleDateFormat("h:mm a, EEE, d'" + c(a2) + "' MMMM");
            } else {
                simpleDateFormat = new SimpleDateFormat("h:mm a, EEE, d MMMM");
            }
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat.format(parse);
        } catch (Exception unused) {
            return "";
        }
    }

    private static int a(Date date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return Integer.parseInt(simpleDateFormat.format(date));
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String f(String str) {
        SimpleDateFormat simpleDateFormat;
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat2.parse(str);
            int a2 = a(parse);
            if (a2 >= 0) {
                simpleDateFormat = new SimpleDateFormat("EEE, d'" + c(a2) + "' MMM");
            } else {
                simpleDateFormat = new SimpleDateFormat("EEE, d MMM");
            }
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat.format(parse);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(String str) {
        SimpleDateFormat simpleDateFormat;
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat2.parse(str);
            if (a(parse) >= 0) {
                simpleDateFormat = new SimpleDateFormat("h:mm a");
            } else {
                simpleDateFormat = new SimpleDateFormat("h:mm a");
            }
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
            return simpleDateFormat.format(parse);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(double d2) {
        DecimalFormat decimalFormat = new DecimalFormat("###########.##");
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
        return decimalFormat.format(d2);
    }

    public static CJRMovieWidget a(String str, List<CJRCinemaV2> list) {
        CJRMovieWidget cJRMovieWidget = null;
        if (list != null && list.size() > 0) {
            for (CJRCinemaV2 next : list) {
                if (next.getId().equalsIgnoreCase(str)) {
                    cJRMovieWidget = next.getWidgets();
                }
            }
        }
        return cJRMovieWidget;
    }

    public static final int b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return androidx.core.content.b.c(context, i2);
        }
        return context.getResources().getColor(i2);
    }

    public static final Drawable c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return androidx.core.content.b.a(context, i2);
        }
        return context.getResources().getDrawable(i2);
    }

    public static JSONObject h(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void d() {
        ArrayList<CJRSelectCityModel> arrayList = f75964a;
        if (arrayList != null) {
            arrayList.clear();
            f75964a = null;
        }
        ArrayList<CJRSelectCityModel> arrayList2 = f75965b;
        if (arrayList2 != null) {
            arrayList2.clear();
            f75965b = null;
        }
        ArrayList<CJRSelectCityModel> arrayList3 = f75966c;
        if (arrayList3 != null) {
            arrayList3.clear();
            f75966c = null;
        }
    }

    public static ArrayList<CJRSelectCityModel> e() {
        return f75967d;
    }

    public static void a(ArrayList<CJRSelectCityModel> arrayList) {
        f75967d = arrayList;
    }

    public static ArrayList<CJRSelectCityModel> f() {
        return f75969f;
    }

    public static void b(ArrayList<CJRSelectCityModel> arrayList) {
        f75969f = arrayList;
    }

    public static void c(ArrayList<CJRSelectCityModel> arrayList) {
        ArrayList<CJRSelectCityModel> arrayList2 = f75966c;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            f75966c = new ArrayList<>();
        }
        f75966c.addAll(arrayList);
    }

    public static double a(double d2, double d3, double d4, double d5) {
        return ((Math.acos((Math.sin(b(d2)) * Math.sin(b(d4))) + ((Math.cos(b(d2)) * Math.cos(b(d4))) * Math.cos(b(d3 - d5)))) * 180.0d) / 3.141592653589793d) * 60.0d * 1.1515d * 1.609344d;
    }

    public static ArrayList<CJRSelectCityModel> g() {
        return f75966c;
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        if (v.a(str3) || v.a(str) || v.a(str2)) {
            return str3;
        }
        if (str3.contains("?")) {
            str4 = str3 + AppConstants.AND_SIGN;
        } else {
            str4 = str3 + "?";
        }
        return str4 + str + "=" + str2;
    }

    public static CJRSelectCitiesModel a(CJRCitiesResponse cJRCitiesResponse) {
        if (cJRCitiesResponse == null || cJRCitiesResponse.getData() == null || cJRCitiesResponse.getData().getCities() == null) {
            return null;
        }
        CJRSelectCitiesModel cJRSelectCitiesModel = new CJRSelectCitiesModel();
        cJRSelectCitiesModel.setCities(new ArrayList());
        Iterator<CJRCityInfo> it2 = cJRCitiesResponse.getData().getCities().iterator();
        while (it2.hasNext()) {
            CJRCityInfo next = it2.next();
            if (next != null) {
                CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
                cJRSelectCityModel.setlabel(next.getName());
                cJRSelectCityModel.setValue(next.getValue());
                cJRSelectCityModel.setmSeachKeys(next.getSearchable());
                cJRSelectCityModel.setmCityImageUrl(next.getImgPath());
                if (cJRCitiesResponse.getData().getTopCities() != null) {
                    cJRSelectCityModel.setIsTopCity(cJRCitiesResponse.getData().getTopCities().contains(next.getId()));
                }
                cJRSelectCityModel.setLatitude(String.valueOf(next.getLat()));
                cJRSelectCityModel.setLongitude(String.valueOf(next.getLon()));
                cJRSelectCitiesModel.getCities().add(cJRSelectCityModel);
            }
        }
        return cJRSelectCitiesModel;
    }

    public static String a(Object obj) {
        return f75970g.b(obj);
    }

    public static <T> T a(String str, Class<T> cls) {
        return f75970g.a(str, cls);
    }

    public static CJRMoviePassCardWidgetModel a(CJRMoviePassModelNew cJRMoviePassModelNew, boolean z, Context context) {
        CJRMoviePassCardWidgetModel cJRMoviePassCardWidgetModel = new CJRMoviePassCardWidgetModel();
        cJRMoviePassCardWidgetModel.setBgImage(cJRMoviePassModelNew.getProductImage());
        cJRMoviePassCardWidgetModel.setDescription(cJRMoviePassModelNew.getDescription());
        cJRMoviePassCardWidgetModel.setHeading(cJRMoviePassModelNew.getHeading());
        cJRMoviePassCardWidgetModel.setHeading(cJRMoviePassModelNew.getHeading());
        cJRMoviePassCardWidgetModel.setDisabled(cJRMoviePassModelNew.getIsOutOfStock() == 1);
        if (!TextUtils.isEmpty(cJRMoviePassModelNew.getTotalPrice())) {
            cJRMoviePassCardWidgetModel.setPriceText(context.getResources().getString(R.string.rupee_symbol) + cJRMoviePassModelNew.getTotalPrice());
        }
        if (!TextUtils.isEmpty(cJRMoviePassModelNew.getStrikeOffPrice())) {
            cJRMoviePassCardWidgetModel.setPassMrpText(context.getResources().getString(R.string.rupee_symbol) + cJRMoviePassModelNew.getStrikeOffPrice());
        }
        if (!d.a((List) cJRMoviePassModelNew.getBenefits())) {
            cJRMoviePassCardWidgetModel.setSubDescription(cJRMoviePassModelNew.getBenefits().get(0));
        }
        if (cJRMoviePassModelNew.getMaximumPassesAllowed() > 0) {
            String str = cJRMoviePassModelNew.getMaximumPassesAllowed() > 1 ? " Movies" : " Movie";
            cJRMoviePassCardWidgetModel.setMovieCountText(cJRMoviePassModelNew.getMaximumPassesAllowed() + str);
        }
        if (cJRMoviePassModelNew.getValidityDays() > 0) {
            String str2 = cJRMoviePassModelNew.getValidityDays() > 1 ? " Days" : " Day";
            cJRMoviePassCardWidgetModel.setPassValidityText(cJRMoviePassModelNew.getValidityDays() + str2);
        }
        if (!d.a((List) cJRMoviePassModelNew.getBenefits())) {
            cJRMoviePassCardWidgetModel.setCinemaLocationValidityText(cJRMoviePassModelNew.getBenefits().get(0));
        }
        cJRMoviePassCardWidgetModel.setMoviePassIconVisible(z);
        return cJRMoviePassCardWidgetModel;
    }

    public static void a(boolean z, View view) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static String a(SentimentInterestedItem sentimentInterestedItem) {
        if (sentimentInterestedItem == null || sentimentInterestedItem.getCountInfo() == null || sentimentInterestedItem.getCountInfo().get(H5AppHandler.CHECK_VALUE) == null || sentimentInterestedItem.getCountInfo().get(H5AppHandler.CHECK_VALUE).longValue() == 0) {
            return null;
        }
        long longValue = sentimentInterestedItem.getCountInfo().get(H5AppHandler.CHECK_VALUE).longValue();
        if (longValue < 1000) {
            return String.valueOf(longValue);
        }
        return new DecimalFormat("##.#").format(((double) longValue) / 1000.0d) + "k";
    }

    public static String a(CJRMovieHomeListItem cJRMovieHomeListItem) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(cJRMovieHomeListItem.getLang())) {
            sb.append(cJRMovieHomeListItem.getLang());
        }
        if (!TextUtils.isEmpty(cJRMovieHomeListItem.getCensor())) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(cJRMovieHomeListItem.getCensor());
        }
        return sb.toString();
    }

    public static int b(int i2) {
        return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static void b(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(String str, Context context) {
        b.f75032a.f75033b.sendOpenScreenWithDeviceInfo(str, "movies", context);
    }
}
