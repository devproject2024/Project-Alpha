package com.paytm.utility;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.paytm.b.a.a;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f43762a = x.f43866a;

    /* renamed from: b  reason: collision with root package name */
    private static String f43763b;

    /* renamed from: c  reason: collision with root package name */
    private static String f43764c;

    /* renamed from: d  reason: collision with root package name */
    private static String f43765d;

    /* renamed from: e  reason: collision with root package name */
    private static String f43766e;

    /* renamed from: f  reason: collision with root package name */
    private static String f43767f;

    /* renamed from: g  reason: collision with root package name */
    private static String f43768g;

    public static String a(Context context, boolean z) {
        String str;
        context.getSystemService(ContactColumn.PHONE_NUMBER);
        f43764c = a.a(context.getApplicationContext(), a.c.UTILITY).b("session_id", "", true);
        f43763b = a.q(context);
        try {
            f43765d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.b(e2.getMessage());
        }
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        f43766e = a.e(context);
        try {
            f43766e = URLEncoder.encode(f43766e, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e3) {
            q.b(e3.getMessage());
        }
        StringBuilder sb = new StringBuilder("?");
        if (z && (str = f43763b) != null && str.length() > 0) {
            sb.append("sso_token=" + f43763b);
        }
        if (f43766e != null) {
            if (sb.length() > 1) {
                sb.append("&deviceIdentifier=" + f43766e);
            } else {
                sb.append("deviceIdentifier=" + f43766e);
            }
        }
        try {
            String encode = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43767f = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f43767f);
                } else {
                    sb.append("deviceManufacturer=" + f43767f);
                }
            }
        } catch (UnsupportedEncodingException e4) {
            q.b(e4.getMessage());
        } catch (Exception e5) {
            q.b(e5.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str3.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43768g = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f43768g);
                } else {
                    sb.append("deviceName=" + f43768g);
                }
            }
        } catch (UnsupportedEncodingException e6) {
            q.b(e6.getMessage());
        } catch (Exception e7) {
            q.b(e7.getMessage());
        }
        if (f43762a != null) {
            if (sb.length() > 1) {
                sb.append("&client=" + f43762a);
            } else {
                sb.append("client=" + f43762a);
            }
        }
        if (f43765d != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f43765d);
            } else {
                sb.append("version=" + f43765d);
            }
        }
        if (c(context)) {
            if (sb.length() > 1) {
                sb.append("&playStore=true");
            } else {
                sb.append("playStore=true");
            }
        } else if (sb.length() > 1) {
            sb.append("&playStore=false");
        } else {
            sb.append("playStore=false");
        }
        String g2 = a.g(context);
        String h2 = a.h(context);
        if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h2)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + g2 + "&long=" + h2);
            } else {
                sb.append("lat=" + g2 + "&long=" + h2);
            }
        }
        String i2 = a.i(context);
        if (i2 != null && i2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(i2)));
            } else {
                sb.append("language=".concat(String.valueOf(i2)));
            }
        }
        String l = a.l(context);
        if (l != null && l.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(l)));
            } else {
                sb.append("networkType=".concat(String.valueOf(l)));
            }
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(a2)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(a2)));
            }
        }
        String a3 = n.a(context, n.a());
        if (a3 != null) {
            int intValue = e.p.get(a3).intValue();
            if (intValue == 0) {
                intValue = 1;
            }
            sb.append("&lang_id=".concat(String.valueOf(intValue)));
        }
        String k = a.k(context);
        if (TextUtils.isEmpty(k)) {
            k = "en-IN";
        }
        if (k != null && k.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(k)));
            } else {
                sb.append("locale=".concat(String.valueOf(k)));
            }
        }
        return sb.toString();
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        context.getSystemService(ContactColumn.PHONE_NUMBER);
        f43764c = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("session_id", "", true);
        f43763b = a.q(context);
        try {
            f43765d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.b(e2.getMessage());
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        f43766e = a.e(context);
        try {
            f43766e = URLEncoder.encode(f43766e, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e3) {
            q.b(e3.getMessage());
        }
        StringBuilder sb = new StringBuilder("?");
        if (f43766e != null) {
            if (sb.length() > 1) {
                sb.append("&deviceIdentifier=" + f43766e);
            } else {
                sb.append("deviceIdentifier=" + f43766e);
            }
        }
        try {
            String encode = URLEncoder.encode(str.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43767f = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f43767f);
                } else {
                    sb.append("deviceManufacturer=" + f43767f);
                }
            }
        } catch (UnsupportedEncodingException e4) {
            q.b(e4.getMessage());
        } catch (Exception e5) {
            q.b(e5.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43768g = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f43768g);
                } else {
                    sb.append("deviceName=" + f43768g);
                }
            }
        } catch (UnsupportedEncodingException e6) {
            q.b(e6.getMessage());
        } catch (Exception e7) {
            q.b(e7.getMessage());
        }
        if (f43762a != null) {
            if (sb.length() > 1) {
                sb.append("&client=" + f43762a);
            } else {
                sb.append("client=" + f43762a);
            }
        }
        if (f43765d != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f43765d);
            } else {
                sb.append("version=" + f43765d);
            }
        }
        if (c(context)) {
            if (sb.length() > 1) {
                sb.append("&playStore=true");
            } else {
                sb.append("playStore=true");
            }
        } else if (sb.length() > 1) {
            sb.append("&playStore=false");
        } else {
            sb.append("playStore=false");
        }
        String g2 = a.g(context);
        String h2 = a.h(context);
        if (TextUtils.isEmpty(g2)) {
            g2 = "0.0";
        }
        if (TextUtils.isEmpty(h2)) {
            h2 = "0.0";
        }
        if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h2)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + g2 + "&long=" + h2);
            } else {
                sb.append("lat=" + g2 + "&long=" + h2);
            }
        }
        String i2 = a.i(context);
        if (i2 != null && i2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(i2)));
            } else {
                sb.append("language=".concat(String.valueOf(i2)));
            }
        }
        String l = a.l(context);
        if (l != null && l.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(l)));
            } else {
                sb.append("networkType=".concat(String.valueOf(l)));
            }
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(a2)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(a2)));
            }
        }
        String k = a.k(context);
        if (TextUtils.isEmpty(k)) {
            k = "en-IN";
        }
        if (k != null && k.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(k)));
            } else {
                sb.append("locale=".concat(String.valueOf(k)));
            }
        }
        return sb.toString();
    }

    public static Map<String, String> b(Context context, boolean z) {
        Uri parse = Uri.parse("http://www.paytm.com".concat(String.valueOf(a(context, z))));
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        HashMap hashMap = new HashMap();
        for (String next : queryParameterNames) {
            hashMap.put(next, parse.getQueryParameter(next));
        }
        return hashMap;
    }

    public static String b(Context context) {
        try {
            if (f43765d == null) {
                f43765d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            q.b(e2.getMessage());
        }
        return f43765d;
    }

    public static String a() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, Context context) {
        if (context.getSystemService(ContactColumn.PHONE_NUMBER) == null) {
            f43766e = a.e(context);
            try {
                f43766e = URLEncoder.encode(f43766e, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                q.b(e2.getMessage());
            }
        } else {
            context.getSystemService(ContactColumn.PHONE_NUMBER);
            f43766e = a.e(context);
            try {
                f43766e = URLEncoder.encode(f43766e, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e3) {
                q.b(e3.getMessage());
            }
        }
        f43764c = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("session_id", "", true);
        f43763b = a.q(context);
        try {
            f43765d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            q.b(e4.getMessage());
        }
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        StringBuilder sb = new StringBuilder();
        Uri parse = Uri.parse(str);
        sb.append(str);
        if (parse != null) {
            if (parse.getQuery() != null) {
                sb.append(AppConstants.AND_SIGN);
            } else {
                sb.append("?");
            }
        }
        String str4 = f43763b;
        if (str4 != null && !str4.equalsIgnoreCase("")) {
            sb.append("sso_token=" + f43763b + AppConstants.AND_SIGN);
        }
        if (f43766e != null) {
            if (sb.length() > 1) {
                sb.append("deviceIdentifier=" + f43766e);
            } else {
                sb.append("deviceIdentifier=" + f43766e);
            }
        }
        try {
            String encode = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43767f = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f43767f);
                } else {
                    sb.append("deviceManufacturer=" + f43767f);
                }
            }
        } catch (UnsupportedEncodingException e5) {
            q.b(e5.getMessage());
        } catch (Exception e6) {
            q.b(e6.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str3.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43768g = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f43768g);
                } else {
                    sb.append("deviceName=" + f43768g);
                }
            }
        } catch (UnsupportedEncodingException e7) {
            q.b(e7.getMessage());
        } catch (Exception e8) {
            q.b(e8.getMessage());
        }
        if (f43762a != null) {
            if (sb.length() > 1) {
                sb.append("&client=" + f43762a);
            } else {
                sb.append("client=" + f43762a);
            }
        }
        if (f43765d != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f43765d);
            } else {
                sb.append("version=" + f43765d);
            }
        }
        if (c(context)) {
            if (sb.length() > 1) {
                sb.append("&playStore=true");
            } else {
                sb.append("playStore=true");
            }
        } else if (sb.length() > 1) {
            sb.append("&playStore=false");
        } else {
            sb.append("playStore=false");
        }
        String g2 = a.g(context);
        String h2 = a.h(context);
        if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h2)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + g2 + "&long=" + h2);
            } else {
                sb.append("lat=" + g2 + "&long=" + h2);
            }
        }
        String i2 = a.i(context);
        if (i2 != null && i2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(i2)));
            } else {
                sb.append("language=".concat(String.valueOf(i2)));
            }
        }
        String l = a.l(context);
        if (l != null && l.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(l)));
            } else {
                sb.append("networkType=".concat(String.valueOf(l)));
            }
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(a2)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(a2)));
            }
        }
        String k = a.k(context);
        if (TextUtils.isEmpty(k)) {
            k = "en-IN";
        }
        if (k != null && k.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(k)));
            } else {
                sb.append("locale=".concat(String.valueOf(k)));
            }
        }
        return sb.toString();
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (str != null) {
            try {
                f43765d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                try {
                    q.b(e2.getMessage());
                } catch (Exception e3) {
                    q.b(e3.getMessage());
                }
            }
            Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(str2, str3);
            if (f43762a != null) {
                appendQueryParameter.appendQueryParameter("client", f43762a);
            }
            if (f43765d != null) {
                appendQueryParameter.appendQueryParameter("version", f43765d);
            }
            return appendQueryParameter.build().toString();
        }
        return str;
    }

    public static boolean c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            if (!TextUtils.isEmpty(installerPackageName)) {
                return "com.android.vending".equalsIgnoreCase(installerPackageName);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String b(String str, Context context) {
        if (str == null) {
            return str;
        }
        if (context.getSystemService(ContactColumn.PHONE_NUMBER) == null) {
            f43766e = a.e(context);
            try {
                f43766e = URLEncoder.encode(f43766e, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                q.b(e2.getMessage());
            }
        } else {
            context.getSystemService(ContactColumn.PHONE_NUMBER);
            f43766e = a.e(context);
            try {
                f43766e = URLEncoder.encode(f43766e, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e3) {
                q.b(e3.getMessage());
            }
        }
        f43764c = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("session_id", "", true);
        try {
            f43765d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            q.b(e4.getMessage());
        }
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        StringBuilder sb = new StringBuilder();
        try {
            Uri parse = Uri.parse(str);
            sb.append(str);
            if (parse != null) {
                if (parse.getQuery() != null) {
                    sb.append(AppConstants.AND_SIGN);
                } else {
                    sb.append("?");
                }
            }
        } catch (Exception e5) {
            if (x.j) {
                q.b(e5.getMessage());
            }
        }
        if (f43766e != null) {
            if (sb.length() > 1) {
                sb.append("deviceIdentifier=" + f43766e);
            } else {
                sb.append("deviceIdentifier=" + f43766e);
            }
        }
        try {
            String encode = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43767f = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f43767f);
                } else {
                    sb.append("deviceManufacturer=" + f43767f);
                }
            }
        } catch (UnsupportedEncodingException e6) {
            q.b(e6.getMessage());
        } catch (Exception e7) {
            q.b(e7.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str3.replaceAll(" ", "_"), AppConstants.UTF_8);
            f43768g = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f43768g);
                } else {
                    sb.append("deviceName=" + f43768g);
                }
            }
        } catch (UnsupportedEncodingException e8) {
            q.b(e8.getMessage());
        } catch (Exception e9) {
            q.b(e9.getMessage());
        }
        if (!str.contains("client") && f43762a != null) {
            if (sb.length() > 1) {
                sb.append("&client=" + f43762a);
            } else {
                sb.append("client=" + f43762a);
            }
        }
        if (!str.contains("?version") && !str.contains("&version") && f43765d != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f43765d);
            } else {
                sb.append("version=" + f43765d);
            }
        }
        if (c(context)) {
            if (sb.length() > 1) {
                sb.append("&playStore=true");
            } else {
                sb.append("playStore=true");
            }
        } else if (sb.length() > 1) {
            sb.append("&playStore=false");
        } else {
            sb.append("playStore=false");
        }
        String g2 = a.g(context);
        String h2 = a.h(context);
        if (!TextUtils.isEmpty(g2) && !TextUtils.isEmpty(h2)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + g2 + "&long=" + h2);
            } else {
                sb.append("lat=" + g2 + "&long=" + h2);
            }
        }
        String i2 = a.i(context);
        if (i2 != null && i2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(i2)));
            } else {
                sb.append("language=".concat(String.valueOf(i2)));
            }
        }
        String l = a.l(context);
        if (l != null && l.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(l)));
            } else {
                sb.append("networkType=".concat(String.valueOf(l)));
            }
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(a2)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(a2)));
            }
        }
        String k = a.k(context);
        if (TextUtils.isEmpty(k)) {
            k = "en-IN";
        }
        if (k != null && k.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(k)));
            } else {
                sb.append("locale=".concat(String.valueOf(k)));
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052 A[SYNTHETIC, Splitter:B:13:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[SYNTHETIC, Splitter:B:21:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1 A[SYNTHETIC, Splitter:B:29:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5 A[Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc A[SYNTHETIC, Splitter:B:35:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ec A[SYNTHETIC, Splitter:B:43:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0105 A[SYNTHETIC, Splitter:B:51:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012a A[SYNTHETIC, Splitter:B:59:0x012a] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0141 A[Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0148 A[Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject d(android.content.Context r10) {
        /*
            java.lang.String r0 = "1"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "phone"
            r10.getSystemService(r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = com.paytm.utility.a.e(r10)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r4 = "cookieId"
            java.lang.String r5 = "null"
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r4 = "client"
            java.lang.String r5 = "androidapp"
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r5 = "deviceIdentifier"
            java.lang.String r6 = "UTF-8"
            java.lang.String r7 = ""
            if (r4 != 0) goto L_0x0041
            java.lang.String r4 = r3.trim()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            int r4 = r4.length()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r4 <= 0) goto L_0x0041
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r6)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            r2.put(r5, r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x0044
        L_0x0041:
            r2.put(r5, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x0044:
            java.lang.String r3 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r5 = "_"
            java.lang.String r8 = " "
            java.lang.String r9 = "deviceManufacturer"
            if (r4 != 0) goto L_0x0068
            java.lang.String r4 = r3.trim()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            int r4 = r4.length()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r4 <= 0) goto L_0x0068
            java.lang.String r3 = r3.replaceAll(r8, r5)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r6)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            r2.put(r9, r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x006b
        L_0x0068:
            r2.put(r9, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x006b:
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r9 = "deviceName"
            if (r4 != 0) goto L_0x008b
            java.lang.String r4 = r3.trim()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            int r4 = r4.length()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r4 <= 0) goto L_0x008b
            java.lang.String r3 = r3.replaceAll(r8, r5)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r6)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            r2.put(r9, r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x008e
        L_0x008b:
            r2.put(r9, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x008e:
            java.lang.String r3 = "ipAddress"
            java.lang.String r4 = "127.0.0.1"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = com.paytm.utility.a.k(r10)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r5 = "language"
            if (r4 != 0) goto L_0x00a5
            r2.put(r5, r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x00aa
        L_0x00a5:
            java.lang.String r3 = "en-IN"
            r2.put(r5, r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x00aa:
            java.lang.String r3 = com.paytm.utility.a.g(r10)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r4 = com.paytm.utility.a.h(r10)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r6 = "long"
            java.lang.String r8 = "lat"
            if (r5 != 0) goto L_0x00c9
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r5 != 0) goto L_0x00c9
            r2.put(r8, r3)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            r2.put(r6, r4)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x00cf
        L_0x00c9:
            r2.put(r8, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            r2.put(r6, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x00cf:
            java.lang.String r3 = "location"
            java.lang.String r4 = "India"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = "mappedDeviceFlag"
            r2.put(r3, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = "mappedSimFlag"
            r2.put(r3, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r0 = com.paytm.utility.a.l(r10)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r4 = "networkType"
            if (r3 != 0) goto L_0x00f6
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r3 != 0) goto L_0x00f6
            r2.put(r4, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x00f9
        L_0x00f6:
            r2.put(r4, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x00f9:
            java.lang.String r0 = a()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r4 = "osVersion"
            if (r3 != 0) goto L_0x010f
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r3 != 0) goto L_0x010f
            r2.put(r4, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x0112
        L_0x010f:
            r2.put(r4, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x0112:
            android.content.pm.PackageManager r0 = r10.getPackageManager()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r3 = r10.getPackageName()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r0 = r0.versionName     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r5 = "version"
            if (r3 != 0) goto L_0x0138
            java.lang.String r3 = r0.trim()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            int r3 = r3.length()     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r3 <= 0) goto L_0x0138
            r2.put(r5, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x013b
        L_0x0138:
            r2.put(r5, r7)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x013b:
            boolean r10 = c(r10)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            if (r10 == 0) goto L_0x0148
            java.lang.String r10 = "playStore"
            r0 = 1
            r2.put(r10, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x014d
        L_0x0148:
            java.lang.String r10 = "playStore"
            r2.put(r10, r4)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
        L_0x014d:
            java.lang.String r10 = "User-Agent"
            java.lang.String r0 = "Android"
            r2.put(r10, r0)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            java.lang.String r10 = "deviceInfo"
            r1.put(r10, r2)     // Catch:{ JSONException -> 0x016c, UnsupportedEncodingException -> 0x0163, NameNotFoundException -> 0x015a }
            goto L_0x0174
        L_0x015a:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.b(r10)
            goto L_0x0174
        L_0x0163:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.b(r10)
            goto L_0x0174
        L_0x016c:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.b(r10)
        L_0x0174:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.c.d(android.content.Context):org.json.JSONObject");
    }
}
