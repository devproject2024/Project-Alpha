package androidx.core.content.a;

import android.content.pm.PackageInfo;
import android.os.Build;

public final class a {
    public static long a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }
}
