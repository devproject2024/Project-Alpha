package net.one97.paytm.h5paytmsdk.d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f17102a = new g();

    private g() {
    }

    public static String a(long j, boolean z) {
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(j);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        String str = "-";
        if (hours > 0) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (!z) {
                str = "";
            }
            objArr[0] = str;
            objArr[1] = Long.valueOf(hours);
            objArr[2] = Long.valueOf(minutes - TimeUnit.HOURS.toMinutes(hours));
            objArr[3] = Long.valueOf(seconds - TimeUnit.MINUTES.toSeconds(minutes));
            String format = String.format(locale, "%s%02d:%02d:%02d", objArr);
            k.a((Object) format, "java.lang.String.format(…ds(minutes)\n            )");
            return format;
        }
        Locale locale2 = Locale.getDefault();
        Object[] objArr2 = new Object[3];
        if (!z) {
            str = "";
        }
        objArr2[0] = str;
        objArr2[1] = Long.valueOf(minutes);
        objArr2[2] = Long.valueOf(seconds - TimeUnit.MINUTES.toSeconds(minutes));
        String format2 = String.format(locale2, "%s%02d:%02d", objArr2);
        k.a((Object) format2, "java.lang.String.format(…econds(minutes)\n        )");
        return format2;
    }

    public static Drawable a(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i2});
        try {
            return obtainStyledAttributes.getDrawable(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
