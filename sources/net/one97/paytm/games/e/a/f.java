package net.one97.paytm.games.e.a;

import android.content.Context;
import android.content.res.Resources;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f35598a = new f();

    private f() {
    }

    public static int a(Context context) {
        k.c(context, "context");
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        return resources.getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        k.c(context, "context");
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        return resources.getDisplayMetrics().heightPixels;
    }

    public static int a(Context context, int i2) {
        k.c(context, "context");
        k.c(context, "context");
        Resources resources = context.getResources();
        k.a((Object) resources, "context.resources");
        return i2 * ((int) resources.getDisplayMetrics().density);
    }
}
