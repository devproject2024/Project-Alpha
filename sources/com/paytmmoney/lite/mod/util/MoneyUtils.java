package com.paytmmoney.lite.mod.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.app.a;
import androidx.core.content.b;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.PaytmMoneyManager;
import com.paytmmoney.lite.mod.R;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import org.json.JSONObject;

public class MoneyUtils {
    public static String getHomePageURLType() {
        return "main";
    }

    public static String getDefaultDirectory() {
        String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "PM";
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            q.d("Oops! Failed create PM directory");
        }
        return str;
    }

    public static String getReadableFileSize(File file) {
        long length = file.length();
        if (length <= 0) {
            return "0";
        }
        double d2 = (double) length;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d2 / Math.pow(1024.0d, (double) log10)) + " " + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public static Uri saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        File file = new File(getDefaultDirectory(), str);
        if (file.exists()) {
            file.delete();
            file = new File(getDefaultDirectory(), str);
        }
        try {
            boolean createNewFile = file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, 100, fileOutputStream);
            bitmap.recycle();
            fileOutputStream.flush();
            fileOutputStream.close();
            return Uri.fromFile(file);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (!file.exists() || 0 == 0) {
                return null;
            }
            file.delete();
            return null;
        }
    }

    public static long getUtcOffset() {
        return (long) (TimeZone.getDefault().getOffset(new Date().getTime()) / 60000);
    }

    public static boolean isIntentHandled(Intent intent, Activity activity) {
        return (intent == null || intent.resolveActivity(activity.getPackageManager()) == null) ? false : true;
    }

    public static void handleCommonIntent(Intent intent, Integer num, Activity activity) {
        if (!isIntentHandled(intent, activity)) {
            Toast.makeText(activity, activity.getString(R.string.no_client_available), 0).show();
        } else if (num == null) {
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, num.intValue());
        }
    }

    public static boolean checkPermission(Activity activity, String str, boolean z, int i2) {
        Boolean bool = Boolean.FALSE;
        if (b.a((Context) activity, str) == 0) {
            bool = Boolean.TRUE;
        } else if (z) {
            a.a(activity, new String[]{str}, i2);
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    public static String getRequestId() {
        return getRandomNumber().toString() + getTimeStamp();
    }

    public static Integer getRandomNumber() {
        try {
            return Integer.valueOf(new Random().nextInt(1000) + 100);
        } catch (RuntimeException unused) {
            return 0;
        }
    }

    public static Long getTimeStamp() {
        try {
            return Long.valueOf(System.currentTimeMillis() / 1000);
        } catch (RuntimeException unused) {
            return 0L;
        }
    }

    public static String getDefaultDirectoryForPdf() {
        if (Build.VERSION.SDK_INT >= 19) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + File.separator + "Paytm";
        }
        return Environment.getExternalStoragePublicDirectory("Documents") + File.separator + "Paytm";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri savePdfToFile(java.io.InputStream r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = getDefaultDirectoryForPdf()
            r0.<init>(r1, r5)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003b }
            r5.<init>(r0)     // Catch:{ Exception -> 0x003b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x002f }
        L_0x0012:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x002f }
            if (r2 <= 0) goto L_0x001d
            r3 = 0
            r5.write(r1, r3, r2)     // Catch:{ all -> 0x002f }
            goto L_0x0012
        L_0x001d:
            r5.flush()     // Catch:{ all -> 0x002f }
            r5.close()     // Catch:{ all -> 0x002f }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x002f }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x002f }
            r5.close()     // Catch:{ Exception -> 0x003b }
            return r4
        L_0x002f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r0 = move-exception
            r5.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch:{ Exception -> 0x003b }
        L_0x003a:
            throw r0     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            r4 = move-exception
            r4.printStackTrace()
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmoney.lite.mod.util.MoneyUtils.savePdfToFile(java.io.InputStream, java.lang.String):android.net.Uri");
    }

    public static String getPaytmLiteUserAgent(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android-lite");
            jSONObject.put("app_version", PaytmMoneyManager.INSTANCE.getAppVersion());
            jSONObject.put("device_id", com.paytm.utility.b.A(context));
            jSONObject.put("model", Build.MANUFACTURER + "  " + Build.MODEL);
            jSONObject.put("os_version", com.paytm.utility.b.d());
            jSONObject.put("user_id", PaytmMoneyManager.INSTANCE.getUserId(context));
            jSONObject.put("lite_version", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return String.valueOf(jSONObject);
    }

    public static String getDeepLinkUriForNative(Uri uri) {
        if (uri == null) {
            return "";
        }
        return PMConstants.PAYTM_MONEY_APP_URI + uri.getPath();
    }

    public static boolean isBlogDeepLink(Uri uri) {
        return uri != null && uri.getPath().startsWith(PMConstants.BLOG_PATH);
    }

    public static boolean isAppInstalled(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(str, 1);
            return packageManager.getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
