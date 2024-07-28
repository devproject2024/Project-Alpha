package com.paytm.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.alipay.mobile.nebula.util.H5Utils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.g;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiContract;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f43677a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f43678b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f43679c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f43680d = "paytm";

    public static void c() {
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return true;
    }

    public static String a() {
        String str = f43678b;
        return str == null ? x.f43871f : str;
    }

    public static void a(String str) {
        f43678b = str;
    }

    public static String b() {
        String str = f43679c;
        return str == null ? x.f43872g : str;
    }

    public static void b(String str) {
        f43679c = str;
    }

    public static String a(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("userId", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("mobile", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b(AppConstants.KEY_EMAIL, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String d(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        return string == null ? "2k3k4k34k3k" : string;
    }

    public static String e(Context context) {
        String f2 = f(context);
        return (Build.MANUFACTURER + "-" + Build.MODEL + "-" + f2).replaceAll(" ", "");
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(f43677a)) {
            return f43677a;
        }
        j jVar = j.f43829a;
        String a2 = j.a(context);
        f43677a = a2;
        return a2;
    }

    public static String a(Context context, String str) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b(str, "", true);
        }
        return "";
    }

    public static void a(Context context, String str, String str2) {
        new StringBuilder("setSharedPref : Context : ").append(context);
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a(str, str2, true);
        }
    }

    public static String g(Context context) {
        if (context != null) {
            try {
                return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("pref_key_latitude", "", true);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        return "";
    }

    public static String h(Context context) {
        if (context != null) {
            try {
                return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("pref_key_longitude", "", true);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        return "";
    }

    public static String l(Context context) {
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
            q.b(e2.getMessage());
            return null;
        }
    }

    public static boolean m(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (SecurityException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public static String d() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return Formatter.formatIpAddress(nextElement.hashCode());
                        }
                    }
                }
            }
            return null;
        } catch (Exception | SocketException unused) {
            return null;
        }
    }

    public static boolean n(Context context) {
        try {
            return g.a(context) == 0;
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
            return false;
        }
    }

    public static boolean o(Context context) {
        List<String> allProviders;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null || (allProviders = locationManager.getAllProviders()) == null) {
                return false;
            }
            return allProviders.contains("gps");
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
            return false;
        }
    }

    public static boolean p(Context context) {
        if (context != null) {
            String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("sso_token=", "", true);
            if (b2.equals("")) {
                b2 = null;
            }
            if (b2 != null) {
                return true;
            }
        }
        return false;
    }

    public static String q(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("sso_token=", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static ArrayList<String> r(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            arrayList.add(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getSSID());
            return arrayList;
        } catch (Exception e2) {
            q.d("excepton in wifissid" + e2.toString());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ab A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010a A[EDGE_INSN: B:46:0x010a->B:41:0x010a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.Integer, java.util.ArrayList<java.lang.String>> a(java.util.Date r19, android.content.Context r20) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            android.content.ContentResolver r3 = r20.getContentResolver()     // Catch:{ Exception -> 0x011d }
            android.net.Uri r4 = android.provider.CallLog.Calls.CONTENT_URI     // Catch:{ Exception -> 0x011d }
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "date DESC"
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x011d }
            java.lang.String r4 = "number"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x011d }
            java.lang.String r5 = "date"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "type"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ Exception -> 0x011d }
        L_0x0031:
            boolean r7 = r3.moveToNext()     // Catch:{ Exception -> 0x011d }
            r9 = 1
            if (r7 == 0) goto L_0x010a
            java.lang.String r7 = r3.getString(r4)     // Catch:{ Exception -> 0x011d }
            java.lang.String r10 = r3.getString(r5)     // Catch:{ Exception -> 0x011d }
            java.lang.String r11 = r3.getString(r6)     // Catch:{ Exception -> 0x011d }
            java.util.Date r12 = new java.util.Date     // Catch:{ Exception -> 0x011d }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x011d }
            long r13 = r10.longValue()     // Catch:{ Exception -> 0x011d }
            r12.<init>(r13)     // Catch:{ Exception -> 0x011d }
            long r13 = r19.getTime()     // Catch:{ Exception -> 0x011d }
            long r15 = r12.getTime()     // Catch:{ Exception -> 0x011d }
            long r13 = r13 - r15
            java.io.PrintStream r10 = java.lang.System.out     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = "startDate : "
            java.lang.String r8 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x011d }
            java.lang.String r8 = r15.concat(r8)     // Catch:{ Exception -> 0x011d }
            r10.println(r8)     // Catch:{ Exception -> 0x011d }
            java.io.PrintStream r8 = java.lang.System.out     // Catch:{ Exception -> 0x011d }
            java.lang.String r10 = "endDate : "
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x011d }
            java.lang.String r10 = r10.concat(r12)     // Catch:{ Exception -> 0x011d }
            r8.println(r10)     // Catch:{ Exception -> 0x011d }
            java.io.PrintStream r8 = java.lang.System.out     // Catch:{ Exception -> 0x011d }
            java.lang.String r10 = "different : "
            java.lang.String r12 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x011d }
            java.lang.String r10 = r10.concat(r12)     // Catch:{ Exception -> 0x011d }
            r8.println(r10)     // Catch:{ Exception -> 0x011d }
            r15 = 86400000(0x5265c00, double:4.2687272E-316)
            long r13 = r13 % r15
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            long r17 = r13 / r15
            long r13 = r13 % r15
            r15 = 60000(0xea60, double:2.9644E-319)
            long r13 = r13 / r15
            r15 = 1
            r8 = 0
            int r10 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x00a4
            r15 = 0
            int r12 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r12 != 0) goto L_0x00a4
            goto L_0x00a6
        L_0x00a4:
            if (r10 >= 0) goto L_0x00a8
        L_0x00a6:
            r10 = 1
            goto L_0x00a9
        L_0x00a8:
            r10 = 0
        L_0x00a9:
            if (r10 == 0) goto L_0x010a
            int r10 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x011d }
            r11 = 3
            if (r10 == r9) goto L_0x00c8
            r12 = 2
            if (r10 == r12) goto L_0x00b7
            goto L_0x0031
        L_0x00b7:
            boolean r8 = r1.contains(r7)     // Catch:{ Exception -> 0x011d }
            if (r8 != 0) goto L_0x0031
            int r8 = r1.size()     // Catch:{ Exception -> 0x011d }
            if (r8 > r11) goto L_0x0031
            r1.add(r7)     // Catch:{ Exception -> 0x011d }
            goto L_0x0031
        L_0x00c8:
            boolean r10 = r0.contains(r7)     // Catch:{ Exception -> 0x011d }
            if (r10 != 0) goto L_0x0031
            int r10 = r0.size()     // Catch:{ Exception -> 0x011d }
            if (r10 > r11) goto L_0x0031
            if (r7 == 0) goto L_0x0105
            java.lang.String r10 = "0"
            boolean r8 = r7.startsWith(r10, r8)     // Catch:{ Exception -> 0x011d }
            if (r8 == 0) goto L_0x00e3
            java.lang.String r7 = r7.substring(r9)     // Catch:{ Exception -> 0x011d }
            goto L_0x0105
        L_0x00e3:
            java.lang.String r8 = "91"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x011d }
            if (r8 == 0) goto L_0x00f9
            int r8 = r7.length()     // Catch:{ Exception -> 0x011d }
            r9 = 10
            if (r8 <= r9) goto L_0x00f9
            r8 = 2
            java.lang.String r7 = r7.substring(r8)     // Catch:{ Exception -> 0x011d }
            goto L_0x0105
        L_0x00f9:
            java.lang.String r8 = "+91"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x011d }
            if (r8 == 0) goto L_0x0105
            java.lang.String r7 = r7.substring(r11)     // Catch:{ Exception -> 0x011d }
        L_0x0105:
            r0.add(r7)     // Catch:{ Exception -> 0x011d }
            goto L_0x0031
        L_0x010a:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x011d }
            r2.put(r4, r0)     // Catch:{ Exception -> 0x011d }
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x011d }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x011d }
            r3.close()     // Catch:{ Exception -> 0x011d }
            return r2
        L_0x011d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.a.a(java.util.Date, android.content.Context):java.util.HashMap");
    }

    public static String s(Context context) {
        return ((TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)).getNetworkOperatorName();
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    public static String f() {
        String str = Build.MODEL;
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    public static String b(Context context, String str) {
        String f2 = f(context);
        return c(f2 + str);
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length << 1);
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(Character.forDigit((digest[i2] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i2] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            if (!b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static int t(Context context) {
        return a((Activity) context) / 16;
    }

    public static int a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (activity == null || activity.isFinishing()) {
            return 0;
        }
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int u(Context context) {
        return a((Activity) context) / 32;
    }

    public static int b(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int a(int i2) {
        try {
            return (int) (((float) i2) * Resources.getSystem().getDisplayMetrics().density);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int v(Context context) {
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case 120:
            case 160:
                return 1;
            case 240:
                return 2;
            case 280:
            case UpiConstants.REQUEST_CODE_BANK_DETAIL /*320*/:
                return 3;
            case 560:
            case 640:
                return 5;
            default:
                return 4;
        }
    }

    public static String c(Context context, String str) {
        return c.b(str, context);
    }

    public static HashMap<String, String> a(HashMap<String, String> hashMap, Context context) {
        hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, q(context));
        return hashMap;
    }

    public static HashMap<String, String> i() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    public static String w(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("ADVERTISING_ID", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static boolean j() {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i2 = 0; i2 < 8; i2++) {
            String str = strArr[i2];
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public static String x(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String y(Context context) {
        if (context == null) {
            return null;
        }
        return "/Android/data/" + context.getPackageName();
    }

    public static boolean z(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("profile_pic_update", false, true);
        }
        return false;
    }

    public static void k() {
        g.a();
    }

    public static String i(Context context) {
        return n.a(context, n.a());
    }

    public static String j(Context context) {
        if (context == null) {
            return "English";
        }
        String a2 = n.a(context, n.a());
        if (TextUtils.isEmpty(a2)) {
            return "English";
        }
        char c2 = 65535;
        switch (a2.hashCode()) {
            case 3148:
                if (a2.equals("bn")) {
                    c2 = 8;
                    break;
                }
                break;
            case 3241:
                if (a2.equals("en")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3310:
                if (a2.equals("gu")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3329:
                if (a2.equals("hi")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3427:
                if (a2.equals("kn")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3487:
                if (a2.equals("ml")) {
                    c2 = 9;
                    break;
                }
                break;
            case 3493:
                if (a2.equals("mr")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3555:
                if (a2.equals("or")) {
                    c2 = 10;
                    break;
                }
                break;
            case 3569:
                if (a2.equals("pa")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3693:
                if (a2.equals("ta")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3697:
                if (a2.equals("te")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return "English";
            case 1:
                return "Hindi";
            case 2:
                return "Tamil";
            case 3:
                return "Telugu";
            case 4:
                return "Kannada";
            case 5:
                return "Punjabi";
            case 6:
                return "Marathi";
            case 7:
                return "Gujarati";
            case 8:
                return "Bangla";
            case 9:
                return "Malayalam";
            case 10:
                return "Odia";
            default:
                return "English";
        }
    }

    public static String k(Context context) {
        String a2 = n.a(context, n.a());
        if (a2.contains("-IN")) {
            return a2;
        }
        return a2 + "-IN";
    }
}
