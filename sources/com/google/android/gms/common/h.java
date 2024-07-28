package com.google.android.gms.common;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.q;
import com.google.android.gms.common.util.t;
import com.sendbird.android.constant.StringSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8687a = false;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f8688b = 12451000;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicBoolean f8689c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8690d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f8691e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8692f = false;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicBoolean f8693g = new AtomicBoolean();

    @Deprecated
    public static boolean b(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    @Deprecated
    public static String a(int i2) {
        return ConnectionResult.a(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        if (com.google.android.gms.common.util.i.f8977a.booleanValue() == false) goto L_0x0090;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r4, int r5) {
        /*
            android.content.res.Resources r0 = r4.getResources()     // Catch:{ all -> 0x000a }
            int r1 = com.google.android.gms.common.R.string.common_google_play_services_unknown_issue     // Catch:{ all -> 0x000a }
            r0.getString(r1)     // Catch:{ all -> 0x000a }
            goto L_0x000b
        L_0x000a:
        L_0x000b:
            java.lang.String r0 = r4.getPackageName()
            java.lang.String r1 = "com.google.android.gms"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0058
            java.util.concurrent.atomic.AtomicBoolean r0 = f8693g
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0058
            int r0 = com.google.android.gms.common.internal.ay.b(r4)
            if (r0 == 0) goto L_0x0050
            int r1 = f8688b
            if (r0 != r1) goto L_0x002a
            goto L_0x0058
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r5 = 320(0x140, float:4.48E-43)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r5)
            java.lang.String r5 = "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected "
            r2.append(r5)
            r2.append(r1)
            java.lang.String r5 = " but found "
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r4.<init>(r5)
            throw r4
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
            r4.<init>(r5)
            throw r4
        L_0x0058:
            boolean r0 = com.google.android.gms.common.util.i.a((android.content.Context) r4)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x008f
            java.lang.Boolean r0 = com.google.android.gms.common.util.i.f8977a
            if (r0 != 0) goto L_0x0086
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "android.hardware.type.iot"
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 != 0) goto L_0x007f
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "android.hardware.type.embedded"
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r0 = 0
            goto L_0x0080
        L_0x007f:
            r0 = 1
        L_0x0080:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.i.f8977a = r0
        L_0x0086:
            java.lang.Boolean r0 = com.google.android.gms.common.util.i.f8977a
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r1 = 0
        L_0x0090:
            int r4 = a((android.content.Context) r4, (boolean) r1, (int) r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.h.a(android.content.Context, int):int");
    }

    private static int a(Context context, boolean z, int i2) {
        s.b(i2 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            i.a(context);
            if (!i.a(packageInfo2, true)) {
                String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid.");
                return 9;
            } else if (z && (!i.a(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid.");
                return 9;
            } else if (t.a(packageInfo2.versionCode) < t.a(i2)) {
                int i3 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                sb.append("Google Play services out of date for ");
                sb.append(packageName);
                sb.append(".  Requires ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(i3);
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                        return 1;
                    }
                }
                if (!applicationInfo.enabled) {
                    return 3;
                }
                return 0;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            String.valueOf(packageName).concat(" requires Google Play services, but they are missing.");
            return 1;
        }
    }

    @Deprecated
    public static void e(Context context) throws f, e {
        int a2 = d.b().a(context, (int) f8688b);
        if (a2 != 0) {
            Intent a3 = d.b().a(context, a2, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(a2);
            if (a3 == null) {
                throw new e(a2);
            }
            throw new f(a2, "Google Play Services not available", a3);
        }
    }

    @Deprecated
    public static boolean a(Context context, int i2, String str) {
        return q.a(context, i2, str);
    }

    public static boolean f(Context context) {
        if (!f8692f) {
            try {
                PackageInfo b2 = c.a(context).b("com.google.android.gms", 64);
                i.a(context);
                if (b2 == null || i.a(b2, false) || !i.a(b2, true)) {
                    f8691e = false;
                } else {
                    f8691e = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } finally {
                f8692f = true;
            }
        }
        return f8691e || !StringSet.user.equals(Build.TYPE);
    }

    @Deprecated
    public static void g(Context context) {
        if (!f8689c.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static Resources h(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Context i(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int j(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @Deprecated
    public static boolean b(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return a(context, "com.google.android.gms");
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        r5 = ((android.os.UserManager) r5.getSystemService(com.sendbird.android.constant.StringSet.user)).getApplicationRestrictions(r5.getPackageName());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "com.google.android.gms"
            boolean r0 = r6.equals(r0)
            boolean r1 = com.google.android.gms.common.util.n.d()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0036
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ Exception -> 0x0035 }
            android.content.pm.PackageInstaller r1 = r1.getPackageInstaller()     // Catch:{ Exception -> 0x0035 }
            java.util.List r1 = r1.getAllSessions()     // Catch:{ Exception -> 0x0035 }
            java.util.Iterator r1 = r1.iterator()
        L_0x001e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0036
            java.lang.Object r4 = r1.next()
            android.content.pm.PackageInstaller$SessionInfo r4 = (android.content.pm.PackageInstaller.SessionInfo) r4
            java.lang.String r4 = r4.getAppPackageName()
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x001e
            return r2
        L_0x0035:
            return r3
        L_0x0036:
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            r4 = 8192(0x2000, float:1.14794E-41)
            android.content.pm.ApplicationInfo r6 = r1.getApplicationInfo(r6, r4)     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r0 == 0) goto L_0x0045
            boolean r5 = r6.enabled     // Catch:{ NameNotFoundException -> 0x0077 }
            return r5
        L_0x0045:
            boolean r6 = r6.enabled     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r6 == 0) goto L_0x0077
            boolean r6 = com.google.android.gms.common.util.n.a()     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r6 == 0) goto L_0x0073
            java.lang.String r6 = "user"
            java.lang.Object r6 = r5.getSystemService(r6)     // Catch:{ NameNotFoundException -> 0x0077 }
            android.os.UserManager r6 = (android.os.UserManager) r6     // Catch:{ NameNotFoundException -> 0x0077 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0077 }
            android.os.Bundle r5 = r6.getApplicationRestrictions(r5)     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r5 == 0) goto L_0x0073
            java.lang.String r6 = "true"
            java.lang.String r0 = "restricted_profile"
            java.lang.String r5 = r5.getString(r0)     // Catch:{ NameNotFoundException -> 0x0077 }
            boolean r5 = r6.equals(r5)     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r5 == 0) goto L_0x0073
            r5 = 1
            goto L_0x0074
        L_0x0073:
            r5 = 0
        L_0x0074:
            if (r5 != 0) goto L_0x0077
            return r2
        L_0x0077:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.h.a(android.content.Context, java.lang.String):boolean");
    }
}
