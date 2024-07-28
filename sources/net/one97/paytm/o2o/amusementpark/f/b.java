package net.one97.paytm.o2o.amusementpark.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import net.one97.paytm.common.entity.CJRSelectCityModel;

public final class b {
    public static void a(Context context, CJRSelectCityModel cJRSelectCityModel, String str) {
        if (context != null && cJRSelectCityModel != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("paytmPref", 0).edit();
            if (str.equalsIgnoreCase("ampark")) {
                edit.putString("cityLabel", cJRSelectCityModel.getLabel());
                edit.putString("cityValue", cJRSelectCityModel.getValue());
                edit.putBoolean("cityIsTop", cJRSelectCityModel.isTopCity());
                edit.putString("parkLat", cJRSelectCityModel.getLatitude());
                edit.putString("parkLng", cJRSelectCityModel.getLongitude());
            }
            edit.commit();
        }
    }

    public static List<String> a(String str) {
        if (b(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(str.split("#")));
        if (new HashSet(arrayList).size() < arrayList.size()) {
            arrayList.remove(arrayList.indexOf(arrayList.get(arrayList.size() - 1)));
        }
        return arrayList.size() > 4 ? arrayList.subList(arrayList.size() - 4, arrayList.size()) : arrayList;
    }

    public static String a(List<String> list) {
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

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(List list) {
        return list == null || list.size() == 0;
    }

    public static CJRSelectCityModel a(Context context, String str) {
        String str2;
        String str3;
        String str4;
        if (context == null) {
            return null;
        }
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("paytmPref", 0);
        String str5 = "";
        if (str.equalsIgnoreCase("ampark")) {
            str2 = sharedPreferences.getString("cityLabel", (String) null);
            String string = sharedPreferences.getString("cityValue", (String) null);
            z = sharedPreferences.getBoolean("cityIsTop", false);
            str4 = sharedPreferences.getString("parkLat", str5);
            str3 = sharedPreferences.getString("parkLng", str5);
            str5 = string;
        } else {
            str3 = str5;
            str2 = str3;
            str4 = str2;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str5)) {
            return null;
        }
        CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
        cJRSelectCityModel.setlabel(str2);
        cJRSelectCityModel.setValue(str5);
        cJRSelectCityModel.setIsTopCity(z);
        cJRSelectCityModel.setLatitude(str4);
        cJRSelectCityModel.setLongitude(str3);
        return cJRSelectCityModel;
    }
}
