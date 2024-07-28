package net.one97.paytm.feed.utility;

import android.content.Context;
import android.content.res.Resources;
import kotlin.g.b.k;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f35432a = new r();

    private r() {
    }

    public static float a(float f2, Context context) {
        k.c(context, "context");
        Resources resources = context.getResources();
        k.a((Object) resources, "resources");
        return f2 * (((float) resources.getDisplayMetrics().densityDpi) / 160.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float b(float r1, android.content.Context r2) {
        /*
            if (r2 == 0) goto L_0x000d
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x000d
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            r0 = 1
            float r1 = android.util.TypedValue.applyDimension(r0, r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.utility.r.b(float, android.content.Context):float");
    }

    public static int a() {
        Resources system = Resources.getSystem();
        k.a((Object) system, "Resources.getSystem()");
        return system.getDisplayMetrics().widthPixels;
    }

    public static int b() {
        Resources system = Resources.getSystem();
        k.a((Object) system, "Resources.getSystem()");
        return system.getDisplayMetrics().heightPixels;
    }
}
