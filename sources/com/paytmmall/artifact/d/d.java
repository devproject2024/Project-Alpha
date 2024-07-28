package com.paytmmall.artifact.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.cart.entity.CJRRechargePayment;
import com.paytmmall.artifact.common.a.a;
import com.paytmmall.artifact.common.entity.CJRError;
import com.sendbird.android.constant.StringSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f15693a = "client_id";

    /* renamed from: b  reason: collision with root package name */
    public static String f15694b = "head";

    /* renamed from: c  reason: collision with root package name */
    public static String f15695c = "body";

    /* renamed from: d  reason: collision with root package name */
    public static String f15696d = "requestId";

    /* renamed from: e  reason: collision with root package name */
    public static String f15697e = StringSet.token;

    /* renamed from: f  reason: collision with root package name */
    public static String f15698f = "tokenType";

    /* renamed from: g  reason: collision with root package name */
    public static String f15699g = "sso";

    /* renamed from: h  reason: collision with root package name */
    public static String f15700h = "version";

    /* renamed from: i  reason: collision with root package name */
    public static String f15701i = "deviceId";
    public static String j = "channelId";
    private static final String k = d.class.getSimpleName();
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static ProgressDialog r;

    public static String l() {
        return "main";
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static String a(Context context, String str) {
        return g.a(str, context);
    }

    public static void a(Context context, String str, String str2) {
        if (context != null) {
            String string = context.getResources().getString(R.string.message_error_data_display);
            if (!TextUtils.isEmpty(str)) {
                string = string + "(" + str + ")";
            }
            if (!TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase(H5BridgeContext.INVALID_ID)) {
                string = string + "| Http Code " + str2;
            }
            c(context, context.getResources().getString(R.string.error_data_display), string);
        }
    }

    public static void c(Context context, String str, String str2) {
        if (context != null && str2 != null) {
            String a2 = l.a(context);
            if (!TextUtils.isEmpty(a2)) {
                String concat = "/".concat(String.valueOf(a2));
                if (str2.contains(concat)) {
                    str2 = str2.replace(concat, "");
                }
            }
            String b2 = l.b();
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (str2.contains(concat2)) {
                    str2 = str2.replace(concat2, "");
                }
            }
            n.a(context, str, str2);
        }
    }

    public static String a() {
        return m;
    }

    public static String b() {
        return o;
    }

    public static String c() {
        return p;
    }

    public static int b(Context context) {
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

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            c.b();
        }
    }

    public static String c(Context context, String str) {
        return g.c(str, context);
    }

    public static HashMap<String, String> a(HashMap<String, String> hashMap, Context context) {
        hashMap.put(AppConstants.SSO_TOKEN, t.e().getSSOToken(context));
        return hashMap;
    }

    public static void a(Map<String, String> map) {
        l = map.get("SITE_ID");
        m = map.get("CLIENT_ID");
        o = map.get("SECRET_CODE");
        p = map.get("AUTHORIZATION_VALUE");
        q = map.get("USER_ID");
        n = map.get("CLIENT");
    }

    public static String d() {
        return l;
    }

    public static String e() {
        return q;
    }

    public static String f() {
        return n;
    }

    public static String g() {
        return t.e().postRequestBodyForV2();
    }

    public static String c(Context context) {
        return u.a(context.getApplicationContext()).b("userName", "", true);
    }

    public static void a(Activity activity, String str) {
        if (activity != null) {
            ProgressDialog progressDialog = r;
            if (progressDialog == null || !progressDialog.isShowing()) {
                r = new z(activity);
                try {
                    r.setProgressStyle(0);
                    r.setMessage(str);
                    r.setCancelable(false);
                    r.setCanceledOnTouchOutside(false);
                    r.show();
                } catch (IllegalArgumentException e2) {
                    q.c(e2.getMessage());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(Activity activity, String str, Boolean bool, Boolean bool2) {
        if (activity != null) {
            ProgressDialog progressDialog = r;
            if (progressDialog == null || !progressDialog.isShowing()) {
                r = new z(activity);
                try {
                    r.setProgressStyle(0);
                    r.setMessage(str);
                    r.setCancelable(bool.booleanValue());
                    r.setCanceledOnTouchOutside(bool2.booleanValue());
                    r.show();
                } catch (IllegalArgumentException e2) {
                    q.c(e2.getMessage());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void h() {
        try {
            if (r != null && r.isShowing()) {
                r.dismiss();
                r = null;
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static boolean a(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static boolean d(Context context) {
        return !TextUtils.isEmpty(l.a(context));
    }

    public static void b(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static void a(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 21 && activity.getWindow() != null) {
            activity.getWindow().setStatusBarColor(i2);
        }
    }

    public static int i() {
        try {
            return (int) (Resources.getSystem().getDisplayMetrics().density * 10.0f);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        String a2 = g.a();
        if (!TextUtils.isEmpty(str) && str.contains("?")) {
            a2 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + a2.substring(1);
        }
        return str + a2;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN);
            return decimalFormat.format((double) Float.parseFloat(str));
        } catch (Exception unused) {
            return new DecimalFormat(com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN).format((double) Float.parseFloat(str));
        }
    }

    public static int j() {
        return Build.VERSION.SDK_INT;
    }

    public static String e(Context context) {
        return u.a(context.getApplicationContext()).b("first name", "", true);
    }

    public static String f(Context context) {
        return u.a(context.getApplicationContext()).b("last name", "", true);
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError, String str, String str2) {
        if (activity != null && !activity.isFinishing() && networkCustomError != null) {
            if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                t.e().handleErrorCall(activity, (VolleyError) null, str, (Bundle) null, (String) null);
            } else if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                a.a();
                sb.append(a.a("base_url_auth", (String) null));
                if (str2.contains(sb.toString())) {
                    c(activity, "error.auth@paytm.com");
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                a.a();
                sb2.append(a.a("base_url_kyc", (String) null));
                if (!str2.contains(sb2.toString())) {
                    StringBuilder sb3 = new StringBuilder();
                    a.a();
                    sb3.append(a.a("base_url_golden_gate", (String) null));
                    if (!str2.contains(sb3.toString())) {
                        StringBuilder sb4 = new StringBuilder();
                        a.a();
                        sb4.append(a.a("base_url_wallet", (String) null));
                        if (str2.contains(sb4.toString())) {
                            c(activity, "error.wallet@paytm.com");
                            return;
                        }
                        return;
                    }
                }
                c(activity, "error.kyc@paytm.com");
            }
        }
    }

    private static void c(Activity activity, String str) {
        t.e().handleErrorReport(activity, (VolleyError) null, str);
    }

    public static String g(Context context) {
        return u.a(context.getApplicationContext()).b(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, "", true);
    }

    public static boolean d(Context context, String str) {
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

    public static String e(Context context, String str) {
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
            boolean z = c.f15691a;
            return null;
        }
    }

    public static boolean a(Context context, NetworkCustomError networkCustomError, String str) {
        String str2;
        if (networkCustomError == null) {
            return true;
        }
        String alertMessage = networkCustomError.getAlertMessage();
        if ("parsing_error".equalsIgnoreCase(alertMessage)) {
            return false;
        }
        String str3 = null;
        if (TextUtils.isEmpty((CharSequence) null) || TextUtils.isEmpty((CharSequence) null)) {
            CJRError h2 = h(alertMessage);
            str2 = h2.getMessage() + "(" + str + " | HTTP " + networkCustomError.getAlertMessage() + ")";
            str3 = h2.getTitle();
        } else {
            str2 = null;
        }
        if (alertMessage.equalsIgnoreCase("503")) {
            return true;
        }
        c(context, str3, str2);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.paytmmall.artifact.common.entity.CJRError h(java.lang.String r7) {
        /*
            com.paytmmall.artifact.common.a r0 = com.paytmmall.artifact.d.t.e()
            android.content.Context r0 = r0.getApplicationContext()
            com.paytmmall.artifact.common.entity.CJRError r1 = new com.paytmmall.artifact.common.entity.CJRError
            r1.<init>()
            int r2 = r7.hashCode()
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -1311914055: goto L_0x0039;
                case -617237321: goto L_0x002f;
                case 1700738474: goto L_0x0024;
                case 2038628819: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0043
        L_0x0019:
            java.lang.String r2 = "unknown_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0043
            r2 = 3
            goto L_0x0044
        L_0x0024:
            java.lang.String r2 = "timeout_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0043
            r2 = 1
            goto L_0x0044
        L_0x002f:
            java.lang.String r2 = "network_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0043
            r2 = 0
            goto L_0x0044
        L_0x0039:
            java.lang.String r2 = "parsing_error"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0043
            r2 = 2
            goto L_0x0044
        L_0x0043:
            r2 = -1
        L_0x0044:
            if (r2 == 0) goto L_0x00bd
            if (r2 == r6) goto L_0x00bd
            if (r2 == r5) goto L_0x00b0
            if (r2 == r4) goto L_0x00a3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ NumberFormatException -> 0x0054 }
            int r3 = r7.intValue()     // Catch:{ NumberFormatException -> 0x0054 }
        L_0x0054:
            int r7 = com.paytmmall.artifact.R.string.error_title_inconvenience
            java.lang.String r7 = r0.getString(r7)
            r2 = 400(0x190, float:5.6E-43)
            if (r3 == r2) goto L_0x009c
            r2 = 404(0x194, float:5.66E-43)
            if (r3 == r2) goto L_0x0095
            r2 = 408(0x198, float:5.72E-43)
            if (r3 == r2) goto L_0x008e
            r2 = 429(0x1ad, float:6.01E-43)
            if (r3 == r2) goto L_0x0087
            r2 = 500(0x1f4, float:7.0E-43)
            if (r3 == r2) goto L_0x0080
            r2 = 503(0x1f7, float:7.05E-43)
            if (r3 == r2) goto L_0x0079
            int r2 = com.paytmmall.artifact.R.string.error_msg_default
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x0079:
            int r2 = com.paytmmall.artifact.R.string.error_msg_503
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x0080:
            int r2 = com.paytmmall.artifact.R.string.error_msg_500
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x0087:
            int r2 = com.paytmmall.artifact.R.string.error_msg_429
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x008e:
            int r2 = com.paytmmall.artifact.R.string.error_msg_408
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x0095:
            int r2 = com.paytmmall.artifact.R.string.error_msg_404
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x009c:
            int r2 = com.paytmmall.artifact.R.string.error_msg_400
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x00a3:
            int r7 = com.paytmmall.artifact.R.string.error_title_inconvenience
            java.lang.String r7 = r0.getString(r7)
            int r2 = com.paytmmall.artifact.R.string.error_msg_default
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x00b0:
            int r7 = com.paytmmall.artifact.R.string.error_data_display
            java.lang.String r7 = r0.getString(r7)
            int r2 = com.paytmmall.artifact.R.string.parse_error
            java.lang.String r0 = r0.getString(r2)
            goto L_0x00c9
        L_0x00bd:
            int r7 = com.paytmmall.artifact.R.string.network_error_heading
            java.lang.String r7 = r0.getString(r7)
            int r2 = com.paytmmall.artifact.R.string.network_error_message
            java.lang.String r0 = r0.getString(r2)
        L_0x00c9:
            r1.setTitle(r7)
            r1.setMessage(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.d.d.h(java.lang.String):com.paytmmall.artifact.common.entity.CJRError");
    }

    public static void f(Context context, String str) {
        com.paytm.b.a.a a2 = u.a(context.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            a2.a(Payload.REFERRER, str, true);
        }
    }

    public static String g(Context context, String str) {
        String b2 = g.b(str, context);
        if (!d(context)) {
            return b2;
        }
        String c2 = t.c().c("USER_ID");
        if (TextUtils.isEmpty(c2)) {
            return b2;
        }
        return b2 + "&custId=" + c2;
    }

    public static String h(Context context) {
        return u.a(context.getApplicationContext()).b("ADVERTISING_ID", "", true);
    }

    public static HashMap<String, String> m() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    public static String d(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        if (ab.a()) {
            sb.append(".webp");
        }
        return sb.toString();
    }

    public static boolean b(Activity activity, String str) {
        if (str == null) {
            return false;
        }
        try {
            String c2 = t.c().c("DEEPLINK_SCHEME_ID");
            if ("market".equals(Uri.parse(str).getScheme())) {
                int indexOf = str.indexOf(t.c().c("DEEPLINK_SCHEME_ID") + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON);
                if (indexOf < str.length()) {
                    a.a().a(activity, str.substring(indexOf));
                    return true;
                }
            } else if (c2.equals(Uri.parse(str).getScheme())) {
                a.a().a(activity, str);
                return true;
            } else if (str.contains("onelink")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(67108864);
                intent.addFlags(268435456);
                activity.startActivity(intent);
                return true;
            } else {
                t.e().redirectToPaytm(activity, str);
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean e(String str) {
        return str.startsWith("http://pytm.ml") || str.startsWith("https://pytm.ml");
    }

    public static boolean f(String str) {
        return str.startsWith("http://m.p-y.tm") || str.startsWith("https://m.p-y.tm") || str.startsWith("https://p-y.tm") || str.startsWith("http://p-y.tm");
    }

    public static String i(Context context) {
        if (context == null) {
            return null;
        }
        return "/Android/data/" + context.getPackageName();
    }

    public static String g(String str) {
        int i2;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        File file = new File(str);
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= 0) {
            i3 = 1;
        }
        if (i4 <= 0) {
            i4 = 1;
        }
        float f2 = (float) (i4 / i2);
        float f3 = (float) i2;
        if (f3 > 816.0f || ((float) i4) > 612.0f) {
            if (f2 < 0.75f) {
                i4 = (int) ((816.0f / f3) * ((float) i4));
                i2 = 816;
            } else {
                i2 = f2 > 0.75f ? (int) ((612.0f / ((float) i4)) * f3) : 816;
                i4 = 612;
            }
        }
        options.inSampleSize = a(options, i4, i2);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        try {
            bitmap = Bitmap.createBitmap(i4, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
        float f4 = (float) i4;
        float f5 = f4 / ((float) options.outWidth);
        float f6 = (float) i2;
        float f7 = f6 / ((float) options.outHeight);
        float f8 = f4 / 2.0f;
        float f9 = f6 / 2.0f;
        if (decodeFile != null) {
            Matrix matrix = new Matrix();
            matrix.setScale(f5, f7, f8, f9);
            Canvas canvas = new Canvas(bitmap);
            canvas.setMatrix(matrix);
            if (decodeFile.getWidth() / 2 == 0 && decodeFile.getHeight() / 2 == 0) {
                canvas.drawBitmap(decodeFile, 0.0f, 0.0f, new Paint(2));
            } else if (decodeFile.getWidth() / 2 == 0) {
                canvas.drawBitmap(decodeFile, 0.0f, f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
            } else if (decodeFile.getHeight() / 2 == 0) {
                canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), 0.0f, new Paint(2));
            } else {
                canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
            }
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
                Matrix matrix2 = new Matrix();
                if (attributeInt == 6) {
                    matrix2.postRotate(90.0f);
                } else if (attributeInt == 3) {
                    matrix2.postRotate(180.0f);
                } else if (attributeInt == 8) {
                    matrix2.postRotate(270.0f);
                }
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
            } catch (IOException e4) {
                q.c(e4.getMessage());
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str));
            } catch (FileNotFoundException e5) {
                q.c(e5.getMessage());
            }
        }
        return str;
    }

    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        if (i5 > i3 || i6 > i2) {
            i4 = Math.round(((float) i5) / ((float) i3));
            int round = Math.round(((float) i6) / ((float) i2));
            if (i4 >= round) {
                i4 = round;
            }
        } else {
            i4 = 1;
        }
        while (((float) (i6 * i5)) / ((float) (i4 * i4)) > ((float) (i2 * i3 * 2))) {
            i4++;
        }
        return i4;
    }

    public static String j(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("REQUEST_TYPE", "QR_CODE_REQUEST_MONEY");
        jSONObject.put("NAME", b.h(context));
        jSONObject.put(CJRQRScanResultModel.KEY_MOBILE_NO, b.l(context));
        jSONObject.put(CJRQRScanResultModel.KEY_PAYEE_TYPE, StringSet.user);
        return jSONObject.toString();
    }

    public static void b(Context context, String str, String str2) {
        c(context, str, str2);
    }

    public static String b(Context context, String str) {
        return g.c(str, context);
    }

    public static void a(CJRRechargePayment cJRRechargePayment, Intent intent) {
        if ("1".equalsIgnoreCase(cJRRechargePayment.isNativeEnabled())) {
            String str = null;
            try {
                str = new JSONObject(cJRRechargePayment.getmPGParams().get("txnAmount")).getString("value");
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
            intent.putExtra("price", str);
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("merchant_id", cJRRechargePayment.getMID());
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("nativeSdkEnabled", true);
            return;
        }
        intent.putExtra("price", cJRRechargePayment.getmPGParams().get("TXN_AMOUNT"));
        intent.putExtra("nativeSdkEnabled", false);
    }

    public static void a(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                textView.setTypeface(Typeface.create("sans-serif-medium", 0));
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

    public static void k() {
        n.f15731a = false;
    }

    public static void c(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                textView.setTypeface(Typeface.create("sans-serif", 0));
            } else {
                textView.setTypeface((Typeface) null, 0);
            }
        }
    }
}
