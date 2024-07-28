package net.one97.paytm.upi.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.location.Location;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.alipay.mobile.nebula.util.H5Utils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.zxing.a;
import com.google.zxing.g;
import com.google.zxing.g.a.f;
import com.google.zxing.l;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.UpiContract;

public class UpiAppUtils {
    private static final String TAG_APP_LANGUAGE = "language";
    private static final String TAG_LATITUDE = "latitude";
    private static final String TAG_LONGITUDE = "longitude";
    private static final String TAG_NETWORK_TYPE = "networkType";
    private static final String TAG_OS_VERSION = "osVersion";
    private static final String TAG_PLAY_STORE_INSTALL = "playStore";
    private static final String TAG_TIMESTAMP = "timestamp";
    private static final String kmTagClient = "client";
    private static final String kmTagDeviceId = "deviceId";
    private static final String kmTagDeviceIdentifier = "deviceIdentifier";
    private static final String kmTagDeviceManufacturer = "deviceManufacturer";
    private static final String kmTagDeviceName = "deviceName";
    private static final String kmTagVersion = "version";
    public static String mClient = "androidapp";

    public static String deeplinkSchemaName() {
        return "paytmmp://";
    }

    public static boolean showOnPaytmApp() {
        return true;
    }

    public static String priceToString(String str) {
        try {
            return priceToString(Double.valueOf(Double.parseDouble(str)));
        } catch (Exception | NumberFormatException unused) {
            return "";
        }
    }

