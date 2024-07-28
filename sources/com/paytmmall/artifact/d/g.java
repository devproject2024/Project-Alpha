package com.paytmmall.artifact.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f15712a = "CJRDefaultRequestParam";

    /* renamed from: b  reason: collision with root package name */
    private static String f15713b;

    /* renamed from: c  reason: collision with root package name */
    private static String f15714c;

    /* renamed from: d  reason: collision with root package name */
    private static String f15715d;

    /* renamed from: e  reason: collision with root package name */
    private static String f15716e;

    /* renamed from: f  reason: collision with root package name */
    private static String f15717f;

    /* renamed from: g  reason: collision with root package name */
    private static String f15718g;

    /* renamed from: h  reason: collision with root package name */
    private static String f15719h;

    public static String a(Context context) {
        context.getSystemService(ContactColumn.PHONE_NUMBER);
        f15715d = u.a(context.getApplicationContext()).b("session_id", "", true);
        f15714c = i.a(context);
        try {
            f15716e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.c(e2.getMessage());
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        f15717f = c.a(context);
        try {
            f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e3) {
            q.c(e3.getMessage());
        }
        StringBuilder sb = new StringBuilder("?");
        if (f15717f != null) {
            if (sb.length() > 1) {
                sb.append("&deviceIdentifier=" + f15717f);
            } else {
                sb.append("deviceIdentifier=" + f15717f);
            }
        }
        try {
            String encode = URLEncoder.encode(str.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15718g = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f15718g);
                } else {
                    sb.append("deviceManufacturer=" + f15718g);
                }
            }
        } catch (UnsupportedEncodingException e4) {
            q.c(e4.getMessage());
        } catch (Exception e5) {
            q.c(e5.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15719h = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f15719h);
                } else {
                    sb.append("deviceName=" + f15719h);
                }
            }
        } catch (UnsupportedEncodingException e6) {
            q.c(e6.getMessage());
        } catch (Exception e7) {
            q.c(e7.getMessage());
        }
        String str3 = f15713b;
        if (str3 != null) {
            if (sb.length() > 1) {
                sb.append("&client=".concat(String.valueOf(str3)));
            } else {
                sb.append("client=".concat(String.valueOf(str3)));
            }
        }
        if (f15716e != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f15716e);
            } else {
                sb.append("version=" + f15716e);
            }
        }
        if (b(context)) {
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
        String d2 = b.d(context);
        String e8 = b.e(context);
        if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(e8)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + d2 + "&long=" + e8);
            } else {
                sb.append("lat=" + d2 + "&long=" + e8);
            }
        }
        a(context, sb);
        String c2 = c.c(context);
        if (c2 != null && c2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(c2)));
            } else {
                sb.append("language=".concat(String.valueOf(c2)));
            }
        }
        String d3 = c.d(context);
        if (d3 != null && d3.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(d3)));
            } else {
                sb.append("networkType=".concat(String.valueOf(d3)));
            }
        }
        String e9 = c.e(context);
        if (!TextUtils.isEmpty(e9)) {
            if (sb.length() > 1) {
                sb.append("&imei=".concat(String.valueOf(e9)));
            } else {
                sb.append("imei=".concat(String.valueOf(e9)));
            }
        }
        String c3 = c();
        if (!TextUtils.isEmpty(c())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(c3)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(c3)));
            }
        }
        String a2 = r.a(context);
        if (a2 != null) {
            int intValue = k.f15725a.get(a2).intValue();
            if (intValue == 0) {
                intValue = 1;
            }
            sb.append("&lang_id=".concat(String.valueOf(intValue)));
        }
        String f2 = c.f(context);
        if (TextUtils.isEmpty(f2)) {
            f2 = "en-IN";
        }
        if (f2 != null && f2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(f2)));
            } else {
                sb.append("locale=".concat(String.valueOf(f2)));
            }
        }
        return sb.toString();
    }

    private static void a(Context context, StringBuilder sb) {
        String a2 = b.a(context);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (sb.length() > 1) {
            sb.append("&pincode=".concat(String.valueOf(a2)));
        } else {
            sb.append("pincode=".concat(String.valueOf(a2)));
        }
    }

    public static String a() {
        Context applicationContext = t.e().getApplicationContext();
        applicationContext.getSystemService(ContactColumn.PHONE_NUMBER);
        f15715d = u.a(applicationContext.getApplicationContext()).b("session_id", "", true);
        f15714c = i.a(applicationContext);
        try {
            f15716e = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.c(e2.getMessage());
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        f15717f = c.a(applicationContext);
        try {
            f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e3) {
            q.c(e3.getMessage());
        }
        StringBuilder sb = new StringBuilder("?");
        if (f15717f != null) {
            if (sb.length() > 1) {
                sb.append("&deviceIdentifier=" + f15717f);
            } else {
                sb.append("deviceIdentifier=" + f15717f);
            }
        }
        try {
            String encode = URLEncoder.encode(str.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15718g = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f15718g);
                } else {
                    sb.append("deviceManufacturer=" + f15718g);
                }
            }
        } catch (UnsupportedEncodingException e4) {
            q.c(e4.getMessage());
        } catch (Exception e5) {
            q.c(e5.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15719h = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f15719h);
                } else {
                    sb.append("deviceName=" + f15719h);
                }
            }
        } catch (UnsupportedEncodingException e6) {
            q.c(e6.getMessage());
        } catch (Exception e7) {
            q.c(e7.getMessage());
        }
        String f2 = d.f();
        if (f2 != null) {
            if (sb.length() > 1) {
                sb.append("&client=".concat(String.valueOf(f2)));
            } else {
                sb.append("client=".concat(String.valueOf(f2)));
            }
        }
        if (f15716e != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f15716e);
            } else {
                sb.append("version=" + f15716e);
            }
        }
        if (b(applicationContext)) {
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
        String d2 = b.d(applicationContext);
        String e8 = b.e(applicationContext);
        if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(e8)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + d2 + "&long=" + e8);
            } else {
                sb.append("lat=" + d2 + "&long=" + e8);
            }
        }
        a(applicationContext, sb);
        String c2 = c.c(applicationContext);
        if (c2 != null && c2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(c2)));
            } else {
                sb.append("language=".concat(String.valueOf(c2)));
            }
        }
        String d3 = c.d(applicationContext);
        if (d3 != null && d3.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(d3)));
            } else {
                sb.append("networkType=".concat(String.valueOf(d3)));
            }
        }
        String e9 = c.e(applicationContext);
        if (!TextUtils.isEmpty(e9)) {
            if (sb.length() > 1) {
                sb.append("&imei=".concat(String.valueOf(e9)));
            } else {
                sb.append("imei=".concat(String.valueOf(e9)));
            }
        }
        String c3 = c();
        if (!TextUtils.isEmpty(c())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(c3)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(c3)));
            }
        }
        String g2 = c.g(applicationContext);
        if (!TextUtils.isEmpty(g2)) {
            if (sb.length() > 1) {
                sb.append("&sim1=".concat(String.valueOf(g2)));
            } else {
                sb.append("sim1=".concat(String.valueOf(g2)));
            }
        }
        String f3 = c.f(applicationContext);
        if (TextUtils.isEmpty(f3)) {
            f3 = "en-IN";
        }
        if (f3 != null && f3.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(f3)));
            } else {
                sb.append("locale=".concat(String.valueOf(f3)));
            }
        }
        return sb.toString();
    }

    public static Map<String, String> b() {
        Context applicationContext = t.e().getApplicationContext();
        applicationContext.getSystemService(ContactColumn.PHONE_NUMBER);
        f15715d = u.a(applicationContext.getApplicationContext()).b("session_id", "", true);
        f15714c = i.a(applicationContext);
        try {
            f15716e = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            q.c(e2.getMessage());
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        f15717f = c.a(applicationContext);
        try {
            f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e3) {
            q.c(e3.getMessage());
        }
        HashMap hashMap = new HashMap();
        String str3 = f15714c;
        if (str3 != null && str3.length() > 0) {
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, f15714c);
        }
        String str4 = f15717f;
        if (str4 != null) {
            hashMap.put("deviceIdentifier", str4);
        }
        try {
            String encode = URLEncoder.encode(str.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15718g = encode;
            if (encode != null) {
                hashMap.put("deviceManufacturer", f15718g);
            }
        } catch (UnsupportedEncodingException e4) {
            q.c(e4.getMessage());
        } catch (Exception e5) {
            q.c(e5.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15719h = encode2;
            if (encode2 != null) {
                hashMap.put("deviceName", f15719h);
            }
        } catch (UnsupportedEncodingException e6) {
            q.c(e6.getMessage());
        } catch (Exception e7) {
            q.c(e7.getMessage());
        }
        String f2 = d.f();
        if (f2 != null) {
            hashMap.put("client", f2);
        }
        String str5 = f15716e;
        if (str5 != null) {
            hashMap.put("version", str5);
        }
        if (b(applicationContext)) {
            hashMap.put("playStore", "true");
        } else {
            hashMap.put("playStore", "false");
        }
        String d2 = b.d(applicationContext);
        String e8 = b.e(applicationContext);
        if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(e8)) {
            hashMap.put("lat", d2);
            hashMap.put("long", e8);
        }
        String a2 = b.a(applicationContext);
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, a2);
        }
        String c2 = c.c(applicationContext);
        if (c2 != null && c2.trim().length() > 0) {
            hashMap.put("language", c2);
        }
        String d3 = c.d(applicationContext);
        if (d3 != null && d3.trim().length() > 0) {
            hashMap.put("networkType", d3);
        }
        String e9 = c.e(applicationContext);
        if (!TextUtils.isEmpty(e9)) {
            hashMap.put("imei", e9);
        }
        String c3 = c();
        if (!TextUtils.isEmpty(c3)) {
            hashMap.put("osVersion", c3);
        }
        String a3 = r.a(applicationContext);
        if (!TextUtils.isEmpty(a3)) {
            int intValue = k.f15725a.get(a3).intValue();
            if (intValue == 0) {
                intValue = 1;
            }
            hashMap.put(com.business.merchant_payments.common.utility.AppConstants.TAG_LANG_ID, String.valueOf(intValue));
        }
        hashMap.put(com.business.merchant_payments.common.utility.AppConstants.TAG_DEVICE, "android");
        return hashMap;
    }

    private static String c() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, Context context) {
        if (context.getSystemService(ContactColumn.PHONE_NUMBER) == null) {
            f15717f = c.a(context);
            try {
                f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                q.c(e2.getMessage());
            }
        } else {
            context.getSystemService(ContactColumn.PHONE_NUMBER);
            f15717f = c.a(context);
            try {
                f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e3) {
                q.c(e3.getMessage());
            }
        }
        f15715d = u.a(context.getApplicationContext()).b("session_id", "", true);
        f15714c = i.a(context);
        try {
            f15716e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            q.c(e4.getMessage());
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
        String str4 = f15714c;
        if (str4 != null && !str4.equalsIgnoreCase("")) {
            sb.append("sso_token=" + f15714c + AppConstants.AND_SIGN);
        }
        if (f15717f != null) {
            if (sb.length() > 1) {
                sb.append("deviceIdentifier=" + f15717f);
            } else {
                sb.append("deviceIdentifier=" + f15717f);
            }
        }
        try {
            String encode = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15718g = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f15718g);
                } else {
                    sb.append("deviceManufacturer=" + f15718g);
                }
            }
        } catch (UnsupportedEncodingException e5) {
            q.c(e5.getMessage());
        } catch (Exception e6) {
            q.c(e6.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str3.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15719h = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f15719h);
                } else {
                    sb.append("deviceName=" + f15719h);
                }
            }
        } catch (UnsupportedEncodingException e7) {
            q.c(e7.getMessage());
        } catch (Exception e8) {
            q.c(e8.getMessage());
        }
        String f2 = d.f();
        if (f2 != null) {
            if (sb.length() > 1) {
                sb.append("&client=".concat(String.valueOf(f2)));
            } else {
                sb.append("client=".concat(String.valueOf(f2)));
            }
        }
        if (f15716e != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f15716e);
            } else {
                sb.append("version=" + f15716e);
            }
        }
        if (b(context)) {
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
        String d2 = b.d(context);
        String e9 = b.e(context);
        if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(e9)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + d2 + "&long=" + e9);
            } else {
                sb.append("lat=" + d2 + "&long=" + e9);
            }
        }
        a(context, sb);
        String c2 = c.c(context);
        if (c2 != null && c2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(c2)));
            } else {
                sb.append("language=".concat(String.valueOf(c2)));
            }
        }
        String d3 = c.d(context);
        if (d3 != null && d3.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(d3)));
            } else {
                sb.append("networkType=".concat(String.valueOf(d3)));
            }
        }
        String e10 = c.e(context);
        if (!TextUtils.isEmpty(e10)) {
            if (sb.length() > 1) {
                sb.append("&imei=".concat(String.valueOf(e10)));
            } else {
                sb.append("imei=".concat(String.valueOf(e10)));
            }
        }
        String c3 = c();
        if (!TextUtils.isEmpty(c())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(c3)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(c3)));
            }
        }
        String a2 = c.a();
        if (!TextUtils.isEmpty(a2)) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(a2)));
            } else {
                sb.append("locale=".concat(String.valueOf(a2)));
            }
        }
        return sb.toString();
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (str != null) {
            try {
                f15716e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                try {
                    q.c(e2.getMessage());
                } catch (Exception e3) {
                    q.c(e3.getMessage());
                }
            }
            Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(str2, str3);
            String f2 = d.f();
            if (f2 != null) {
                appendQueryParameter.appendQueryParameter("client", f2);
            }
            if (f15716e != null) {
                appendQueryParameter.appendQueryParameter("version", f15716e);
            }
            return appendQueryParameter.build().toString();
        }
        return str;
    }

    private static boolean b(Context context) {
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
        return c(str, context);
    }

    public static String c(String str, Context context) {
        String f2;
        if (str == null) {
            return str;
        }
        if (context.getSystemService(ContactColumn.PHONE_NUMBER) == null) {
            f15717f = c.a(context);
            try {
                f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                q.c(e2.getMessage());
            }
        } else {
            context.getSystemService(ContactColumn.PHONE_NUMBER);
            f15717f = c.a(context);
            try {
                f15717f = URLEncoder.encode(f15717f, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e3) {
                q.c(e3.getMessage());
            }
        }
        f15715d = u.a(context.getApplicationContext()).b("session_id", "", true);
        try {
            f15716e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            q.c(e4.getMessage());
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
            q.c(e5.getMessage());
        }
        if (f15717f != null) {
            if (sb.length() > 1) {
                sb.append("deviceIdentifier=" + f15717f);
            } else {
                sb.append("deviceIdentifier=" + f15717f);
            }
        }
        try {
            String encode = URLEncoder.encode(str2.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15718g = encode;
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=" + f15718g);
                } else {
                    sb.append("deviceManufacturer=" + f15718g);
                }
            }
        } catch (UnsupportedEncodingException e6) {
            q.c(e6.getMessage());
        } catch (Exception e7) {
            q.c(e7.getMessage());
        }
        try {
            String encode2 = URLEncoder.encode(str3.replaceAll(" ", "_"), AppConstants.UTF_8);
            f15719h = encode2;
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=" + f15719h);
                } else {
                    sb.append("deviceName=" + f15719h);
                }
            }
        } catch (UnsupportedEncodingException e8) {
            q.c(e8.getMessage());
        } catch (Exception e9) {
            q.c(e9.getMessage());
        }
        if (!str.contains("client") && (f2 = d.f()) != null) {
            if (sb.length() > 1) {
                sb.append("&client=".concat(String.valueOf(f2)));
            } else {
                sb.append("client=".concat(String.valueOf(f2)));
            }
        }
        if (!str.contains("?version") && !str.contains("&version") && f15716e != null) {
            if (sb.length() > 1) {
                sb.append("&version=" + f15716e);
            } else {
                sb.append("version=" + f15716e);
            }
        }
        if (b(context)) {
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
        String d2 = b.d(context);
        String e10 = b.e(context);
        if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(e10)) {
            if (sb.length() > 1) {
                sb.append("&lat=" + d2 + "&long=" + e10);
            } else {
                sb.append("lat=" + d2 + "&long=" + e10);
            }
        }
        a(context, sb);
        String c2 = c.c(context);
        if (c2 != null && c2.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(c2)));
            } else {
                sb.append("language=".concat(String.valueOf(c2)));
            }
        }
        String d3 = c.d(context);
        if (d3 != null && d3.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(d3)));
            } else {
                sb.append("networkType=".concat(String.valueOf(d3)));
            }
        }
        String e11 = c.e(context);
        if (!TextUtils.isEmpty(e11)) {
            if (sb.length() > 1) {
                sb.append("&imei=".concat(String.valueOf(e11)));
            } else {
                sb.append("imei=".concat(String.valueOf(e11)));
            }
        }
        String c3 = c();
        if (!TextUtils.isEmpty(c())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(c3)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(c3)));
            }
        }
        String a2 = c.a();
        if (!TextUtils.isEmpty(a2)) {
            if (sb.length() > 1) {
                sb.append("&locale=".concat(String.valueOf(a2)));
            } else {
                sb.append("locale=".concat(String.valueOf(a2)));
            }
        }
        return sb.toString();
    }

    public static void a(Map<String, String> map) {
        f15713b = map.get("CLIENT");
    }
}
