package net.one97.paytm.locale.b;

import android.content.Context;
import android.os.Build;
import android.view.ContextThemeWrapper;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f53104a = false;

    /* renamed from: b  reason: collision with root package name */
    private static c f53105b;

    /* renamed from: c  reason: collision with root package name */
    private static n f53106c;

    public static void a() {
        if (!f53104a) {
            f53104a = true;
            f53105b = new c();
            n nVar = new n();
            f53106c = nVar;
            nVar.a(new l());
            if (Build.VERSION.SDK_INT >= 21) {
                f53106c.a(new m());
            }
            f53106c.a(new k());
            f53106c.a(new a());
        }
    }

    public static ContextThemeWrapper a(Context context) {
        return f.a(context, f53105b, f53106c);
    }

    public static void b() {
        f53105b.f53101d = false;
    }
}
