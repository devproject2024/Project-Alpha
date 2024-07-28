package com.alibaba.wireless.security.a.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Method;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f14599a = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14600b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f14601c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f14602d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f14603e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f14604f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f14605g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f14606h = true;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f14607i = false;

    public static String a(ClassLoader classLoader, String str) {
        if (classLoader == null || str == null || "".equals(str)) {
            return null;
        }
        String a2 = a(classLoader, str, true);
        return a2 == null ? a(classLoader, str, false) : a2;
    }

    private static String a(ClassLoader classLoader, String str, boolean z) {
        Method method;
        if (classLoader == null) {
            return null;
        }
        if (z) {
            try {
                method = classLoader.getClass().getMethod("findLibrary", new Class[]{String.class});
            } catch (Exception unused) {
                return null;
            }
        } else {
            method = classLoader.getClass().getDeclaredMethod("findLibrary", new Class[]{String.class});
        }
        if (method == null) {
            return null;
        }
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        Object invoke = method.invoke(classLoader, new Object[]{str});
        if (invoke == null || !(invoke instanceof String)) {
            return null;
        }
        return (String) invoke;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT > 27 || AppConstants.FEED_COMMUNITY_POST.equalsIgnoreCase(Build.VERSION.RELEASE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if ((r3.applicationInfo.flags & 128) == 0) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r3) {
        /*
            boolean r0 = f14600b
            if (r0 == 0) goto L_0x0029
            android.content.pm.PackageManager r0 = r3.getPackageManager()
            r1 = 0
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x0024 }
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r1)     // Catch:{ all -> 0x0024 }
            r0 = 1
            if (r3 == 0) goto L_0x0024
            android.content.pm.ApplicationInfo r2 = r3.applicationInfo     // Catch:{ all -> 0x0024 }
            int r2 = r2.flags     // Catch:{ all -> 0x0024 }
            r2 = r2 & r0
            if (r2 == 0) goto L_0x0024
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo     // Catch:{ all -> 0x0024 }
            int r3 = r3.flags     // Catch:{ all -> 0x0024 }
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            f14601c = r0
            f14600b = r1
        L_0x0029:
            boolean r3 = f14601c
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.a.e.a(android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0098 A[SYNTHETIC, Splitter:B:49:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009f A[SYNTHETIC, Splitter:B:53:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00aa A[SYNTHETIC, Splitter:B:62:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b1 A[SYNTHETIC, Splitter:B:66:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d5 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.zip.ZipFile r8, java.util.zip.ZipEntry r9, java.io.File r10) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x00d6
            if (r9 != 0) goto L_0x0007
            goto L_0x00d6
        L_0x0007:
            r1 = 1
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            r4.<init>()     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            java.lang.String r5 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            r4.append(r5)     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            java.lang.String r5 = ".tmp."
            r4.append(r5)     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            int r5 = android.os.Process.myPid()     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            r4.append(r5)     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00a6, all -> 0x0093 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r4 == 0) goto L_0x0033
            r3.delete()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
        L_0x0033:
            java.io.InputStream r8 = r8.getInputStream(r9)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008b, all -> 0x0086 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x008b, all -> 0x0086 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x008c, all -> 0x0084 }
        L_0x0040:
            int r6 = r8.read(r5)     // Catch:{ Exception -> 0x008c, all -> 0x0084 }
            r7 = -1
            if (r6 == r7) goto L_0x004b
            r4.write(r5, r0, r6)     // Catch:{ Exception -> 0x008c, all -> 0x0084 }
            goto L_0x0040
        L_0x004b:
            r8.close()     // Catch:{ Exception -> 0x008c, all -> 0x0084 }
            r4.flush()     // Catch:{ Exception -> 0x00a8, all -> 0x0082 }
            r4.close()     // Catch:{ Exception -> 0x00a8, all -> 0x0082 }
            boolean r8 = r10.exists()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r8 == 0) goto L_0x0068
            long r4 = r10.length()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            long r6 = r9.getSize()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0068
            r0 = 1
            goto L_0x00b4
        L_0x0068:
            boolean r8 = r3.exists()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r8 == 0) goto L_0x00b4
            long r4 = r3.length()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            long r6 = r9.getSize()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00b4
            r10.delete()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            boolean r0 = r3.renameTo(r10)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            goto L_0x00b4
        L_0x0082:
            r8 = move-exception
            goto L_0x0096
        L_0x0084:
            r9 = move-exception
            goto L_0x0088
        L_0x0086:
            r9 = move-exception
            r4 = r2
        L_0x0088:
            r2 = r8
            r8 = r9
            goto L_0x0096
        L_0x008b:
            r4 = r2
        L_0x008c:
            r2 = r8
            goto L_0x00a8
        L_0x008e:
            r8 = move-exception
            r4 = r2
            goto L_0x0096
        L_0x0091:
            r4 = r2
            goto L_0x00a8
        L_0x0093:
            r8 = move-exception
            r3 = r2
            r4 = r3
        L_0x0096:
            if (r2 == 0) goto L_0x009d
            r2.close()     // Catch:{ Exception -> 0x009c }
            goto L_0x009d
        L_0x009c:
        L_0x009d:
            if (r4 == 0) goto L_0x00a2
            r4.close()     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r3.delete()
            throw r8
        L_0x00a6:
            r3 = r2
            r4 = r3
        L_0x00a8:
            if (r2 == 0) goto L_0x00af
            r2.close()     // Catch:{ Exception -> 0x00ae }
            goto L_0x00af
        L_0x00ae:
        L_0x00af:
            if (r4 == 0) goto L_0x00b4
            r4.close()     // Catch:{ Exception -> 0x00b4 }
        L_0x00b4:
            r3.delete()
            if (r0 != 0) goto L_0x00d6
            boolean r8 = r10.exists()
            if (r8 == 0) goto L_0x00d6
            long r2 = r10.length()
            r4 = 0
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d6
            long r2 = r10.length()
            long r8 = r9.getSize()
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x00d6
            r0 = 1
        L_0x00d6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.a.e.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    public static boolean b(Context context) {
        boolean z;
        if (f14604f) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (!(packageInfo == null || (packageInfo.applicationInfo.flags & 128) == 0)) {
                    z = true;
                    f14605g = z;
                    f14604f = false;
                }
            } catch (Throwable unused) {
            }
            z = false;
            f14605g = z;
            f14604f = false;
        }
        return f14605g;
    }

    public static boolean c(Context context) {
        if (f14606h) {
            try {
                f14607i = d(context).equals(context.getPackageName());
                f14606h = false;
            } catch (Exception unused) {
            }
        }
        return f14607i;
    }

    private static String d(Context context) {
        try {
            int myPid = Process.myPid();
            if (context == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName != null ? next.processName : "";
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
