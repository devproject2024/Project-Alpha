package com.paytm.erroranalytics.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import com.paytm.erroranalytics.c.a;
import com.paytm.erroranalytics.e;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class b {
    public static Map<String, String> c(Context context) {
        String str = a(context).f42715g;
        HashMap hashMap = new HashMap();
        if (str == null || str.equalsIgnoreCase(SDKConstants.KEY_STAGING_API)) {
            hashMap.put("secret", "587c67045c585d3d6decbf8134684a7a");
            hashMap.put("app_id", "android-staging");
            return hashMap;
        }
        hashMap.put("secret", "4YYECvCRJxfLw0V2C3VMeeiEFhk7aHew");
        hashMap.put("app_id", "android-prod");
        return hashMap;
    }

    public static void a(Context context, a aVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.paytm.androidErrorAnalytics", 0).edit();
        edit.putString("customer_id", aVar.f42710b);
        edit.putString("device_id", aVar.f42709a);
        edit.putString("auth_token", aVar.f42712d);
        edit.putString("name", aVar.f42711c);
        edit.putBoolean("location_enable", aVar.f42713e);
        if (aVar.f42714f != null) {
            edit.putString("server_end_points", aVar.f42714f);
        }
        edit.putString("build_flavour", aVar.f42715g);
        edit.putString("app_flavour", aVar.f42716h);
        edit.putString("client_name", aVar.f42717i);
        if (aVar.j > 0) {
            edit.putInt("event_upload_time_in_sec", aVar.j);
        }
        edit.apply();
        String str = e.f42808a;
    }

    public static a a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.paytm.androidErrorAnalytics", 0);
        a.C0712a aVar = new a.C0712a();
        aVar.f42719b = sharedPreferences.getString("customer_id", (String) null);
        aVar.f42718a = sharedPreferences.getString("device_id", (String) null);
        aVar.f42721d = sharedPreferences.getString("auth_token", (String) null);
        aVar.f42720c = sharedPreferences.getString("name", (String) null);
        aVar.f42722e = sharedPreferences.getBoolean("location_enable", false);
        aVar.f42723f = sharedPreferences.getString("server_end_points", (String) null);
        aVar.f42724g = sharedPreferences.getString("build_flavour", (String) null);
        aVar.f42725h = sharedPreferences.getString("app_flavour", (String) null);
        aVar.f42726i = sharedPreferences.getString("client_name", (String) null);
        aVar.j = sharedPreferences.getInt("event_upload_time_in_sec", 0);
        return aVar.a();
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.paytm.androidErrorAnalytics", 0).edit();
        edit.putLong("db_check_time", j);
        edit.commit();
    }

    public static long b(Context context) {
        return context.getSharedPreferences("com.paytm.androidErrorAnalytics", 0).getLong("db_check_time", 0);
    }
}
