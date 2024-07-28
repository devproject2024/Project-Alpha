package com.paytm.utility;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gson.f;
import com.paytm.b.a.a;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.paytm.utility.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiContract;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f43688a = "clientId";

    /* renamed from: b  reason: collision with root package name */
    public static String f43689b = "mid";

    /* renamed from: c  reason: collision with root package name */
    public static String f43690c = "requestId";

    /* renamed from: d  reason: collision with root package name */
    public static String f43691d = "token";

    /* renamed from: e  reason: collision with root package name */
    public static String f43692e = "version";

    /* renamed from: f  reason: collision with root package name */
    public static String f43693f = "deviceId";

    /* renamed from: g  reason: collision with root package name */
    public static String f43694g = "channelId";

    /* renamed from: h  reason: collision with root package name */
    public static String f43695h = "industryTypeId";

    /* renamed from: i  reason: collision with root package name */
    public static String f43696i = "orderAmount";
    public static String j = "instrumentTypes";
    public static String k = "savedInstrumentsTypes";
    public static String l = "extendInfo";
    public static String m = "signature";
    public static String n = "head";
    public static String o = "body";
    public static String p = "value";
    public static String q = "currency";
    public static String r = "orderId";
    public static String s = "SMART_NOTIFICATION_ID";
    public static String t = null;
    public static String u = null;
    @Deprecated
    public static final boolean v = x.j;
    private static String w = null;
    private static String x = "paytm";
    private static ProgressDialog y = null;
    private static int z = -1;

    public static String a() {
        return "sso";
    }

    public static boolean r() {
        return true;
    }

    public static int a(int i2, Context context) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static void a(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }

    public static String a(Context context) {
        return a.i(context);
    }

    public static int a(Activity activity) {
        return a.a(activity);
    }

    public static int b(Activity activity) {
        return a.b(activity);
    }

    public static String b() {
        return a.e();
    }

    public static String c() {
        return a.f();
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean a(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String b(Context context) {
        return a.l(context);
    }

    public static boolean c(Context context) {
        return a.m(context);
    }

    public static String d(Context context) {
        return a.f(context);
    }

    public static String e(Context context) {
        return a.e(context);
    }

    public static String a(String str) {
        return a.c(str);
    }

    public static int f(Context context) {
        return a.t(context);
    }

    public static int g(Context context) {
        return a.u(context);
    }

    public static String b(Context context, String str) {
        return c.a(str, context);
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str).find();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(SDKConstants.MOB_NO_REG_EX).matcher(str).matches();
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(AppConstants.EMAIL_REG_EX).matcher(str).find();
    }

    public static String h(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = a.a(context.getApplicationContext(), a.c.UTILITY).b("first name", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String i(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("last name", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String j(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("userName", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static int k(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("isVerifiedMobile", 0, true);
        }
        return 0;
    }

    public static String l(Context context) {
        return a.b(context);
    }

    public static String m(Context context) {
        return a.c(context);
    }

    public static String n(Context context) {
        return a.a(context);
    }

    public static boolean o(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("isGoldUser", false, true);
        }
        return false;
    }

    public static boolean p(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("isBankCustomer", false, false);
        }
        return false;
    }

    public static boolean q(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("isEmailNotificationEnabled", false, false);
        }
        return false;
    }

    public static boolean r(Context context) {
        return a.p(context);
    }

    public static String s(Context context) {
        return a.g(context);
    }

    public static String t(Context context) {
        return a.h(context);
    }

    public static String u(Context context) {
        return a.s(context);
    }

    public static String e(String str) {
        try {
            Matcher matcher = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String f(String str) {
        try {
            Matcher matcher = Pattern.compile("https?:\\/\\/(?:[0-9A-Z-]+\\.)?(?:youtu\\.be\\/|youtube\\.com\\S*[^\\w\\-\\s])([\\w\\-]{11})(?=[^\\w\\-]|$)(?![?=&+%\\w]*(?:['\"][^<>]*>|<\\/a>))[?=&+%\\w]*", 2).matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String g(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("/p/")) {
                return "product";
            }
            if (str.contains("/g/")) {
                return CLPConstants.DEFAULT_GRID_VIEW_TYPE;
            }
            if (str.contains("/h/")) {
                return CLPConstants.URL_TYPE_EMBED;
            }
        }
        return "";
    }

    public static byte[] h(String str) {
        byte[] byteArray = new BigInteger(str, 36).toByteArray();
        return Arrays.copyOfRange(byteArray, 1, byteArray.length);
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = (bArr[i2] >>> 4) & 15;
            int i3 = 0;
            while (true) {
                if (b2 < 0 || b2 > 9) {
                    stringBuffer.append((char) ((b2 - 10) + 97));
                } else {
                    stringBuffer.append((char) (b2 + TarHeader.LF_NORMAL));
                }
                b2 = bArr[i2] & 15;
                int i4 = i3 + 1;
                if (i3 > 0) {
                    break;
                }
                i3 = i4;
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] i(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String e() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            return a(instance.generateKey().getEncoded());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String f() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return a(bArr);
    }

    public static String v(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
    }

    public static String w(Context context) {
        return a.k(context);
    }

    public static boolean j(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("hi") || str.equalsIgnoreCase("en") || str.equalsIgnoreCase("ta") || str.equalsIgnoreCase("te") || str.equalsIgnoreCase("kn") || str.equalsIgnoreCase("pa") || str.equalsIgnoreCase("mr") || str.equalsIgnoreCase("gu") || str.equalsIgnoreCase("bn") || str.equalsIgnoreCase("or") || str.equalsIgnoreCase("ml");
        }
        return false;
    }

    public static String g() {
        if (n.b() == 1) {
            return "en-IN";
        }
        String language = Locale.getDefault().getLanguage();
        return language + "-IN";
    }

    public static boolean k(String str) {
        return str.startsWith("https://play.google.com/store/apps/") || str.startsWith("http://play.google.com/store/apps/");
    }

    public static String l(String str) {
        if (str.startsWith("https://play.google.com/store/apps/")) {
            return "https://play.google.com/store/apps/";
        }
        if (str.startsWith("http://play.google.com/store/apps/")) {
            return "http://play.google.com/store/apps/";
        }
        return "";
    }

    public static boolean m(String str) {
        return str.startsWith("market://");
    }

    public static boolean n(String str) {
        return str.startsWith("http://m.p-y.tm") || str.startsWith("https://m.p-y.tm") || str.startsWith("https://p-y.tm") || str.startsWith("http://p-y.tm");
    }

    public static void x(Context context) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("isCreditCard", true, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = com.paytm.b.a.a.a(r3.getApplicationContext(), com.paytm.network.a.c.UTILITY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean y(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0019
            android.content.Context r3 = r3.getApplicationContext()
            com.paytm.network.a$c r1 = com.paytm.network.a.c.UTILITY
            com.paytm.b.a.a r3 = com.paytm.b.a.a.a((android.content.Context) r3, (com.paytm.network.a.c) r1)
            if (r3 == 0) goto L_0x0019
            r1 = 1
            java.lang.String r2 = "isCreditCard"
            boolean r3 = r3.b((java.lang.String) r2, (boolean) r0, (boolean) r1)
            if (r3 == 0) goto L_0x0019
            return r1
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.b.y(android.content.Context):boolean");
    }

    public static boolean a(List<String> list, String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String startsWith : list) {
                if (str.startsWith(startsWith)) {
                    return true;
                }
            }
        }
        if (r(str) || Z(str) || aa(str)) {
            return true;
        }
        return false;
    }

    public static String h() {
        return a.a();
    }

    public static String i() {
        return a.b();
    }

    public static boolean o(String str) {
        return str.startsWith("paytmmp://") || str.startsWith("paytmmall://");
    }

    public static boolean p(String str) {
        return str.startsWith("upi://");
    }

    public static boolean q(String str) {
        return str.startsWith("000201");
    }

    public static boolean r(String str) {
        if (!s(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            Pattern compile = Pattern.compile("https?:\\/\\/([a-z0-9]+[.])*(paytm.com?)$");
            return compile.matcher(url.getProtocol() + "://" + url.getHost()).find();
        } catch (MalformedURLException e2) {
            if (!v) {
                return false;
            }
            q.b(e2.getMessage());
            return false;
        }
    }

    private static boolean Z(String str) {
        if (!s(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            Pattern compile = Pattern.compile("https?:\\/\\/([a-z0-9]+[.])*(paytmmall.com?)$");
            return compile.matcher(url.getProtocol() + "://" + url.getHost()).find();
        } catch (MalformedURLException e2) {
            if (!v) {
                return false;
            }
            q.b(e2.getMessage());
            return false;
        }
    }

    private static boolean aa(String str) {
        if (!s(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            Pattern compile = Pattern.compile("https?:\\/\\/([a-z0-9]+[.])*(gamepind.com?)$");
            return compile.matcher(url.getProtocol() + "://" + url.getHost()).find();
        } catch (MalformedURLException e2) {
            if (!v) {
                return false;
            }
            q.b(e2.getMessage());
            return false;
        }
    }

    public static boolean s(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException e2) {
            if (v) {
                q.b(e2.getMessage());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean t(String str) {
        return Pattern.compile("((?:http|https)://)?(?:www\\.)?[\\w\\d\\-_]+\\.\\w{2,3}(\\.\\w{2})?(/(?<=/)(?:[\\w\\d\\-./_]+)?)?(\\?.+)?").matcher(str).find();
    }

    public static boolean u(String str) {
        return str.startsWith(x.f43873h);
    }

    public static String a(String str, String str2) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(Long.parseLong(str2)));
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static int b(int i2, Context context) {
        return Math.round(((float) i2) / (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public static String z(Context context) {
        try {
            context.getSystemService(ContactColumn.PHONE_NUMBER);
            return a.e(context);
        } catch (Exception e2) {
            if (x.j) {
                q.b(e2.getMessage());
            }
            return null;
        }
    }

    public static String A(Context context) {
        return a.d(context);
    }

    public static void j() {
        a.c();
    }

    public static void b(Context context, String str, String str2, boolean z2) {
        a(context, str, str2, z2);
    }

    public static String B(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static InputFilter a(final int i2) {
        return new InputFilter() {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f43698b = 2;

            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                StringBuilder sb = new StringBuilder(spanned);
                sb.append(charSequence);
                if (sb.toString().equals(AppUtility.CENTER_DOT)) {
                    return "";
                }
                StringBuilder sb2 = new StringBuilder(spanned);
                sb2.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder("(([1-9]{1})([0-9]{0,");
                sb4.append(i2 - 1);
                sb4.append("})?)?(\\.[0-9]{0,");
                sb4.append(this.f43698b);
                sb4.append("})?");
                if (sb3.matches(sb4.toString())) {
                    return null;
                }
                if (charSequence.length() == 0) {
                    return spanned.subSequence(i4, i5);
                }
                return "";
            }
        };
    }

    public static String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String[] split = str.toLowerCase().split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < split.length; i2++) {
                sb.append(Character.toUpperCase(split[i2].charAt(0)));
                sb.append(split[i2].substring(1));
                if (i2 < split.length - 1) {
                    sb.append(' ');
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String w(String str) {
        for (String str2 : str.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN)) {
            if (str2.startsWith("paytmqr")) {
                String[] split = str2.split("=");
                if (split.length > 1 && split[1].length() == 24) {
                    return split[1];
                }
            }
        }
        return null;
    }

    public static String a(String str, int i2, int i3) {
        String str2 = Math.abs(i2) + "x" + Math.abs(i3) + "/";
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.insert(sb.lastIndexOf("/") + 1, str2);
        return sb.toString();
    }

    public static String c(Context context, String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + a.q(context);
    }

    public static String d(Context context, String str) {
        String b2 = c.b(str, context);
        if (!a.p(context)) {
            return b2;
        }
        String a2 = a.a(context);
        if (TextUtils.isEmpty(a2)) {
            return b2;
        }
        return b2 + "&custId=" + a2;
    }

    public static String a(String str, Map<String, String> map) {
        if (!URLUtil.isValidUrl(str)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        String b2 = c.b(str, context);
        if (a.p(context)) {
            String a2 = a.a(context);
            if (!TextUtils.isEmpty(a2)) {
                b2 = b2 + "&custId=" + a2;
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            b2 = b2 + "&sessionId=" + str4;
        }
        if (!TextUtils.isEmpty(str2)) {
            b2 = b2 + "&movieCode=" + str2;
        }
        if (TextUtils.isEmpty(str3)) {
            return b2;
        }
        return b2 + "&cinemaID=" + str3;
    }

    public static String e(Context context, String str) {
        String a2 = c.a(context);
        if (!TextUtils.isEmpty(str) && str.contains("?") && !TextUtils.isEmpty(a2) && a2.length() > 0) {
            a2 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + a2.substring(1);
        }
        return str + a2;
    }

    public static String C(Context context) {
        String h2 = h(context);
        String i2 = i(context);
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (TextUtils.isEmpty(h2)) {
            h2 = str;
        }
        sb.append(h2);
        if (!TextUtils.isEmpty(i2)) {
            str = " ".concat(String.valueOf(i2));
        }
        sb.append(str);
        return sb.toString();
    }

    public static String D(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("userImage", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static int E(Context context) {
        return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("isVerifiedEmail", 0, true);
    }

    public static String F(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("user_dob", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String G(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("user_gender", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String H(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("kyc_state", "", true);
        }
        return null;
    }

    public static boolean I(Context context) {
        if (context != null) {
            return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("isPrime", false, true);
        }
        return false;
    }

    public static String J(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("userType", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String K(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("user_Type_merchant", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static boolean L(Context context) {
        return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("key_user_is_sign_in_shown", false, true);
    }

    public static String k() {
        return x.f43867b;
    }

    public static String l() {
        return x.f43868c;
    }

    public static String m() {
        return x.f43869d;
    }

    public static Map<String, String> M(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppConstants.KEY_EMAIL, a.c(context));
        hashMap.put(ContactColumn.PHONE_NUMBER, a.b(context));
        hashMap.put("displayName", aa(context));
        hashMap.put("firstName", h(context));
        hashMap.put("lastName", i(context));
        hashMap.put("gender", G(context));
        hashMap.put("profileImage", a.x(context));
        return hashMap;
    }

    public static String x(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(AppConstants.PRICE_PATTERN);
            return decimalFormat.format((double) Float.parseFloat(str));
        } catch (Exception unused) {
            return new DecimalFormat(AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
        }
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(str2);
            return decimalFormat.format((double) Float.parseFloat(str));
        } catch (Exception unused) {
            return new DecimalFormat(str2).format((double) Float.parseFloat(str));
        }
    }

    public static String a(double d2) {
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(AppConstants.PRICE_PATTERN);
            return decimalFormat.format(d2);
        } catch (Exception unused) {
            return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
        }
    }

    public static int N(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void d(Context context, String str, String str2) {
        if (context != null) {
            String string = context.getResources().getString(R.string.message_error_data_display);
            if (!TextUtils.isEmpty(str)) {
                string = string + "(" + str + ")";
            }
            if (!TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase(H5BridgeContext.INVALID_ID)) {
                string = string + "| Http Code " + str2;
            }
            a(context, context.getResources().getString(R.string.error_data_display), string, false);
        }
    }

    public static void f(Context context, String str) {
        if (context != null) {
            String string = context.getResources().getString(R.string.trains_message_error_data_display);
            if (!TextUtils.isEmpty(str)) {
                string = string + "(" + str + ")";
            }
            a(context, context.getResources().getString(R.string.error_data_display), string, false);
        }
    }

    public static void g(Context context, String str) {
        if (context != null) {
            String string = context.getResources().getString(R.string.flight_message_error_data_display);
            if (!TextUtils.isEmpty(str)) {
                string = string + "(" + str + ")";
            }
            a(context, context.getResources().getString(R.string.error_data_display), string, false);
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (str2.equals("HHmm") && str.length() != 4) {
                str = v.a(str, 4, '0');
            }
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
        } catch (Exception e2) {
            if (!v) {
                return "";
            }
            q.b(e2.getMessage());
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3, Locale.ENGLISH).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
        } catch (ParseException e2) {
            if (v) {
                q.b(e2.getMessage());
            }
            return "";
        } catch (Exception e3) {
            if (v) {
                q.b(e3.getMessage());
            }
            return "";
        }
    }

    public static String c(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3, Locale.ENGLISH).format(new SimpleDateFormat(str2, new Locale(n.a())).parse(str));
        } catch (ParseException e2) {
            if (v) {
                q.b(e2.getMessage());
            }
            return "";
        } catch (Exception e3) {
            if (v) {
                q.b(e3.getMessage());
            }
            return "";
        }
    }

    public static String a(Long l2) {
        try {
            return new SimpleDateFormat("dd MMMM yy", Locale.ENGLISH).format(new Date(l2.longValue()));
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static String d(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, new Locale(n.a())).parse(str));
        } catch (ParseException e2) {
            if (v) {
                q.b(e2.getMessage());
            }
            return "";
        } catch (Exception e3) {
            if (v) {
                q.b(e3.getMessage());
            }
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x002e
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x002e
            r1 = 0
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0021 }
            r2.<init>(r4)     // Catch:{ ParseException -> 0x0021 }
            java.util.Date r4 = r2.parse(r3)     // Catch:{ ParseException -> 0x0021 }
            java.lang.String r2 = r2.format(r4)     // Catch:{ ParseException -> 0x001f }
            boolean r3 = r3.equals(r2)     // Catch:{ ParseException -> 0x001f }
            if (r3 != 0) goto L_0x002a
            r4 = r1
            goto L_0x002a
        L_0x001f:
            r3 = move-exception
            goto L_0x0023
        L_0x0021:
            r3 = move-exception
            r4 = r1
        L_0x0023:
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x002a:
            if (r4 == 0) goto L_0x002e
            r3 = 1
            return r3
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.b.c(java.lang.String, java.lang.String):boolean");
    }

    public static String e(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            try {
                return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String f(String str, String str2, String str3) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, new Locale(n.a()));
            simpleDateFormat.setLenient(true);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str3);
            simpleDateFormat2.setLenient(true);
            return simpleDateFormat2.format(simpleDateFormat.parse(str));
        } catch (ParseException e2) {
            if (v) {
                q.b(e2.getMessage());
            }
            return "";
        } catch (Exception e3) {
            if (v) {
                q.b(e3.getMessage());
            }
            return "";
        }
    }

    public static String a(String str, long j2) {
        return new SimpleDateFormat(str, new Locale(n.a(), "IN")).format(new Date(j2));
    }

    public static String a(Date date, String str) {
        return new SimpleDateFormat(str, new Locale(n.a(), "IN")).format(date);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        return new java.text.DecimalFormat(r3).format(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(double r1, java.lang.String r3) {
        /*
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0010 }
            java.text.NumberFormat r0 = java.text.NumberFormat.getInstance(r0)     // Catch:{ Exception -> 0x0010 }
            java.text.DecimalFormat r0 = (java.text.DecimalFormat) r0     // Catch:{ Exception -> 0x0010 }
            r0.applyPattern(r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r1 = r0.format(r1)     // Catch:{ Exception -> 0x0010 }
            return r1
        L_0x0010:
            java.text.DecimalFormat r0 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x001a }
            r0.<init>(r3)     // Catch:{ Exception -> 0x001a }
            java.lang.String r1 = r0.format(r1)     // Catch:{ Exception -> 0x001a }
            return r1
        L_0x001a:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.b.a(double, java.lang.String):java.lang.String");
    }

    public static boolean O(Context context) {
        return a.n(context);
    }

    public static boolean P(Context context) {
        return a.o(context);
    }

    public static String d(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = null;
        if (str == null) {
            return null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        stringBuffer.append(str2 + StringUtility.NEW_LINE + valueOf + StringUtility.NEW_LINE + str);
        String.valueOf(stringBuffer);
        a.c();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(x.f43870e.getBytes(), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(stringBuffer.toString().getBytes());
            String encodeToString = Base64.encodeToString(doFinal, 2);
            StringBuilder sb = new StringBuilder("HEX:");
            sb.append(doFinal.toString());
            sb.append("BASE64:");
            sb.append(encodeToString);
            sb.append("ENCOADED URL:");
            sb.append(URLEncoder.encode(encodeToString, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
            a.c();
            str3 = str + "&timestamp=" + valueOf + "&signature=" + URLEncoder.encode(encodeToString, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            String.valueOf(str3);
            a.c();
            return str3;
        } catch (InvalidKeyException e2) {
            if (!v) {
                return str3;
            }
            q.b(e2.getMessage());
            return str3;
        } catch (NoSuchAlgorithmException e3) {
            if (!v) {
                return str3;
            }
            q.b(e3.getMessage());
            return str3;
        } catch (IllegalStateException e4) {
            if (!v) {
                return str3;
            }
            q.b(e4.getMessage());
            return str3;
        } catch (UnsupportedEncodingException e5) {
            if (!v) {
                return str3;
            }
            q.b(e5.getMessage());
            return str3;
        } catch (Exception e6) {
            if (!v) {
                return str3;
            }
            q.b(e6.getMessage());
            return str3;
        }
    }

    public static String e(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            if (!str.toLowerCase().contains("paytm")) {
                return null;
            }
            Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception e2) {
            if (!v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String f(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            if (!str.toLowerCase().contains("aadhaar") && !str.toLowerCase().contains("adhaar") && !str.toLowerCase().contains("aadhar")) {
                return null;
            }
            Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception e2) {
            if (!v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String y(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = Pattern.compile("(?<!\\d)\\d{10}(?!\\d)").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception e2) {
            if (!v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String g(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            if (!str.toLowerCase().contains("irctci")) {
                return null;
            }
            Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception e2) {
            if (!v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String h(String str, String str2) {
        int indexOf;
        if (str == null || str2 == null) {
            return null;
        }
        try {
            if (!str.toLowerCase().contains("irctci") || TextUtils.isEmpty(str2) || !str2.toLowerCase().contains("password is :") || (indexOf = str2.toLowerCase().indexOf("password is :") + 13) >= str2.length()) {
                return null;
            }
            String substring = str2.substring(indexOf);
            if (!TextUtils.isEmpty(substring)) {
                return substring.trim();
            }
            return substring;
        } catch (Exception e2) {
            if (!v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }

    public static boolean h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static long z(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            q.b(e2.getMessage());
            date = null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.getTimeInMillis();
    }

    public static String Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static void i(Context context, String str) {
        com.paytm.b.a.a a2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY);
        if (str != null && str.trim().length() > 0) {
            a2.a(Payload.REFERRER, str, true);
        }
    }

    public static String R(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b(Payload.REFERRER, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String a(Long l2, String str) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(l2.longValue());
            return new SimpleDateFormat(str).format(instance.getTime());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static String g(String str, String str2, String str3) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            Date parse = simpleDateFormat.parse(str);
            simpleDateFormat.applyPattern(str3);
            return simpleDateFormat.format(parse);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static void S(Context context) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("movie_time_slot_flag", true, false);
    }

    public static boolean T(Context context) {
        return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("movie_time_slot_flag", false, false);
    }

    public static String A(String str) {
        if (str.length() == 0) {
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

    public static int U(Context context) {
        return a.v(context);
    }

    public static String B(String str) {
        try {
            return new SimpleDateFormat("hh:mm a").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(str));
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static String C(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            q.c("Error Parsing TimeString");
            date = null;
        }
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE d MMM yyyy, hh:mm a");
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
        return simpleDateFormat2.format(date);
    }

    public static String D(String str) {
        String[] split = str.trim().replace(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON, AppUtility.CENTER_DOT).split(" ");
        boolean z2 = false;
        float floatValue = Float.valueOf(split[0]).floatValue();
        String str2 = split[1];
        if (str2.equalsIgnoreCase("AM") && ((int) floatValue) == 12) {
            z2 = true;
        }
        if ((str2.equalsIgnoreCase("PM") && ((int) floatValue) != 12) || z2) {
            floatValue += 12.0f;
        }
        if (floatValue >= 6.0f && floatValue < 12.0f) {
            return "Morning";
        }
        if (floatValue >= 12.0f && floatValue < 15.0f) {
            return "Afternoon";
        }
        if (floatValue < 15.0f || floatValue >= 18.0f) {
            return (floatValue < 18.0f || floatValue >= 21.0f) ? "Night" : "Evening";
        }
        return "Late Afternoon";
    }

    public static String b(int i2) {
        if (i2 >= 11 && i2 <= 13) {
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

    public static String V(Context context) {
        return a.w(context);
    }

    public static HashMap<String, String> n() {
        return a.i();
    }

    public static String o() {
        return a.d();
    }

    public static String E(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (char c2 : str.toLowerCase().toCharArray()) {
            if (Character.isSpaceChar(c2)) {
                z2 = true;
            } else if (z2) {
                c2 = Character.toTitleCase(c2);
                z2 = false;
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    public static boolean a(Context context, boolean z2) {
        int i2;
        if (z2 && !e.av) {
            if (Build.VERSION.SDK_INT <= 16) {
                i2 = Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
            } else {
                i2 = Settings.Global.getInt(context.getContentResolver(), "always_finish_activities", 0);
            }
            if (i2 == 1) {
                e.av = true;
                return true;
            }
        }
        return false;
    }

    public static boolean F(String str) {
        return str.equalsIgnoreCase("mobile_prepaid") || str.equalsIgnoreCase("mobile_postpaid") || str.equalsIgnoreCase("datacard_prepaid") || str.equalsIgnoreCase("datacard_postpaid") || str.equalsIgnoreCase("mobile-prepaid") || str.equalsIgnoreCase("mobile-postpaid") || str.equalsIgnoreCase("datacard-prepaid") || str.equalsIgnoreCase("datacard-postpaid") || str.equalsIgnoreCase("dth") || str.equalsIgnoreCase("utility") || "utility_creditcard".equalsIgnoreCase(str) || "automatic".equalsIgnoreCase(str);
    }

    public static String W(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("registered_user_id", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void j(Context context, String str) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("registered_user_id", str, true);
    }

    public static String a(Activity activity, String str, String str2, String str3, String str4) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, new Locale(n.a())).parse(str));
        } catch (ParseException e2) {
            if (v) {
                q.b(e2.getMessage());
            }
            a(activity, str4);
            return "";
        } catch (Exception e3) {
            if (v) {
                q.b(e3.getMessage());
            }
            a(activity, str4);
            return "";
        }
    }

    public static void a(Activity activity, String str) {
        if (activity != null) {
            n.b(activity.getApplicationContext(), n.a(activity.getApplicationContext(), n.a()));
            Intent intent = new Intent();
            intent.setClassName(activity.getApplicationContext().getPackageName(), str);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "featured");
            intent.putExtra("resultant fragment position", 0);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static void a(Context context, Boolean bool) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("profile_pic_update", bool.booleanValue(), true);
        }
    }

    public static String G(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        for (char c2 : str.toCharArray()) {
            if (c2 != ' ') {
                z2 = false;
            } else if (z2) {
                sb.append("&nbsp;");
                z2 = false;
            } else {
                z2 = true;
            }
            if (c2 == 9) {
                sb.append("&nbsp; &nbsp; &nbsp;");
            } else if (c2 == 10) {
                sb.append("<br>");
            } else if (c2 == '\"') {
                sb.append("&quot;");
            } else if (c2 == '&') {
                sb.append("&amp;");
            } else if (c2 == '<') {
                sb.append("&lt;");
            } else if (c2 == '>') {
                sb.append("&gt;");
            } else if (c2 < 128) {
                sb.append(c2);
            } else {
                sb.append("&#");
                sb.append(c2);
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static String X(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("entity_merchant_ID", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String Y(Context context) {
        if (context == null) {
            return null;
        }
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("sd_merchant_name", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[Catch:{ Exception -> 0x005d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ Exception -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r9, android.widget.TextView r10) {
        /*
            java.lang.String r0 = ""
            android.graphics.Typeface r1 = r10.getTypeface()     // Catch:{ Exception -> 0x005d }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0013
            android.graphics.Typeface r1 = r10.getTypeface()     // Catch:{ Exception -> 0x005d }
            if (r1 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r1 = r3
            goto L_0x0019
        L_0x0013:
            java.lang.String r1 = "sans-serif-medium"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r2)     // Catch:{ Exception -> 0x005d }
        L_0x0019:
            android.graphics.Typeface r4 = r10.getTypeface()     // Catch:{ Exception -> 0x005d }
            r5 = 0
            if (r4 == 0) goto L_0x0026
            android.graphics.Typeface r4 = r10.getTypeface()     // Catch:{ Exception -> 0x005d }
            if (r4 == 0) goto L_0x002c
        L_0x0026:
            java.lang.String r3 = "sans-serif-light"
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r5)     // Catch:{ Exception -> 0x005d }
        L_0x002c:
            android.text.SpannableStringBuilder r4 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x005d }
            r4.<init>(r9)     // Catch:{ Exception -> 0x005d }
            java.lang.String r6 = "\\."
            java.lang.String[] r6 = r9.split(r6)     // Catch:{ Exception -> 0x005d }
            if (r6 != 0) goto L_0x003a
            return
        L_0x003a:
            r7 = r6[r5]     // Catch:{ Exception -> 0x005d }
            int r7 = r7.length()     // Catch:{ Exception -> 0x005d }
            int r9 = r9.length()     // Catch:{ Exception -> 0x005d }
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x005d }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x005d }
            r1 = 34
            r4.setSpan(r8, r5, r7, r1)     // Catch:{ Exception -> 0x005d }
            int r5 = r6.length     // Catch:{ Exception -> 0x005d }
            if (r5 <= r2) goto L_0x0059
            com.paytm.utility.CustomTypefaceSpan r2 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x005d }
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x005d }
            r4.setSpan(r2, r7, r9, r1)     // Catch:{ Exception -> 0x005d }
        L_0x0059:
            r10.setText(r4)     // Catch:{ Exception -> 0x005d }
            return
        L_0x005d:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.paytm.utility.q.b(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.b.a(java.lang.String, android.widget.TextView):void");
    }

    public static String h(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2, Locale.ENGLISH).parse(str));
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return str;
        }
    }

    private static String a(String str, String str2, Context context) {
        String str3;
        String str4 = Build.MANUFACTURER;
        String str5 = Build.MODEL;
        String str6 = Build.VERSION.RELEASE;
        if (context != null) {
            try {
                str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                q.b(e2.getMessage());
            }
            return context.getString(R.string.error_reporting_mail_body, new Object[]{str4, str5, str6, str3, str, str2});
        }
        str3 = null;
        return context.getString(R.string.error_reporting_mail_body, new Object[]{str4, str5, str6, str3, str, str2});
    }

    public static void a(String str, String str2, Context context, String str3) {
        String a2 = a(str, str2, context);
        Intent intent = new Intent("android.intent.action.SEND");
        if (str3 == null) {
            str3 = "error@paytm.com";
        }
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str3});
        intent.putExtra("android.intent.extra.SUBJECT", "Something went wrong");
        intent.putExtra("android.intent.extra.TEXT", a2);
        intent.setType("message/rfc822");
        context.startActivity(Intent.createChooser(intent, "Select Email Sending App :"));
    }

    public static String i(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        if (str2.length() <= 4) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(str2);
        for (int length = sb.length(); length > 0; length -= 4) {
            sb.insert(length, str);
        }
        return sb.toString();
    }

    public static void k(Context context, String str) {
        if (context != null) {
            ProgressDialog progressDialog = y;
            if (progressDialog == null || !progressDialog.isShowing()) {
                y = new ProgressDialog(context);
                try {
                    y.setProgressStyle(0);
                    y.setMessage(str);
                    y.setCancelable(false);
                    y.setCanceledOnTouchOutside(false);
                    y.show();
                } catch (IllegalArgumentException e2) {
                    if (v) {
                        q.b(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @Deprecated
    public static void p() {
        try {
            if (y != null && y.isShowing()) {
                y.dismiss();
                y = null;
            }
        } catch (Exception e2) {
            if (v) {
                q.b(e2.getMessage());
            }
        }
    }

    public static void Z(Context context) {
        try {
            if (y != null && y.isShowing() && context != null) {
                y.dismiss();
                y = null;
            }
        } catch (Exception e2) {
            if (v) {
                q.b(e2.getMessage());
            }
        }
    }

    public static int a(Date date, Date date2) {
        if (date2.before(date)) {
            return -1;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i2 = 0;
        while (instance.getTime().before(date2)) {
            instance.add(2, 1);
            i2++;
        }
        return i2;
    }

    public static int b(Date date, Date date2) {
        if (date2.before(date)) {
            return -1;
        }
        return ((int) TimeUnit.DAYS.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS)) + 1;
    }

    public static String aa(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("display_name", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void l(Context context, String str) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("aadhar", str, true);
    }

    public static boolean H(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String replaceAll = str.replaceAll("-", "");
            if (replaceAll.length() == 12 && y.a(replaceAll)) {
                Pattern compile = Pattern.compile("^[01]\\d{11}");
                Pattern compile2 = Pattern.compile("^(\\d)(?!\\1+$)\\d{11}$");
                Pattern compile3 = Pattern.compile("^(\\d{4})(?!\\1+$)\\d{8}$");
                if (compile.matcher(replaceAll).matches() || !compile2.matcher(replaceAll).matches() || !compile3.matcher(replaceAll).matches()) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public static void m(Context context, String str) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("pan", str, true);
    }

    public static void b(Context context, Boolean bool) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("is_adhar_verified", bool.booleanValue(), true);
    }

    public static void c(Context context, Boolean bool) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("is_pan_verified", bool.booleanValue(), true);
    }

    public static String ab(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("mobile_number_entered", "", false);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void n(Context context, String str) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("mobile_number_entered", str, false);
        }
    }

    public static String ac(Context context) {
        return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("kyc_first_name", "", true);
    }

    public static void o(Context context, String str) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("kyc_first_name", str, true);
        }
    }

    public static String ad(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("kyc_last_name", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void p(Context context, String str) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("kyc_last_name", str, true);
        }
    }

    public static String ae(Context context) {
        String b2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b("kyc_gender", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void q(Context context, String str) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("kyc_gender", str, true);
        }
    }

    public static void r(Context context, String str) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("kyc_dob", str, true);
        }
    }

    public static String s(Context context, String str) {
        return a.c(context, str);
    }

    private static boolean j(String str, String str2) {
        for (String equalsIgnoreCase : Uri.parse(str2).getQueryParameterNames()) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean I(String str) {
        for (String equalsIgnoreCase : Uri.parse(str).getQueryParameterNames()) {
            if (equalsIgnoreCase.equalsIgnoreCase("buyInsuranceEnabled")) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context, String str, boolean z2) {
        String replace = str.replace(" ", "%20");
        StringBuilder sb = new StringBuilder(replace);
        if (!TextUtils.isEmpty(replace)) {
            if (replace.contains("?")) {
                if (!j("versionidentifier", replace)) {
                    sb.append("&versionidentifier=1&");
                }
            } else if (!j("versionidentifier", replace)) {
                sb.append("?versionidentifier=1");
            }
            if (!j("groupingVersion", replace) && z2) {
                sb.append("&groupingVersion=v3");
            }
        }
        int a2 = n.a(context, n.b());
        sb.append("&lang_id=");
        sb.append(String.valueOf(a2));
        return sb.toString();
    }

    public static String t(Context context, String str) {
        int a2 = n.a(context, n.b());
        try {
            if (TextUtils.isEmpty(String.valueOf(a2))) {
                return str;
            }
            return str + "&lang_id=" + String.valueOf(a2);
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public static Date i(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat;
        try {
            if (TextUtils.isEmpty(str3)) {
                simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
            } else {
                simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
            }
            return simpleDateFormat.parse(str);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static int a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(5);
    }

    public static String a(Date date, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.getDisplayName(2, i2, Locale.getDefault());
    }

    public static boolean J(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (length >= 0) {
            try {
                int parseInt = Integer.parseInt(str.substring(length, length + 1));
                if (z2 && (parseInt = parseInt * 2) > 9) {
                    parseInt = (parseInt % 10) + 1;
                }
                i2 += parseInt;
                z2 = !z2;
                length--;
            } catch (Exception unused) {
                return false;
            }
        }
        return i2 % 10 == 0;
    }

    public static String u(Context context, String str) {
        if (TextUtils.isEmpty(str) || !a.p(context)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
        } else {
            sb.append("?");
        }
        sb.append("customer_id=" + a.a(context));
        return sb.toString();
    }

    public static HashMap<String, String> a(HashMap<String, String> hashMap, Context context) {
        return a.a(hashMap, context);
    }

    public static boolean v(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.toLowerCase().startsWith("mailto:") && context != null) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse(str));
                if (intent.resolveActivity(context.getPackageManager()) == null) {
                    return true;
                }
                context.startActivity(intent);
                return true;
            } else if (str.startsWith("tel:")) {
                context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            } else {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("url_open");
                if (!TextUtils.isEmpty(queryParameter) && queryParameter.equalsIgnoreCase("ext_browser")) {
                    context.startActivity(new Intent("android.intent.action.VIEW", parse));
                    return true;
                }
            }
        }
        return false;
    }

    public static String b(String str, int i2, int i3) {
        int abs = Math.abs(i2);
        Math.abs(i3);
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("imwidth", String.valueOf(abs)).build().toString();
        } catch (Exception e2) {
            e2.getMessage();
            return str;
        }
    }

    public static void a(final Context context, final ImageView imageView, final String str, final float f2) {
        if (imageView != null && context != null && !TextUtils.isEmpty(str)) {
            if (f2 < 1.0f) {
                f2 = 1.0f;
            }
            imageView.post(new Runnable() {

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ int f43707e = -1;

                public final void run() {
                    final String str = str;
                    int i2 = imageView.getContext().getResources().getDisplayMetrics().widthPixels;
                    int i3 = imageView.getContext().getResources().getDisplayMetrics().heightPixels;
                    ImageView imageView = imageView;
                    if (imageView != null && imageView.getWidth() > 0) {
                        i2 = imageView.getWidth();
                    }
                    ImageView imageView2 = imageView;
                    if (imageView2 != null && imageView2.getHeight() > 0) {
                        i3 = imageView.getHeight();
                    }
                    if (i2 > 0 && i3 > 0) {
                        str = b.b(str, (int) (((float) i2) / f2), i3);
                    }
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                    a2.f43753a = str;
                    a2.a((Object) Integer.valueOf(this.f43707e)).a(imageView, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Bitmap>() {
                        public final void onError(Exception exc) {
                        }

                        public final /* synthetic */ void onSuccess(Object obj, c cVar) {
                            if (imageView.getDrawable() instanceof BitmapDrawable) {
                                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                                StringBuilder sb = new StringBuilder("onSuccess, bitmap size ");
                                sb.append(((double) bitmap.getByteCount()) / 1048576.0d);
                                sb.append(" MB url ");
                                sb.append(str);
                                sb.append(" ");
                                sb.append(bitmap);
                                sb.append(" imageview ");
                                sb.append(imageView);
                            }
                        }
                    });
                }
            });
        }
    }

    public static int c(int i2) {
        return a.a(i2);
    }

    public static double b(double d2) {
        double ceil;
        if (d2 > 0.0d) {
            ceil = Math.floor(d2 * 1000.0d);
        } else {
            ceil = Math.ceil(d2 * 1000.0d);
        }
        return ceil / 1000.0d;
    }

    public static Boolean K(String str) {
        try {
            if (Integer.valueOf(str) != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }

    public static boolean a(Double d2) {
        return d2.doubleValue() % 1.0d == 0.0d;
    }

    public static String c(double d2) {
        try {
            return new DecimalFormat("##,##,##,##,##,##,###").format(d2);
        } catch (Exception unused) {
            return String.valueOf(d2);
        }
    }

    public static String L(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return c(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public static String M(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(AppUtility.CENTER_DOT)) < 0 || Integer.parseInt(str.substring(indexOf + 1)) > 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String O(String str) {
        String str2 = str;
        int i2 = 0;
        for (int i3 = 0; i3 < str2.length(); i3++) {
            if (str2.charAt(i3) == '?' && (i2 = i2 + 1) > 1) {
                str2 = str2.substring(0, i3) + '&' + str2.substring(i3 + 1);
            }
        }
        return str2;
    }

    public static String q() {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return UUID.randomUUID().toString() + format;
    }

    public static String j(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        String str4 = null;
        if (str2 == null) {
            return null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        stringBuffer.append(str3 + StringUtility.NEW_LINE + valueOf + StringUtility.NEW_LINE + str2);
        String.valueOf(stringBuffer);
        a.c();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(x.f43870e.getBytes(), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(stringBuffer.toString().getBytes());
            String encodeToString = Base64.encodeToString(doFinal, 2);
            StringBuilder sb = new StringBuilder("HEX:");
            sb.append(doFinal.toString());
            sb.append("BASE64:");
            sb.append(encodeToString);
            sb.append("ENCOADED URL:");
            sb.append(URLEncoder.encode(encodeToString, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
            a.c();
            str4 = str + "&timestamp=" + valueOf + "&signature=" + URLEncoder.encode(encodeToString, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            String.valueOf(str4);
            a.c();
            return str4;
        } catch (InvalidKeyException e2) {
            if (!v) {
                return str4;
            }
            q.b(e2.getMessage());
            return str4;
        } catch (NoSuchAlgorithmException e3) {
            if (!v) {
                return str4;
            }
            q.b(e3.getMessage());
            return str4;
        } catch (IllegalStateException e4) {
            if (!v) {
                return str4;
            }
            q.b(e4.getMessage());
            return str4;
        } catch (UnsupportedEncodingException e5) {
            if (!v) {
                return str4;
            }
            q.b(e5.getMessage());
            return str4;
        } catch (Exception e6) {
            if (!v) {
                return str4;
            }
            q.b(e6.getMessage());
            return str4;
        }
    }

    public static final boolean ag(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "auto_time", 0) == 1 : Settings.System.getInt(context.getContentResolver(), "auto_time", 0) == 1;
    }

    public static HashMap<String, String> ah(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (context != null) {
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a.q(context));
        }
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.indexOf("?");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String P(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0016
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = "?"
            int r0 = r2.indexOf(r0)
            r1 = -1
            if (r0 == r1) goto L_0x0016
            r1 = 0
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.utility.b.P(java.lang.String):java.lang.String");
    }

    public static void ai(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse("market://details?id=" + context.getPackageName()));
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void a(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null && activity.getWindow() != null) {
            activity.getWindow().setStatusBarColor(i2);
        }
    }

    public static String w(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e2) {
            e2.getMessage();
            return null;
        }
    }

    public static void c(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static int a(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static String Q(String str) {
        return str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    public static void x(Context context, String str) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a(str, true, true);
        }
    }

    public static void a(Context context, String str, long j2) {
        if (context != null) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a(str, j2, true);
        }
    }

    private static long z(Context context, String str) {
        return com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).b(str, 0, true);
    }

    public static <T> T a(Object obj, Class<T> cls) {
        f fVar = new f();
        return fVar.a(fVar.b(obj), cls);
    }

    public static String a(long j2) {
        return new SimpleDateFormat("dd MMM yyyy hh:mm:ss a").format(new Date(j2));
    }

    private static String c(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    private static String d(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    public static String R(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int i2 = 0;
        while (i2 < str.length() / 4) {
            int i3 = i2 + 1;
            sb.insert((i3 * 4) + i2, ' ');
            i2 = i3;
        }
        return sb.toString();
    }

    public static String S(String str) {
        String replaceAll = str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
        try {
            if (TextUtils.isEmpty(replaceAll)) {
                return "";
            }
            if (!replaceAll.contains(AppUtility.CENTER_DOT)) {
                return d(Double.valueOf(Double.parseDouble(replaceAll)));
            }
            return new DecimalFormat("##,##,##,##,##0.00").format(Double.valueOf(Double.parseDouble(replaceAll)));
        } catch (NumberFormatException e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public static String T(String str) {
        try {
            return b(Double.valueOf(Double.parseDouble(str)));
        } catch (Exception | NumberFormatException unused) {
            return "";
        }
    }

    public static String b(Double d2) {
        if (d(d2).indexOf(AppUtility.CENTER_DOT) > 0) {
            if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
                return c(d2);
            }
            return "0" + c(d2);
        } else if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
            return d(d2);
        } else {
            return "0" + d(d2);
        }
    }

    public static boolean U(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("(([a-zA-Z]{1})\\d{7})");
    }

    public static boolean V(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}").matcher(str).matches();
    }

    public static boolean W(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[A-Z]{3}[P]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}").matcher(str).matches();
    }

    public static boolean X(String str) {
        return !TextUtils.isEmpty(str) && str.contains("@");
    }

    public static void a(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null && view != null && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static void d(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static boolean aj(Context context) {
        com.paytm.b.a.a a2 = com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY);
        boolean b2 = a2.b("screen_disable_recording", true, true);
        Long valueOf = Long.valueOf(a2.b("screen_enable_time", -1, true));
        if (b2 || valueOf.longValue() == -1) {
            return false;
        }
        if ((Calendar.getInstance().getTimeInMillis() - valueOf.longValue()) / 60000 > 30) {
            return true;
        }
        return false;
    }

    public static void e(Activity activity) {
        if (activity != null && !x.j && !aj(activity)) {
            activity.getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
    }

    public static String Y(String str) {
        return (TextUtils.isEmpty(str) || !Pattern.compile(Pattern.quote("paytm"), 2).matcher(str).find()) ? str : str.toLowerCase().replaceAll("paytm", "pay t m");
    }

    public static boolean a(Context context, long j2, long j3, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        long z2 = z(context, "app_rating_5_star_timestamp");
        if (z2 != 0 && currentTimeMillis - z2 < j2) {
            return false;
        }
        long z3 = z(context, "app_rating_less_than_5_star_timestamp");
        if (z3 != 0 && currentTimeMillis - z3 < j3) {
            return false;
        }
        long z4 = z(context, "app_rating_not_now_timestamp");
        if (z4 == 0 || currentTimeMillis - z4 >= j4) {
            return true;
        }
        return false;
    }

    public static void a(Context context, long j2) {
        com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("lastExplicitlyLogoutTimestamp", j2, false);
    }

    public static boolean s() {
        if (z == -1) {
            byte[] decode = Base64.decode("UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA", 2);
            try {
                z = BitmapFactory.decodeByteArray(decode, 0, decode.length) != null ? 1 : 0;
            } catch (Exception e2) {
                z = 0;
                e2.printStackTrace();
            }
        }
        return z == 1;
    }

    public static boolean t() {
        return a.j();
    }

    public static String al(Context context) {
        return a.x(context);
    }

    public static String am(Context context) {
        return a.y(context);
    }

    public static boolean an(Context context) {
        return a.z(context);
    }

    public static void u() {
        a.k();
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && str2 != null) {
            String q2 = a.q(context);
            if (!TextUtils.isEmpty(q2)) {
                String concat = "/".concat(String.valueOf(q2));
                if (str2.contains(concat)) {
                    str2 = str2.replace(concat, "");
                }
            }
            String b2 = d.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (str2.contains(concat2)) {
                    str2 = str2.replace(concat2, "");
                }
            }
            g.a(context, str, str2);
        }
    }

    public static void a(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                textView.setTypeface(Typeface.create("sans-serif", 0));
            } else {
                textView.setTypeface((Typeface) null, 0);
            }
        }
    }

    public static void b(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                textView.setTypeface(Typeface.create("sans-serif-light", 0));
            } else {
                textView.setTypeface((Typeface) null, 0);
            }
        }
    }

    public static void c(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                textView.setTypeface(Typeface.create("sans-serif-medium", 0));
            } else {
                textView.setTypeface((Typeface) null, 0);
            }
        }
    }

    public static void d(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                textView.setTypeface(Typeface.create("sans-serif", 1));
            } else {
                textView.setTypeface((Typeface) null, 0);
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z2) {
        if (context != null && str2 != null) {
            String q2 = a.q(context);
            if (!TextUtils.isEmpty(q2)) {
                String concat = "/".concat(String.valueOf(q2));
                if (str2.contains(concat)) {
                    str2 = str2.replace(concat, "");
                }
            }
            String b2 = d.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (str2.contains(concat2)) {
                    str2 = str2.replace(concat2, "");
                }
            }
            g.a(context, str, str2, z2);
        }
    }

    public static void a(Context context, String str, boolean z2) {
        if (context != null && str != null) {
            String q2 = a.q(context);
            if (!TextUtils.isEmpty(q2)) {
                String concat = "/".concat(String.valueOf(q2));
                if (str.contains(concat)) {
                    str = str.replace(concat, "");
                }
            }
            String b2 = d.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (str.contains(concat2)) {
                    str = str.replace(concat2, "");
                }
            }
            g.a(context, str, z2);
        }
    }

    public static void b(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void c(Context context, String str, String str2) {
        if (context != null && str2 != null) {
            String q2 = a.q(context);
            if (!TextUtils.isEmpty(q2)) {
                String concat = "/".concat(String.valueOf(q2));
                if (str2.contains(concat)) {
                    str2 = str2.replace(concat, "");
                }
            }
            String b2 = d.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (str2.contains(concat2)) {
                    str2 = str2.replace(concat2, "");
                }
            }
            if (!g.f43804a && !((Activity) context).isFinishing()) {
                h hVar = new h(context);
                hVar.setTitle(str);
                hVar.a(str2);
                hVar.setCancelable(false);
                WindowManager.LayoutParams a2 = g.a((Dialog) hVar);
                hVar.a(-3, context.getString(R.string.ok), new View.OnClickListener(hVar) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ h f43813a;

                    {
                        this.f43813a = r1;
                    }

                    public final void onClick(View view) {
                        if (g.f43805b != null) {
                            g.f43805b.onOkClick();
                            g.f43805b = null;
                        }
                        this.f43813a.cancel();
                        g.f43804a = false;
                    }
                });
                hVar.show();
                if (a2 != null) {
                    hVar.getWindow().setAttributes(a2);
                }
                g.f43804a = true;
            }
        }
    }

    public static void a(EditText editText) {
        if (editText != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                editText.setTypeface(Typeface.create("sans-serif", 0));
            } else {
                editText.setTypeface((Typeface) null, 0);
            }
        }
    }

    public static void a(final Context context, final ImageView imageView, final String str) {
        if (imageView != null && context != null && !TextUtils.isEmpty(str)) {
            imageView.post(new Runnable() {

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ int f43702d = -1;

                public final void run() {
                    ImageView imageView = imageView;
                    if (imageView == null || imageView.getWidth() <= 0 || imageView.getHeight() <= 0) {
                        b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                        a2.f43753a = str;
                        b.a.C0750a.a(a2.a((Object) Integer.valueOf(this.f43702d)), imageView, (com.paytm.utility.b.b.b) null, 2);
                        return;
                    }
                    String b2 = b.b(str, imageView.getWidth(), imageView.getHeight());
                    b.a.C0750a a3 = com.paytm.utility.b.b.a(context);
                    a3.f43753a = b2;
                    b.a.C0750a.a(a3.a((Object) Integer.valueOf(this.f43702d)), imageView, (com.paytm.utility.b.b.b) null, 2);
                }
            });
        }
    }

    public static String af(Context context) {
        return a.d(context);
    }

    public static String N(String str) {
        String str2;
        if (str.startsWith(x.f43873h)) {
            return str;
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("paytmmp")) {
            return (TextUtils.isEmpty(str) || !str.startsWith("paytmmall")) ? str : str.replace("paytmmall", "paytmmp");
        }
        String[] strArr = {CLPConstants.DEFAULT_GRID_VIEW_TYPE, "homepage_secondary", CLPConstants.GA_CHANNEL_NAME, "product", "checkout", "nearbuy", "deals", "generic", "share_earn"};
        Uri parse = Uri.parse(str.replace('$', '&'));
        if (parse == null) {
            return str;
        }
        String host = parse.getHost();
        int i2 = 0;
        while (true) {
            if (i2 >= 9) {
                str2 = str;
                break;
            } else if (strArr[i2].equals(host)) {
                str2 = str.replace("paytmmp", "paytmmall");
                break;
            } else {
                i2++;
            }
        }
        return (!str.startsWith("paytmmp") || !k.b()) ? str2 : str.replace("paytmmp", x.f43873h);
    }

    public static String b(String str, Context context) {
        String q2 = a.q(context);
        return (TextUtils.isEmpty(str) || !str.contains(q2)) ? str : str.replace(q2, "");
    }

    public static void y(Context context, String str) {
        List<e.b> asList = Arrays.asList(e.b.values());
        ArrayList arrayList = new ArrayList(asList.size());
        for (e.b name : asList) {
            arrayList.add(name.name());
        }
        if (arrayList.contains(str)) {
            com.paytm.b.a.a.a(context.getApplicationContext(), a.c.UTILITY).a("selected_user_profile", str, true);
            return;
        }
        throw new IllegalArgumentException("Invalid profile type");
    }

    public static String ak(Context context) {
        return a.a(context, "selected_user_profile");
    }
}
