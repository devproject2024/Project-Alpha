package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.FileProvider;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.squareup.a.b;
import io.reactivex.rxjava3.g.c;
import io.reactivex.rxjava3.i.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiContract;

public class CommonUtil {
    private static final String TAG = "CommonUtil";
    private static final NavigableMap<Long, String> suffixes;

    public interface Callback {
        void callBack(boolean z);
    }

    public static String capitalizeString(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toLowerCase().toCharArray();
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (!z && Character.isLetter(charArray[i2])) {
                charArray[i2] = Character.toUpperCase(charArray[i2]);
                z = true;
            } else if (Character.isWhitespace(charArray[i2]) || charArray[i2] == '.' || charArray[i2] == '\'') {
                z = false;
            }
        }
        return String.valueOf(charArray);
    }

    public static int convertDpToPixel(float f2, Context context) {
        return Math.round(f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return capitalize(str2);
        }
        return capitalize(str) + " " + str2;
    }

    private static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static String getAndroidVersion() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static void hideKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isBranchLink(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return false;
        }
        if (((uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) && uri.getHost().equalsIgnoreCase("shrs.me")) || uri.getHost().equalsIgnoreCase("jnua.app.link") || uri.getHost().equalsIgnoreCase("jnua.test-app.link")) {
            return true;
        }
        return false;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <S, T> boolean isEmpty(Map<S, T> map) {
        return map == null || map.isEmpty();
    }

    public static int colorBurn(int i2) {
        return Color.rgb((int) Math.floor(((double) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID)) * 0.9d), (int) Math.floor(((double) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID)) * 0.9d), (int) Math.floor(((double) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID)) * 0.9d));
    }

    public static int[] getWindowSize(Context context) {
        int i2;
        int i3;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i2 = point.x;
            i3 = point.y;
        } else {
            int width = defaultDisplay.getWidth();
            i3 = defaultDisplay.getHeight();
            i2 = width;
        }
        return new int[]{i2, i3};
    }

    public static int getWindowWidth(Context context) {
        try {
            return getWindowSize(context)[0];
        } catch (NullPointerException unused) {
            return 400;
        }
    }

    public static void shareImageWhatsApp(Context context, String str, String str2, String str3, final boolean z, final Event event, HashMap<String, Object> hashMap) {
        CompressImageUtil.createBitmap(context, str2, 816, 816).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new c<Bitmap>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
            }

            public final void onNext(Bitmap bitmap) {
            }
        });
    }

    public static void shareImageChooser(final Context context, final String str, String str2) {
        CompressImageUtil.createBitmap(SheroesSdk.getApplicationContext(), str2, 816, 816).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new c<Bitmap>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
            }

            public final void onNext(Bitmap bitmap) {
                CommonUtil.shareCardViaSocial(context, bitmap, str);
            }
        });
    }

    public static File getFilFromBitmap(Context context, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file = new File(context.getCacheDir(), "images");
        file.mkdirs();
        String str = "IMG_" + new Date().getTime() + ".png";
        try {
            fileOutputStream = new FileOutputStream(file + "/" + str);
        } catch (FileNotFoundException unused) {
            fileOutputStream = null;
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
        return new File(file, str);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getImagePathFromInputStreamUri(android.content.Context r2, android.net.Uri r3) {
        /*
            java.lang.String r0 = r3.getAuthority()
            r1 = 0
            if (r0 == 0) goto L_0x0036
            android.content.ContentResolver r0 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x002d, all -> 0x0022 }
            java.io.InputStream r3 = r0.openInputStream(r3)     // Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x002d, all -> 0x0022 }
            java.io.File r2 = createTemporalFileFrom(r2, r3)     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x002e, all -> 0x0020 }
            java.lang.String r1 = r2.getPath()     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x002e, all -> 0x0020 }
            r3.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x0036
        L_0x001b:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0036
        L_0x0020:
            r2 = move-exception
            goto L_0x0024
        L_0x0022:
            r2 = move-exception
            r3 = r1
        L_0x0024:
            r3.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002c:
            throw r2
        L_0x002d:
            r3 = r1
        L_0x002e:
            r3.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x0036
        L_0x0032:
            r3 = r1
        L_0x0033:
            r3.close()     // Catch:{ IOException -> 0x001b }
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil.getImagePathFromInputStreamUri(android.content.Context, android.net.Uri):java.lang.String");
    }

    private static File createTemporalFileFrom(Context context, InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        File createTemporalFile = createTemporalFile(context);
        FileOutputStream fileOutputStream = new FileOutputStream(createTemporalFile);
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                    return createTemporalFile;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return createTemporalFile;
                }
            }
        }
    }

    private static File createTemporalFile(Context context) {
        return new File(context.getExternalCacheDir(), "IMG_" + new Date().getTime() + ".png");
    }

    public static void shareBitmapWhatsApp(Context context, Bitmap bitmap, String str, String str2, String str3, Event event, HashMap<String, Object> hashMap) {
        Uri contentUriFromBitmap = getContentUriFromBitmap(context, bitmap);
        if (contentUriFromBitmap != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", contentUriFromBitmap);
            intent.setType("image/jpeg");
            if (isNotEmpty(str3)) {
                intent.putExtra("android.intent.extra.TEXT", str3);
            }
            if (isAppInstalled(context, AppConstants.WHATS_APP)) {
                intent.setPackage(AppConstants.WHATS_APP);
                context.startActivity(intent);
            } else {
                context.startActivity(Intent.createChooser(intent, "Share via"));
            }
            if (event != null) {
                if (!StringUtil.isNotNullOrEmptyString(str) || !str.equalsIgnoreCase(AppConstants.CHALLENGE_GRATIFICATION_SCREEN)) {
                    HashMap<String, Object> build = new EventProperty.Builder().sharedTo(BaseActivity.SHARE_WHATSAPP).build();
                    build.put(EventProperty.SCREEN_NAME.getString(), str);
                    if (event.equals(Event.IMAGE_SHARED)) {
                        build.put(EventProperty.URL.getString(), str2);
                    }
                    hashMap.put(EventProperty.SHARED_TO.getString(), BaseActivity.SHARE_WHATSAPP);
                    AnalyticsManager.trackEvent(event, str, (Map<String, Object>) hashMap);
                    return;
                }
                HashMap<String, Object> build2 = new EventProperty.Builder().sharedTo(BaseActivity.SHARE_WHATSAPP).build();
                build2.put(EventProperty.URL.getString(), str2);
                AnalyticsManager.trackEvent(Event.CHALLENGE_SHARED, str, (Map<String, Object>) build2);
            }
        }
    }

    public static String getThumborUri(String str, int i2, int i3) {
        if (!isNotEmpty(str)) {
            return "";
        }
        try {
            b a2 = SheroesThumbor.getInstance().a(URLEncoder.encode(str, AppConstants.UTF_8)).a(i2, i3).a(b.a(b.c.WEBP)).a("no_upscale()");
            if (a2.f33757e) {
                a2.f33758f = true;
                return a2.a();
            }
            throw new IllegalStateException("Image must be resized first in order to smart align.");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static Uri getContentUriFromBitmap(Context context, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file = new File(context.getCacheDir(), "images");
        file.mkdirs();
        String str = "IMG_" + new Date().getTime() + ".png";
        try {
            fileOutputStream = new FileOutputStream(file + "/" + str);
        } catch (FileNotFoundException unused) {
            fileOutputStream = null;
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
        return FileProvider.getUriForFile(context, "net.one97.paytm.com.sheroes.final_sdk.provider", new File(file, str));
    }

    public static void shareLinkToWhatsApp(Context context, String str) {
        if (isAppInstalled(context, AppConstants.WHATS_APP)) {
            Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
            type.putExtra("android.intent.extra.TEXT", str);
            type.setPackage(AppConstants.WHATS_APP);
            context.startActivity(type);
        }
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !TextUtils.isEmpty(str);
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    static {
        TreeMap treeMap = new TreeMap();
        suffixes = treeMap;
        treeMap.put(1000L, AppConstants.THOUSANDS);
        suffixes.put(1000000L, "M");
        suffixes.put(1000000000L, "B");
        suffixes.put(1000000000000L, "T");
    }

    public static String getRoundedMetricFormat(long j) {
        while (j == Long.MIN_VALUE) {
            j = -9223372036854775807L;
        }
        if (j < 0) {
            return "-" + getRoundedMetricFormat(-j);
        } else if (j < 1000) {
            return Long.toString(j);
        } else {
            Map.Entry<Long, String> floorEntry = suffixes.floorEntry(Long.valueOf(j));
            String value = floorEntry.getValue();
            long longValue = j / (floorEntry.getKey().longValue() / 10);
            if (longValue < 100 && ((double) longValue) / 10.0d != ((double) (longValue / 10))) {
                return (((double) longValue) / 10.0d) + value;
            }
            return (longValue / 10) + value;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r3 != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean ensureFirstTime(java.lang.String r5) {
        /*
            java.lang.Class<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil> r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil.class
            monitor-enter(r0)
            android.content.SharedPreferences r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk.getAppSharedPrefs()     // Catch:{ all -> 0x0023 }
            r2 = 0
            if (r1 != 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            boolean r3 = r1.getBoolean(r5, r2)     // Catch:{ all -> 0x0023 }
            r4 = 1
            if (r3 != 0) goto L_0x001e
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x0023 }
            android.content.SharedPreferences$Editor r5 = r1.putBoolean(r5, r4)     // Catch:{ all -> 0x0023 }
            r5.commit()     // Catch:{ all -> 0x0023 }
        L_0x001e:
            monitor-exit(r0)
            if (r3 != 0) goto L_0x0022
            return r4
        L_0x0022:
            return r2
        L_0x0023:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil.ensureFirstTime(java.lang.String):boolean");
    }

    public static String getPref(String str) {
        SharedPreferences appSharedPrefs = SheroesSdk.getAppSharedPrefs();
        if (appSharedPrefs == null) {
            return "";
        }
        return appSharedPrefs.getString(str, "");
    }

    public static void clearPref(String str) {
        SharedPreferences appSharedPrefs = SheroesSdk.getAppSharedPrefs();
        if (appSharedPrefs != null) {
            appSharedPrefs.edit().remove(str).commit();
        }
    }

    public static void shareCardViaSocial(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("Check out this post on the SHEROES App. I loved it. android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, AppConstants.SHARE));
    }

    public static void shareCardViaSocial(Context context, Bitmap bitmap, String str) {
        Uri contentUriFromBitmap = getContentUriFromBitmap(context, bitmap);
        if (contentUriFromBitmap != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", contentUriFromBitmap);
            intent.setType("image/jpeg");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.putExtra("Check out this post on the SHEROES App. I loved it. android.intent.extra.TEXT", str);
            context.startActivity(Intent.createChooser(intent, AppConstants.SHARE));
        }
    }

    public static void setUserIdPref(String str, String str2) {
        SharedPreferences appSharedPrefs = SheroesSdk.getAppSharedPrefs();
        if (appSharedPrefs != null) {
            appSharedPrefs.edit().putString(str, str2).apply();
        }
    }

    public static boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    public static String getDeviceId() {
        try {
            if (!isNotEmpty("")) {
                return Settings.Secure.getString(SheroesSdk.getApplicationContext().getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            }
            return "";
        } catch (Exception e2) {
            e2.getMessage();
            return " ";
        }
    }

    public static String getDeviceManufacturer() {
        String str = Build.MANUFACTURER;
        return !StringUtil.isNotNullOrEmptyString(str) ? Build.BRAND : str;
    }
}
