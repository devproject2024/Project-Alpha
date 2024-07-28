package net.one97.paytm.addmoney.addmoneysource.c.c.a;

import android.content.Context;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.c.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f48214a;

    /* renamed from: b  reason: collision with root package name */
    private Context f48215b;

    public final void a(String str, h hVar, String str2) {
    }

    public final void a(h hVar, String str) {
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
    }

    private a(Context context) {
        this.f48215b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48214a == null) {
                f48214a = new a(context);
            }
            aVar = f48214a;
        }
        return aVar;
    }

    public final void a(String str) {
        f48214a = null;
    }
}
