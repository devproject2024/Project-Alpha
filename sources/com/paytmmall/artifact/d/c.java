package com.paytmmall.artifact.d;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.core.app.a;
import com.alipay.mobile.nebula.util.H5Utils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.j;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f15691a = t.c().g();

    /* renamed from: b  reason: collision with root package name */
    private static String f15692b = "paytm";

    public static void b() {
    }

    public static String b(Context context) {
        j jVar = j.f43829a;
        return j.a(context);
    }

    public static String c(Context context) {
        return r.a(context);
    }

    public static String d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return H5Utils.NETWORK_TYPE_WIFI;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return H5Utils.NETWORK_TYPE_2G;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return H5Utils.NETWORK_TYPE_3G;
                            case 13:
                                return H5Utils.NETWORK_TYPE_4G;
                            default:
                                return null;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (telephonyManager == null || a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            return telephonyManager.getDeviceId();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static String g(Context context) {
        if (context == null) {
            return null;
        }
        try {
            com.paytm.b.a.a a2 = u.a(context.getApplicationContext());
            String b2 = a2.b("simSerial", "", true);
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
            if (telephonyManager == null || a.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            a2.a("simSerial", simSerialNumber, true);
            return simSerialNumber;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        if (r.a() == 1) {
            return "en-IN";
        }
        String language = Locale.getDefault().getLanguage();
        return language + "-IN";
    }

    public static String a(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
            return "";
        }
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
    }

    public static int h(Context context) {
        return d.a((Activity) context) / 16;
    }

    public static String c() {
        String str = Build.MANUFACTURER;
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str;
        }
    }

    public static String d() {
        String str = Build.MODEL;
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str;
        }
    }

    public static String i(Context context) {
        return u.a(context.getApplicationContext()).b(AppConstants.KEY_EMAIL, "", true);
    }

    public static String j(Context context) {
        return u.a(context.getApplicationContext()).b("userId", "", true);
    }

    public static String k(Context context) {
        return u.a(context.getApplicationContext()).b("mobile", "", true);
    }

    public static Map<String, String> l(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.KEY_EMAIL, i(context));
        hashMap.put(ContactColumn.PHONE_NUMBER, k(context));
        hashMap.put("displayName", u.a(context.getApplicationContext()).b("display_name", "", true));
        hashMap.put("firstName", d.e(context));
        hashMap.put("lastName", d.f(context));
        hashMap.put("gender", u.a(context.getApplicationContext()).b("user_gender", "", true));
        hashMap.put("profileImage", u.a(context.getApplicationContext()).b(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, "", true));
        return hashMap;
    }

    public static boolean b(String str) {
        return str.startsWith("paytmmp://") || str.startsWith("paytmmall://");
    }

    public static boolean c(String str) {
        return str.startsWith(t.c().c("DEEPLINK_SCHEME_ID"));
    }

    public static boolean d(String str) {
        if (!e(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            Pattern compile = Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))(([a-zA-Z]*\\.)|())(paytm.com)|www\\.(paytm.com))");
            return compile.matcher(url.getProtocol() + "://" + url.getHost()).find();
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static boolean e(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        return str.startsWith("http://m.p-y.tm") || str.startsWith("https://m.p-y.tm") || str.startsWith("https://p-y.tm") || str.startsWith("http://p-y.tm");
    }

    public static boolean g(String str) {
        return str.startsWith("https://play.google.com/store/apps/") || str.startsWith("http://play.google.com/store/apps/");
    }

    public static String h(String str) {
        if (str.startsWith("https://play.google.com/store/apps/")) {
            return "https://play.google.com/store/apps/";
        }
        if (str.startsWith("http://play.google.com/store/apps/")) {
            return "http://play.google.com/store/apps/";
        }
        return "";
    }

    public static boolean i(String str) {
        return str.startsWith("market://");
    }

    public static boolean j(String str) {
        return Pattern.compile("((?:http|https)://)?(?:www\\.)?[\\w\\d\\-_]+\\.\\w{2,3}(\\.\\w{2})?(/(?<=/)(?:[\\w\\d\\-./_]+)?)?(\\?.+)?").matcher(str).find();
    }

    public static boolean m(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static String k(String str) {
        if (c(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("paytmmp")) {
            return (TextUtils.isEmpty(str) || !str.startsWith("paytmmall")) ? str : str.replace("paytmmall", "paytmmp");
        }
        String[] strArr = {CLPConstants.DEFAULT_GRID_VIEW_TYPE, "homepage_secondary", CLPConstants.GA_CHANNEL_NAME, "product", "checkout"};
        Uri parse = Uri.parse(str.replace('$', '&'));
        if (parse == null) {
            return str;
        }
        String host = parse.getHost();
        for (int i2 = 0; i2 < 5; i2++) {
            if (strArr[i2].equals(host)) {
                return str.replace("paytmmp", "paytmmall");
            }
        }
        return str;
    }

    private static Point o(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return point;
    }

    public static String a(Context context) {
        j jVar = j.f43829a;
        String a2 = j.a(context);
        String replaceAll = (Build.MANUFACTURER + "-" + Build.MODEL + "-" + a2).replaceAll(" ", "");
        "Device identifier is : ".concat(String.valueOf(replaceAll));
        return replaceAll;
    }

    public static String f(Context context) {
        String a2 = r.a(context);
        if (a2.contains("-IN")) {
            return a2;
        }
        return a2 + "-IN";
    }

    public static String a(Context context, String str) {
        String str2;
        if (str.startsWith("paytmmp")) {
            str2 = "net.one97.paytm";
        } else {
            str2 = str.startsWith("paytmmall") ? "com.paytmmall" : "";
        }
        try {
            context.getPackageManager().getPackageInfo(str2, 1);
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            return str2;
        }
    }

    public static Point n(Context context) {
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point o = o(context);
        if (ViewConfiguration.get(context).hasPermanentMenuKey() || point.y != o.y) {
            return new Point();
        }
        int i3 = point.x;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            i2 = resources.getDimensionPixelSize(identifier);
        } else {
            i2 = 0;
        }
        return new Point(i3, i2);
    }
}
