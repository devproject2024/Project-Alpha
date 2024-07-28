package net.one97.paytm.addmoney.addmoneysource.b.c.a;

import android.content.Context;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.b.c.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48188b;

    /* renamed from: a  reason: collision with root package name */
    private Context f48189a;

    public final void a(h hVar, String str) {
    }

    private a(Context context) {
        this.f48189a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48188b == null) {
                f48188b = new a(context);
            }
            aVar = f48188b;
        }
        return aVar;
    }

    public final void a(String str) {
        f48188b = null;
    }
}
