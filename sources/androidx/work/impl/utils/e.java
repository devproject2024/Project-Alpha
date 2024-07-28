package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.l;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5448a = l.a("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z) {
        String str;
        String str2 = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            l.a();
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            String.format("%s %s", objArr);
        } catch (Exception e2) {
            l.a();
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            String.format("%s could not be %s", objArr2);
            new Throwable[1][0] = e2;
        }
    }
}
