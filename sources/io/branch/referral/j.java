package io.branch.referral;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.text.TextUtils;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f46515a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f46516b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f46517c;

    /* renamed from: d  reason: collision with root package name */
    private static String f46518d;

    /* renamed from: e  reason: collision with root package name */
    private static a f46519e;

    public enum a {
        CordovaIonic,
        PhoneGap,
        Unity,
        Corona,
        Xamarin,
        ReactNative,
        Titanium,
        mParticle,
        AdobeLaunch,
        AdobeLaunchMobileUI,
        Segment
    }

    static boolean a(Context context) {
        if (!f46516b && f46517c == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("io.branch.sdk.TestMode")) {
                    Resources resources = context.getResources();
                    f46516b = Boolean.parseBoolean(resources.getString(resources.getIdentifier("io.branch.sdk.TestMode", "string", context.getPackageName())));
                } else {
                    f46516b = applicationInfo.metaData.getBoolean("io.branch.sdk.TestMode", false);
                }
            } catch (Exception unused) {
            }
            f46517c = Boolean.valueOf(f46516b);
        }
        return f46516b;
    }

    public static boolean a() {
        return f46516b;
    }

    static void a(boolean z) {
        f46516b = z;
    }

    public static boolean b() {
        return f46515a || f46516b;
    }

    public static String c() {
        return f46518d;
    }

    public static a d() {
        return f46519e;
    }

    public static String b(Context context) {
        String str = f46516b ? "io.branch.sdk.BranchKey.test" : "io.branch.sdk.BranchKey";
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null && (str2 = applicationInfo.metaData.getString(str)) == null && f46516b) {
                str2 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            Resources resources = context.getResources();
            return resources.getString(resources.getIdentifier(str, "string", context.getPackageName()));
        } catch (Exception unused2) {
            return str2;
        }
    }
}
