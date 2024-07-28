package com.alipay.iap.android.webapp.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.provider.LanguageProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.view.H5NavigationBar;
import com.business.merchant_payments.common.utility.AppUtility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

public class KitUtils {
    private static final String TAG = "KitUtils";

    public static int compareVersion(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i2 == i3 ? 0 : -1;
    }

    public static <T> T getH5Provider(String str) {
        return H5Utils.getProvider(str);
    }

    public static String getAssetUrl(String str) {
        return H5NavigationBar.FILE_ANDROID_ASSET_PREFIX.concat(String.valueOf(str));
    }

    public static String base64(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(Base64.encode(bArr, 0));
            } catch (Exception unused) {
                c.j();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.alipay.iap.android.common.b.c.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        if (r1 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        com.alipay.iap.android.common.b.c.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
        com.alipay.iap.android.common.b.c.j();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0030 A[SYNTHETIC, Splitter:B:25:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getAssetBytesContent(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x001f, all -> 0x001c }
            int r2 = r1.available()     // Catch:{ IOException -> 0x0020 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0020 }
            r1.read(r2)     // Catch:{ IOException -> 0x0020 }
            if (r1 == 0) goto L_0x001b
            r1.close()     // Catch:{ IOException -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            com.alipay.iap.android.common.b.c.j()
        L_0x001b:
            return r2
        L_0x001c:
            r2 = move-exception
            r1 = r0
            goto L_0x002e
        L_0x001f:
            r1 = r0
        L_0x0020:
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            com.alipay.iap.android.common.b.c.j()
        L_0x002c:
            return r0
        L_0x002d:
            r2 = move-exception
        L_0x002e:
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0037
        L_0x0034:
            com.alipay.iap.android.common.b.c.j()
        L_0x0037:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.webapp.sdk.utils.KitUtils.getAssetBytesContent(android.content.Context, java.lang.String):byte[]");
    }

    public static String getAssetContent(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
        } catch (IOException unused) {
            c.j();
        }
        return sb.toString();
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getLanguage() {
        LanguageProvider languageProvider = (LanguageProvider) getH5Provider(LanguageProvider.class.getName());
        String language = languageProvider != null ? languageProvider.getLanguage() : null;
        return TextUtils.isEmpty(language) ? Locale.getDefault().toString() : language;
    }

    public static boolean isDomainMatch(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String domain = getDomain(str2);
        if (TextUtils.isEmpty(domain)) {
            return false;
        }
        if (domain.equals(str)) {
            return true;
        }
        return domain.endsWith(AppUtility.CENTER_DOT.concat(String.valueOf(str)));
    }

    public static int compareVersion(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length > split2.length ? split2.length : split.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                int i3 = (Long.parseLong(split2[i2]) > Long.parseLong(split[i2]) ? 1 : (Long.parseLong(split2[i2]) == Long.parseLong(split[i2]) ? 0 : -1));
                if (i3 > 0) {
                    return 1;
                }
                if (i3 < 0) {
                    return -1;
                }
                i2++;
            } catch (NumberFormatException e2) {
                e2.getMessage();
                c.i();
                return -1;
            }
        }
        if (split2.length == split.length) {
            return 0;
        }
        if (split2.length > split.length) {
            return 1;
        }
        return -1;
    }

    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            c.j();
            return null;
        }
    }

    public static String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf <= 0 || lastIndexOf >= str.length()) ? str : str.substring(lastIndexOf + 1, str.length());
    }

    public static void enableSlowWholeDocumentDraw() {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                WebView.enableSlowWholeDocumentDraw();
            } catch (Exception unused) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            WebView.enableSlowWholeDocumentDraw();
                        } catch (Exception unused) {
                            c.f();
                        }
                    }
                }, 1000);
            }
        }
    }
}
