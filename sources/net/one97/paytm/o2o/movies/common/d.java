package net.one97.paytm.o2o.movies.common;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.paytm.b.a.a;
import com.paytm.utility.b;
import com.paytm.utility.v;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.movies.search.CJRCityTranslationModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.GroupFormatObject;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.utils.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<Integer, String> f75112a;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        f75112a = hashMap;
        hashMap.put(0, "#00AB84");
        f75112a.put(1, "#3B3FB6");
        f75112a.put(2, "#5F259F");
        f75112a.put(3, "#E63888");
        f75112a.put(4, "#FF6A39");
    }

    public static void a(Context context, CJRSelectCityModel cJRSelectCityModel, String str) {
        if (context != null && cJRSelectCityModel != null) {
            a a2 = x.a(context.getApplicationContext());
            if (str.equalsIgnoreCase("movies")) {
                a2.a("movies_cached_city_name", cJRSelectCityModel.getLabel(), false);
                a2.a("movies_cached_city_value", cJRSelectCityModel.getValue(), false);
                if (cJRSelectCityModel.getTranslated() == null || TextUtils.isEmpty(cJRSelectCityModel.getTranslated().getLabel())) {
                    a2.a("movies_cached_city_translated", "", false);
                } else {
                    a2.a("movies_cached_city_translated", cJRSelectCityModel.getTranslated().getLabel(), false);
                    a2.a("movies_cached_city_saved_locale", b.w(context), false);
                }
                a2.a("cityIsTopMovies", cJRSelectCityModel.isTopCity(), false);
                a2.a("movieLat", cJRSelectCityModel.getLatitude(), false);
                a2.a("movieLng", cJRSelectCityModel.getLongitude(), false);
            }
        }
    }

    public static void a(Context context, CJRSelectCityModel cJRSelectCityModel) {
        if (cJRSelectCityModel != null) {
            x.a(context.getApplicationContext()).a("movies_one_pager_selected_location", n.a((Object) cJRSelectCityModel), false);
        }
    }

    public static CJRSelectCityModel a(Context context) {
        String b2 = x.a(context.getApplicationContext()).b("movies_one_pager_selected_location", "", false);
        if (!b2.equals("")) {
            return (CJRSelectCityModel) n.a(b2, CJRSelectCityModel.class);
        }
        return null;
    }

    public static CJRSelectCityModel a(Context context, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        CJRSelectCityModel cJRSelectCityModel = null;
        if (context != null) {
            a a2 = x.a(context.getApplicationContext());
            boolean z = false;
            String str6 = "";
            if (str.equalsIgnoreCase("movies")) {
                str2 = a2.b("movies_cached_city_name", str6, false);
                String b2 = a2.b("movies_cached_city_value", str6, false);
                String b3 = b.w(context).equalsIgnoreCase(a2.b("movies_cached_city_saved_locale", str6, false)) ? a2.b("movies_cached_city_translated", str6, false) : str6;
                boolean b4 = a2.b("cityIsTopMovies", false, false);
                str4 = a2.b("movieLat", str6, false);
                String b5 = a2.b("movieLng", str6, false);
                str5 = b3;
                str3 = b5;
                str6 = b2;
                z = b4;
            } else {
                str3 = str6;
                str2 = str3;
                str5 = str2;
                str4 = str5;
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str6)) {
                cJRSelectCityModel = new CJRSelectCityModel();
                cJRSelectCityModel.setlabel(str2);
                cJRSelectCityModel.setValue(str6);
                cJRSelectCityModel.setIsTopCity(z);
                cJRSelectCityModel.setLatitude(str4);
                cJRSelectCityModel.setLongitude(str3);
            }
            if (!TextUtils.isEmpty(str5)) {
                cJRSelectCityModel.setTranslated(new CJRCityTranslationModel(str5));
            }
        }
        return cJRSelectCityModel;
    }

    public static String b(Context context, String str) {
        String b2 = x.a(context.getApplicationContext()).b("key_user_recent_cities".concat(String.valueOf(str)), "", false);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String b(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            str = x.a(context.getApplicationContext()).b("user_selected_city", "", false);
        } catch (Exception unused) {
            str = null;
        }
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    public static void a(Context context, String str, String str2) {
        String str3;
        if (context != null) {
            a a2 = x.a(context.getApplicationContext());
            String b2 = a2.b("key_user_recent_cities".concat(String.valueOf(str2)), "", false);
            if (!b2.equals("")) {
                str3 = b2 + "#" + str;
            } else {
                str3 = str;
            }
            a2.a("key_user_recent_cities".concat(String.valueOf(str2)), b(a(str3)), false);
            a2.a("user_selected_city", str, false);
        }
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return x.a(context.getApplicationContext()).b("isUpdatedApp", false, false);
    }

    public static void d(Context context) {
        if (context != null) {
            x.a(context.getApplicationContext()).a("isUpdatedApp", true, false);
        }
    }

    public static List<String> a(String str) {
        if (v.a(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(str.split("#")));
        if (new HashSet(arrayList).size() < arrayList.size()) {
            arrayList.remove(arrayList.indexOf(arrayList.get(arrayList.size() - 1)));
        }
        return arrayList.size() > 4 ? arrayList.subList(arrayList.size() - 4, arrayList.size()) : arrayList;
    }

    private static String b(List<String> list) {
        StringBuilder sb = null;
        if (list == null) {
            return null;
        }
        for (String next : list) {
            if (sb == null) {
                sb = new StringBuilder(next);
            } else {
                sb.append("#");
                sb.append(next);
            }
        }
        return ((StringBuilder) Objects.requireNonNull(sb)).toString();
    }

    public static CJRSelectCityModel c(Context context, String str) {
        return a(context, str);
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean a(List list) {
        return list == null || list.size() == 0;
    }

    public static String a(Context context, int i2, int i3, int i4) {
        if (context == null) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i2, i3 - 1, i4);
        Date time = instance.getTime();
        return ((String) DateFormat.format("EE", time)) + ", " + ((String) DateFormat.format("dd", time)) + " " + ((String) DateFormat.format("MMM", time)) + " " + ((String) DateFormat.format("yyyy", time)).substring(2);
    }

    public static String a(int i2, int i3, int i4, int i5) {
        Calendar instance = Calendar.getInstance();
        instance.set(i2, i3 - 1, i4);
        if (i5 > 0) {
            instance.add(5, i5);
        }
        Date time = instance.getTime();
        return ((String) DateFormat.format("dd", time)) + " " + ((String) DateFormat.format("MMM", time)) + " " + ((String) DateFormat.format("yyyy", time));
    }

    public static Date c(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static String a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("Free") || str.equalsIgnoreCase("0")) {
            return "Free";
        }
        if (str.equalsIgnoreCase("Rsvp")) {
            return str;
        }
        return context.getResources().getString(R.string.rupee_symbol) + str;
    }

    public static ArrayList<CJRMovieHomeListItem> a(CJRMovieHomeDataResponse cJRMovieHomeDataResponse) {
        ArrayList<CJRMovieHomeListItem> movies = cJRMovieHomeDataResponse.getData().getMovies();
        ArrayList<CJRMovieHomeListItem> arrayList = new ArrayList<>();
        if (a((List) movies)) {
            return null;
        }
        Iterator<CJRMovieHomeListItem> it2 = movies.iterator();
        while (it2.hasNext()) {
            CJRMovieHomeListItem next = it2.next();
            if (!arrayList.contains(next)) {
                if (next.getScrnFmtList() == null) {
                    next.setScrnFmtList(new ArrayList());
                    next.getScrnFmtList().add(new GroupFormatObject(next.getId(), next.getScrnFmt()));
                }
                arrayList.add(next);
            } else {
                CJRMovieHomeListItem cJRMovieHomeListItem = arrayList.get(arrayList.indexOf(next));
                cJRMovieHomeListItem.setTotalSessionCount(cJRMovieHomeListItem.getTotalSessionCount() + next.getTotalSessionCount());
                GroupFormatObject groupFormatObject = new GroupFormatObject(next.getId(), next.getScrnFmt());
                if (cJRMovieHomeListItem.getScrnFmtList() != null && !cJRMovieHomeListItem.getScrnFmtList().contains(groupFormatObject)) {
                    cJRMovieHomeListItem.getScrnFmtList().add(groupFormatObject);
                }
            }
        }
        return arrayList;
    }
}
