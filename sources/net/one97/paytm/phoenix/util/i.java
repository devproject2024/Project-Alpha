package net.one97.paytm.phoenix.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.mobile.nebulacore.view.H5NavigationBar;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f59645a = new i();

    private i() {
    }

    public static final String a(String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
        return H5NavigationBar.FILE_ANDROID_ASSET_PREFIX.concat(String.valueOf(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c A[Catch:{ all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0015
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ all -> 0x0013 }
            if (r1 == 0) goto L_0x0015
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x0013 }
            r2 = 0
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r2)     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r3 = move-exception
            goto L_0x0020
        L_0x0015:
            r3 = r0
        L_0x0016:
            if (r3 == 0) goto L_0x0029
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch:{ all -> 0x0013 }
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = r3.dataDir     // Catch:{ all -> 0x0013 }
            r0 = r3
            goto L_0x0029
        L_0x0020:
            net.one97.paytm.phoenix.util.j r1 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r1 = "PhoenixFileUtil"
            java.lang.String r2 = "exception detail"
            net.one97.paytm.phoenix.util.j.a(r1, r2, r3)
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.util.i.a(android.content.Context):java.lang.String");
    }

    public static final boolean b(String str) {
        boolean z;
        k.c(str, "absPath");
        File file = new File(str);
        if (d(str)) {
            k.c(str, "absPath");
            if (!d(str)) {
                z = false;
            } else {
                z = new File(str).isDirectory();
            }
            if (!z) {
                return false;
            }
        }
        try {
            file.mkdirs();
        } catch (Exception e2) {
            j jVar = j.f59646a;
            j.a("PhoenixFileUtil", "exception detail", e2);
        }
        return a(file);
    }

    private static boolean d(String str) {
        k.c(str, "absPath");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    private static boolean a(File file) {
        return file.exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri a(android.content.Context r7, android.graphics.Bitmap r8) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "bitmap"
            kotlin.g.b.k.c(r8, r0)
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = android.os.Environment.DIRECTORY_PICTURES
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x001e
            r0.mkdir()
        L_0x001e:
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077 }
            java.lang.String r3 = "tmp_"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0077 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0077 }
            r2.append(r3)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0077 }
            r3 = 4
            java.io.File r2 = a(r7, r2, r1, r3)     // Catch:{ Exception -> 0x0077 }
            if (r2 == 0) goto L_0x005d
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0077 }
            if (r3 == 0) goto L_0x0043
            r2.delete()     // Catch:{ Exception -> 0x0077 }
        L_0x0043:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077 }
            r3.<init>()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r7.getPackageName()     // Catch:{ Exception -> 0x0077 }
            r3.append(r4)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = ".provider"
            r3.append(r4)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0077 }
            android.net.Uri r7 = androidx.core.content.FileProvider.getUriForFile(r7, r3, r2)     // Catch:{ Exception -> 0x0077 }
            goto L_0x005e
        L_0x005d:
            r7 = r1
        L_0x005e:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0072 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0072 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0072 }
            r4 = 90
            r5 = r3
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ Exception -> 0x0072 }
            r8.compress(r2, r4, r5)     // Catch:{ Exception -> 0x0072 }
            r3.close()     // Catch:{ Exception -> 0x0072 }
            r0 = 1
            goto L_0x007d
        L_0x0072:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0079
        L_0x0077:
            r7 = move-exception
            r8 = r1
        L_0x0079:
            r7.printStackTrace()
            r7 = r8
        L_0x007d:
            if (r0 == 0) goto L_0x0080
            return r7
        L_0x0080:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.util.i.a(android.content.Context, android.graphics.Bitmap):android.net.Uri");
    }

    public static /* synthetic */ File a(Context context, String str, String str2, int i2) throws IOException {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = ".png";
        }
        return a(context, str, str2);
    }

    private static File a(Context context, String str, String str2) throws IOException {
        k.c(context, "context");
        k.c(str2, "suffix");
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        k.a((Object) format, "SimpleDateFormat(\"yyyyMM…Default()).format(Date())");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Image_");
        if (str == null) {
            str = format;
        }
        sb.append(str);
        return File.createTempFile(sb.toString(), str2, externalFilesDir);
    }
}
