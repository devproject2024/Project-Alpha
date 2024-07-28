package com.google.firebase.crashlytics.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.firebase.crashlytics.a.b;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import net.one97.paytm.upi.util.UpiContract;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<File> f38182a = new Comparator<File>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((File) obj).lastModified() - ((File) obj2).lastModified());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f38183b;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f38184c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d  reason: collision with root package name */
    private static long f38185d = -1;

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r6 = com.google.firebase.crashlytics.a.b.a();
        "Error parsing ".concat(java.lang.String.valueOf(r5));
        r6.a(6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r5 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.io.File r5, java.lang.String r6) {
        /*
            boolean r0 = r5.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0053
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r3 = 1024(0x400, float:1.435E-42)
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
        L_0x0013:
            java.lang.String r2 = r0.readLine()     // Catch:{ Exception -> 0x003c }
            if (r2 == 0) goto L_0x0034
            java.lang.String r3 = "\\s*:\\s*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ Exception -> 0x003c }
            r4 = 2
            java.lang.String[] r2 = r3.split(r2, r4)     // Catch:{ Exception -> 0x003c }
            int r3 = r2.length     // Catch:{ Exception -> 0x003c }
            r4 = 1
            if (r3 <= r4) goto L_0x0013
            r3 = 0
            r3 = r2[r3]     // Catch:{ Exception -> 0x003c }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x003c }
            if (r3 == 0) goto L_0x0013
            r5 = r2[r4]     // Catch:{ Exception -> 0x003c }
            r1 = r5
        L_0x0034:
            a((java.io.Closeable) r0)
            goto L_0x0053
        L_0x0038:
            r5 = move-exception
            r0 = r1
            goto L_0x004f
        L_0x003b:
            r0 = r1
        L_0x003c:
            com.google.firebase.crashlytics.a.b r6 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "Error parsing "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x004e }
            r2.concat(r5)     // Catch:{ all -> 0x004e }
            r5 = 6
            r6.a(r5)     // Catch:{ all -> 0x004e }
            goto L_0x0034
        L_0x004e:
            r5 = move-exception
        L_0x004f:
            a((java.io.Closeable) r0)
            throw r5
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.g.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static int a() {
        return a.getValue().ordinal();
    }

    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, a> matcher = null;

        static {
            HashMap hashMap = new HashMap(4);
            matcher = hashMap;
            hashMap.put("armeabi-v7a", ARMV7);
            matcher.put("armeabi", ARMV6);
            matcher.put("arm64-v8a", ARM64);
            matcher.put("x86", X86_32);
        }

        static a getValue() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                b.a().a(3);
                return UNKNOWN;
            }
            a aVar = matcher.get(str.toLowerCase(Locale.US));
            return aVar == null ? UNKNOWN : aVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4 = com.google.firebase.crashlytics.a.b.a();
        "Unexpected meminfo format while computing RAM: ".concat(java.lang.String.valueOf(r3));
        r4.a(6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized long b() {
        /*
            java.lang.Class<com.google.firebase.crashlytics.a.c.g> r0 = com.google.firebase.crashlytics.a.c.g.class
            monitor-enter(r0)
            long r1 = f38185d     // Catch:{ all -> 0x0082 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x007e
            r1 = 0
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "/proc/meminfo"
            r3.<init>(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "MemTotal"
            java.lang.String r3 = a((java.io.File) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0082 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0082 }
            if (r4 != 0) goto L_0x007c
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r3.toUpperCase(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "KB"
            boolean r4 = r3.endsWith(r4)     // Catch:{ NumberFormatException -> 0x006b }
            if (r4 == 0) goto L_0x0037
            java.lang.String r4 = "KB"
            r5 = 1024(0x400, float:1.435E-42)
            long r1 = a((java.lang.String) r3, (java.lang.String) r4, (int) r5)     // Catch:{ NumberFormatException -> 0x006b }
            goto L_0x007c
        L_0x0037:
            java.lang.String r4 = "MB"
            boolean r4 = r3.endsWith(r4)     // Catch:{ NumberFormatException -> 0x006b }
            if (r4 == 0) goto L_0x0048
            java.lang.String r4 = "MB"
            r5 = 1048576(0x100000, float:1.469368E-39)
            long r1 = a((java.lang.String) r3, (java.lang.String) r4, (int) r5)     // Catch:{ NumberFormatException -> 0x006b }
            goto L_0x007c
        L_0x0048:
            java.lang.String r4 = "GB"
            boolean r4 = r3.endsWith(r4)     // Catch:{ NumberFormatException -> 0x006b }
            if (r4 == 0) goto L_0x0059
            java.lang.String r4 = "GB"
            r5 = 1073741824(0x40000000, float:2.0)
            long r1 = a((java.lang.String) r3, (java.lang.String) r4, (int) r5)     // Catch:{ NumberFormatException -> 0x006b }
            goto L_0x007c
        L_0x0059:
            com.google.firebase.crashlytics.a.b r4 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ NumberFormatException -> 0x006b }
            java.lang.String r5 = "Unexpected meminfo format while computing RAM: "
            java.lang.String r6 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x006b }
            r5.concat(r6)     // Catch:{ NumberFormatException -> 0x006b }
            r5 = 3
            r4.a(r5)     // Catch:{ NumberFormatException -> 0x006b }
            goto L_0x007c
        L_0x006b:
            com.google.firebase.crashlytics.a.b r4 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "Unexpected meminfo format while computing RAM: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0082 }
            r5.concat(r3)     // Catch:{ all -> 0x0082 }
            r3 = 6
            r4.a(r3)     // Catch:{ all -> 0x0082 }
        L_0x007c:
            f38185d = r1     // Catch:{ all -> 0x0082 }
        L_0x007e:
            long r1 = f38185d     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)
            return r1
        L_0x0082:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.g.b():long");
    }

    private static long a(String str, String str2, int i2) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i2);
    }

    public static ActivityManager.RunningAppProcessInfo a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static String a(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    private static String a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            b a2 = b.a();
            StringBuilder sb = new StringBuilder("Could not create hashing algorithm: ");
            sb.append(str);
            sb.append(", returning empty string.");
            a2.a(6);
            return "";
        }
    }

    public static String a(String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < 4; i2++) {
            String str = strArr[i2];
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String append : arrayList) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return a(sb2);
        }
        return null;
    }

    public static long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static boolean d(Context context) {
        if (!e(context) && ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return true;
        }
        int a2 = a(context, str, "bool");
        if (a2 > 0) {
            return resources.getBoolean(a2);
        }
        int a3 = a(context, str, "string");
        if (a3 > 0) {
            return Boolean.parseBoolean(context.getString(a3));
        }
        return true;
    }

    private static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, l(context));
    }

    public static boolean e(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID) == null;
    }

    public static boolean f(Context context) {
        boolean e2 = e(context);
        String str = Build.TAGS;
        if ((!e2 && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (e2 || !file.exists()) {
            return false;
        }
        return true;
    }

    public static int g(Context context) {
        boolean e2 = e(context);
        if (f(context)) {
            e2 |= true;
        }
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger() ? e2 | true ? 1 : 0 : e2 ? 1 : 0;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = f38184c;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static boolean h(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String b(Context context, String str) {
        int a2 = a(context, str, "string");
        return a2 > 0 ? context.getString(a2) : "";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                b.a().a(6);
            }
        }
    }

    public static void a(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException unused) {
                b.a().a(6);
            }
        }
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public static String a(int i2) {
        if (i2 >= 0) {
            return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i2)}).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    private static String l(Context context) {
        int i2 = context.getApplicationContext().getApplicationInfo().icon;
        if (i2 > 0) {
            try {
                return context.getResources().getResourcePackageName(i2);
            } catch (Resources.NotFoundException unused) {
            }
        }
        return context.getPackageName();
    }

    public static String i(Context context) {
        int a2 = a(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (a2 == 0) {
            a2 = a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a2 != 0) {
            return context.getResources().getString(a2);
        }
        return null;
    }

    public static String j(Context context) {
        int a2 = a(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (a2 == 0) {
            return null;
        }
        String string = context.getResources().getString(a2);
        b a3 = b.a();
        "Unity Editor version is: ".concat(String.valueOf(string));
        a3.a(3);
        return string;
    }

    public static String a(String str) {
        return a(str.getBytes(), "SHA-1");
    }

    public static boolean k(Context context) {
        if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
