package net.one97.paytm.addmoney.addmoneysource.e.b.a.a;

import android.content.Context;
import net.one97.paytm.addmoney.h;

public final class a implements net.one97.paytm.addmoney.addmoneysource.e.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f48285b;

    /* renamed from: a  reason: collision with root package name */
    private Context f48286a;

    public final void a(String str, String str2, String str3, String str4, h hVar) {
    }

    private a(Context context) {
        this.f48286a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f48285b == null) {
                f48285b = new a(context);
            }
            aVar = f48285b;
        }
        return aVar;
    }

    public final void a(String str) {
        f48285b = null;
    }
}