    public static int getPixelValue(int i2, Context context) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static String priceToString(Double d2) {
        if (priceWithoutDecimal(d2).indexOf(AppUtility.CENTER_DOT) > 0) {
            if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
                return priceWithDecimal(d2);
            }
            return "0" + priceWithDecimal(d2);
        } else if (d2.doubleValue() >= 1.0d || d2.doubleValue() <= 0.0d) {
            return priceWithoutDecimal(d2);
        } else {
            return "0" + priceWithoutDecimal(d2);
        }
    }

    private static String priceWithDecimal(Double d2) {
        return new DecimalFormat("##,##,##,##,###.00").format(d2);
    }

    private static String priceWithoutDecimal(Double d2) {
        return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
    }

    private static String priceWithTrailing0Decimal(Double d2) {
        return new DecimalFormat("##,##,##,##,##0.00").format(d2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ Exception -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void updateAmount(java.lang.String r7, android.widget.TextView r8) {
        /*
            java.lang.String r0 = ""
            android.graphics.Typeface r1 = r8.getTypeface()     // Catch:{ Exception -> 0x0049 }
            r2 = 0
            if (r1 == 0) goto L_0x0012
            android.graphics.Typeface r1 = r8.getTypeface()     // Catch:{ Exception -> 0x0049 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0018
        L_0x0012:
            java.lang.String r1 = "sans-serif-medium"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r2)     // Catch:{ Exception -> 0x0049 }
        L_0x0018:
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r7.split(r3)     // Catch:{ Exception -> 0x0049 }
            if (r3 == 0) goto L_0x0048
            int r4 = r3.length     // Catch:{ Exception -> 0x0049 }
            if (r4 > 0) goto L_0x0024
            goto L_0x0048
        L_0x0024:
            r3 = r3[r2]     // Catch:{ Exception -> 0x0049 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0049 }
            int r4 = r7.length()     // Catch:{ Exception -> 0x0049 }
            android.text.SpannableStringBuilder r5 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x0049 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0049 }
            net.one97.paytm.upi.util.CustomTypefaceSpan r7 = new net.one97.paytm.upi.util.CustomTypefaceSpan     // Catch:{ Exception -> 0x0049 }
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x0049 }
            r6 = 34
            r5.setSpan(r7, r2, r3, r6)     // Catch:{ Exception -> 0x0049 }
            net.one97.paytm.upi.util.CustomTypefaceSpan r7 = new net.one97.paytm.upi.util.CustomTypefaceSpan     // Catch:{ Exception -> 0x0049 }
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x0049 }
            r5.setSpan(r7, r3, r4, r6)     // Catch:{ Exception -> 0x0049 }
            r8.setText(r5)     // Catch:{ Exception -> 0x0049 }
        L_0x0048:
            return
        L_0x0049:
            r7 = move-exception
            r7.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.UpiAppUtils.updateAmount(java.lang.String, android.widget.TextView):void");
    }

    public static void disableScreenCapturing() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (UpiAppUtils.getTopActivity() != null) {
                    UpiAppUtils.getTopActivity().getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    if (UpiAppUtils.getTopActivity().findViewById(R.id.form_item_input) != null) {
                        UpiAppUtils.getTopActivity().findViewById(R.id.form_item_input).requestFocus();
                    }
                }
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object next : map.values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(next);
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String getFormattedAmount(String str) {
        try {
            String[] split = str.split("\\.");
            if (split.length <= 0) {
                return "";
            }
            int length = split[0].length();
            int length2 = str.length();
            Typeface create = Typeface.create("sans-serif-medium", 0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", create), 0, length, 34);
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", create), length, length2, 34);
            return spannableStringBuilder.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getFormattedBankAccountNum(String str) {
        try {
            return "XX".concat(String.valueOf(str.substring(str.length() - 4)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getMobile(Context context) {
        String b2 = PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b("mobile", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static int convertDpToPixel(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static boolean isValidAadhaar(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String replaceAll = str.replaceAll("-", "");
            if (replaceAll.length() == 12 && VerhoeffAlgorithm.validateVerhoeff(replaceAll)) {
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
            e2.printStackTrace();
            return false;
        }
    }

    public static String getNetworkType(Context context) {
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
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isValidAmount(String str) {
        try {
            if (TextUtils.isEmpty(str) || Double.parseDouble(str) <= 0.0d) {
                return false;
            }
            return true;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null && view != null && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static boolean checkIsVpa(String str) {
        return !TextUtils.isEmpty(str) && str.contains("@");
    }

    public static int daysBetween(Date date, Date date2) {
        if (date2.before(date)) {
            return -1;
        }
        return ((int) TimeUnit.DAYS.convert(date2.getTime() - date.getTime(), TimeUnit.MILLISECONDS)) + 1;
    }

    public static String insertSpaceAfterInterval(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int i3 = 0;
        while (i3 < str.length() / i2) {
            int i4 = i3 + 1;
            sb.insert((i4 * i2) + i3, ' ');
            i3 = i4;
        }
        return sb.toString();
    }

    public static String getCleanString(String str) {
        return str.replaceAll("[₹, ]", "").trim().replaceAll("^\\s+", "");
    }

    public static String getInitialsSingle(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                return String.valueOf(trim.toUpperCase().charAt(0));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String formatNumber(String str) {
        if (str == null || str.trim().equalsIgnoreCase("")) {
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

    public static String formatNumber(double d2) {
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            decimalFormat.applyPattern(AppConstants.PRICE_PATTERN);
            return decimalFormat.format(d2);
        } catch (Exception unused) {
            return new DecimalFormat(AppConstants.PRICE_PATTERN).format(d2);
        }
    }

    public static boolean isValidUPIAmount(String str, double d2, double d3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            double parseDouble = Double.parseDouble(str);
            if (d3 <= 0.0d) {
                return true;
            }
            return parseDouble >= d2 && parseDouble <= d3;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String clearExtension(String str) {
        if (str.contains(".com")) {
            return str.replaceAll(".com", "");
        }
        return str.contains(".COM") ? str.replaceAll(".COM", "") : str;
    }

    public static String addAuthDefaultParams(Context context, String str) {
        String authDefaultParams = getAuthDefaultParams(context);
        if (!TextUtils.isEmpty(str) && str.contains("?")) {
            authDefaultParams = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + authDefaultParams.substring(1);
        }
        return str + authDefaultParams;
    }

    public static String addExtratParams(Context context, String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
        }
        return str + sb.toString();
    }

    public static String getLanguage(Context context) {
        return Resources.getSystem().getConfiguration().locale.getLanguage();
    }

    public static String getAuthDefaultParams(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
        generateNewSessionId(context);
        try {
            str = b.Q(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        String deviceIdentifier = getDeviceIdentifier(context, telephonyManager);
        try {
            deviceIdentifier = URLEncoder.encode(deviceIdentifier, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        StringBuilder sb = new StringBuilder("?");
        if (deviceIdentifier != null) {
            if (sb.length() > 1) {
                sb.append("&deviceIdentifier=".concat(String.valueOf(deviceIdentifier)));
            } else {
                sb.append("deviceIdentifier=".concat(String.valueOf(deviceIdentifier)));
            }
        }
        try {
            String encode = URLEncoder.encode(str2.replaceAll(" ", ""), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            if (encode != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceManufacturer=".concat(String.valueOf(encode)));
                } else {
                    sb.append("deviceManufacturer=".concat(String.valueOf(encode)));
                }
            }
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            String encode2 = URLEncoder.encode(str3.replaceAll(" ", ""), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            if (encode2 != null) {
                if (sb.length() > 1) {
                    sb.append("&deviceName=".concat(String.valueOf(encode2)));
                } else {
                    sb.append("deviceName=".concat(String.valueOf(encode2)));
                }
            }
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        if (mClient != null) {
            if (sb.length() > 1) {
                sb.append("&client=" + mClient);
            } else {
                sb.append("client=" + mClient);
            }
        } else if (sb.length() > 1) {
            sb.append("&client=androidapp");
        } else {
            sb.append("client=androidapp");
        }
        if (str != null) {
            if (sb.length() > 1) {
                sb.append("&version=".concat(String.valueOf(str)));
            } else {
                sb.append("version=".concat(String.valueOf(str)));
            }
        }
        if (isPlayStoreInstall(context)) {
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
        Location location = LocationManager.getManger().getLocation(context);
        String latitude = getLatitude(location);
        String longitude = getLongitude(location);
        if (TextUtils.isEmpty(latitude)) {
            latitude = "0.0";
        }
        if (TextUtils.isEmpty(longitude)) {
            longitude = "0.0";
        }
        if (!TextUtils.isEmpty(latitude) && !TextUtils.isEmpty(longitude)) {
            if (sb.length() > 1) {
                sb.append("&latitude=" + latitude + "&longitude=" + longitude);
            } else {
                sb.append("latitude=" + latitude + "&longitude=" + longitude);
            }
        }
        String language = getLanguage(context);
        if (language != null && language.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&language=".concat(String.valueOf(language)));
            } else {
                sb.append("language=".concat(String.valueOf(language)));
            }
        }
        String networkType = getNetworkType(context);
        if (networkType != null && networkType.trim().length() > 0) {
            if (sb.length() > 1) {
                sb.append("&networkType=".concat(String.valueOf(networkType)));
            } else {
                sb.append("networkType=".concat(String.valueOf(networkType)));
            }
        }
        String oSReleaseVersion = getOSReleaseVersion();
        if (!TextUtils.isEmpty(getOSReleaseVersion())) {
            if (sb.length() > 1) {
                sb.append("&osVersion=".concat(String.valueOf(oSReleaseVersion)));
            } else {
                sb.append("osVersion=".concat(String.valueOf(oSReleaseVersion)));
            }
        }
        String epochTimeStamp = getEpochTimeStamp();
        if (!TextUtils.isEmpty(epochTimeStamp)) {
            if (sb.length() > 1) {
                sb.append("&timestamp=".concat(String.valueOf(epochTimeStamp)));
            } else {
                sb.append("timestamp=".concat(String.valueOf(epochTimeStamp)));
            }
        }
        String deviceID = getDeviceID(context);
        if (!TextUtils.isEmpty(deviceID)) {
            if (sb.length() > 1) {
                sb.append("&deviceId=".concat(String.valueOf(deviceID)));
            } else {
                sb.append("deviceId=".concat(String.valueOf(deviceID)));
            }
        }
        return sb.toString();
    }

    public static String generateNewSessionId(Context context) {
        return generateSessionId(context, (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER), String.valueOf((int) System.currentTimeMillis()));
    }

    public static String generateSessionId(Context context, TelephonyManager telephonyManager, String str) {
        String uniqueDeviceId = getUniqueDeviceId(context, telephonyManager);
        return md5(uniqueDeviceId + str);
    }

    private static String getEpochTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String getUniqueDeviceId(Context context, TelephonyManager telephonyManager) {
        return i.a().m.c(context);
    }

    public static String md5(String str) {
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
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String getDeviceIdentifier(Context context, TelephonyManager telephonyManager) {
        String uniqueDeviceId = getUniqueDeviceId(context, telephonyManager);
        String replaceAll = (Build.MANUFACTURER + "-" + Build.MODEL + "-" + uniqueDeviceId).replaceAll(" ", "");
        LogUtility.d("", "Device identifier is : ".concat(String.valueOf(replaceAll)));
        return replaceAll;
    }

    public static boolean isPlayStoreInstall(Context context) {
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

    public static String getLatitude(Location location) {
        if (location != null) {
            try {
                return Double.toString(location.getLatitude());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String getLongitude(Location location) {
        if (location != null) {
            try {
                return Double.toString(location.getLatitude());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String getOSReleaseVersion() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap generateQR(String str, Context context, int i2, int i3, boolean z) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put(g.ERROR_CORRECTION, f.H);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                str = CJRQRCryptoUtils.encrypt(str, UpiConstants.QR_KEY);
            }
            try {
                com.google.zxing.b.b a2 = new l().a(str, a.QR_CODE, i2, i3, hashMap);
                int i4 = a2.f39889a;
                int i5 = a2.f39890b;
                int[] iArr = new int[(i4 * i5)];
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = i6 * i4;
                    for (int i8 = 0; i8 < i4; i8++) {
                        iArr[i7 + i8] = a2.a(i8, i6) ? -16777216 : -1;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.RGB_565);
                createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i5);
                return createBitmap;
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static Dialog getWalletStyleProgressDialog(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.lyt_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String removeSpaceAndBracketP2P(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.trim().replaceAll("[^\\d+]", "").replaceAll(" ", "");
        }
        return "";
    }

    public static String filterMobileNumberP2P(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i2 = 0;
        String replaceAll = str.trim().replaceAll("[^\\d+]", "");
        if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_91))) {
            i2 = 3;
        } else if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_91_without_plus))) {
            i2 = 2;
        } else if (replaceAll.startsWith(activity.getString(R.string.mobile_number_prefix_0))) {
            i2 = 1;
        }
        return replaceAll.substring(i2, replaceAll.length()).trim().replaceAll(" ", "");
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static Map<String, String> getConsolidatePaymentInstHeader(Context context, Object... objArr) {
        HashMap hashMap = new HashMap();
        String deviceID = getDeviceID(context);
        if (TextUtils.isEmpty(deviceID)) {
            deviceID = "";
        }
        hashMap.put(UpiConstants.DESTINATION_PHONE, objArr[0]);
        hashMap.put(UpiConstants.USER_TOKEN, i.a().f66980a);
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap.put(UpiConstants.REQUEST_TOKEN, deviceID + System.currentTimeMillis());
        return hashMap;
    }

    public static String getDeviceID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        return string == null ? "2k3k4k34k3k" : string;
    }

    public static String getConsolidatePaymentInstUrl(Object... objArr) {
        StringBuilder sb = new StringBuilder(UpiGTMLoader.getInstance().getConsolidatePaymentOptionURL());
        String a2 = com.paytm.utility.a.a(i.a().m.c());
        int indexOf = sb.indexOf("{userID}");
        int i2 = indexOf + 8;
        if (a2 == null) {
            a2 = "";
        }
        sb.replace(indexOf, i2, a2);
        return sb.toString();
    }

    public static String removeParams(String str) {
        int indexOf = str.indexOf("?");
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public static String getMoneyTransferDeeplink() {
        return deeplinkSchemaName() + "cash_wallet?featuretype=money_transfer";
    }

    public static String getDeviceName() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }

    public static String getAccountNoV4Format(Context context, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    if (str.equalsIgnoreCase("null")) {
                        return context.getString(R.string.upi_v4_bank) + " XX " + str2.substring(str2.length() - 4);
                    }
                    return str + " XX " + str2.substring(str2.length() - 4);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                return context.getString(R.string.upi_v4_bank) + " XX " + str2.substring(str2.length() - 4);
            }
            return context.getString(R.string.upi_v4_bank) + " XX";
        } catch (Exception e2) {
            e2.printStackTrace();
            return context.getString(R.string.upi_v4_bank) + str2;
        }
    }

    public static String getAccountNoV4Format(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return " XX " + str.substring(str.length() - 4);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String toCamelCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (String str2 : str.split(" ")) {
            if (!str2.isEmpty()) {
                sb.append(Character.toUpperCase(str2.charAt(0)));
                sb.append(str2.substring(1).toLowerCase());
            }
            if (sb.length() != str.length()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void setBankIcon(ImageView imageView, String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_bhim));
        } else if (URLUtil.isValidUrl(str)) {
            w.a().a(str).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(UpiRequestBuilder.getBankIconUrl(context.getApplicationContext(), str)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        }
    }

    public static URI appendUri(String str, String str2) throws URISyntaxException {
        URI uri = new URI(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String path = uri.getPath();
        if (uri.getQuery() != null) {
            str2 = uri.getQuery() + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + str2;
        }
        return new URI(scheme, authority, path, str2, uri.getFragment());
    }

    public static boolean shouldShowToolTip(Context context) {
        long b2 = PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b("ToolTipTime", 0, false);
        int b3 = PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b("ToolTipTimeDisplayCount", 0, false);
        if (b2 == 0) {
            com.paytm.b.a.a pref = PaytmUpiPrefUtil.getPref(context.getApplicationContext());
            pref.a("ToolTipTime", System.currentTimeMillis(), false);
            pref.a("ToolTipTimeDisplayCount", b3 + 1, false);
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        if (simpleDateFormat.format(new Date(b2)).equals(simpleDateFormat.format(new Date(System.currentTimeMillis()))) || b3 >= UpiGTMLoader.getInstance().getDayCount()) {
            return false;
        }
        com.paytm.b.a.a pref2 = PaytmUpiPrefUtil.getPref(context.getApplicationContext());
        pref2.a("ToolTipTime", System.currentTimeMillis(), false);
        pref2.a("ToolTipTimeDisplayCount", b3 + 1, false);
        return true;
    }

    public static String compressImage(String str) {
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
        options.inSampleSize = calculateInSampleSize(options, i4, i2);
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
                e4.printStackTrace();
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str));
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
            }
        }
        return str;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
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
}
